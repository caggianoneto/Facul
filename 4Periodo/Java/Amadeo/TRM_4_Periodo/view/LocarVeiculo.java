/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.Principal.PainelPrincipal;
import dao.ConnectionFactory;
import static view.Principal.telaPrincipal.painelCentral;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author NIB
 */
public class LocarVeiculo extends javax.swing.JPanel {

    /**
     * Creates new form LocarVeiculo
     */
    // variaveis da connexão do banco
    
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static PreparedStatement pst = null;
    private static String opcionais;
    
    // variaveis staticas 
    private static int cod;
    private static int codigoCliente;
    private static float vd;
    private static String placa;
    private static String modelo;
    private static String motor;  
    private static String nome;
    private static String cadeirinha;
    private static String gps;
        
    
    
    public LocarVeiculo() {
        initComponents();
        conn = ConnectionFactory.getConexao();
        updateTable();
        campoMarca();
        campoBoxForn();
        campoComb();
        campoBoxCliente();
        
    } 
    
    public static  void mudarStatus(boolean status){
        String sql2;
                
            sql2 = "UPDATE veiculo SET status = ? WHERE placa = ? ";
                   System.out.println("placa "+placa);
                   System.out.println("status "+status );
        try {
           pst = conn.prepareStatement(sql2);
           
           pst.setBoolean(1, status);
           pst.setString(2, placa);
           
           if (pst.executeUpdate() > 0) {
                pst.close();                          
                System.out.println("Mudança de status ok ");
            } else {
                pst.close();              
            }
                                  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na mudança de status do veiculo");
        }
    }
    
