/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cadastros;

import control.EnderecoBO;
import control.FornecedorBO;
import control.MaskFormater;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Endereco;
import model.Fornecedor;
import view.Principal.PainelPrincipal;
import static view.Principal.telaPrincipal.painelCentral;

/**
 *
 * @author Robson
 */
public class PainelCadastroFornecedor extends javax.swing.JPanel {

    /**
     * Creates new form PainelCadastroFornecedor
     */
    
    private Fornecedor fornecedor;
    private Endereco endereco;
    
    // variáveis utilizada para conexao bd
    private static Connection conn = null;
    private static PreparedStatement pstm = null;
    private static ResultSet rs = null;
    
    
    // variáveis utilizada na alteração do fornecedor
    private static boolean alterar = false;
    private static String altRS;
    private static String altCNPJ;
    private static String altNF;
    private static String altIE;
    // variáveis a serem alteradas do endereço
    private static String altLogradouro;
    private static String altNumero;
    private static String altPais;
    private static String altCidade;
    private static String altComplemento;
    private static String altES;
    private static String altCEP;
    private static String altBairo;
    private static String altVendedor;
    private static String altTelCom;
    private static String altEmail;
    private static String altCel;
    private static int altCodForn;
    
    
    
    
    public PainelCadastroFornecedor() {
        initComponents();
        MaskFormater.mascaraCNPJ(campoCNPJ);
        MaskFormater.mascaraCEP(campoCep);
        MaskFormater.mascaraFoneRes(campoTelCel);
        MaskFormater.mascaraFoneRes(campoTelcom);
    }
    
