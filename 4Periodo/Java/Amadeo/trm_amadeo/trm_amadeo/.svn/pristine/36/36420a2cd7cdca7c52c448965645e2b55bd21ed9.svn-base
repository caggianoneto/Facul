package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.ListSelectionModel;

import controller.*;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JList;

import model.Veiculo;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Color;

public class Cadastro extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS DA CLASSE CADASTRO (PARA TODAS AS SUBCLASSES DE CADASTRO)
	private JLabel lblTela;
	private MascaraCampos mascara;
	private boolean alerta = true;
	
	//ATRIBUTOS DE CADASTRO DE CLIENTE/DESTINATARIO
	private JLabel lbl_rzsNome;
	private JLabel lbl_doc;
	private JLabel lblDataDeNascimento;
	private JLabel lbl_IE;
	private JLabel lbl_IM;
	private JTextField campoRazaoSocial;
	private JTextField campoIM;
	private JTextField campoEndereco;
	private JTextField campoNumero;
	private JTextField campoCidade;
	private JTextField campoBairro;
	private JTextField campoComplemento;
	private JTextField campoContato;
	private JTextField campoEmail;
	private JFormattedTextField campoIE;
	private JFormattedTextField campoCep;
	private JFormattedTextField campoCpf;
	private JFormattedTextField campoCnpj;
	private JFormattedTextField campoDataNascFun;
	private JFormattedTextField campoTelefone1;
	private JFormattedTextField campoTelefone2;
	private JComboBox campoUF;
	private JComboBox campoTipoCliente;
	private JComboBox comboBoxTipoPessoa;
	private String ufRetornado;
	private int uf = 0;
	private ClienteDestinatarioController validaCliente;
	private ClienteDestinatarioController validaendereco;
	private PainelPrincipal principal;
	
	//ATRIBUTOS DE CADASTRO DE VEICULO
	private boolean aceitar;
	private JFormattedTextField campoTara;
	private JFormattedTextField campoCompCompCarga;
	private JFormattedTextField campoLarCompCarga;
	private JFormattedTextField campoALtCompCarga;
	private JFormattedTextField campoPlaca;
	private JFormattedTextField campoRenavam;
	private JTextField campoCapTanqueComb;
	private JTextField campoPesoMaxCarga;
	private JTextField campoMarcaModelo;
	private JPanel viewCadastroCliente;
	private JComboBox comboBox_AnoFab;
	private JComboBox campoEixos;
	private JComboBox campoTipoVeiculo;
	private JComboBox campoCombustivel;
	private JComboBox campoStatusVeiculo;
	private VeiculoController veiculo;
	
	//ATRIBUTOS DE FROTAS
	private ArrayList<Veiculo> listaVeiculosHabilitados = new ArrayList<Veiculo>();
	@SuppressWarnings("rawtypes")
	private DefaultListModel model;
	private JScrollPane scrollPane;
	private DefaultListModel model2;
	private DefaultListModel modelIds;
	private DefaultListModel modelIdsSelecionados;	
	private JScrollPane scrollPane2;
	private JList listaVeiculos;
	private JList listaVeiculosFrota;
	private JList listRowIds;
	private JList listRowIdsSelecionados;
	private JComboBox campoCidadesRegiao;
	private JComboBox campoEstadoRegiao;
	private int i = 0;
	private int k =0;
	private FrotaController frota;
	private ArrayList<Object> veiculosIncluidos = new ArrayList<Object>();
	
	
	// INICIO DO PAINEL
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Cadastro() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblTela  = new JLabel("Cadastro :");
		lblTela.setBounds(10, 11, 84, 14);
		add(lblTela);
		
		JTabbedPane viewCadastros = new JTabbedPane(JTabbedPane.TOP);
		viewCadastros.setBackground(Color.WHITE);
		viewCadastros.setBounds(20, 36, 1220, 600);
		add(viewCadastros);
	    
		mascara = new MascaraCampos();
		
