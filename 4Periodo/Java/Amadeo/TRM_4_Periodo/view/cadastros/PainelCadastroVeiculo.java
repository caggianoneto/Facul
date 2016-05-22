/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cadastros;


import control.MaskFormater;
import control.VeiculoBO;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Veiculo;
import view.Principal.PainelPrincipal;
import static view.Principal.telaPrincipal.painelCentral;
import view.Relatorios.RelatorioVeiculo;
/**
 *
 * @author Robson
 */
public class PainelCadastroVeiculo extends javax.swing.JPanel {

    /**
     * Creates new form PainelCadastroVeiculo
     */
    
    private boolean status1 = false;
    private float vd = 0.0f;
    private float vs = 0.0f;
    private Veiculo veiculo;
    private String opcional;
    
    
    private static Connection conn = null;
    private static PreparedStatement pstm = null;
    private static ResultSet rs = null;
    
    private static boolean alterar = false;
    private static boolean altStatus;
    private static String altModelo;
    private static String altPlaca;
    private static String altRenavam; 
    private static String altChassi;
    private static String altMotor;
    private static String altMarca;
    private static String altCor;
    private static int altCodVenda;
    private static float altVD;
    private static float altVS;
    private static int altCodVeiculo;
    
   
 
    
    
     
    public static void metodoAlterar(final int codigo) {
        alterar = true;
        //System.out.println("codigo = " + codigo);
        altCodVeiculo = codigo;
        
        String sql = "SELECT modelo, placa, renavam, numChassi, valorDiaria,"
                + " valorSeguro, motor, cod_venda FROM veiculo WHERE codigo = " + codigo + " ";
        try {
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                altModelo = rs.getString("modelo");
                altPlaca =  rs.getString("placa");
                altRenavam =  rs.getString("renavam");
                altChassi =  rs.getString("numChassi");
                altVD =  rs.getFloat("valorDiaria");
                altVS = rs.getFloat("valorSeguro");
                altMotor =  rs.getString("motor");
                altCodVenda =  rs.getInt("cod_venda");
                altCor = rs.getString("cor");
                altMarca = rs.getString("marca");
                altStatus = rs.getBoolean("status");

            }
        } catch (Exception e) {
            System.out.println("erro nos campos");
        }
        
        //campoMarca.setSelectedItem(altMarca);
        //campoCor.setSelectedItem(altCor);
        //campoStatus.setSelectedItem(altStatus);
        
