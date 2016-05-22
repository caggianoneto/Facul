/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.DateFormat; 
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.Calendar; 
import java.util.Date; 
import javax.swing.JOptionPane;
import view.Principal.PainelPrincipal;
import static view.Principal.telaPrincipal.painelCentral;

/**
 *
 * @author NIB
 */
public class Pagamento extends javax.swing.JFrame {

    /**
     * Creates new form Pagamento
     */
    public Pagamento() {
        initComponents();
        conn = ConnectionFactory.getConexao();
    }
    
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement pst = null;
    
    private static Date dataR = new Date();
    private static float ValorTotal;
   
    
    private static String pegaData(int cod){
        String dataRetirada = null;
        
        try {
            String sql = "SELECT data_retirada FROM cliente_aluga_veiculo WHERE cod_cliente = "+cod+" ";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            
            while(rs.next()){
                 dataRetirada = rs.getString("data_retirada");              
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pegar a data");
        }
      
        return dataRetirada;
    }
    
   public static String calculaTempo(Date data1, Date data2){
       DecimalFormat df = new DecimalFormat();  
       df.applyPattern("00.00;(00.00)");
       
     
       float vinteQuatroHoras = 24*60*60*1000;
       float total = data2.getTime() - data1.getTime();
       float total3 = total / vinteQuatroHoras;
       float total2 = total / vinteQuatroHoras;
       float total1 = total / vinteQuatroHoras;  
       total2 = total2 * 24;
       
       
       System.out.println("total em dias "+df.format(total1));
       System.out.println("total em horas "+df.format(total2));
       
       if(total1 > 1){
           ValorTotal = total1;
           return df.format(total1)+" Dias";
       }else{
           ValorTotal = 1;
           return df.format(total2)+" Horas";
       }
      
   }
    

    public static void updateValores(int codCli, String nome, String placa, String modelo, float vd){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataR;
        String dataE;
        Date dataHoje = new Date();
        Date dataIni = new Date();
        String tempoTotal;
        
        campoNome.setText(nome);
        campoCod.setText(String.valueOf(codCli));
        campoVeiculoL.setText(modelo);
        campoPlaca.setText(placa);
        campoValorD.setText(String.valueOf(vd));
        
        placa = campoPlaca.getText();
        
        dataR = pegaData(Integer.parseInt(campoCod.getText()));          
        Calendar calendar = Calendar.getInstance();
        dataHoje = calendar.getTime();
              
        dataE = df.format(dataHoje);
        campoDataEntrega.setText(dataE);
        try {
            dataIni = df.parse(dataR);
        } catch (ParseException ex) {
            ex.printStackTrace();

        }
       
        System.out.println(dataE+"  ---- data de hoje"); // data de hoje  
        System.out.println(dataR+ "   ----- data de retirada");

        tempoTotal = calculaTempo(dataIni, dataHoje);

        System.out.println("tempo calculado : "+tempoTotal);
        
        campoTempo.setText(tempoTotal);
        
        ValorTotal = ValorTotal*vd;
        
        campoValorT.setText("R$ "+ValorTotal);           
        calculaTotal();
    }
    
    private static float pegaValorSeguro(String placa){
        
        float seguro = 0;
        
        String sql = "SELECT valorSeguro FROM veiculo WHERE placa LIKE '%"+placa+"%' ";
        
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            
            while(rs.next()){
                seguro = rs.getFloat("valorSeguro");
                
            return seguro;            
            }
            
        } catch (Exception e) {
            System.out.println("erro ao pegar valor do seguro do bd");
        }
        
        
        return seguro;
    }
    
    private static void calculaTotal(){
        float subtotal = 0;
        float desconto = 0;
        float adicionais = 0;
        float seguro = 0;
        
        if(campoSeguro.isSelected()){
            
            seguro = pegaValorSeguro(campoPlaca.getText());
            System.out.println("Valor do seguro pego do banco = "+seguro);
        }
        
        try {
            if(campoAdicionais.getText().trim().equals("")){
                desconto = Float.parseFloat(campoDesconto.getText());
            }else{
                adicionais = Float.parseFloat(campoAdicionais.getText());
                desconto = Float.parseFloat(campoDesconto.getText());
            }
            
                          
        } catch (Exception e) {
            System.out.println("valores nulos");
                 
        }
        if(desconto > 100 || adicionais < 0){
            JOptionPane.showMessageDialog(null, "Desconto não permitido!");
        }else{
            desconto = desconto/100;
            desconto = ValorTotal * desconto;
            subtotal = ValorTotal - desconto;
            subtotal = subtotal + adicionais;
            if(seguro != 0){
                subtotal = subtotal + seguro;
            }
            campoSubTotal.setText(String.valueOf(subtotal));
        }
      
    }
    