// ************************************************************* TELA DE CADASTRO DE CLIENTE/DESTINATARIO *********************************************************************************************
		
		// PAINEL DE CADASTRO CLIENTE/DESTINATARIO
		viewCadastroCliente  = new JPanel();
		viewCadastroCliente.setBackground(Color.WHITE);
		viewCadastros.addTab("Clientes/Destinatario", null, viewCadastroCliente, null);
		viewCadastroCliente.setLayout(null);
		
	    // LABELS DE CADASTRO DE CLIENTE / DESTINATARIO	
		   // LABELS DINAMICOS
		lbl_doc = new JLabel("CPF:");
		lbl_doc.setBounds(10, 11, 85, 14);
	    viewCadastroCliente.add(lbl_doc);
		
		lbl_rzsNome = new JLabel("Nome:");
		lbl_rzsNome.setBounds(10, 36, 98, 14);
		viewCadastroCliente.add(lbl_rzsNome);
		
		lbl_IE = new JLabel("RG:");
		lbl_IE.setBounds(10, 61, 109, 14);
		viewCadastroCliente.add(lbl_IE);
		lbl_IE.setVisible(true);
		
		lbl_IM = new JLabel("Inscri\u00E7\u00E3o Municipal:");
		lbl_IM.setBounds(298, 61, 123, 14);
		viewCadastroCliente.add(lbl_IM);
		lbl_IM.setVisible(false);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(298, 36, 123, 14);
		viewCadastroCliente.add(lblDataDeNascimento);
		
		// LABELS ESTATICOS
		JLabel lbl_endereco = new JLabel("INFORMA\u00C7\u00D5ES DE ENDERE\u00C7O DO CLIENTE");
		lbl_endereco.setBounds(10, 116, 241, 14);
		viewCadastroCliente.add(lbl_endereco);
		
		JLabel lblLogradouro = new JLabel("CEP:");
		lblLogradouro.setBounds(10, 150, 44, 14);
		viewCadastroCliente.add(lblLogradouro);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(355, 149, 23, 14);
		viewCadastroCliente.add(lblUf);
		
		JLabel textLog = new JLabel("Endere\u00E7o:");
		textLog.setBounds(10, 182, 73, 14);
		viewCadastroCliente.add(textLog);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(550, 147, 46, 14);
		viewCadastroCliente.add(lblCidade);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(300, 181, 65, 14);
		viewCadastroCliente.add(lblNumero);
		
		JLabel lbl_bairro = new JLabel("Bairro:");
		lbl_bairro.setBounds(550, 175, 46, 14);
		viewCadastroCliente.add(lbl_bairro);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 214, 98, 14);
		viewCadastroCliente.add(lblComplemento);
		
		JLabel lbl_info_contato = new JLabel("INFORMA\u00C7\u00D5ES DE CONTATO DO CLIENTE / DESTINATARIO");
		lbl_info_contato.setBounds(10, 256, 329, 14);
		viewCadastroCliente.add(lbl_info_contato);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setBounds(10, 291, 65, 14);
		viewCadastroCliente.add(lblContato);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 338, 46, 14);
		viewCadastroCliente.add(lblEmail);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(533, 11, 46, 14);
		viewCadastroCliente.add(lblTipo);
		
		JLabel lblTipoPessoa = new JLabel("Tipo Pessoa:");
		lblTipoPessoa.setBounds(298, 11, 85, 14);
		viewCadastroCliente.add(lblTipoPessoa);
		
		JLabel lblTelefone1 = new JLabel("Telefone 1:");
		lblTelefone1.setBounds(279, 291, 73, 14);
		viewCadastroCliente.add(lblTelefone1);
		
		JLabel lblTelefone2 = new JLabel("Telefone 2:");
		lblTelefone2.setBounds(279, 338, 73, 14);
		viewCadastroCliente.add(lblTelefone2);
		
		// SEPARADORES DE CADASTRO CLIENTE / DESTINATARIO
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(349, 268, 788, 2);
		viewCadastroCliente.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(247, 126, 890, 2);
		viewCadastroCliente.add(separator);
		
		// CAMPOS FORMATADOS DE CLIENTE / DESTINATARIO
		campoCpf = new JFormattedTextField();
		campoCpf.setBounds(105, 8, 161, 20);
		viewCadastroCliente.add(campoCpf);
		campoCpf.setColumns(10);
		mascara.mascaraCPF(campoCpf);
		
		campoCnpj = new JFormattedTextField();
		campoCnpj.setBounds(105, 8, 161, 20);
		viewCadastroCliente.add(campoCnpj);
		campoCnpj.setColumns(10);
		campoCnpj.setVisible(false);
		
		campoCep = new JFormattedTextField();
		campoCep.setBounds(64, 147, 123, 20);
		viewCadastroCliente.add(campoCep);
		campoCep.setColumns(10);
		mascara.mascaraCEP(campoCep);
		
		campoDataNascFun = new JFormattedTextField();
		campoDataNascFun.setBounds(431, 33, 79, 20);
		viewCadastroCliente.add(campoDataNascFun);
		mascara.mascaraData(campoDataNascFun);
		
	    campoTelefone1 = new JFormattedTextField();
		campoTelefone1.setBounds(362, 288, 98, 20);
		viewCadastroCliente.add(campoTelefone1);
		mascara.mascaraFoneRes(campoTelefone1);
		
	    campoTelefone2 = new JFormattedTextField();
		campoTelefone2.setBounds(362, 335, 98, 20);
		viewCadastroCliente.add(campoTelefone2);
		mascara.mascaraFoneRes(campoTelefone2);
		
		campoIE = new JFormattedTextField();
		campoIE.setBounds(125, 58, 141, 20);
		viewCadastroCliente.add(campoIE);
		campoIE.setColumns(10);
		campoIE.setVisible(true);
		mascara.mascaraSoNumeros(campoIE);
		
		// CAMPOS TEXT-FIELDS CLIENTE/DESTINATARIO
		campoRazaoSocial = new JTextField();
		campoRazaoSocial.setBounds(105, 33, 161, 20);
		viewCadastroCliente.add(campoRazaoSocial);
		campoRazaoSocial.setColumns(10);
		
		campoIM = new JTextField();
		campoIM.setBounds(431, 58, 141, 20);
		viewCadastroCliente.add(campoIM);
		campoIM.setColumns(10);
		campoIM.setVisible(false);
		
		campoNumero = new JTextField();
		campoNumero.setBounds(377, 179, 46, 20);
		viewCadastroCliente.add(campoNumero);
		campoNumero.setColumns(10);
		
		campoCidade = new JTextField();
		campoCidade.setBounds(601, 144, 141, 20);
		viewCadastroCliente.add(campoCidade);
		campoCidade.setColumns(10);
		
		campoBairro = new JTextField();
		campoBairro.setBounds(601, 172, 141, 20);
		viewCadastroCliente.add(campoBairro);
		campoBairro.setColumns(10);
		
		campoComplemento = new JTextField();
		campoComplemento.setBounds(117, 211, 176, 20);
		viewCadastroCliente.add(campoComplemento);
		campoComplemento.setColumns(10);
		
		campoContato = new JTextField();
		campoContato.setBounds(67, 288, 153, 20);
		viewCadastroCliente.add(campoContato);
		campoContato.setColumns(10);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(52, 335, 168, 20);
		viewCadastroCliente.add(campoEmail);
		campoEmail.setColumns(10);
		
		campoEndereco = new JTextField();
		campoEndereco.setBounds(74, 179, 216, 20);
		viewCadastroCliente.add(campoEndereco);
		campoEndereco.setColumns(10);
		
		// CAMPOS COMBOBOX - CLIENTE/DESTINATARIO
		campoUF  = new JComboBox();
		campoUF.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", 
																"DF", "ES", "GO", "MA", "MT", "MS",
																"MG", "PA", "PB", "PR", "PE", "PI",
																"RJ", "RN", "RS", "RO", "RR", "SC",
																"SP", "SE", "TO"}));
		campoUF.setToolTipText("");
		campoUF.setBounds(388, 145, 126, 22);
		viewCadastroCliente.add(campoUF);
		
		campoTipoCliente  = new JComboBox();
		campoTipoCliente.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Destinatario"}));
		campoTipoCliente.setBounds(589, 7, 135, 22);
		viewCadastroCliente.add(campoTipoCliente);
		
	    comboBoxTipoPessoa = new JComboBox();
		comboBoxTipoPessoa.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica", "Jur\u00EDdica"}));
		comboBoxTipoPessoa.setBounds(395, 7, 115, 22);
		viewCadastroCliente.add(comboBoxTipoPessoa);
		
		// BOTOES DA TELA DE CADASTRO DE CLIENTE/DESTINATARIO
		JButton btnCadastroClienteDESTINATARIO = new JButton("Cadastrar");
		btnCadastroClienteDESTINATARIO.setBounds(10, 507, 126, 23);
		viewCadastroCliente.add(btnCadastroClienteDESTINATARIO);
		
		JButton buscaCep = new JButton("Buscar");
		buscaCep.setBounds(207, 146, 102, 23);
		viewCadastroCliente.add(buscaCep);	
		
		// AÇÃO DE MUDANÇA DE TIPO-PESSOA PARA PF(0),PJ(1) QUE ALTERA ALGUN COMPONENTES DA TELA
		comboBoxTipoPessoa.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent arg0) {
	    		//CHAMA O METODO PARA A MECANICA DA TELA
	    		mecanicaDeTela();	
	    	}
	    });
		
		// AÇÃO DE MUDANÇA PARA TIPO DESTINATARIO(1) - CLIENTE(0)
		campoTipoCliente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//CHAMA O METODO PARA A MECANICA DA TELA
	    		mecanicaDeTela();
			}
		});		
		
		// AÇÃO DO BOTÃO CADASTRAR CLIENTE / DESTINATARIO
		btnCadastroClienteDESTINATARIO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//INTANCIA OBJETOS DO CONTROLLER
				validaendereco = new ClienteDestinatarioController();
				validaCliente = new ClienteDestinatarioController();
				Boolean enderecoValido = false;
				Boolean camposValidos = false;
				Boolean idadeValida = false;
				// TIPO PESSOA FISICA CLIENTE
				if(comboBoxTipoPessoa.getSelectedIndex() == 0 && campoTipoCliente.getSelectedIndex() == 0 ){
					
					if(validaCamposFisicaCliente()){
						
						pegaCamposEndereco();
						pegaCamposClientePf();
						idadeValida = validaCliente.calculaIdade(campoDataNascFun.getText());
						enderecoValido = true;
						camposValidos = true;
					}
				// TIPO PESSOA JURIDICA CLIENTE		
				}else if(comboBoxTipoPessoa.getSelectedIndex() == 1 && campoTipoCliente.getSelectedIndex() == 0){
					
					if(validaCamposJuridicaCliente()){
						pegaCamposEndereco();
						pegaCamposClienteJ();
						enderecoValido = true;
						camposValidos = true;
						idadeValida = true;
					}
				// TIPO PESSOA FISICA DESTINATARIO			
				}else if(comboBoxTipoPessoa.getSelectedIndex() == 0 && campoTipoCliente.getSelectedIndex() == 1){
					
					if(validaCamposDestinatarioF()){
						pegaCamposEndereco();
						// PUXA CAMPOS CLIENTE DESTINATARIO
						if(campoCpf.getText().contains("   .   .   -  ")){
							validaCliente.setCpf("");
						}else{
							validaCliente.setCpf(campoCpf.getText());
						}
						validaCliente.setNome(campoRazaoSocial.getText());
						validaCliente.setTipoCliente(campoTipoCliente.getSelectedIndex());
						validaCliente.setTipoPessoa(comboBoxTipoPessoa.getSelectedIndex());
						enderecoValido = true;
						camposValidos = true;
						idadeValida = true;
					}
				// TIPO PESSOA JURIDICA DESTINATARIO		
				}else if(comboBoxTipoPessoa.getSelectedIndex() == 1 && campoTipoCliente.getSelectedIndex() == 1){
					
					if(validaCamposDestinatarioj()){
						pegaCamposEndereco();
						// PUXA CAMPOS JURIDICA DESTINATARIO
						if(campoCnpj.getText().contains("  .   .   /   -  ")){
							validaCliente.setCnpj("");
						}else{
							validaCliente.setCnpj(campoCnpj.getText());
						}
						validaCliente.setRazaoSocial(campoRazaoSocial.getText());
						validaCliente.setTipoCliente(campoTipoCliente.getSelectedIndex());
						validaCliente.setTipoPessoa(comboBoxTipoPessoa.getSelectedIndex());
						enderecoValido = true;
						camposValidos = true;
						idadeValida = true;
					}
					
				}
				
				if(enderecoValido && camposValidos && idadeValida){
					// APOS OS DADOS VALIDADOS ENVIA PARA INCLUSAO NO BANCO DE DADOS
					if(validaCliente.init(validaCliente,validaendereco) ){
						JOptionPane.showMessageDialog(null,"Cliente/Destinatário cadastrado com sucesso!");
						RetornaMain.retornaMain(viewCadastroCliente);
					}else{
						JOptionPane.showMessageDialog(null,"Cliente/Destinatário não cadastrado erro de inserção!");
					}
		
				}else if(idadeValida){
					JOptionPane.showMessageDialog(null, "Campos incorretos! Por favor verifique.");
				}else{
					JOptionPane.showMessageDialog(null, "Idade menor a 18 anos");
				}
							
			}
		});	
		
		// AÇÃO DO BOTAO BUSCAR CEP	
		buscaCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				try {
					ChecaEstado validacao = new ChecaEstado();
					campoEndereco.setText(BuscaCEP.getEndereco(campoCep.getText()));
					campoBairro.setText(BuscaCEP.getBairro(campoCep.getText()));
					campoCidade.setText(BuscaCEP.getCidade(campoCep.getText()));
					ufRetornado = BuscaCEP.getUF(campoCep.getText());
					if( !ufRetornado.isEmpty() ){	
						uf = validacao.retornaUfSelecionado(ufRetornado);
						campoUF.setSelectedIndex(uf);
						campoUF.disable();
						campoBairro.disable();
						campoCidade.disable();
						campoNumero.grabFocus();
					}else{
						JOptionPane.showMessageDialog(null, "Sem Conexão com o servidor de Endereço" );
					}
											
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});		
		