    public static void selectEndereco(int codigo){
        System.out.println("codigo = "+codigo);
        try {
            String sql = "SELECT Logradouro, numero, CEP, Pais, Complemento,"
                    + "Bairro, estado, cidade FROM endereco WHERE cod = "+codigo+" ";
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            
            while(rs.next()){
                
                altLogradouro = rs.getString("Logradouro");
                altNumero = rs.getString("numero");
                altCEP = rs.getString("CEP");
                altPais = rs.getString("Pais");
                altComplemento = rs.getString("Complemento");
                altBairo = rs.getString("Bairro");
                altES = rs.getString("estado");
                altCidade = rs.getString("cidade");
            }
            
            
            
        } catch (Exception e11) {
            System.out.println("Erro no select do endereço do fornecedor");
        }
        
        
        
        SwingUtilities.invokeLater(new Runnable() {
         public void run() {

         // campos de endereço
         
         campoLogradouro.setText(altLogradouro);
         campoNum.setText(String.valueOf(altNumero));
         campoPais.setText(altPais);
         campoCidade.setText(altCidade);
         campoComp.setText(altComplemento);
         campoCep.setText(altCEP);
         campoBairro.setText(altBairo);
         

         }
         });
        
        
    }

    
    public static void metodoAlterar(final int codigo) {
        alterar = true;
        //System.out.println("codigo = " + codigo);
        altCodForn = codigo;
        
        String sql = "SELECT razaoSocial, cnpj, nomeFantasia, IE, vendedor, telComercial,"
                + "telCel, email FROM fornecedor WHERE codigo = "+codigo+" ";
        
        
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                altRS = rs.getString("razaoSocial");
                altCNPJ = rs.getString("cnpj");
                altNF = rs.getString("nomeFantasia");
                altIE = rs.getString("IE");
                altVendedor = rs.getString("vendedor");
                altTelCom = rs.getString("telComercial");
                altCel = rs.getString("telCel");
                altEmail = rs.getString("email");
                

            }
        } catch (Exception e) {
            System.out.println("erro nos campos");
        }
        System.out.println("cod passado "+altCodForn);
        selectEndereco(altCodForn);
        
        
        
         SwingUtilities.invokeLater(new Runnable() {
         public void run() {

         campoRS.setText(altRS);
         campoCNPJ.setText(altCNPJ);
         campoNF.setText(altNF);
         campoIE.setText(altIE);
         campoVendedor.setText(altVendedor);
         campoTelcom.setText(altTelCom);
         campoTelCel.setText(altCel);
         campoEmail.setText(altEmail);
         
        
         }
         });
      

    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoRS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoIE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoNF = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        campoVendedor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        campoTelCel = new javax.swing.JFormattedTextField();
        campoTelcom = new javax.swing.JFormattedTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        campoLogradouro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        campoNum = new javax.swing.JTextField();
        campoBairro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        campoEstado = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        campoPais = new javax.swing.JTextField();
        campoCidade = new javax.swing.JTextField();
        campoCep = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        campoCNPJ = new javax.swing.JFormattedTextField();
        campoEmail = new javax.swing.JTextField();
        botaoVoltar = new javax.swing.JButton();
        botaoEnviar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        campoComp = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(alterar == false){
            jLabel1.setText("CADASTRO FORNECEDOR");
        }else{
            jLabel1.setText("ALTERAÇÃO DE FORNECEDOR");
        }

        jLabel2.setText("Razão Social:");

        campoRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoRSActionPerformed(evt);
            }
        });

        jLabel3.setText("CNPJ:");

        jLabel4.setText("IE:");

        campoIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIEActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Contato");

        jLabel6.setText("Nome fantasia:");

        jLabel7.setText("Vendedor:");

        campoVendedor.setText("   ");
        campoVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoVendedorActionPerformed(evt);
            }
        });

        jLabel8.setText("Tel Comecial:");

        jLabel11.setText("Celular : ");

        jLabelEmail.setText("E-mail:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Endereço");

        jLabel23.setText("Estado:");

        campoLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLogradouroActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("CEP:");

        jLabel15.setText("Numero:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Rua:");

        campoNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumActionPerformed(evt);
            }
        });

        campoBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBairroActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Bairro:");

        campoEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC\t", "AL\t", "AP\t", "AM\t", "BA", "CE\t", "DF\t", "ES\t", "GO\t", "MA\t", "MT\t", "MS\t", "MG\t", "PA\t", "PB\t", "PR\t", "PE\t", "PI\t", "RJ\t", "RN\t", "RS\t", "RO\t", "RR\t", "SC\t", "SP\t", "SE\t", "TO", "OUTRO" }));

        jLabel24.setText("País:");

        campoCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCidadeActionPerformed(evt);
            }
        });

        campoCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCepActionPerformed(evt);
            }
        });

        jLabel22.setText("Cidade:");

        campoEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoEmailFocusLost(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoEnviar.setText("Enviar");
        botaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEnviarActionPerformed(evt);
            }
        });

        jLabel9.setText("Complemento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoRS, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNF)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoIE, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoComp, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelEmail)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoTelcom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoTelCel))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(campoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campoNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(campoIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel14))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(campoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(campoComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(campoTelcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(campoTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoEnviar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoRSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoRSActionPerformed

    private void campoVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoVendedorActionPerformed

    private void campoLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoLogradouroActionPerformed

    private void campoNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumActionPerformed

    private void campoBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBairroActionPerformed

    private void campoCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCidadeActionPerformed

    private void campoCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCepActionPerformed

    private void campoIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIEActionPerformed

    private void campoEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoEmailFocusLost
        // Validando campo email
        
        if ((campoEmail.getText().contains("@")) 
                && (campoEmail.getText().contains(".")) 
                && (!campoEmail.getText().contains(" "))){ 
            String usuario = new String(campoEmail.getText().substring(0, campoEmail.getText().lastIndexOf('@')));
            String dominio = new String(campoEmail.getText().substring(campoEmail.getText().lastIndexOf ('@') 
                    + 1, campoEmail.getText().length()));
            
            if ((usuario.length() >=1) && (!usuario.contains("@")) 
                    && (dominio.contains(".")) && (!dominio.contains("@")) 
                    && (dominio.indexOf(".") >= 1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {
                
                jLabelEmail.setText("E-mail Valido!");
                
            }else{ 
                jLabelEmail.setText("E-mail Inválido");
                campoEmail.requestFocus();
            } 
            }else{ 
                    jLabelEmail.setText("E-mail Inválido"); 
                    campoEmail.requestFocus(); 
                }


    }//GEN-LAST:event_campoEmailFocusLost

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // BOTÃO VOLTAR ACIONADO
        
        PainelPrincipal pn = new PainelPrincipal();
        pn.setVisible(true);
        painelCentral.removeAll();
        pn.setSize(painelCentral.getSize());
        painelCentral.add(pn);
        painelCentral.revalidate();
        
        
        painelCentral.repaint();
        
        
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarActionPerformed
        // BOTÃO ENVIAR ACIONADO
        System.out.println("Botão enviar acionado!");
        
        // Pegando valores informados na tela
        
        // pegando informações do fornecedor
        String razaoSocial = campoRS.getText();
        String cnpj = campoCNPJ.getText();
        String nomeFant = campoNF.getText();
        String incricaoE = campoIE.getText();
        
        // coletando informações de endereço do fornecedor
        
        String logradouro = campoLogradouro.getText();
        String numero = campoNum.getText();
        String cep = campoCep.getText();
        String pais = campoPais.getText();
        String cidade = campoCidade.getText();
        String estado = campoEstado.getSelectedItem().toString();
        String bairro = campoBairro.getText();
        String complemento = campoComp.getText();
        
        // coletando informações de contato
        
        String telCom = campoTelcom.getText();
        String telCel = campoTelCel.getText();
        String vendedor = campoVendedor.getText();
        String email = campoEmail.getText();
        
        
        // Instanciando fornecedor e seu endereço
        
        Fornecedor f = this.fornecedor;
        Endereco e = this.endereco;
        
        
         // validando os campos
        if (razaoSocial.length() > 3 && cnpj.length() == 17  
                 && (telCel.length() == 14 || telCom.length() == 14) && logradouro != null
                 && numero != null && cep.length() == 9 && pais != null 
                 && cidade != null && estado != null 
                 && bairro != null ){
        
        if( alterar == false){
              System.out.println("validando cadastro");
                        
                  // criar um objeto Fornecedor
                  f = new Fornecedor(cnpj, razaoSocial, nomeFant, incricaoE);
                  
                  f.setTelefone1(telCom);
                  f.setTelefone2(telCel);
                  f.setVendedor(vendedor);
                  f.setEmail(email);
            
                  e = new Endereco(f.getCodigo(), logradouro, numero, cep, cidade, estado,
                             pais, bairro);
                  e.setComplemento(complemento);
            
                  // tentando fazer inserção do fornecedor no BD
                        
                  FornecedorBO f2 = new FornecedorBO();
                  
                      
                        if(f2.incluir(f)){
                            System.out.println("Fornecedor inserido com sucesso no BD");
                            if(f2.selecionarCod(f)){
                                System.out.println("Cod selecionado!!");
                            }
                            
                        }else{
                            System.err.println("Erro de inserção");
                            }
                            
             
             
                  // tentando fazer inserção do Endereco do cliente no BD
            
                  EnderecoBO e2 = new EnderecoBO();
            
                  if (e2.incluir(e)) {

                    System.out.println("Endereco do fornecedor inserido com sucesso no BD");
                    JOptionPane.showMessageDialog(this, "Fornecedor Cadastrado com sucesso");

                    PainelPrincipal pn = new PainelPrincipal();
                    pn.setVisible(true);
                    painelCentral.removeAll();
                    pn.setSize(painelCentral.getSize());
                    painelCentral.add(pn);
                    painelCentral.revalidate();
                    painelCentral.repaint();

                } else {
                    System.err.println("Erro de inserção do endereco");
                }
            
        } else {
            System.out.println("Alterando cadastro");
            
            
            f = new Fornecedor(campoCNPJ.getText(),campoRS.getText(),campoNF.getText(),campoIE.getText());
            
            f.setTelefone1(campoTelcom.getText());
            f.setTelefone2(campoTelCel.getText());
            f.setVendedor(campoVendedor.getText());
            f.setEmail(campoEmail.getText());
            
            
            
            
            
            
            e = new Endereco(altCodForn, campoLogradouro.getText(), campoNum.getText(), campoCep.getText(),
                    campoCidade.getText(), campoEstado.getSelectedItem().toString(), 
                    campoPais.getText(), campoBairro.getText());
            
                  e.setComplemento(campoComp.getText());
            
                  // tentando fazer inserção do fornecedor no BD
                        
                  FornecedorBO f2 = new FornecedorBO();
                  
                  if(f2.alterar(f,altCodForn)){
                            System.out.println("Fornecedor alterado com sucesso no BD");
                            
                        }else{
                            System.err.println("Erro de update");
                            }
                  
                  // tentando fazer update do Endereco do cliente no BD
            
                  EnderecoBO e2 = new EnderecoBO();
            
                  if (e2.alterar(e,altCodForn)) {

                    System.out.println("Endereco do fornecedor alterado com sucesso no BD");
                    JOptionPane.showMessageDialog(this, "Fornecedor Alterado com sucesso");

                    PainelPrincipal pn = new PainelPrincipal();
                    pn.setVisible(true);
                    painelCentral.removeAll();
                    pn.setSize(painelCentral.getSize());
                    painelCentral.add(pn);
                    painelCentral.revalidate();
                    painelCentral.repaint();

                } else {
                    System.err.println("Erro de inserção do endereco");
                }
            
            
            
        }
        }else{
                JOptionPane.showMessageDialog(this, "Cadastro Não realizado. "
                        + "\n\nFaltando dados");
            }
              
              
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_botaoEnviarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JButton botaoVoltar;
    private static javax.swing.JTextField campoBairro;
    private static javax.swing.JFormattedTextField campoCNPJ;
    private static javax.swing.JFormattedTextField campoCep;
    private static javax.swing.JTextField campoCidade;
    private static javax.swing.JTextField campoComp;
    private static javax.swing.JTextField campoEmail;
    private static javax.swing.JComboBox campoEstado;
    private static javax.swing.JTextField campoIE;
    private static javax.swing.JTextField campoLogradouro;
    private static javax.swing.JTextField campoNF;
    private static javax.swing.JTextField campoNum;
    private static javax.swing.JTextField campoPais;
    private static javax.swing.JTextField campoRS;
    private static javax.swing.JFormattedTextField campoTelCel;
    private static javax.swing.JFormattedTextField campoTelcom;
    private static javax.swing.JTextField campoVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