    public static void mudarLocado(boolean status){
        
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
                System.out.println("Mudança de para locado ok ");
            } else {
                pst.close();              
            }
                                  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na mudança para locado do veiculo");
        }
        
    }

    private void updateTable(){
              
        try {
            String sql = "SELECT codigo, placa, marca, modelo, motor, cambio, portas, combustivel, valorDiaria, ano FROM veiculo WHERE locado = 0";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaVeiculos.setModel(DbUtils.resultSetToTableModel(rs));
                       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro do bd");
        }
        
    }
    
    private void updateTable2(String opcionais){
      
       String marca = campoMarca.getSelectedItem().toString();
       String fornecedor = campoForn.getSelectedItem().toString();
       String cambio = campoCambio.getSelectedItem().toString();
       String comb = campoComb.getSelectedItem().toString();
       float valor1 = 0.0f;
       float valor2 = 0.0f;
       int portas = Integer.parseInt(campoPortas.getSelectedItem().toString());
       int op = campoValor.getSelectedIndex();
       
       
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
       
        try {
            String sql = "SELECT codigo, placa, marca, modelo, motor, cambio, portas, combustivel, valorDiaria, ano "
                    + "FROM veiculo WHERE locado = 0 AND marca LIKE '%"+marca+"%'"
                   + "AND  fornecedor LIKE '%"+fornecedor+"%' AND portas LIKE '%"+portas+"%'"
                    + "AND cambio LIKE '%"+cambio+"%' AND combustivel LIKE '%"+comb+"%' "
                    + " AND opcionais LIKE  '%"+opcionais+"%' "
                    + "AND valorDiaria >= "+valor1+" AND valorDiaria <= "+valor2+"   ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaVeiculos.setModel(DbUtils.resultSetToTableModel(rs));

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
      
    
    private void campoBoxCliente(){
                    
        try {
            String sql = "SELECT NomeCompleto FROM cliente";
            
            conn = ConnectionFactory.getConexao();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String nomeCliente = rs.getString("NomeCompleto");          
                campoCliente.addItem(nomeCliente);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox cliente");
        }
        
    }
     
    
    public static void locar(){
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();
        nome = campoCliente.getSelectedItem().toString();
        
        // verificando utilitários selecionados pelo cliente
        if(LocarAcionado.campoC1.isSelected()){
            cadeirinha = LocarAcionado.campoC1.getText();
        }else if(LocarAcionado.campoC2.isSelected()){
            cadeirinha = LocarAcionado.campoC2.getText();
        }else if(LocarAcionado.campoC3.isSelected()){
            cadeirinha = LocarAcionado.campoC3.getText();
        }else{
            cadeirinha = null;
        }
        
        if(LocarAcionado.campoGPS.isSelected())
            gps = "SIM";
        else
            gps = "NÃO";
        



        // Pagando codigo do cliente escolhido
        try {
            String sql = "SELECT Codigo FROM cliente WHERE 1 AND NomeCompleto LIKE '%" + nome + "%' ";

            conn = ConnectionFactory.getConexao();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                codigoCliente = rs.getInt("Codigo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pegar cod do cliente");
        }


        String query = "INSERT INTO cliente_aluga_veiculo (placa, modelo, cod_cliente, nomeCliente, cod_veiculo, data_retirada,"
                + " valor_diaria, cadeirinha, GPS, finalizada) VALUES(?,?,?,?,?,?,?,?,?,?)";


        // try catch para tentar inserir
        try {
            //prepara a string para inser��o
            pst = conn.prepareStatement(query);

            //passa os parametros

            pst.setString(1, placa);
            pst.setString(2, modelo);
            pst.setInt(3, codigoCliente);
            pst.setString(4, nome);
            pst.setInt(5, cod);
            pst.setString(6, dateFormat.format(data));
            pst.setFloat(7, vd);
            pst.setString(8, cadeirinha);
            pst.setString(9, gps);
            pst.setBoolean(10, false);


            if (pst.executeUpdate() > 0) {
                pst.close();
                JOptionPane.showMessageDialog(null, "Veículo alugado com sucesso");                          
            } else {
                pst.close();
                System.out.println("Erro ao alugar veiculo");
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("erro exeption");
        }

        // alterando status do veiculo para locado
        //mudarStatus(false);
        mudarLocado(true);

        PainelPrincipal pn = new PainelPrincipal();
        pn.setVisible(true);
        painelCentral.removeAll();
        pn.setSize(painelCentral.getSize());
        painelCentral.add(pn);
        painelCentral.revalidate();
        painelCentral.repaint();


    }

    public static String getPlaca() {
        return placa;
    }

    public static void setPlaca(String placa) {
        LocarVeiculo.placa = placa;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Voltar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campoCliente = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoMarca = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        campoForn = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaVeiculos = new javax.swing.JTable();
        BotaoFiltro = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        campoValor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        pacote1 = new javax.swing.JCheckBox();
        pacote2 = new javax.swing.JCheckBox();
        pacote3 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        campoCambio = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        campoComb = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        campoPortas = new javax.swing.JComboBox();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOCAÇÃO DE VEÍCULO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("VEÍCULOS DISPONÍVEIS :");

        Voltar.setText("Voltar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        jButton2.setText("Locar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente:");

        jLabel4.setText("Filtrar por :");

        jLabel5.setText("Marca :");

        jLabel6.setText("Fornecedor :");

        tabelaVeiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaVeiculos.getTableHeader().setReorderingAllowed(false);
        tabelaVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVeiculosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaVeiculosMousePressed(evt);
            }
        });
        tabelaVeiculos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tabelaVeiculosMouseDragged(evt);
            }
        });
        tabelaVeiculos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaVeiculosKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaVeiculos);

        BotaoFiltro.setText("Filtrar:");
        BotaoFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFiltroActionPerformed(evt);
            }
        });

        jLabel8.setText("Valor Diária:");

        campoValor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Qualquer valor", "Até R$ 30,00", "R$ 30,00 a R$ 50,00", "R$ 51,00 a R$ 80,00", "R$ 81,00 a R$ 100,00", "R$ 101,00 a R$ 150,00", "R$ 151,00 a R$ 200,00", "Acima de R$ 200,00" }));

        jLabel9.setText("Opcionais :");

        pacote1.setText("Pacote Light");
        pacote1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pacote1StateChanged(evt);
            }
        });

        pacote2.setText("Pacote Super");
        pacote2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pacote2StateChanged(evt);
            }
        });

        pacote3.setText("Pacote Full");
        pacote3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pacote3StateChanged(evt);
            }
        });

        jLabel10.setText("Câmbio:");

        campoCambio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manual", "Automático" }));

        jLabel11.setText("Comb. :");

        jLabel12.setText("Portas :");

        campoPortas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(326, 326, 326))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(pacote2)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(26, 26, 26)
                                                        .addComponent(pacote3))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(campoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel11)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(campoComb, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                                .addComponent(campoPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(BotaoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addComponent(pacote1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(27, 27, 27)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacote1)
                    .addComponent(pacote2)
                    .addComponent(pacote3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Voltar)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        // TODO add your handling code here:
        PainelPrincipal pn = new PainelPrincipal();
        pn.setVisible(true);
        painelCentral.removeAll();
        pn.setSize(painelCentral.getSize());
        painelCentral.add(pn);
        painelCentral.revalidate();

        painelCentral.repaint();

    }//GEN-LAST:event_VoltarActionPerformed

    private void BotaoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFiltroActionPerformed
        // Botão filtro
        if (campoMarca.getSelectedIndex() == -1 || campoForn.getSelectedIndex() == -1
                || campoComb.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione campos válidos!!");
        } else {
            updateTable2(opcionais);
        }

    }//GEN-LAST:event_BotaoFiltroActionPerformed

    private void pacote1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pacote1StateChanged
        // TODO add your handling code here:
        if (pacote1.isSelected()) {
            opcionais = "Pacote Light";
        } else {
            opcionais = "todos";
        }

    }//GEN-LAST:event_pacote1StateChanged

    private void pacote2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pacote2StateChanged
        // TODO add your handling code here:
        if (pacote2.isSelected()) {
            opcionais = "Pacote Super";
        } else {
            opcionais = "todos";
        }
    }//GEN-LAST:event_pacote2StateChanged

    private void pacote3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pacote3StateChanged
        // TODO add your handling code here:
        if (pacote3.isSelected()) {
            opcionais = "Pacote Full";
        } else {
            opcionais = "todos";
        }
    }//GEN-LAST:event_pacote3StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // BOTÃO LOCAR ACIONADO!
        int linhaSelecionada = tabelaVeiculos.getSelectedRow();
        if(linhaSelecionada == -1){
            JOptionPane.showMessageDialog(null, "Selecione um veiculo antes!!");
        }else{
            new LocarAcionado().setVisible(true);
        }
        
        
      
    }//GEN-LAST:event_jButton2ActionPerformed

 
    
    private void tabelaVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVeiculosMouseClicked
        // mouse clicked da Jtable 
        int linhaSelecionada = tabelaVeiculos.getSelectedRow();
      
        // preparando variáveis a serem passadas
        try {
            motor =  tabelaVeiculos.getValueAt(linhaSelecionada, 4).toString();
            modelo = tabelaVeiculos.getValueAt(linhaSelecionada, 3).toString();
            placa = tabelaVeiculos.getValueAt(linhaSelecionada, 1).toString();
            vd = Float.parseFloat(tabelaVeiculos.getValueAt(linhaSelecionada, 8).toString()); 
            cod = Integer.parseInt(tabelaVeiculos.getValueAt(linhaSelecionada, 0).toString());
            
        } catch (Exception e) {
            System.out.println("erro na tabela");
        }
        
        if (evt.getClickCount() == 2) {
            //JOptionPane.showMessageDialog(null, "Clicou 2 x $%¨#*!!!!");
             new VeiculoSelecionado().setVisible(true);
             VeiculoSelecionado.updateValores(cod);
        }
       
        
    }//GEN-LAST:event_tabelaVeiculosMouseClicked

    
    private void tabelaVeiculosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVeiculosMouseDragged
        // TODO add your handling code here:
        int linhaSelecionada = tabelaVeiculos.getSelectedRow();
        int i = 1;
        
        
        if(tabelaVeiculos.isRowSelected(linhaSelecionada)){
            i++;          
            if(i > 1){
                tabelaVeiculos.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaVeiculosMouseDragged

    private void tabelaVeiculosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaVeiculosKeyPressed
        // TODO add your handling code here:
        int linhaSelecionada = tabelaVeiculos.getSelectedRow();
        int i = 1;
        
        
        if(tabelaVeiculos.isRowSelected(linhaSelecionada)){
            i++;          
            if(i > 1){
                tabelaVeiculos.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaVeiculosKeyPressed

    private void tabelaVeiculosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVeiculosMousePressed
         
         tabelaVeiculos.editingCanceled(null);
          
    }//GEN-LAST:event_tabelaVeiculosMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoFiltro;
    private javax.swing.JButton Voltar;
    private javax.swing.JComboBox campoCambio;
    private static javax.swing.JComboBox campoCliente;
    private javax.swing.JComboBox campoComb;
    private javax.swing.JComboBox campoForn;
    private javax.swing.JComboBox campoMarca;
    private javax.swing.JComboBox campoPortas;
    private javax.swing.JComboBox campoValor;
    private static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JCheckBox pacote1;
    private javax.swing.JCheckBox pacote2;
    private javax.swing.JCheckBox pacote3;
    private javax.swing.JTable tabelaVeiculos;
    // End of variables declaration//GEN-END:variables
}