// ************************************************************* TELA DE CADASTRO DE FROTAS *********************************************************************************************		
		// PAINEL DE CADASTRO FROTA
		JPanel viewCadastroFrota = new JPanel();
		viewCadastroFrota.setBackground(Color.WHITE);
		viewCadastros.addTab("Frotas", null, viewCadastroFrota, null);
		viewCadastroFrota.setLayout(null);
		
		//LABELS DE FROTA
		JLabel lblNewLabel_10 = new JLabel("Veiculos disponiveis:");
		lblNewLabel_10.setBounds(31, 26, 150, 14);
		viewCadastroFrota.add(lblNewLabel_10);
		
		JLabel lblNoveFrota = new JLabel("Nova Frota:");
		lblNoveFrota.setBounds(450, 26, 89, 14);
		viewCadastroFrota.add(lblNoveFrota);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(31, 344, 69, 14);
		viewCadastroFrota.add(lblEstado);
		
		JLabel lblCidade_1 = new JLabel("Cidade:");
		lblCidade_1.setBounds(150, 344, 46, 14);
		viewCadastroFrota.add(lblCidade_1);
		
		JLabel lblRegioDaFrota = new JLabel("Regi\u00E3o da Frota:");
		lblRegioDaFrota.setBounds(31, 319, 136, 14);
		viewCadastroFrota.add(lblRegioDaFrota);
		
		//COMBOBOX FROTAS - REGIOES
		campoCidadesRegiao = new JComboBox();
		campoCidadesRegiao.setBounds(150, 375, 207, 20);
		viewCadastroFrota.add(campoCidadesRegiao);
	
		campoEstadoRegiao = new JComboBox();
		campoEstadoRegiao.setBounds(31, 375, 55, 20);
		viewCadastroFrota.add(campoEstadoRegiao);
		
		// LISTA DE VEICULOS HABILITADOS
		model = new DefaultListModel(); 
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(100, 50));
		//viewCadastroFrota.add(scrollPane);
		scrollPane.setBounds(31, 68, 256,167);
	
		viewCadastroFrota.add(scrollPane);
		listaVeiculos = new JList(model);
		scrollPane.setViewportView(listaVeiculos);
		listaVeiculos.setBorder(BorderFactory.createLoweredBevelBorder());
		listaVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		listaVeiculos.setLayoutOrientation(JList.VERTICAL);
		
		//LISTA DE VEICULOS ADICIONADOS A  NOVA FROTA
		model2 = new DefaultListModel(); 
		scrollPane2 = new JScrollPane();
		scrollPane2.setPreferredSize(new Dimension(100, 50));
		viewCadastroFrota.add(scrollPane2);
		scrollPane2.setBounds(407, 68, 265,172);
		
		listaVeiculosFrota = new JList(model2);
		scrollPane2.setViewportView(listaVeiculosFrota);
		listaVeiculosFrota.setBorder(BorderFactory.createLoweredBevelBorder());
		listaVeiculosFrota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		listaVeiculosFrota.setLayoutOrientation(JList.VERTICAL);
		
		modelIds = new DefaultListModel();
		listRowIds = new JList(modelIds);
		modelIdsSelecionados = new DefaultListModel();
		listRowIdsSelecionados = new JList(modelIdsSelecionados);
		
		//BOTOES
		JButton btnCarregarlista = new JButton("Carregar Lista");
		btnCarregarlista.setBounds(31, 259, 136, 23);
		viewCadastroFrota.add(btnCarregarlista);
		
		JButton btnInserirVeiculo = new JButton(">>>");
		btnInserirVeiculo.setBounds(297, 120, 89, 23);
		viewCadastroFrota.add(btnInserirVeiculo);
		
		JButton btnRemoverVeiculo = new JButton("<<<");
		btnRemoverVeiculo.setBounds(297, 154, 89, 23);
		viewCadastroFrota.add(btnRemoverVeiculo);
		
		JButton btnCadastrarFrota = new JButton("Cadastrar Frota");
		btnCadastrarFrota.setBounds(31, 461, 123, 23);
		viewCadastroFrota.add(btnCadastrarFrota);
		
		
		//CHAMA FUNÇÃO NO CONTROLLER PARA POPULAR OS COMBOBOX	
		frota = new FrotaController();
		frota.populaComboboxRegioes(campoEstadoRegiao , campoCidadesRegiao);
		campoEstadoRegiao = frota.cidades;
	    campoCidadesRegiao = frota.estados;    
	    
	    // BOTOES PARA SELECIONAR AUTOMATICO A CAPITAL DO ESTADO SELECIONADO
	    campoEstadoRegiao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			i = 1;	
			campoCidadesRegiao.setSelectedIndex(campoEstadoRegiao.getSelectedIndex());
			
			}
		});
	    campoCidadesRegiao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(i == 0){
					campoEstadoRegiao.setSelectedIndex(campoCidadesRegiao.getSelectedIndex());		
				}else{
					i = 0;
				}
			}
		});  
	         
		// BOTÃO DE CARREGAR LISTA DE VEICULOS DISPONIVEIS	
		btnCarregarlista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				model.clear();
				model2.clear();
				modelIds.clear();
				modelIdsSelecionados.clear();
				veiculosIncluidos.clear();
				veiculo = new VeiculoController();
				listaVeiculosHabilitados = veiculo.listaVeiculos();
				
				for(int i=0; i < listaVeiculosHabilitados.size() ; i++){ 
					model.addElement(listaVeiculosHabilitados.get(i).getTipo()+"  "+listaVeiculosHabilitados.get(i).getMarcaModelo()+"  "+listaVeiculosHabilitados.get(i).getPlaca());
					modelIds.addElement(listaVeiculosHabilitados.get(i).getIdVeiculo());
					}
			}
		});
		
		// BOTÃO DE INSERIR VEICULO
		btnInserirVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i =0;
				Object veiculoSelecionado = listaVeiculos.getSelectedValue();	
				int index = listaVeiculos.getSelectedIndex();
				
				modelIdsSelecionados.add(i, modelIds.remove(index));
				
				model.removeElement(veiculoSelecionado);
				model2.addElement(veiculoSelecionado);
				i++;				
			}
		});
		
		// BOTÃO DE RETIRAR VEICULO
		btnRemoverVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object veiculoSelecionado = listaVeiculosFrota.getSelectedValue();	
				int index = listaVeiculosFrota.getSelectedIndex();
				
				modelIds.addElement( modelIdsSelecionados.remove(index) );			
				model2.removeElement(veiculoSelecionado);
				model.addElement(veiculoSelecionado);		
			}
		});
		
		// BOTÃO PARA CADASTRO DE FROTA
		btnCadastrarFrota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frota = new FrotaController();
				//VERIFICA SE A LISTA DA NOVA FROTA ESTA PREENCHIDA
				if(!model2.isEmpty()){
					
					ArrayList<Object> veiculosAinserir = new ArrayList<Object>();
					int regiaoFrota = campoCidadesRegiao.getSelectedIndex();
					
					for (int i = 0; i < modelIdsSelecionados.size(); i++) {
						veiculosAinserir.add(modelIdsSelecionados.getElementAt(i));
					}
					
					if(frota.insereNaFrota(veiculosAinserir, regiaoFrota)){
						JOptionPane.showMessageDialog(null, "Frota cadastrada com sucesso");
						RetornaMain.retornaMain(viewCadastroCliente);
					}else{
						JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a frota!");
					}
					
				}else{
					System.out.println("empty");
				}
				
			}
		});
		
			
				
		
