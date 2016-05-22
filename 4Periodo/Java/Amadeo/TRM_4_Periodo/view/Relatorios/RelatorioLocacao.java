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

/**
 *
 * @author NIB2
 */
public class RelatorioLocacao extends javax.swing.JPanel {

    /**
     * Creates new form RelatorioLocacao
     */
    // variaveis de conexão com bd
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    public RelatorioLocacao() {
        initComponents();
        conn = ConnectionFactory.getConexao();
        updateTable();
    }

    private void updateTable(){
    
        try {
            String sql = "SELECT codigoLocacao, cod_veiculo, modelo, placa, cod_cliente, nomeCliente, data_retirada,"
                    + "data_entrega, valor_diaria, cadeirinha, GPS FROM cliente_aluga_veiculo WHERE finalizada = false";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaLocacoes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println("Erro no select do bd");
        }
        
    }
    
    private void updateTableByCod(int cod){
    
        String sql = "SELECT codigoLocacao, NomeCliente, modelo, placa, cod_veiculo,"
                + "data_retirada, data_entrega, valor_diaria, valor_pago, formaPgto, cadeirinha, GPS,"
                + "usouSeguro, avarias FROM cliente_aluga_veiculo "
                + "WHERE finalizada = 0 AND codigoLocacao = "+cod+" ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaLocacoes.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("erro no BayCod");
        }
       
       
    }
    
    private void updateTableByCodVeiculo(int cod){
    
        String sql = "SELECT codigoLocacao, NomeCliente, modelo, placa, cod_veiculo,"
                + "data_retirada, data_entrega, valor_diaria, valor_pago, formaPgto, cadeirinha, GPS,"
                + "usouSeguro, avarias FROM cliente_aluga_veiculo "
                + "WHERE finalizada = 0 AND cod_veiculo = "+cod+" ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaLocacoes.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("erro no BayCodVeiculo");
        }
       
       
    }
    
    private void updateTableByNome(String nome){
    
        String sql = "SELECT codigoLocacao, NomeCliente, modelo, placa, cod_veiculo,"
                + "data_retirada, data_entrega, valor_diaria, valor_pago, formaPgto, cadeirinha, GPS,"
                + "usouSeguro, avarias FROM cliente_aluga_veiculo "
                + "WHERE finalizada = 0 AND NomeCliente LIKE '%"+nome+"%' ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaLocacoes.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("erro no BayNome");
        }
       
       
    }
    
    private void updateTableByPlaca(String placa){
    
        String sql = "SELECT codigoLocacao, NomeCliente, modelo, placa, cod_veiculo,"
                + "data_retirada, data_entrega, valor_diaria, valor_pago, formaPgto, cadeirinha, GPS,"
                + "usouSeguro, avarias FROM cliente_aluga_veiculo "
                + "WHERE finalizada = 0 AND placa LIKE '%"+placa+"%' ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaLocacoes.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("erro no BayPlaca");
        }
       
       
    }
    
    
    
    
    private void finalizada1(){
        
        String sql = "SELECT codigoLocacao, NomeCliente, modelo, placa, cod_veiculo,"
                + "data_retirada, data_entrega, valor_diaria, valor_pago, formaPgto, cadeirinha, GPS,"
                + "usouSeguro, avarias FROM cliente_aluga_veiculo WHERE finalizada = 1";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaLocacoes.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("erro no finalizada!");
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        locacao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campoCodLocacao = new javax.swing.JTextField();
        clienteNome = new javax.swing.JLabel();
        campoNomeCliente = new javax.swing.JTextField();
        codV = new javax.swing.JLabel();
        campoCodVeiculo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoPlaca = new javax.swing.JTextField();
        campoFinalizada = new javax.swing.JCheckBox();
        filtrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLocacoes = new javax.swing.JTable();
        voltar = new javax.swing.JButton();

        locacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        locacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        locacao.setText("RELATÓRIO DE LOCAÇÕES");

        jLabel1.setText("Cod Locação :");

        clienteNome.setText("Nome Cliente :");

        codV.setText("Cod Veículo :");

        jLabel3.setText("Placa :");

        campoFinalizada.setText("Finalizada");
        campoFinalizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoFinalizadaActionPerformed(evt);
            }
        });

        filtrar.setText("Filtrar :");
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        tabelaLocacoes.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaLocacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaLocacoesMousePressed(evt);
            }
        });
        tabelaLocacoes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tabelaLocacoesMouseDragged(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaLocacoes);

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(locacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoFinalizada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCodLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codV)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCodVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(clienteNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoCodLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteNome)
                    .addComponent(campoNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codV)
                    .addComponent(campoCodVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoFinalizada)
                    .addComponent(filtrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(voltar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void tabelaLocacoesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLocacoesMousePressed
        
        tabelaLocacoes.editingCanceled(null);
    }//GEN-LAST:event_tabelaLocacoesMousePressed

    private void tabelaLocacoesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLocacoesMouseDragged
       int linhaSelecionada = tabelaLocacoes.getSelectedRow();
        int i = 1;

        if(tabelaLocacoes.isRowSelected(linhaSelecionada)){
            i++;
            if(i > 1){
                tabelaLocacoes.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaLocacoesMouseDragged

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
       // Botão filtro
        if(campoCodLocacao.getText().trim().equals("")){
            if(campoCodVeiculo.getText().trim().equals("")){
                if(campoNomeCliente.getText().trim().equals("")){
                    if(campoPlaca.getText().trim().equals("")){
                        updateTable();
                    }else{
                        updateTableByPlaca(campoPlaca.getText());
                    }
                }else{
                    updateTableByNome(campoNomeCliente.getText());
                }
            }else{
                updateTableByCodVeiculo(Integer.parseInt(campoCodVeiculo.getText()));
            }
        }else{
            updateTableByCod(Integer.parseInt(campoCodLocacao.getText()));
        }
    }//GEN-LAST:event_filtrarActionPerformed

    private void campoFinalizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoFinalizadaActionPerformed
        // TODO add your handling code here:
        if(campoFinalizada.isSelected()){
            finalizada1();
        }else{
            updateTable();
        }
        
    }//GEN-LAST:event_campoFinalizadaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoCodLocacao;
    private javax.swing.JTextField campoCodVeiculo;
    private javax.swing.JCheckBox campoFinalizada;
    private javax.swing.JTextField campoNomeCliente;
    private javax.swing.JTextField campoPlaca;
    private javax.swing.JLabel clienteNome;
    private javax.swing.JLabel codV;
    private javax.swing.JButton filtrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locacao;
    private javax.swing.JTable tabelaLocacoes;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
