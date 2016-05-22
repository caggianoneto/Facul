/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cadastros;

import control.ClienteBO;
import control.EnderecoBO;
import control.MaskFormater;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;
import model.Cliente;
import model.Endereco;
import view.Principal.PainelPrincipal;
import static view.Principal.telaPrincipal.painelCentral;


/**
 *
 * @author NIB2
 */
public class PainelCliente extends javax.swing.JPanel {

    /**
     * Creates new form PainelCliente
     */
    
    private Cliente cliente;
    private Endereco endereco;
    
    public PainelCliente() {
        initComponents();
        MaskFormater.mascaraData(campodataNascimento);
        MaskFormater.mascaraCPF(campocpf);
        MaskFormater.mascaraFoneRes(campoTelRes);
        MaskFormater.mascaraFoneRes(campoTelCel);
        MaskFormater.mascaraCEP(campoCep);
        MaskFormater.mascaraCnh(campoCnh);
    }

    // variáveis utilizada para conexao bd
    private static Connection conn = null;
    private static PreparedStatement pstm = null;
    private static ResultSet rs = null;
    
    // variaveis usadas na alteração de cliente
    private static boolean alterar = false;
    private static String altNome;
    private static String altDtaNasc;
    private static String altRG;
    private static String altCPF;
    private static String altCNH;
    private static String altNacionalidade;
    private static String altTelRes;
    private static String altTelCel;
    private static String altSexo;
    private static String altProfissao;
    private static String altEstadoCivil;
    
    // variáveis a serem alteradas do endereço
    private static String altLogradouro;
    private static String altNumero;
    private static String altPais;
    private static String altCidade;
    private static String altComplemento;
    private static String altES;
    private static String altCEP;
    private static String altBairo;
    private static int altCodCli;
    
    
    
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
            System.out.println("Erro no select do endereço do cliente");
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
        System.out.println("ALTERAR = "+alterar);
        altCodCli = codigo;
        
