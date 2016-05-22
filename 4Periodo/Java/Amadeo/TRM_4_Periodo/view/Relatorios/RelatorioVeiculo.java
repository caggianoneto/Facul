/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Relatorios;

import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import view.Principal.PainelPrincipal;
import static view.Principal.telaPrincipal.painelCentral;
import view.VeiculoSelecionado;
import view.cadastros.PainelCadastroVeiculo;

/**
 *
 * @author NIB
 */
public class RelatorioVeiculo extends javax.swing.JPanel {

    /**
     * Creates new form RelatorioVeiculo
     */
    public RelatorioVeiculo() {
        initComponents();
        conn = ConnectionFactory.getConexao();
        uptadeTabela();
        campoBoxForn();
        campoMarca();
        campoComb();
    }

    // variaveis de conexão com bd
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private static String opcionais = "todos";
    private static int cod;
    private static float vd;
    private static String placa;
    private static String modelo;
    private static String motor; 
    
    
    private void uptadeTabela(){
        
        
        try {
            String sql = "SELECT codigo, placa, marca, modelo, motor, cambio, portas, combustivel, valorDiaria, ano FROM veiculo";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaRveiculos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro bd na table.");
        }
    }
    
    
    
    private void updateTabela2(String opcionais){
      
       String marca = campoMarca.getSelectedItem().toString();
       String fornecedor = campoForn.getSelectedItem().toString();
       String cambio = campoCambio.getSelectedItem().toString();
       String comb = campoComb.getSelectedItem().toString();
       float valor1 = 0.0f;
       float valor2 = 0.0f;
       int portas = Integer.parseInt(campoPortas.getSelectedItem().toString());
       int op = campoValor.getSelectedIndex();
       boolean locado, habilitado;
       
       
        System.out.println("op = "+op);
       
       switch (op){
           
           case 0:
               valor1 = 0;
               valor2 = Float.MAX_VALUE;
               break;
           
           case 1:
               valor1 = 0;
               valor2 = 30;
               break;
           case 2:
               valor1 = 30;
               valor2 = 50;
               break;
           case 3:
               valor1 = 51;
               valor2 = 80;
               break;
           case 4:
               valor1 = 81;
               valor2 = 100;
               break;
           case 5:
               valor1 = 101;
               valor2 = 150;
               break;
           case 6:
               valor1 = 151;
               valor2 = 200;
               break;
           case 7:
               valor1 = 200;
               valor2 = Float.MAX_VALUE;
               break;
       }
         
       // preparando opcionais
       
       if(opcionais == "Pacote Light"){
           opcionais = "Alarme  Trava Elétrica  Desemb. Traseiro  Ar quente";
       }else if(opcionais == "Pacote Super"){
           opcionais = "Alarme  Trava Elétrica  Ar condicionado  Desemb. Traseiro  Vidro E  Direção  Ar quente  Som";
       }else if(opcionais == "Pacote Full"){
           opcionais = " Alarme  Trava Elétrica  Ar condicionado  Desemb. Traseiro  Vidro E  Direção  ABS  Ar quente  Rodas Liga leve  Som";
                   
       }else{
           opcionais = " ";
       }
       
       // verificando campos boolean locado e habilitado
       if(campoHabilitado.isSelected()){
           habilitado = true;
       }else{
           habilitado = false;
       }
       
       if(campoLocado.isSelected()){
           locado = true;
       }else{
           locado = false;
       }
       
       
        try {
            String sql = "SELECT codigo, placa, marca, modelo, motor, cambio, portas, combustivel, valorDiaria, ano "
                    + "FROM veiculo WHERE status = "+habilitado+" AND locado = "+locado+" "
                    + "AND marca LIKE '%"+marca+"%' AND  fornecedor LIKE '%"+fornecedor+"%' AND portas LIKE '%"+portas+"%'"
                    + "AND cambio LIKE '%"+cambio+"%' AND combustivel LIKE '%"+comb+"%' "
                    + " AND opcionais LIKE  '%"+opcionais+"%' "
                    + "AND valorDiaria >= "+valor1+" AND valorDiaria <= "+valor2+"   ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaRveiculos.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro do bd");
        }   
    }
    
    private void campoMarca(){
                    
        try {
            String sql = "SELECT DISTINCT marca FROM veiculo";
            
            conn = ConnectionFactory.getConexao();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String marca = rs.getString("marca");
                campoMarca.addItem(marca);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox marca");
        }
        
    }
    
    private void campoComb(){
        
        try {
            String sql = "SELECT DISTINCT combustivel FROM veiculo";
            
            conn = ConnectionFactory.getConexao();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String combustivel = rs.getString("combustivel");
                campoComb.addItem(combustivel);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox combustivel");
        }
        
    }
    
    
    
    private void campoBoxForn(){
                    
        try {
            String sql = "SELECT razaoSocial FROM fornecedor";
            
            conn = ConnectionFactory.getConexao();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String nome = rs.getString("razaoSocial");
                campoForn.addItem(nome);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox fornecedor");
        }
        
    }
    
    private boolean isLocado(int cod){
        boolean locado = false;
        
        try {
            String sql = "SELECT locado FROM veiculo WHERE codigo = "+cod+" ";
            
            conn = ConnectionFactory.getConexao();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                locado = rs.getBoolean("locado");
                
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox fornecedor");
        }
      
        return locado;
    }
    
    private boolean excluirVeiculo(int cod){
        
        boolean excluido = false;
        String sql = "DELETE FROM veiculo WHERE codigo = "+cod+" AND locado = false ";
                
        
        try {
            pst = conn.prepareStatement(sql);
        
            
            if (pst.executeUpdate() > 0) {
                excluido = true;
                pst.close();
                return excluido;
            } else {
                pst.close();              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o veiculo!");
        }
        return excluido;
        
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRveiculos = new javax.swing.JTable();
        Alterar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pacote1 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        campoValor = new javax.swing.JComboBox();
        campoCambio = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BotaoFiltro = new javax.swing.JButton();
        campoComb = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoPortas = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        campoForn = new javax.swing.JComboBox();
        pacote3 = new javax.swing.JCheckBox();
        pacote2 = new javax.swing.JCheckBox();
        campoMarca = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoHabilitado = new javax.swing.JCheckBox();
        campoLocado = new javax.swing.JCheckBox();
        excluir = new javax.swing.JButton();

        tabelaRveiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaRveiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRveiculosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaRveiculosMousePressed(evt);
            }
        });
        tabelaRveiculos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tabelaRveiculosMouseDragged(evt);
            }
        });
        tabelaRveiculos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaRveiculosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaRveiculos);

        Alterar.setText("Alterar");
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RELATÓRIO DE VEÍCULOS");

        pacote1.setText("Pacote Light");
        pacote1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pacote1StateChanged(evt);
            }
        });

        jLabel10.setText("Câmbio:");

        campoValor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Qualquer valor", "Até R$ 30,00", "R$ 30,00 a R$ 50,00", "R$ 51,00 a R$ 80,00", "R$ 81,00 a R$ 100,00", "R$ 101,00 a R$ 150,00", "R$ 151,00 a R$ 200,00", "Acima de R$ 200,00" }));

        campoCambio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manual", "Automático" }));

        jLabel9.setText("Opcionais :");

        jLabel11.setText("Comb. :");

        BotaoFiltro.setText("Filtrar:");
        BotaoFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFiltroActionPerformed(evt);
            }
        });

        jLabel8.setText("Valor Diária:");

        jLabel12.setText("Portas :");

        campoPortas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "4" }));

        jLabel6.setText("Fornecedor :");

        pacote3.setText("Pacote Full");
        pacote3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pacote3StateChanged(evt);
            }
        });

        pacote2.setText("Pacote Super");
        pacote2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pacote2StateChanged(evt);
            }
        });

        jLabel5.setText("Marca :");

        jLabel4.setText("Filtrar por :");

        campoHabilitado.setText("Habilitado");
        campoHabilitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHabilitadoActionPerformed(evt);
            }
        });

        campoLocado.setText("Locado");
        campoLocado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLocadoActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoHabilitado)
                        .addGap(18, 18, 18)
                        .addComponent(campoLocado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotaoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoForn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(pacote1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pacote2)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoComb, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(pacote3))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(263, 263, 263)
                                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(campoForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(campoPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(campoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(campoComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoHabilitado)
                    .addComponent(campoLocado))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotaoFiltro)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pacote1)
                            .addComponent(pacote2)
                            .addComponent(pacote3))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltar)
                    .addComponent(Alterar)
                    .addComponent(excluir))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaRveiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRveiculosMouseClicked
     
        // mouse clicked da Jtable 
        int linhaSelecionada = tabelaRveiculos.getSelectedRow();
      
        // preparando variáveis a serem passadas
        try {
            motor =  tabelaRveiculos.getValueAt(linhaSelecionada, 4).toString();
            modelo = tabelaRveiculos.getValueAt(linhaSelecionada, 3).toString();
            placa = tabelaRveiculos.getValueAt(linhaSelecionada, 1).toString();
            vd = Float.parseFloat(tabelaRveiculos.getValueAt(linhaSelecionada, 8).toString()); 
            cod = Integer.parseInt(tabelaRveiculos.getValueAt(linhaSelecionada, 0).toString());
            
        } catch (Exception e) {
            System.out.println("erro na tabela");
        }
        
        if (evt.getClickCount() == 2) {
            //JOptionPane.showMessageDialog(null, "Clicou 2 x $%¨#*!!!!");
             new VeiculoSelecionado().setVisible(true);
             VeiculoSelecionado.updateValores(cod);
        }
        
    }//GEN-LAST:event_tabelaRveiculosMouseClicked

    private void tabelaRveiculosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRveiculosMousePressed
        // TODO add your handling code here:
        tabelaRveiculos.editingCanceled(null);
    }//GEN-LAST:event_tabelaRveiculosMousePressed

    private void tabelaRveiculosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRveiculosMouseDragged

        int linhaSelecionada = tabelaRveiculos.getSelectedRow();
        int i = 1;

        if(tabelaRveiculos.isRowSelected(linhaSelecionada)){
            i++;
            if(i > 1){
                tabelaRveiculos.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaRveiculosMouseDragged

    private void tabelaRveiculosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaRveiculosKeyPressed
        // TODO add your handling code here:
        int linhaSelecionada = tabelaRveiculos.getSelectedRow();
        int i = 1;

        if(tabelaRveiculos.isRowSelected(linhaSelecionada)){
            i++;
            if(i > 1){
                tabelaRveiculos.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaRveiculosKeyPressed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // Botao voltar

        PainelPrincipal pn = new PainelPrincipal();
        pn.setVisible(true);
        painelCentral.removeAll();
        pn.setSize(painelCentral.getSize());
        painelCentral.add(pn);
        painelCentral.revalidate();

        painelCentral.repaint();
    }//GEN-LAST:event_voltarActionPerformed

    private void pacote1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pacote1StateChanged
        // TODO add your handling code here:
        if (pacote1.isSelected()) {
            opcionais = "Pacote Light";
        } else {
            opcionais = "todos";
        }
    }//GEN-LAST:event_pacote1StateChanged

    private void BotaoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFiltroActionPerformed
        // Botão filtro
        if (campoMarca.getSelectedIndex() == -1 || campoForn.getSelectedIndex() == -1
            || campoComb.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione campos válidos!!");
        } else {
            updateTabela2(opcionais);
        }
    }//GEN-LAST:event_BotaoFiltroActionPerformed

    private void pacote3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pacote3StateChanged
        // TODO add your handling code here:
        if (pacote3.isSelected()) {
            opcionais = "Pacote Full";
        } else {
            opcionais = "todos";
        }
    }//GEN-LAST:event_pacote3StateChanged

    private void pacote2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pacote2StateChanged
        // TODO add your handling code here:
        if (pacote2.isSelected()) {
            opcionais = "Pacote Super";
        } else {
            opcionais = "todos";
        }
    }//GEN-LAST:event_pacote2StateChanged

    private void campoHabilitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHabilitadoActionPerformed
        // TODO add your handling code here:
        updateTabela2(opcionais);
    }//GEN-LAST:event_campoHabilitadoActionPerformed

    private void campoLocadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLocadoActionPerformed
        // TODO add your handling code here:
        updateTabela2(opcionais);
    }//GEN-LAST:event_campoLocadoActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        // Botão alterar
        int linhaSelecionada = tabelaRveiculos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um veiculo antes!!");
        } else {

            if (isLocado(cod)) {
                JOptionPane.showMessageDialog(null, "Veiculo locado nao pode ser alterado.");
            } else {
                PainelCadastroVeiculo.metodoAlterar(cod);

                PainelCadastroVeiculo pv = new PainelCadastroVeiculo();
                pv.setVisible(true);
                painelCentral.removeAll();
                pv.setSize(painelCentral.getSize());
                painelCentral.add(pv);
                painelCentral.revalidate();

                painelCentral.repaint();
            }

        }
        
      
        
    }//GEN-LAST:event_AlterarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // Botão exluir
        
        int linha = tabelaRveiculos.getSelectedRow(); 
        
               
        if(linha == -1){
            JOptionPane.showMessageDialog(null,"Selecione um veículo antes de excluir!",
                    "Nenhum cliente selecionado", JOptionPane.WARNING_MESSAGE);
        }else{
            Object[] options = { "Excluir", "Cancelar" };  
        int opcao = JOptionPane.showOptionDialog(null, "Deseja realmente excluir o veículo?",
                "Atenção!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
        if(opcao == 0){
            // exclua o veiculo!
             if(excluirVeiculo(cod)){
                 JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso!");
             }else{
                 JOptionPane.showMessageDialog(null, "Não foi possível excluir o veículo.");
             }
            uptadeTabela();
        }
        
        }
        
    }//GEN-LAST:event_excluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JButton BotaoFiltro;
    private javax.swing.JComboBox campoCambio;
    private javax.swing.JComboBox campoComb;
    private javax.swing.JComboBox campoForn;
    private javax.swing.JCheckBox campoHabilitado;
    private javax.swing.JCheckBox campoLocado;
    private javax.swing.JComboBox campoMarca;
    private javax.swing.JComboBox campoPortas;
    private javax.swing.JComboBox campoValor;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox pacote1;
    private javax.swing.JCheckBox pacote2;
    private javax.swing.JCheckBox pacote3;
    private javax.swing.JTable tabelaRveiculos;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
