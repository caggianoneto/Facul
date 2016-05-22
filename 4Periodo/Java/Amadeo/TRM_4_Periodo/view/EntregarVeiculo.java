/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import view.Principal.PainelPrincipal;
import static view.Principal.telaPrincipal.painelCentral;

/**
 *
 * @author NIB2
 */
public class EntregarVeiculo extends javax.swing.JPanel {

    /**
     * Creates new form EntregarVeiculo
     */
    public EntregarVeiculo() {
        initComponents();
        conn = ConnectionFactory.getConexao();
        updateTabela();
        campoCodCliente();
        campoCodLocacao();
        campoNomeCliente();
    }
    
    // variaveis de conexão com bd
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private static int codVeiculo;
    
    private static int cod_cliente;
    private static float vd;
    private static String nomeCliente;
    private static String modelo;
    private static String placa;
    private static int codigoL;
    
    
    private void updateTabela(){
       
        try {
            String sql = "SELECT cod_veiculo, codigoLocacao, cod_cliente, nomeCliente, placa, modelo, data_retirada,"
                    + " valor_diaria, cadeirinha, GPS FROM cliente_aluga_veiculo WHERE finalizada = 0";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); 
            tabelaEntregaV.setModel(DbUtils.resultSetToTableModel(rs));     
             
            
        } catch (Exception e) {
            System.out.println("Erro no select do bd");
        }
    }
    
    private void updateByCodCliente(int cod){
        
        try {
            String sql = "SELECT cod_veiculo, codigoLocacao, cod_cliente, nomeCliente, placa, modelo, data_retirada,"
                    + " valor_diaria, cadeirinha, GPS FROM cliente_aluga_veiculo WHERE cod_cliente = "+cod+" AND finalizada = 0 ";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaEntregaV.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("Erro 2 no select do bd");
        }
    }
    
    private void updateByCodLocacao(int cod){
        
        try {
            String sql = "SELECT cod_veiculo, codigoLocacao, cod_cliente, nomeCliente, placa, modelo, data_retirada,"
                    + " valor_diaria, cadeirinha, GPS FROM cliente_aluga_veiculo WHERE codigoLocacao = "+cod+" AND finalizada = 0 ";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaEntregaV.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("Erro 3 no select do bd");
        }
    }
    
    private void updateByNome(String nome){
        
        try {
            String sql = "SELECT cod_veiculo, codigoLocacao, cod_cliente, nomeCliente, placa, modelo,  data_retirada,"
                    + " valor_diaria, cadeirinha, GPS FROM cliente_aluga_veiculo WHERE nomeCliente LIKE '%"+nome+"%' AND finalizada = 0 ";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaEntregaV.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("Erro 4 no select do bd");
        }
        
    }
    
    
    private void campoCodCliente(){
        
        try {
            String sql = "SELECT cod_cliente FROM cliente_aluga_veiculo";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            campoCod.addItem("");
            
            while(rs.next()){
                int codCliente = rs.getInt("cod_cliente");               
                campoCod.addItem(codCliente);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox cod cliente");
        }
        
    }
    
    private void campoCodLocacao(){
        
        try {
            String sql = "SELECT codigoLocacao FROM cliente_aluga_veiculo";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            campoCodL.addItem("");
            
            while(rs.next()){
                int codLocacao = rs.getInt("codigoLocacao");               
                campoCodL.addItem(codLocacao);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox cod locacao");
        }
    
    }
    
    private void campoNomeCliente(){
        
        try {
            String sql = "SELECT nomeCliente FROM cliente_aluga_veiculo";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            campoNome.addItem("");
            
            while(rs.next()){
                String nome = rs.getString("nomeCliente");               
                campoNome.addItem(nome);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox nome cliente");
        }
        
    }

    public static int getCodigoL() {
        return codigoL;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entregaVeiculo = new javax.swing.JLabel();
        codLocacao = new javax.swing.JLabel();
        campoCodL = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        campoCod = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaEntregaV = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        filtrar = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        Entregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JComboBox();

        entregaVeiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        entregaVeiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entregaVeiculo.setText("ENTREGA DE VEÍCULO");

        codLocacao.setText("Codigo Locação");

        jLabel2.setText("Codigo Cliente :");

        tabelaEntregaV.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaEntregaV.getTableHeader().setReorderingAllowed(false);
        tabelaEntregaV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEntregaVMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaEntregaVMousePressed(evt);
            }
        });
        tabelaEntregaV.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tabelaEntregaVMouseDragged(evt);
            }
        });
        tabelaEntregaV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaEntregaVKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaEntregaV);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("VEÍCULOS LOCADOS :");

        filtrar.setText("Filtrar:");
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        Entregar.setText("Entregar");
        Entregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome Cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entregaVeiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codLocacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCodL, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Entregar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entregaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codLocacao)
                    .addComponent(campoCodL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltar)
                    .addComponent(Entregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaEntregaVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEntregaVMouseClicked
        // mouse clicked da Jtable
        int linhaSelecionada = tabelaEntregaV.getSelectedRow();
        
        
        // preparando variáveis a serem passadas
        try {
            codigoL = Integer.parseInt(tabelaEntregaV.getValueAt(linhaSelecionada, 1).toString());
            cod_cliente = Integer.parseInt(tabelaEntregaV.getValueAt(linhaSelecionada, 2).toString());
            nomeCliente = tabelaEntregaV.getValueAt(linhaSelecionada, 3).toString();
            placa = tabelaEntregaV.getValueAt(linhaSelecionada, 4).toString();
            modelo = tabelaEntregaV.getValueAt(linhaSelecionada, 5).toString();           
            vd = Float.parseFloat(tabelaEntregaV.getValueAt(linhaSelecionada, 7).toString());
            
            
        } catch (Exception e) {
            System.out.println("erro na tabela"+e);
        }
        
        try {
            codVeiculo = Integer.parseInt(tabelaEntregaV.getValueAt(linhaSelecionada, 0).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
  
        if (evt.getClickCount() == 2) {
            //JOptionPane.showMessageDialog(null, "Clicou 2 x $%¨#*!!!!");
            new VeiculoSelecionado().setVisible(true);
            VeiculoSelecionado.updateValores(codVeiculo);
        }

    }//GEN-LAST:event_tabelaEntregaVMouseClicked

    private void tabelaEntregaVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEntregaVMousePressed

        tabelaEntregaV.editingCanceled(null);

    }//GEN-LAST:event_tabelaEntregaVMousePressed

    private void tabelaEntregaVMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEntregaVMouseDragged
        // TODO add your handling code here:
        int linhaSelecionada = tabelaEntregaV.getSelectedRow();
        int i = 1;

        if(tabelaEntregaV.isRowSelected(linhaSelecionada)){
            i++;
            if(i > 1){
                tabelaEntregaV.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaEntregaVMouseDragged

    private void tabelaEntregaVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaEntregaVKeyPressed
        // TODO add your handling code here:
        int linhaSelecionada = tabelaEntregaV.getSelectedRow();
        int i = 1;

        if(tabelaEntregaV.isRowSelected(linhaSelecionada)){
            i++;
            if(i > 1){
                tabelaEntregaV.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaEntregaVKeyPressed

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
        // Botão filtro 
        int codigoL; 
        int codigo;
        
        if(campoNome.getSelectedIndex() == -1){
            updateByNome(campoNome.getSelectedItem().toString());
        }else{     
        updateByNome(campoNome.getSelectedItem().toString());
        if(campoNome.getSelectedItem().toString().trim().equals("")){
        if (campoCod.getSelectedItem().toString().trim().equals("")) {
            if (campoCodL.getSelectedItem().toString().trim().equals("")) {
             
            } else {
                try {
                    codigoL = Integer.parseInt(campoCodL.getSelectedItem().toString());
                    updateByCodLocacao(codigoL);
                } catch (Exception e) {
                    System.out.println("Erro campo codL");
                }
            }
        } else {
            try {
                codigo = Integer.parseInt(campoCod.getSelectedItem().toString());
                updateByCodCliente(codigo);
            } catch (Exception e) {
                System.out.println("Erro!!!");
            }


        }
        }
        }
    }//GEN-LAST:event_filtrarActionPerformed

    private void EntregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntregarActionPerformed
        // Botão entregar veículo
        int linhaSelecionada = tabelaEntregaV.getSelectedRow();
     
        if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(null, "Selecione um veiculo antes!!");
            } else {
                // puxar tela de valor a pagar
                new Pagamento().setVisible(true);
                Pagamento.updateValores(cod_cliente, nomeCliente, placa, modelo, vd);
            }


    }//GEN-LAST:event_EntregarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // voltar
        PainelPrincipal pn = new PainelPrincipal();
        pn.setVisible(true);
        painelCentral.removeAll();
        pn.setSize(painelCentral.getSize());
        painelCentral.add(pn);
        painelCentral.revalidate();

        painelCentral.repaint();
    }//GEN-LAST:event_voltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Entregar;
    private javax.swing.JComboBox campoCod;
    private javax.swing.JComboBox campoCodL;
    private javax.swing.JComboBox campoNome;
    private javax.swing.JLabel codLocacao;
    private javax.swing.JLabel entregaVeiculo;
    private javax.swing.JButton filtrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaEntregaV;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