         SwingUtilities.invokeLater(new Runnable() {
         public void run() {

         campoModelo.setText(altModelo);
         campoPlaca.setText(altPlaca);
         campoRenavam.setText(altRenavam);
         campoChassi.setText(altChassi);
         campoVD.setText(String.valueOf(altVD));
         campoValorSeguro.setText(String.valueOf(altVS));
         campoMotor.setText(altMotor);
         campoCodvenda.setText(String.valueOf(altCodVenda));
         
         }
         });
      

    }
  
    
    
    
    public float validaNumero(String Numero) { 
        float valor; 
        if (Numero.length() != 0){ 
        try { 
            valor = Float.parseFloat(Numero);
            return valor;
        }catch(NumberFormatException ex){ 
            JOptionPane.showMessageDialog(null, "Esse Campo só aceita números" ,"Informação",JOptionPane.INFORMATION_MESSAGE); 
             
                                        } 
                                            }
        return -1;
    }
    
    
    public void campoBoxForn(){
        
        
        
        try {
            String sql = "SELECT razaoSocial FROM fornecedor";
            
            conn = ConnectionFactory.getConexao();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                String nome = rs.getString("razaoSocial");
                campoForn.addItem(nome);
            }                                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no combobox");
        }
        
    }
    
    
    
    
    public PainelCadastroVeiculo() {
        initComponents();   
        campoBoxForn();
        if(alterar == false){
            MaskFormater.mascaraPlaca(campoPlaca);
            MaskFormater.mascaraRenavam(campoRenavam);
            MaskFormater.mascaraChassi(campoChassi);
        }
        
    }

    private String verOpcionais(){
        String opcionais;
        
        if(pacoteLight.isSelected()){
            opcionais = "Alarme  Trava Elétrica  Desemb. Traseiro  Ar quente"; 
        }else if(pacoteSuper.isSelected()){
            opcionais = "Alarme  Trava Elétrica  Ar condicionado  Desemb. Traseiro  Vidro E  Direção  Ar quente  Som";
        }else if(pacoteFull.isSelected()){
            opcionais = "Alarme  Trava Elétrica  Ar condicionado  Desemb. Traseiro  Vidro E  Direção  ABS  Ar quente  Rodas Liga leve  Som";
        }else{
            opcionais = null;
        }
        return opcionais;
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modelo = new javax.swing.JLabel();
        cor = new javax.swing.JLabel();
        campoCor = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        renavan = new javax.swing.JLabel();
        placa = new javax.swing.JLabel();
        CadastroVeiculo = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        campoMarca = new javax.swing.JComboBox();
        campoModelo = new javax.swing.JTextField();
        ano = new javax.swing.JLabel();
        campoAno = new javax.swing.JComboBox();
        valorDiaria = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        campoStatus = new javax.swing.JComboBox();
        campoPlaca = new javax.swing.JFormattedTextField();
        campoVD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pacoteFull = new javax.swing.JCheckBox();
        pacoteLight = new javax.swing.JCheckBox();
        pacoteSuper = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        campoForn = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        campoCodvenda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoRenavam = new javax.swing.JFormattedTextField();
        campoChassi = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        campoMotor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoCambio = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        campoPortas = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        campoComb = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        campoValorSeguro = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(495, 513));

        modelo.setText("Modelo: ");

        cor.setText("Cor:");

        campoCor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AMARELO", "AZUL", "BRANCO", "BEGE", "CANELA", "CINZA", "FUSCIA", "LARANJA", "MARROM", "MAGENTA", "OURO", "PRATA", "PRETO", "ROSA", "ROXO", "VERDE", "VERDE LIMÃO", "VERMELHO", "VIOLETA", "VINHO" }));

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Enviar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        renavan.setText("Renavan:");

        placa.setText("Placa:");

        CadastroVeiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        if(alterar == false){
            CadastroVeiculo.setText("CADASTRO VEÍCULOS");
        }else{
            CadastroVeiculo.setText("ALTERAR VEÍCULO");
        }

        marca.setText("Marca:");

        campoMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acura", "Alfa Romeo", "Aston Martin", "Audi", "BMW", "Bentley", "Bugatti", "Dodge", "Chevrolet", "Chery", "Citroen", "Chrysler", "Effa", "Ferrari", "Fiat", "Ford", "Hafei", "Honda", "Hyundai", "Hummer", "Iveco", "Jac Motors", "Jaguar", "Jeep", "Jimbei", "Kia", "Koenigsegg", "Lamborguini", "Land Rover", "Lexus", "Lifan", "Lincoln", "Lotus", "Maserati", "Mazda", "Mercedes-Benz", "Mitsubishi", "MG Motors", "Mini", "Nissan", "Pagani", "Peugeot", "Pontiac", "Porsche", "Ram", "Renault", "Rolls Royce", "Seat", "Smart", "Ssangyong", "Subaru", "Suzuki", "TVR", "Toyota", "Troller", "Volkswagen", "Volvo" }));
        campoMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMarcaActionPerformed(evt);
            }
        });

        campoModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoModeloActionPerformed(evt);
            }
        });

        ano.setText("Ano:");

        campoAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));

        valorDiaria.setText("Valor diária:");

        status.setText("Status:");

        campoStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponível", "Indisponível" }));

        campoVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoVDActionPerformed(evt);
            }
        });

        jLabel1.setText("Opcionais");

        pacoteFull.setText("Pacote Full");
        pacoteFull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacoteFullActionPerformed(evt);
            }
        });

        pacoteLight.setText("Pacote Light");

        pacoteSuper.setText("Pacote Super");

        jLabel2.setText("Informações de Fornecedor");

        jLabel3.setText("Fornecedor :");

        campoForn.setToolTipText("");
        campoForn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoFornActionPerformed(evt);
            }
        });

        jLabel4.setText("Cod Venda :");

        jLabel5.setText("Chassi:");

        jLabel6.setText("Motor :");

        jLabel7.setText("Câmbio :");

        campoCambio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manual", "Automático" }));

        jLabel8.setText("Portas :");

        campoPortas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   2 ", "   4 " }));

        jLabel9.setText("Combustível:");

        campoComb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Flex ", "Gasolina", "Álcool", "Diesel", "Gás", "Elétrico" }));

        jLabel10.setText("Valor do seguro:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modelo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(placa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoChassi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(renavan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(campoValorSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(valorDiaria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoVD, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(CadastroVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(marca)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(status)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(campoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel10)
                                                            .addComponent(campoCambio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(ano)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(campoPortas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pacoteLight)
                                .addGap(38, 38, 38)
                                .addComponent(pacoteSuper)
                                .addGap(18, 18, 18)
                                .addComponent(pacoteFull)))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoComb, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campoCodvenda))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campoForn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CadastroVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelo)
                    .addComponent(renavan)
                    .addComponent(placa)
                    .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cor)
                    .addComponent(campoCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marca)
                    .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(campoChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorDiaria)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ano)
                        .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(status)
                        .addComponent(campoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoVD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(campoPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campoComb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(campoValorSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacoteLight)
                    .addComponent(pacoteSuper)
                    .addComponent(pacoteFull))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoCodvenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        alterar = false;    
     
        if(campoModelo.getText().trim().equals("")){
            
            PainelPrincipal pn = new PainelPrincipal();
            pn.setVisible(true);
            painelCentral.removeAll();
            pn.setSize(painelCentral.getSize());
            painelCentral.add(pn);
            painelCentral.revalidate();

            painelCentral.repaint();
        }else{
            
            //System.out.println("nao esta vazio!");
            RelatorioVeiculo rv = new RelatorioVeiculo();
            rv.setVisible(true);
            painelCentral.removeAll();
            rv.setSize(painelCentral.getSize());
            painelCentral.add(rv);
            painelCentral.revalidate();

            painelCentral.repaint();
        }
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // BOTÃO ENVIAR
        
        System.out.println("Botão enviar acionado");
        
        // Pegando valores informados na tela
        
        // pegando informações do veiculo
        String modelo = campoModelo.getText();
        String chassi = campoChassi.getText();
        String placa = campoPlaca.getText();
        String renavam = campoRenavam.getText();
        String cor = campoCor.getSelectedItem().toString();
        String marca = campoMarca.getSelectedItem().toString();
        String valorDiaria = campoVD.getText();
        String valorSeguro = campoValorSeguro.getText();
        String motor = campoMotor.getText();
        String cambio = campoCambio.getSelectedItem().toString();
        String combustivel = campoComb.getSelectedItem().toString();
        valorDiaria = valorDiaria.replace(",",".");
        valorSeguro = valorSeguro.replace(",", ".");
        int portas = campoPortas.getSelectedIndex();
        int codVenda = 0; 
        int ano =0;
       
        
        // verificando itens opcionais
        opcional = verOpcionais();
        
           
     
        // atribuindo valor do campoPortas
        if(portas == 0){
            portas = 2;
        }else{
            portas = 4;
        }
        System.out.println("Portas obtidas : "+portas);
        
        
        // obtendo dados do fornecedor
        String fornecedor = campoForn.getSelectedItem().toString();
        
        // aplicanto try catch nos valores a serem transformados
        
        try {
            vd = validaNumero(valorDiaria);
            vs = validaNumero(valorSeguro);
            
            codVenda = Integer.parseInt(campoCodvenda.getText());
            ano = Integer.parseInt(campoAno.getSelectedItem().toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Existe campos incorretos");
        }
        
           
        // Verificando campo status
        if(campoStatus.getSelectedIndex() == 0){ // Selecionado disponivel
            status1 = true;
        }
            
        
        
        // Instanciando Veiculo a ser cadastrado
        
        Veiculo v = this.veiculo;

        if (modelo.length() != 0 && placa.length() == 8
                && renavam.length() == 10 && chassi.length() == 17
                && valorDiaria != null && fornecedor != null && codVenda != 0 && opcional != null) { // validando campos


            if (alterar == false) { // verificando se objeto não é nulo
                System.out.println("validando cadastro");


                v = new Veiculo(fornecedor, ano, status1, chassi, modelo, marca, cor, placa);

                v.setRenavam(renavam);
                v.setValorDiaria(vd);
                v.setValorSeguro(vs);
                v.setCodVenda(codVenda);
                v.setMotor(motor);
                v.setCambio(cambio);
                v.setPortas(portas);
                v.setCombustivel(combustivel);
                v.setLocado(false);

                // incluindo opcionais na lista de opcionais
              
                
                System.out.println("opcionais selecionados : " + opcional);
                v.setOpcionais(opcional);


                // tentando fazer inserção do veiculo no BD

                VeiculoBO v2 = new VeiculoBO();

                if (v2.incluir(v)) {
                    System.out.println("Veiculo inserido com sucesso no BD");
                    JOptionPane.showMessageDialog(this, "Veculo Cadastrado com sucesso!");


                    PainelPrincipal pn = new PainelPrincipal();
                    pn.setVisible(true);
                    painelCentral.removeAll();
                    pn.setSize(painelCentral.getSize());
                    painelCentral.add(pn);
                    painelCentral.revalidate();
                    painelCentral.repaint();

                } else {
                    System.err.println("Erro de inserção");
                }

            } else {
                System.out.println("Alterando cadastro");
                int altportas = 0;
                
                ano = Integer.parseInt(campoAno.getSelectedItem().toString());
                
                if(campoStatus.getSelectedIndex() == 0)
                    status1 = true;
                else
                    status1 = false;
                
                
                v = new Veiculo(campoForn.getSelectedItem().toString(), ano, status1, campoChassi.getText(),
                        campoModelo.getText(), campoMarca.getSelectedItem().toString(),
                        campoCor.getSelectedItem().toString(), campoPlaca.getText());

                valorDiaria = campoVD.getText();
                valorSeguro = campoValorSeguro.getText();
                valorDiaria = valorDiaria.replace(",", ".");
                valorSeguro = valorSeguro.replace(",", ".");
                
                try {
                   
                    vd = validaNumero(valorDiaria);
                    vs = validaNumero(valorSeguro);
                    altCodVenda = Integer.parseInt(campoCodvenda.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Existem campos incorretos");
                }
                
                opcional = verOpcionais();
                
                if(campoPortas.getSelectedIndex() == 0){
                    altportas = 2;
                }else{
                    altportas = 4;
                }

                v.setRenavam(campoRenavam.getText());
                v.setValorDiaria(vd);
                v.setValorSeguro(vs);
                v.setCodVenda(altCodVenda);
                v.setMotor(campoMotor.getText());
                v.setCambio(campoCambio.getSelectedItem().toString());
                v.setPortas(altportas);
                v.setCombustivel(campoComb.getSelectedItem().toString());
                v.setOpcionais(opcional);

                


                // tentando fazer inserção do veiculo no BD

                VeiculoBO v2 = new VeiculoBO();
                
                if (v2.alterar(v, altCodVeiculo)) {
                    System.out.println("Veiculo alterado com sucesso no BD");
                    JOptionPane.showMessageDialog(this, "Veiculo alterado com sucesso!");
                    alterar = false;


                    PainelPrincipal pn = new PainelPrincipal();
                    pn.setVisible(true);
                    painelCentral.removeAll();
                    pn.setSize(painelCentral.getSize());
                    painelCentral.add(pn);
                    painelCentral.revalidate();
                    painelCentral.repaint();

                } else {
                    System.err.println("Erro de alteracao");
                }             
            }


        } else {
            JOptionPane.showMessageDialog(null, "Revise os campos!");
        }
   
    }//GEN-LAST:event_jButton2ActionPerformed
  

    private void campoMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMarcaActionPerformed

    private void campoModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoModeloActionPerformed

    private void campoVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoVDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoVDActionPerformed

    private void pacoteFullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacoteFullActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pacoteFullActionPerformed

    private void campoFornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoFornActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoFornActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel CadastroVeiculo;
    private javax.swing.JLabel ano;
    private static javax.swing.JComboBox campoAno;
    private static javax.swing.JComboBox campoCambio;
    private static javax.swing.JFormattedTextField campoChassi;
    private static javax.swing.JTextField campoCodvenda;
    private static javax.swing.JComboBox campoComb;
    private static javax.swing.JComboBox campoCor;
    private static javax.swing.JComboBox campoForn;
    private static javax.swing.JComboBox campoMarca;
    private static javax.swing.JTextField campoModelo;
    private static javax.swing.JTextField campoMotor;
    private static javax.swing.JFormattedTextField campoPlaca;
    private static javax.swing.JComboBox campoPortas;
    private static javax.swing.JFormattedTextField campoRenavam;
    private static javax.swing.JComboBox campoStatus;
    private static javax.swing.JTextField campoVD;
    private static javax.swing.JTextField campoValorSeguro;
    private javax.swing.JLabel cor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel marca;
    private javax.swing.JLabel modelo;
    private javax.swing.JCheckBox pacoteFull;
    private javax.swing.JCheckBox pacoteLight;
    private javax.swing.JCheckBox pacoteSuper;
    private javax.swing.JLabel placa;
    private javax.swing.JLabel renavan;
    private javax.swing.JLabel status;
    private javax.swing.JLabel valorDiaria;
    // End of variables declaration//GEN-END:variables
}
