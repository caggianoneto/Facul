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
import view.cadastros.PainelCliente;

/**
 *
 * @author NIB
 */
public class RelatorioCliente extends javax.swing.JPanel {

    // variaveis de conexão com bd
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private static int cod;

    
    public RelatorioCliente() {
        initComponents();
        conn = ConnectionFactory.getConexao();
        updateTabelaCliente();
        campoCod();
    }

    private void updateTabelaCliente(){
               
        try {
            String sql = "SELECT Codigo, NomeCompleto as NOME, CPF, sexo, DataNasc, TelefoneRes, TelefoneCel FROM cliente";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaCliente.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.out.println("Erro no select do bd");
        }
        
    }
    
    private void updateTabelaCliente2(String nome, String cpf){
        
        String where = " WHERE ";
        
        try {
            String sql = "SELECT Codigo, NomeCompleto, CPF, sexo, DataNasc, TelefoneRes,"
                    + " TelefoneCel FROM cliente ";
            if ( !nome.equals("") ) {
                sql = sql + where + " NomeCompleto LIKE '%" + nome + "%' ";
                where = " AND ";
            }
            
            if ( !cpf.equals("") ) {
                sql = sql + where + " CPF LIKE '%" + cpf + "%' ";
                where = " AND ";
            }
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaCliente.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("Erro 2 no select do bd");
        }
    }
    
    private void updateByCod(int codigo){
        
        try {
            String sql = "SELECT Codigo, NomeCompleto, CPF, sexo, DataNasc, TelefoneRes,"
                    + " TelefoneCel FROM cliente WHERE Codigo = "+codigo+" ";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaCliente.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println("Erro 3 no select do bd");
        }
        
    }
    
    private void excluirCliente(int codigo){
        
        String sql = "DELETE FROM cliente WHERE Codigo = "+codigo+" ";
                
        
        try {
            pst = conn.prepareStatement(sql);
        
            
            if (pst.executeUpdate() > 0) {
                pst.close();                                      
            } else {
                pst.close();              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o cliente!");
        }
        
        String sql2 = "DELETE FROM endereco WHERE cod = "+codigo+" ";
        
        try {
            
            pst = conn.prepareStatement(sql2);
        
            
            if (pst.executeUpdate() > 0) {
                pst.close();                          
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");            
            } else {
                pst.close();              
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o end do cliente!");
        }            
    }
    
    private void campoCod(){
        
        try {
            String sql = "SELECT Codigo FROM cliente";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            campoCod.addItem(" ");
            
            while(rs.next()){
                int codCliente = rs.getInt("Codigo");               
                campoCod.addItem(codCliente);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox cod cliente");
        }
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        campoNome = new javax.swing.JTextField();
        voltar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campoCPF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        campoCod = new javax.swing.JComboBox();
        filtrar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RELATÓRIO DE CLIENTES");

        jLabel2.setText("Nome :");

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaClienteMousePressed(evt);
            }
        });
        tabelaCliente.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseDragged(evt);
            }
        });
        tabelaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaClienteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jButton1.setText("Excluir");
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

        jLabel3.setText("CPF:");

        jLabel4.setText("Codigo:");

        filtrar.setText("Filtrar :");
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCod, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(campoCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltar)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void tabelaClienteMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseDragged
        
        int linhaSelecionada = tabelaCliente.getSelectedRow();
        int i = 1;
        
        
        if(tabelaCliente.isRowSelected(linhaSelecionada)){
            i++;          
            if(i > 1){
                tabelaCliente.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaClienteMouseDragged

    private void tabelaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaClienteKeyPressed
        // TODO add your handling code here:
        int linhaSelecionada = tabelaCliente.getSelectedRow();
        int i = 1;
        
        
        if(tabelaCliente.isRowSelected(linhaSelecionada)){
            i++;          
            if(i > 1){
                tabelaCliente.clearSelection();
            }
        }
    }//GEN-LAST:event_tabelaClienteKeyPressed

    private void tabelaClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMousePressed
        // TODO add your handling code here:
        tabelaCliente.editingCanceled(null);
    }//GEN-LAST:event_tabelaClienteMousePressed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        // mouse clicked da Jtable 
        int linhaSelecionada = tabelaCliente.getSelectedRow();
        
        try {
            cod = Integer.parseInt(tabelaCliente.getValueAt(linhaSelecionada, 0).toString());
        } catch (Exception e) {
            System.out.println("Erro ao pegar cod do cliente da tabela");
        }
        
        
        
        if (evt.getClickCount() == 2) {
            //JOptionPane.showMessageDialog(null, "Clicou 2 x $%¨#*!!!!");
             new ClienteSelecionado().setVisible(true);
             ClienteSelecionado.updateValores(cod);
             
        }
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // botão excluir acionado
        int linha = tabelaCliente.getSelectedRow(); 
        //System.out.println("linha = "+linha);
        try {
            cod = Integer.parseInt(tabelaCliente.getValueAt(linha, 0).toString());
        } catch (Exception e) {
            System.out.println("Erro ao pegar cod do cliente da tabela");
        }    
        
        if(linha == -1){
            JOptionPane.showMessageDialog(null,"Selecione um cliente antes de excluir!",
                    "Nenhum cliente selecionado", JOptionPane.WARNING_MESSAGE);
        }else{
            Object[] options = { "Excluir", "Cancelar" };  
        int opcao = JOptionPane.showOptionDialog(null, "Deseja realmente excluir o cliente?",
                "Atenção!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
        if(opcao == 0){
            // exclua o cliente!
            excluirCliente(cod);
            updateTabelaCliente();
        }
        
        }
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
        // botão filtrar
        //Updatetable...
        String nome = campoNome.getText();
        String cpf = campoCPF.getText(); 
        int codigo;
        
        
        if(campoCod.getSelectedItem().toString().trim().equals("")){
            updateTabelaCliente2(nome, cpf);
        }else{
            try {
                codigo = Integer.parseInt(campoCod.getSelectedItem().toString());
                updateByCod(codigo);            
            } catch (Exception e) {
                System.out.println("Erro!!!");
            }
            
            
        }
    }//GEN-LAST:event_filtrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // botão alterar cliente
        //System.out.println("cod = "+cod);
        PainelCliente.metodoAlterar(cod);
        
        int linhaSelecionada = tabelaCliente.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente antes!!");
        } else {
             
                PainelCliente.metodoAlterar(cod);

                PainelCliente pc = new PainelCliente();
                pc.setVisible(true);
                painelCentral.removeAll();
                pc.setSize(painelCentral.getSize());
                painelCentral.add(pc);
                painelCentral.revalidate();

                painelCentral.repaint();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JComboBox campoCod;
    private javax.swing.JTextField campoNome;
    private javax.swing.JButton filtrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