        String sql = "SELECT CPF, RG, NomeCompleto, NumeroCNH,"
                + "TelefoneRes, TelefoneCel, nacionalidade,"
                + "sexo, estadoCivil, DataNasc, Profissao FROM cliente WHERE Codigo = "+codigo+" ";
        
        
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                altCPF = rs.getString("CPF");
                altRG = rs.getString("RG");
                altNome = rs.getString("NomeCompleto");
                altCNH = rs.getString("NumeroCNH");
                altTelRes = rs.getString("TelefoneRes");
                altTelCel = rs.getString("TelefoneCel");
                altNacionalidade = rs.getString("nacionalidade");
                altSexo = rs.getString("sexo");
                altEstadoCivil = rs.getString("estadoCivil");
                altDtaNasc = rs.getString("DataNasc");
                altProfissao = rs.getString("Profissao");
                

            }
        } catch (Exception e) {
            System.out.println("erro nos campos");
        }
        System.out.println("cod passado "+altCodCli);
        selectEndereco(altCodCli);
        
        
        
         SwingUtilities.invokeLater(new Runnable() {
         public void run() {

          nomeCompleto.setText(altNome);
          campodataNascimento.setText(altDtaNasc);
          campoRg.setText(altRG);
          campocpf.setText(altCPF);
          campoCnh.setText(altCNH);
          campoNacionalidade.setText(altNacionalidade);
          campoTelRes.setText(altTelRes);
          campoTelCel.setText(altTelCel);
         
        
         }
         });
      

    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campodataNascimento = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campoProfissao = new javax.swing.JComboBox();
        campoSexo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        nomeCompleto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        campoComp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        campoCidade = new javax.swing.JTextField();
        campoCep = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        campoLogradouro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        campoNum = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        CadastroCliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoRg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoEstado = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        campoPais = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        campoEC = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        campoNacionalidade = new javax.swing.JTextField();
        campocpf = new javax.swing.JFormattedTextField();
        campoTelRes = new javax.swing.JFormattedTextField();
        campoTelCel = new javax.swing.JFormattedTextField();
        campoCnh = new javax.swing.JFormattedTextField();

        campodataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        campodataNascimento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campodataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campodataNascimentoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Data Nascimento:");

        campoBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBairroActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Bairro:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Contato");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Sexo:");

        campoProfissao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Agente transitário", "Arquitecto", "Administrador de bens", "Advogado", "Agente AFIS (aviação civil)", "Agente de investigação privada / Detetive", "Agente desportivo", "Agente funerário", "Agente imobiliário", "Agente público", "Aplicador de produtos anti-parasitários" }));
        campoProfissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoProfissaoActionPerformed(evt);
            }
        });

        campoSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        campoSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSexoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Profissão:");

        nomeCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeCompletoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome Completo :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Endereço");

        jLabel12.setText("CNH:");

        jButton2.setText("Enviar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("CEP:");

        jLabel23.setText("Estado:");

        campoLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLogradouroActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Rua:");

        campoNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumActionPerformed(evt);
            }
        });

        jLabel15.setText("Numero:");

        CadastroCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CadastroCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if(alterar == false){
            CadastroCliente.setText("CADASTRO CLIENTE");
        }else{
            CadastroCliente.setText("ALTERAÇÃO DE CLIENTE");
        }
        CadastroCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("RG: ");

        campoRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoRgActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("CPF: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Telefones : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Residencial :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Celular : ");

        campoEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC\t", "AL\t", "AP\t", "AM\t", "BA", "CE\t", "DF\t", "ES\t", "GO\t", "MA\t", "MT\t", "MS\t", "MG\t", "PA\t", "PB\t", "PR\t", "PE\t", "PI\t", "RJ\t", "RN\t", "RS\t", "RO\t", "RR\t", "SC\t", "SP\t", "SE\t", "TO", "OUTRO" }));

        jLabel24.setText("País:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Dados Pessoais");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Complemento:");

        jLabel25.setText("Estado Civil:");

        campoEC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solteiro", "Casado", "Divorciado", "Viuvo" }));

        jLabel26.setText("Nacionalidade:");

        campoNacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNacionalidadeActionPerformed(evt);
            }
        });

        campocpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campocpfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoComp, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(203, 203, 203))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(326, 326, 326)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(CadastroCliente))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campodataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addGap(4, 4, 4)
                                    .addComponent(campoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(campocpf, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                        .addComponent(campoCnh))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel26)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(campoProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(10, 10, 10)
                                    .addComponent(nomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campoSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel2))
                        .addComponent(campoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10)
                            .addComponent(campoSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(campodataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campocpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(campoProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(campoNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(campoCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(campoEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(campoTelRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel14))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(campoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(campoComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campodataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campodataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campodataNascimentoActionPerformed

    private void campoBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBairroActionPerformed

    private void campoProfissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoProfissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoProfissaoActionPerformed

    private void campoSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSexoActionPerformed

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

    private void campoCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCidadeActionPerformed

    private void campoCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCepActionPerformed

    private void campoLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoLogradouroActionPerformed

    private void campoNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumActionPerformed

    private void campoRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoRgActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Botão cadastrar cliente
        System.out.println("Botão cadastrar acionado");
        
        // Pegando valores informados na tela
        
        // pegando informações do cliente
        String nome = nomeCompleto.getText();
        String sexo = campoSexo.getSelectedItem().toString();
        String datanasc = campodataNascimento.getText();
        String rg = campoRg.getText();
        String cpf = campocpf.getText();
        String cnh = campoCnh.getText();
        String profissao = campoProfissao.getSelectedItem().toString();
        String estadoCivil = campoEC.getSelectedItem().toString();
        String nacionalidade = campoNacionalidade.getText();
        
        // pegando contatos
        String telRes = campoTelRes.getText();
        String telCel = campoTelCel.getText();
        
        // pegando informações de endereço
        String logradouro = campoLogradouro.getText();
        String numero = campoNum.getText();
        String cep = campoCep.getText();
        String pais = campoPais.getText();
        String cidade = campoCidade.getText();
        String estado = campoEstado.getSelectedItem().toString();
        String complemento = campoComp.getText();
        String bairro = campoBairro.getText();
        
        
        // Instanciando cliente e seu endereço
        
        Cliente c = this.cliente;
        Endereco e;
        
        if (nome.length() > 3 && sexo != null && datanasc != null
                 && rg.length() > 1 && cpf.length() == 14 && cnh.length() == 10
                 && profissao != null && estadoCivil != null && nacionalidade != null 
                 && (telRes.length() == 14 || telCel.length() == 14) && logradouro != null
                 && numero != null && cep.length() == 9 && pais != null 
                 && cidade != null && estado != null && complemento != null
                 && bairro != null ){ 
              
        if( alterar == false){
              System.out.println("validando cadastro");
              
             
                
            // criar um objeto Cliente
            c = new Cliente(cpf, rg, nome, cnh, sexo, datanasc, nacionalidade, estadoCivil, 
                            profissao, telRes, telCel);
            
            e = new Endereco(c.getCodigo(), logradouro, numero, cep, cidade, estado,
                             pais, bairro);
            
            e.setComplemento(complemento);
            
            // tentando fazer inserção do cliente no BD
            
            ClienteBO c2 = new ClienteBO();
                     
                
            if(c2.incluir(c)){
                    System.out.println("Cliente inserido com sucesso no BD");
                    if(c2.selecionarCod(c)){
                        System.out.println("Codigo selecionado!!");
                    }
                        
                            
            }else{
                    System.err.println("Erro de inserção");
            }
            
            
            // tentando fazer inserção do Endereco do cliente no BD
            
            EnderecoBO e2 = new EnderecoBO();
            
            if(e2.incluir(e)){
                
                System.out.println("Endereco do cliente inserido com sucesso no BD");
                    JOptionPane.showMessageDialog(this, "Cliente Cadastrado com sucesso"); 
                    
                    PainelPrincipal pn = new PainelPrincipal();
                    pn.setVisible(true);
                    painelCentral.removeAll();
                    pn.setSize(painelCentral.getSize());
                    painelCentral.add(pn);
                    painelCentral.revalidate();
                    painelCentral.repaint();
                
            }else{
                System.err.println("Ero de inserção do endereco");
            }
            
            
        }else{
            // ATUALIZA DADOS DO CLIENTE
            System.out.println("alterando cliente");
            
            // criar um objeto Cliente
            c = new Cliente(campocpf.getText(), campoRg.getText(), nomeCompleto.getText(), campoCnh.getText(),
                    campoSexo.getSelectedItem().toString(), campodataNascimento.getText(), campoNacionalidade.getText(),
                    campoEC.getSelectedItem().toString(), campoProfissao.getSelectedItem().toString(),
                    campoTelRes.getText(), campoTelCel.getText());
            
            e = new Endereco(altCodCli, campoLogradouro.getText(), campoNum.getText(), campoCep.getText(),
                    campoCidade.getText(), campoEstado.getSelectedItem().toString(), campoPais.getText(),
                    campoBairro.getText());
            
            e.setComplemento(campoComp.getText());
            
            // tentando fazer inserção do cliente no BD
            
            ClienteBO c2 = new ClienteBO();
            
            if (c2.alterar(c, altCodCli)) {

                // alterar endereço do cliente
                EnderecoBO e2 = new EnderecoBO();

                if (e2.alterar(e, altCodCli)) {

                    System.out.println("Endereco do cliente alterado com sucesso no BD");
                    JOptionPane.showMessageDialog(this, "Cliente Alterado com sucesso");

                    PainelPrincipal pn = new PainelPrincipal();
                    pn.setVisible(true);
                    painelCentral.removeAll();
                    pn.setSize(painelCentral.getSize());
                    painelCentral.add(pn);
                    painelCentral.revalidate();
                    painelCentral.repaint();

                } else {
                    System.err.println("Erro de inserção do endereco do cliente");
                }

            } else {
                System.err.println("Erro de inserção dos dados do cliente");
            }
            
            
            
        }
        }else{
                 
                 JOptionPane.showMessageDialog(this, "Cadastro Não realizado. "
                        + "\n\nFaltando dados");}   
            
        }
        
         
        
          
   
    
    

    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        // tratamento para operacoes de fechar a janela
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void campoNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNacionalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNacionalidadeActionPerformed

    private void nomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeCompletoActionPerformed

    private void campocpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campocpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campocpfActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CadastroCliente;
    private static javax.swing.JTextField campoBairro;
    private static javax.swing.JFormattedTextField campoCep;
    private static javax.swing.JTextField campoCidade;
    private static javax.swing.JFormattedTextField campoCnh;
    private static javax.swing.JTextField campoComp;
    private static javax.swing.JComboBox campoEC;
    private static javax.swing.JComboBox campoEstado;
    private static javax.swing.JTextField campoLogradouro;
    private static javax.swing.JTextField campoNacionalidade;
    private static javax.swing.JTextField campoNum;
    private static javax.swing.JTextField campoPais;
    private static javax.swing.JComboBox campoProfissao;
    private static javax.swing.JTextField campoRg;
    private static javax.swing.JComboBox campoSexo;
    private static javax.swing.JFormattedTextField campoTelCel;
    private static javax.swing.JFormattedTextField campoTelRes;
    private static javax.swing.JFormattedTextField campocpf;
    private static javax.swing.JFormattedTextField campodataNascimento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private static javax.swing.JTextField nomeCompleto;
    // End of variables declaration//GEN-END:variables
}