    private boolean veiculoEntregue(int cod){
        boolean finalizada = true;
        boolean sucesso = false;
        System.out.println("codigo locacao = "+ cod);
        
        String sql = "UPDATE cliente_aluga_veiculo SET data_entrega = ?, valor_pago = ?, formaPgto = ?, avarias = ?,"
                + "finalizada = ?, usouSeguro = ? WHERE codigoLocacao = "+cod+" ";
        try {           
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, campoDataEntrega.getText());
            pst.setFloat(2, Float.parseFloat(campoSubTotal.getText()));
            pst.setString(3, campoFpgto.getSelectedItem().toString());
            pst.setString(4, campoAvarias.getText());
            pst.setBoolean(5, finalizada);
            pst.setBoolean(6, campoSeguro.isSelected());
            
            if (pst.executeUpdate() > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Veículo devolvido com sucesso");   
                sucesso = true;
            } else {
                pst.close();
                System.out.println("Erro atualizar banco");
            }
                                                                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao fechar locação!"+ e);
        }
        
        return sucesso;
    }
    
    private void mudarLocado(boolean status, String placa){
        
        String sql2;
                
            sql2 = "UPDATE veiculo SET locado = ? WHERE placa = ? ";
                   System.out.println("placa "+placa);
                   System.out.println("locado "+status );
        try {
           pst = conn.prepareStatement(sql2);
           
           pst.setBoolean(1, status);
           pst.setString(2, placa);
           
           if (pst.executeUpdate() > 0) {
                pst.close();                          
                System.out.println("Mudança de para "+status+" ok ");
            } else {
                pst.close();              
            }
                                  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na mudança para locado do veiculo");
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cliente = new javax.swing.JLabel();
        campoNome = new javax.swing.JLabel();
        cod = new javax.swing.JLabel();
        campoCod = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campoVeiculoL = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoValorD = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoTempo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoValorT = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoDesconto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoAdicionais = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoSubTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campoFpgto = new javax.swing.JComboBox();
        Voltar = new javax.swing.JButton();
        Enviar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        campoPlaca = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        campoDataEntrega = new javax.swing.JLabel();
        campoSeguro = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        campoAvarias = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cliente.setText("Cliente :");

        cod.setText("Codigo :");

        jLabel1.setText("Veículo Locado :");

        jLabel2.setText("Valor diário :");

        jLabel3.setText("Tempo Locado:");

        jLabel4.setText("Valor Total:");

        jLabel5.setText("Desconto :");

        jLabel6.setText("%");

        jLabel7.setText("Adicionais :");

        jLabel8.setText("R$");

        jLabel9.setText("SubTotal :");

        jLabel10.setText("Forma de pgto :");

        campoFpgto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Debito", "Crédito", "Cheque" }));

        Voltar.setText("Voltar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        jLabel11.setText("Placa :");

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setText("Data Entrega:");

        campoSeguro.setText("Usou seguro");
        campoSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSeguroActionPerformed(evt);
            }
        });

        jLabel13.setText("Avarias :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoCod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jButton1)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoFpgto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoVeiculoL, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(campoValorT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoValorD, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoSeguro)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(campoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(18, 18, 18)
                                            .addComponent(campoDataEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel13)
                                    .addComponent(campoAvarias, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 43, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cliente)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cod)
                            .addComponent(campoCod, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoVeiculoL, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoValorD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(campoDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(campoValorT, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(campoSeguro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(campoSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(campoFpgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Voltar)
                            .addComponent(Enviar))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(campoAvarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(131, 131, 131))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        
        dispose();
    }//GEN-LAST:event_VoltarActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        // Botão enviar (Pagar)
        if(veiculoEntregue(EntregarVeiculo.getCodigoL())){
            System.out.println("entregue!!!");      
            mudarLocado(false, campoPlaca.getText());
            dispose();
            PainelPrincipal pn = new PainelPrincipal();
            
            pn.setVisible(true);
            painelCentral.removeAll();
            pn.setSize(painelCentral.getSize());
            painelCentral.add(pn);
            painelCentral.revalidate();

            painelCentral.repaint();
        }else{
            System.out.println("FALHOU!");
        }
        
            
        
       
    }//GEN-LAST:event_EnviarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        calculaTotal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSeguroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSeguroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagamento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enviar;
    private javax.swing.JButton Voltar;
    private static javax.swing.JTextField campoAdicionais;
    private javax.swing.JTextField campoAvarias;
    private static javax.swing.JLabel campoCod;
    private static javax.swing.JLabel campoDataEntrega;
    private static javax.swing.JTextField campoDesconto;
    private javax.swing.JComboBox campoFpgto;
    private static javax.swing.JLabel campoNome;
    private static javax.swing.JLabel campoPlaca;
    private static javax.swing.JCheckBox campoSeguro;
    private static javax.swing.JLabel campoSubTotal;
    private static javax.swing.JLabel campoTempo;
    private static javax.swing.JLabel campoValorD;
    private static javax.swing.JLabel campoValorT;
    private static javax.swing.JLabel campoVeiculoL;
    private javax.swing.JLabel cliente;
    private javax.swing.JLabel cod;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
