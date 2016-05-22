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
import view.cadastros.PainelCadastroFornecedor;

/**
 *
 * @author NIB2
 */
public class RelatorioFornecedor extends javax.swing.JPanel {

    /**
     * Creates new form RelatorioFornecedor
     */
    // variaveis de conexão com bd
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private static int cod;
    
    public RelatorioFornecedor() {
        initComponents();
        conn = ConnectionFactory.getConexao();
        
        updateTableForn();
        CampoCod();
    }

   
     private void updateTableForn(){
               
      String sql = "SELECT codigo, cnpj, razaoSocial, nomeFantasia, vendedor, telComercial, telCel, email FROM fornecedor";   
         
        try {
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaForn.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println("Erro no select do bd");
        }
        
    }
     
     private void updateTable2(String nome, String cnpj){
        
        try {
            String sql = "SELECT codigo, cnpj, razaoSocial, nomeFantasia, vendedor, telComercial, telCel, email "
                    + "FROM fornecedor WHERE nomeFantasia LIKE '%"+nome+"%' AND cnpj LIKE '%"+cnpj+"%' ";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaForn.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("Erro 2 no select do bd");
        }
    }
     
     
     private void updateTableByCod(int cod){
        
        try {
            String sql = "SELECT codigo, cnpj, razaoSocial, nomeFantasia, vendedor, telComercial, telCel, email "
                    + "FROM fornecedor WHERE codigo = "+cod+" ";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaForn.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("Erro 2 no select do bd");
        }
    }
     
     
     
     
     private void CampoCod(){
        
        try {
            String sql = "SELECT Codigo FROM fornecedor";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            campoCod.addItem(" ");
            
            while(rs.next()){
                int codForn = rs.getInt("Codigo");               
                campoCod.addItem(codForn);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox cod fornecedor");
        }
        
    }
     
     
     private void ExcluirFornecedor(int codigo){
        
        String sql = "DELETE FROM fornecedor WHERE codigo = "+codigo+" ";
                
        
        try {
            pst = conn.prepareStatement(sql);
        
            
            if (pst.executeUpdate() > 0) {
                pst.close();                                      
            } else {
                pst.close();              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o fornecedor!");
        }
        
        String sql2 = "DELETE FROM endereco WHERE cod = "+codigo+" ";
        
        try {
            
            pst = conn.prepareStatement(sql2);
        
            
            if (pst.executeUpdate() > 0) {
                pst.close();                          
                JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");            
            } else {
                pst.close();              
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o end do fornecedor!");
        }            
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoNome = new javax.swing.JTextField();
        filtrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaForn = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        campoCNPJ = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        campoCod = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        filtrar.setText("Filtrar :");
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RELATÓRIO DE FORNECEDORES");

        nome.setText("Nome :");

        tabelaForn.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaForn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFornMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaFornMousePressed(evt);
            }
        });
        tabelaForn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tabelaFornMouseDragged(evt);
            }
        });
        tabelaForn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaFornKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaForn);

        jLabel3.setText("CNPJ :");

        jLabel4.setText("Codigo:");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 250, 250)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCod, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(campoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(campoCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
        // botão filtrar
        if(campoCod.getSelectedIndex() == 0)
            updateTable2(campoNome.getText() ,campoCNPJ.getText());
        else
            updateTableByCod(Integer.parseInt(campoCod.getSelectedItem().toString()));
            
    }//GEN-LAST:event_filtrarActionPerformed

    private void tabelaFornMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornMousePressed
        // TODO add your handling code here:
        tabelaForn.editingCanceled(null);
    }//GEN-LAST:event_tabelaFornMousePressed

    private void tabelaFornMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornMouseDragged

        int linhaSelecionada = tabelaForn.getSelectedRow();
        int i = 1;

        if(tabelaForn.isRowSelected(linhaSelecionada)){
            i++;
            if(i > 1){
                tabelaForn.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaFornMouseDragged

    private void tabelaFornKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaFornKeyPressed
        // TODO add your handling code here:
        int linhaSelecionada = tabelaForn.getSelectedRow();
        int i = 1;

        if(tabelaForn.isRowSelected(linhaSelecionada)){
            i++;
            if(i > 1){
                tabelaForn.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaFornKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // botão excluir
        int linha = tabelaForn.getSelectedRow();
         cod = -1;
        
        try {
            cod = Integer.parseInt(tabelaForn.getValueAt(linha, 0).toString());
        } catch (Exception e) {
            System.out.println("Erro ao pegar o cod do fornecedor selecionado");
        }
        
        if(linha == -1){
            JOptionPane.showMessageDialog(null,"Selecione um fornecedor antes de excluir!",
                    "Nenhum fornecedor selecionado", JOptionPane.WARNING_MESSAGE);
        }else{
            Object[] options = { "Excluir", "Cancelar" };  
        int opcao = JOptionPane.showOptionDialog(null, "Deseja realmente excluir o fornecedor?",
                "Atenção!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
        if(opcao == 0){
            // exclua o cliente!
            ExcluirFornecedor(cod);
            updateTableForn();
        }
        }
            
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        PainelPrincipal pn = new PainelPrincipal();
        pn.setVisible(true);
        painelCentral.removeAll();
        pn.setSize(painelCentral.getSize());
        painelCentral.add(pn);
        painelCentral.revalidate();

        painelCentral.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Botão alterar
        
        int linhaSelecionada = tabelaForn.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor antes!!");
        } else {
              
                cod = Integer.parseInt(tabelaForn.getValueAt(linhaSelecionada, 0).toString());
                //System.out.println("codigo passado = "+cod);
                PainelCadastroFornecedor.metodoAlterar(cod);

                PainelCadastroFornecedor pf = new PainelCadastroFornecedor();
                pf.setVisible(true);
                painelCentral.removeAll();
                pf.setSize(painelCentral.getSize());
                painelCentral.add(pf);
                painelCentral.revalidate();

                painelCentral.repaint();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelaFornMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFornMouseClicked
        // mouse clicked
        int linhaSelecionada = tabelaForn.getSelectedRow();
        
        try {
            cod = Integer.parseInt(tabelaForn.getValueAt(linhaSelecionada, 0).toString());
        } catch (Exception e) {
            System.out.println("Erro ao pegar cod do fornecedor da tabela");
        }
        
        
        
        if (evt.getClickCount() == 2) {
            //JOptionPane.showMessageDialog(null, "Clicou 2 x $%¨#*!!!!");
             new FornecedorSelecionado().setVisible(true);
             FornecedorSelecionado.updateValores(cod);
             
        }
    }//GEN-LAST:event_tabelaFornMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoCNPJ;
    private javax.swing.JComboBox campoCod;
    private javax.swing.JTextField campoNome;
    private javax.swing.JButton filtrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nome;
    private javax.swing.JTable tabelaForn;
    // End of variables declaration//GEN-END:variables
}