// ***************************************************************  TELA DE CADASTRO DE VEICULOS ****************************************************************************************
		
		// PAINEL DE CADASTRO VEICULO
		JPanel viewCadastroVeiculo = new JPanel();
		viewCadastroVeiculo.setBackground(Color.WHITE);
		viewCadastros.addTab("Veiculos", null, viewCadastroVeiculo, null);
		viewCadastroVeiculo.setLayout(null);
		
		// LABELS DE VEICULOS
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 11, 46, 14);
		viewCadastroVeiculo.add(lblPlaca);
		
		JLabel lblRenavam = new JLabel("Renavam:");
		lblRenavam.setBounds(186, 11, 74, 14);
		viewCadastroVeiculo.add(lblRenavam);
		
		JLabel lblTipoDoVeiculo = new JLabel("Tipo do Veiculo:");
		lblTipoDoVeiculo.setBounds(416, 11, 99, 14);
		viewCadastroVeiculo.add(lblTipoDoVeiculo);
		
		JLabel lblEixos = new JLabel("Eixos:");
		lblEixos.setBounds(10, 55, 46, 14);
		viewCadastroVeiculo.add(lblEixos);
		
		JLabel lblTara = new JLabel("Tara:");
		lblTara.setBounds(186, 55, 46, 14);
		viewCadastroVeiculo.add(lblTara);
		
		JLabel lblPesoMaximoDe = new JLabel("Peso Maximo de carga:");
		lblPesoMaximoDe.setBounds(373, 55, 142, 14);
		viewCadastroVeiculo.add(lblPesoMaximoDe);
		
		JLabel lblComprimentoDoCompartimento = new JLabel("Comprimento do compartimento de carga:");
		lblComprimentoDoCompartimento.setBounds(714, 11, 266, 14);
		viewCadastroVeiculo.add(lblComprimentoDoCompartimento);
		
		JLabel lblLarguraDoCompartimento = new JLabel("Largura do compartimento de carga:");
		lblLarguraDoCompartimento.setBounds(714, 55, 245, 14);
		viewCadastroVeiculo.add(lblLarguraDoCompartimento);
		
		JLabel lblAlturaDoCompartimento = new JLabel("Altura do compartimento de Carga:");
		lblAlturaDoCompartimento.setBounds(714, 95, 245, 14);
		viewCadastroVeiculo.add(lblAlturaDoCompartimento);
		
		JLabel lbl_marcaModelo = new JLabel("Marca/Modelo:");
		lbl_marcaModelo.setBounds(10, 95, 91, 14);
		viewCadastroVeiculo.add(lbl_marcaModelo);
		
		JLabel lblCombustivel = new JLabel("Combustivel:");
		lblCombustivel.setBounds(394, 95, 86, 14);
		viewCadastroVeiculo.add(lblCombustivel);
		
		JLabel lblCapacidadeDoTanque = new JLabel("Capacidade do Tanque de combustivel:");
		lblCapacidadeDoTanque.setBounds(10, 141, 236, 14);
		viewCadastroVeiculo.add(lblCapacidadeDoTanque);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(413, 141, 46, 14);
		viewCadastroVeiculo.add(lblStatus);
		
		JLabel lbl_m1 = new JLabel("m");
		lbl_m1.setBounds(1122, 14, 23, 14);
		viewCadastroVeiculo.add(lbl_m1);
		
		JLabel lbl_m2 = new JLabel("m");
		lbl_m2.setBounds(1122, 58, 23, 14);
		viewCadastroVeiculo.add(lbl_m2);
		
		JLabel lbl_m3 = new JLabel("m");
		lbl_m3.setBounds(1122, 98, 23, 14);
		viewCadastroVeiculo.add(lbl_m3);
		
		JLabel lblTon = new JLabel("Ton");
		lblTon.setBounds(606, 58, 30, 14);
		viewCadastroVeiculo.add(lblTon);
		
		JLabel lblTon_2 = new JLabel("Ton");
		lblTon_2.setBounds(327, 58, 30, 14);
		viewCadastroVeiculo.add(lblTon_2);
		
		JLabel lbl_litros = new JLabel("Litros");
		lbl_litros.setBounds(327, 144, 64, 14);
		viewCadastroVeiculo.add(lbl_litros);
		
		JLabel lblAnoDeFabbricao = new JLabel("Ano de Fabbrica\u00E7\u00E3o:");
		lblAnoDeFabbricao.setBounds(714, 141, 142, 14);
		viewCadastroVeiculo.add(lblAnoDeFabbricao);
		
		// CAMPOS FORMATADOS VEICULO
		campoPlaca = new JFormattedTextField();
		campoPlaca.setBounds(68, 8, 74, 20);
		viewCadastroVeiculo.add(campoPlaca);
		mascara.mascaraPlaca(campoPlaca);
	
		campoRenavam = new JFormattedTextField();
		campoRenavam.setBounds(260, 8, 106, 20);
		viewCadastroVeiculo.add(campoRenavam);
		campoRenavam.setColumns(10);
		mascara.mascaraRenavam(campoRenavam);
		
		campoCompCompCarga = new JFormattedTextField();
		campoCompCompCarga.setBounds(1021, 8, 86, 20);
		viewCadastroVeiculo.add(campoCompCompCarga);
		campoCompCompCarga.setColumns(10);
		mascara.mascaraFloat(campoCompCompCarga);
		
		campoLarCompCarga = new JFormattedTextField();
		campoLarCompCarga.setBounds(1021, 52, 86, 20);
		viewCadastroVeiculo.add(campoLarCompCarga);
		campoLarCompCarga.setColumns(10);
		mascara.mascaraFloat(campoLarCompCarga);
		
		campoALtCompCarga = new JFormattedTextField();
		campoALtCompCarga.setBounds(1021, 92, 86, 20);
		viewCadastroVeiculo.add(campoALtCompCarga);
		campoALtCompCarga.setColumns(10);
		mascara.mascaraFloat(campoALtCompCarga);
		
		campoTara = new JFormattedTextField();
		campoTara.setBounds(231, 52, 86, 20);
		viewCadastroVeiculo.add(campoTara);
		campoTara.setColumns(10);
		mascara.mascaraFloat(campoTara);
		
		// TEXT-FIELDS VEICULOS
		campoMarcaModelo = new JTextField();
		campoMarcaModelo.setBounds(127, 92, 190, 20);
		viewCadastroVeiculo.add(campoMarcaModelo);
		campoMarcaModelo.setColumns(10);
		
		campoCapTanqueComb = new JTextField();
		campoCapTanqueComb.setBounds(240, 138, 77, 20);
		viewCadastroVeiculo.add(campoCapTanqueComb);
		
		campoPesoMaxCarga = new JTextField();	
		campoPesoMaxCarga.setBounds(512, 52, 86, 20);
		viewCadastroVeiculo.add(campoPesoMaxCarga);
		
		// COMBO-BOX'S DE VEICULOS
		campoTipoVeiculo = new JComboBox();
		campoTipoVeiculo.setModel(new DefaultComboBoxModel(new String[] {"Caminh\u00E3o", "Carro", "Van", "Carroceria"}));
		campoTipoVeiculo.setBounds(512, 7, 123, 22);
		viewCadastroVeiculo.add(campoTipoVeiculo);
		
		campoCombustivel = new JComboBox();
		campoCombustivel.setModel(new DefaultComboBoxModel(new String[] {"Gasolina", "Diesel", "Flex", "GNV"}));
		campoCombustivel.setBounds(490, 91, 142, 22);
		viewCadastroVeiculo.add(campoCombustivel);
		
		campoStatusVeiculo = new JComboBox();
		campoStatusVeiculo.setModel(new DefaultComboBoxModel(new String[] {"Desabilitado", "Habilitado"}));
		campoStatusVeiculo.setBounds(489, 137, 147, 22);
		viewCadastroVeiculo.add(campoStatusVeiculo);
		
		campoEixos = new JComboBox();
		campoEixos.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10"}));
		campoEixos.setBounds(68, 52, 64, 20);
		viewCadastroVeiculo.add(campoEixos);
		
		comboBox_AnoFab = new JComboBox();
		comboBox_AnoFab.setModel(new DefaultComboBoxModel(new String[] {"2014", "2013", "2012", "2011", "2010", "2009",
																		"2008", "2007", "2006", "2005", "2004", "2003",
																		"2002", "2001", "2000", "1999", "1998", "1997",
																		"1996", "1995", "1994", "1993", "1992", "1991",
																		"1990", "1989", "1988", "1987", "1986", "1985",
																		"1984", "1983", "1982", "1981", "1980"}));
		comboBox_AnoFab.setBounds(866, 137, 86, 22);
		viewCadastroVeiculo.add(comboBox_AnoFab);
		
		// SEPARADORES DE TELA VEICULOS
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 208, 1195, 2);
		viewCadastroVeiculo.add(separator_2);
		
		//BOTOES DE VEICULOS
		JButton btnCadastrarVeiculo = new JButton("Cadastrar");
		btnCadastrarVeiculo.setBounds(10, 221, 132, 23);
		viewCadastroVeiculo.add(btnCadastrarVeiculo);
		
		// AÇÃO DO BOTÃO CADASTRAR VEICULO
		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					if(questionaStatus()){
				
						if(validaCamposVeiculo()){
							
							veiculo = new VeiculoController(campoPlaca.getText(), campoRenavam.getText(), campoTipoVeiculo.getSelectedItem().toString(), campoMarcaModelo.getText(),
															campoCombustivel.getSelectedItem().toString(), campoStatusVeiculo.getSelectedIndex());
							
							veiculo.setCapacidadeTanqueComb(campoCapTanqueComb.getText());
							veiculo.setAnoFab(comboBox_AnoFab.getSelectedItem().toString());
							veiculo.setPesoMaxCarga(campoPesoMaxCarga.getText());
							veiculo.setTara(campoTara.getText());
							veiculo.setCompCapacidadeCarga(campoCompCompCarga.getText());
							veiculo.setLarguraCapacidadeCarga(campoLarCompCarga.getText());
							veiculo.setAlturaCapacidadeCarga(campoALtCompCarga.getText());
							veiculo.setNumeroEixos(campoEixos.getSelectedIndex());
							
							// ENVIA DADOS DE VEICULO PARA CONTROLLER PARA SER INCLUIDO NO BD
							if(veiculo.init(veiculo)){
								JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
								PainelPrincipal p = new PainelPrincipal();
								//RetornaMain.retornaMain(viewCadastroCliente);
							
							}else{
								JOptionPane.showMessageDialog(null, "Falha no cadastro do veículo!");
							}
							
						}else{
						   JOptionPane.showMessageDialog(null, "Campos incorretos ou não preenchidos, revise-os e tente novamente!");
						}		
				}				
			}
		});

	}
	
	private void mecanicaDeTela(){
		
		// PESSOA FISICA CLIENTE
		if(comboBoxTipoPessoa.getSelectedIndex() == 0 && campoTipoCliente.getSelectedIndex() == 0){
			
			lbl_doc.setText("CPF:");
			lbl_rzsNome.setText("Nome:");
			lblDataDeNascimento.setText("Data de Nascimento:");
			campoCnpj.setVisible(false);
			campoCpf.setVisible(true);
			campoIE.setVisible(true);
			campoIM.setVisible(false);
			lbl_IE.setText("RG:");
			lbl_IE.setVisible(true);
			lbl_IM.setVisible(false);
			lblDataDeNascimento.setVisible(true);
			campoDataNascFun.setVisible(true);
			mascara.mascaraCPF(campoCpf);
			
			
		// PESSOA JURIDICA CLIENTE	
		}else if(comboBoxTipoPessoa.getSelectedIndex() == 1 && campoTipoCliente.getSelectedIndex() == 0){
			
			lbl_doc.setText("CNPJ:");
			lbl_rzsNome.setText("Razão Social:");
			lblDataDeNascimento.setText("Data de Fundação:");
			campoCpf.setVisible(false);
			campoCnpj.setVisible(true);
			mascara.mascaraCNPJ(campoCnpj);
			lblDataDeNascimento.setVisible(true);
			campoDataNascFun.setVisible(true);
			campoIM.setVisible(true);
			lbl_IE.setText("Inscrição Estadual:");
			campoIE.setVisible(true);
			lbl_IE.setVisible(true);
			lbl_IM.setVisible(true);
			
		// PESSOA FISICA DESTINATARIO	
		}else if(comboBoxTipoPessoa.getSelectedIndex() == 0 && campoTipoCliente.getSelectedIndex() == 1){
			
			lbl_doc.setText("CPF:");
			lbl_rzsNome.setText("Nome:");
			lblDataDeNascimento.setText("Data de Nascimento:");
			campoCnpj.setVisible(false);
			campoCpf.setVisible(true);
			campoIE.setVisible(false);
			campoIM.setVisible(false);
			lbl_IE.setVisible(false);
			lbl_IM.setVisible(false);
			lblDataDeNascimento.setVisible(false);
			campoDataNascFun.setVisible(false);
			mascara.mascaraCPF(campoCpf);
		
		// PESSOA JURIDICA DESTINATARIO	
		}else{
			lbl_doc.setText("CNPJ:");
			lbl_rzsNome.setText("Razão Social:");
			lblDataDeNascimento.setText("Data de Fundação:");
			campoCpf.setVisible(false);
			campoCnpj.setVisible(true);
			mascara.mascaraCNPJ(campoCnpj);
			lblDataDeNascimento.setVisible(false);
			campoDataNascFun.setVisible(false);
			campoIE.setVisible(false);
			campoIM.setVisible(false);
			lbl_IE.setVisible(false);
			lbl_IM.setVisible(false);
		}
		
	}
	
// *************************************************** METODOS DE VALIDAÇÕES PARA CLIENTES E DESTINATARIOS **************************************************************************************	
	
	public boolean validaCamposFisicaCliente(){
		
		// VALIDA CAMPOS DE ENDEREÇO EXISTE ALGUM VAZIO
		if( validaEndereco() ){
			// VALIDA CAMPOS DO CLIENTE_F SE EXISTE ALGUM VAZIO
			if(!campoCpf.getText().equals("") && !campoIE.getText().equals("") &&
			   !campoRazaoSocial.getText().equals("")){	
				return true;	
			}	
			return false;
		}
		return false;
	}
	
	public boolean validaCamposJuridicaCliente(){
		
		// VALIDA CAMPOS DE ENDEREÇO EXISTE ALGUM VAZIO
		if( validaEndereco() ){
			// VALIDA CAMPOS DO CLIENTE_J SE EXISTE ALGUM VAZIO
			if(!campoCnpj.getText().equals("") && !campoIE.getText().equals("") &&
			   !campoRazaoSocial.getText().equals("")){	
				return true;	
			}	
			return false;
		}
		return false;
	}
	// VALIDAÇÃO DE CAMPOS PARA DESTINATARIO PESSOA FISICA
	public boolean validaCamposDestinatarioF(){
		
		if( !campoEndereco.getText().equals("") && !campoNumero.getText().equals("") &&
			    !campoCep.getText().equals("") && !campoCidade.getText().equals("")  &&
			    !campoUF.getSelectedItem().toString().equals("") && !campoRazaoSocial.getText().equals("")){
				return true;
		}else{
			return false;
		}
	}
	// VALIDAÇÃO DE CAMPOS PARA DESTINATARIO PESSOA JURIDICA
		public boolean validaCamposDestinatarioj(){
			
			if( !campoEndereco.getText().equals("") && !campoNumero.getText().equals("") &&
				    !campoCep.getText().equals("") && !campoCidade.getText().equals("")  &&
				    !campoUF.getSelectedItem().toString().equals("") && !campoRazaoSocial.getText().equals("")){
					return true;
			}else{
				return false;
			}
		}
	// VALIDAÇÃO DOS CAMPOS DE ENDEREÇO
	public boolean validaEndereco(){
		
		if( !campoEndereco.getText().equals("") && !campoNumero.getText().equals("") &&
			    !campoCep.getText().equals("") && !campoCidade.getText().equals("")  &&
			    !campoUF.getSelectedItem().toString().equals("") ){
				return true;
		}else{
			return false;
		}
	}
	// FUNÇÃO QUE PUXA OS DADOS DA TELA PARA CLIENTE PF
	public void pegaCamposClientePf(){	
		//Atributos do cliente
		validaCliente.setCpf(campoCpf.getText());
		validaCliente.setRg(campoIE.getText());
		validaCliente.setNome(campoRazaoSocial.getText());
		validaCliente.setEmail(campoEmail.getText());
		validaCliente.setTipoCliente(campoTipoCliente.getSelectedIndex());
		validaCliente.setTipoPessoa(comboBoxTipoPessoa.getSelectedIndex()); 	
	}
	// FUNÇÃO QUE PUXA OS DADOS DA TELA PARA CLIENTE PJ
	public void pegaCamposClienteJ(){
		//Atributos do cliente
		validaCliente.setCnpj(campoCnpj.getText());
		validaCliente.setIe(campoIE.getText());
		validaCliente.setRazaoSocial(campoRazaoSocial.getText());
		validaCliente.setIm(campoIM.getText());
		validaCliente.setContato(campoContato.getText());
		validaCliente.setEmail(campoEmail.getText());
		validaCliente.setTipoCliente(campoTipoCliente.getSelectedIndex());
		validaCliente.setTipoPessoa(comboBoxTipoPessoa.getSelectedIndex()); 	
	}
	// FUNÇÃO QUE PUXA OS DADOS DE ENDEREÇO DA TELA
	public void pegaCamposEndereco(){
		// Seta atributos do Endereço do Cliente	
		validaendereco.setEndereco(campoEndereco.getText());
		validaendereco.setBairro(campoBairro.getText());   
		validaendereco.setCep(campoCep.getText());     
		validaendereco.setCidade(campoCidade.getText()); 
		validaendereco.setComplemento(campoComplemento.getText());
		validaendereco.setNumero(campoNumero.getText());
		validaendereco.setEstado(campoUF.getSelectedItem().toString());
		// VERIFICA CAMPO NÃO-OBRIGATORIO QUE PODE ESTAR VAZIO
		if(campoTelefone1.getText().contains("(  )     -    ")){
			validaendereco.setTelefone1("");
		}else{
			validaendereco.setTelefone1(campoTelefone1.getText());
		}
		// VERIFICA CAMPO NÃO-OBRIGATORIO QUE PODE ESTAR VAZIO
		if(campoTelefone2.getText().contains("(  )     -    ")){
			validaendereco.setTelefone2("");
		}else{
			validaendereco.setTelefone2(campoTelefone2.getText());
		}
	}
	
// ********************************************************************** METODOS E VALIDAÇÕES PARA VEICULOS ***************************************************************************************
	
	// QUESTIONA QUANDO HÁ TENTATIVA DE CADASTRO DE VEÍCULO COM STATUS DESABILITADO
	public boolean questionaStatus(){
		
		if(campoStatusVeiculo.getSelectedIndex() == 0){
			Object[] botoesDialogo = new Object[2];    
			  
	        JButton botaoCancelar = new JButton();    
	        botaoCancelar.setText("Cancelar");    
	  
	        JButton botaoAceitar = new JButton();     
	        botaoAceitar.setText("Aceitar");    
	  
	        botoesDialogo[0] = botaoAceitar;    
	        botoesDialogo[1] = botaoCancelar;   
		          
	        JOptionPane optionPane = new JOptionPane(  
	            "Deseja mesmo cadastrar o veículo com o status desabilitado?",     
	        JOptionPane.QUESTION_MESSAGE,    
	        JOptionPane.NO_OPTION,    
	        null,    
	        botoesDialogo,    
	        botoesDialogo[1]);
	        
	        final JDialog dialog = optionPane.createDialog("Importando Projeto");  
	        
	        // ACAO DO BOTAO ACEITAR
	        botaoAceitar.addActionListener(new ActionListener() {  
	            @Override  
	            public void actionPerformed(ActionEvent e) {  
	                dialog.dispose();  
	                aceitar = true;  
	            }  
	        });  
	      
	        // ACAO DO BOTAO CANCELAR
	        botaoCancelar.addActionListener(new ActionListener() {  
	            @Override  
	            public void actionPerformed(ActionEvent e) {  
	                dialog.dispose();  
	                aceitar = false;  
	            }  
	        });  
	          
	        dialog.setVisible(true);  
		}else{
			return true;
		}
		return aceitar;
	}
	
	public boolean validaCamposVeiculo(){
		
		// VALIDA CAMPOS DO VEICULO SE EXISTE ALGUM NESCESSARIO VAZIO
		if(!campoPlaca.getText().equals("") && !campoRenavam.getText().equals("") &&
		   !campoMarcaModelo.getText().equals("") && campoEixos.getSelectedIndex() != 0 ){	
			return true;	
		}	
		return false;	
	}
}
