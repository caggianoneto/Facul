	package view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Relatorio;
import controller.RelatorioController;

public class Relatorios extends JPanel {

	private JTextField campoCpf;
	private JTextField campoNome;
	private JTextField campoCnpj;
	private JTextField campoRazaoSocial;
	private JComboBox comboBoxRelatorioTipoPessoa;
	private JComboBox comboBoxTipo; 
	private JButton btnBuscar;
	private JTextField campoPlaca;
	private JTable table;
	private JTextField campoRenavam;
	private JComboBox comboRelatorioTipo;
	private JPanel clienteFornecedor;
	private ArrayList<String> listaTabelaDois;
	private MascaraCampos mascara;
	
	
	
	//novo
	
	private JTabbedPane viewPesquisa;
	private JPanel veiculos, panelTableVeiculo, panelButtons,ClienteDestinatario;
	private JButton btnNew, btnRemove, btnCancel;
	private JButton btnBuscarVeiculo;
	private JLabel lblDataCadastro;

	
	private List<Relatorio> veiculoList;
	private List<Relatorio> frotaList;
	private List<Relatorio> pedidoList;
	private List<Relatorio> clienteList;
	private String idVeiculo;
	private int idFrota;
	private JPanel panelButton;
	private JTable tableVeiculo;

	private JPanel panelButtonFrota;
	private JButton btnBuscarFrota;
	private JPanel panelTableFrota;
	private JScrollPane scrollPaneFrota;
	private JTable tableFrota;
	private JScrollPane scrollPaneVeiculo;
	private JTable tablePedido;
	private JPanel panelFilter;
	private JFormattedTextField textRelatorioPlaca;
	private JFormattedTextField textRelatorioRenavam;
	private JLabel lblRelatorioTipo;
	private JPanel panelPedidoAdd;
	private JComboBox comboBoxPedidoStatus;
	private JComboBox comboBoxTipoPessoa;
	private JComboBox campoTipoCliente;
	private JLabel lblStatus;
	private JPanel panelAddCliente;
	private JPanel panelTableCliente;
	private JPanel panelButtonCliente;
	private JTable tableClienteDestinatario;
	private JTextField textFieldCnpj;
	private JLabel lblTipoCliente;
	private JLabel lblTipoPessoa;
	private JLabel lblRzs_Nome;
	private JTextField textFieldNOME;
	private JLabel lbldoc;
	private JTextField textFieldCPF;
	private JTextField textRazaoSocial;
	private JFormattedTextField campoDataPostagem;
	private JFormattedTextField campoDt_entrega;

	
	
	
	/**
	 * Create the panel.
	 */
	public Relatorios() throws HeadlessException{
		
		final Relatorio relatorioModelo = new Relatorio();
		
		setBackground(Color.WHITE);
		setLayout(null);

		mascara = new MascaraCampos();
		
		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setBounds(10, 11, 89, 14);
		add(lblPesquisa);
		
		viewPesquisa = new JTabbedPane(JTabbedPane.TOP);
		viewPesquisa.setBounds(20, 36, 1754, 714);
		add(viewPesquisa);
		
		// CLiente
				
				ClienteDestinatario = new JPanel();
				ClienteDestinatario.setBackground(Color.WHITE);
				viewPesquisa.addTab("Cliente / Destinatario", null, ClienteDestinatario, null);
				ClienteDestinatario.setLayout(null);
				
				panelAddCliente = new JPanel();
				panelAddCliente.setBackground(Color.WHITE);
				panelAddCliente.setBounds(10, 11, 779, 76);
				ClienteDestinatario.add(panelAddCliente);
				panelAddCliente.setLayout(null);
				
				textFieldCnpj = new JTextField();
				textFieldCnpj.setBounds(88, 11, 102, 20);
				panelAddCliente.add(textFieldCnpj);
				textFieldCnpj.setColumns(10);
				
				panelTableCliente = new JPanel();
				panelTableCliente.setBackground(Color.WHITE);
				panelTableCliente.setBounds(10, 114, 1258, 216);
				ClienteDestinatario.add(panelTableCliente);
				panelTableCliente.setLayout(null);
				
				JScrollPane scrollPaneTableCliente = new JScrollPane();
				scrollPaneTableCliente.setBounds(10, 11, 1226, 134);
				panelTableCliente.add(scrollPaneTableCliente);
				
				tableClienteDestinatario = new JTable();
				scrollPaneTableCliente.setViewportView(tableClienteDestinatario);
				
				panelButtonCliente = new JPanel();
				panelButtonCliente.setBounds(1139, 337, 113, 61);
				ClienteDestinatario.add(panelButtonCliente);
				panelButtonCliente.setLayout(null);
		
		JPanel frotas = new JPanel();
		frotas.setBackground(Color.WHITE);
		viewPesquisa.addTab("Frota", null, frotas, null);
		frotas.setLayout(null);
		
		panelTableFrota = new JPanel();
		panelTableFrota.setBounds(27, 11, 981, 315);
		panelTableFrota.setBackground(Color.WHITE);
		panelTableFrota.setBorder(BorderFactory.createTitledBorder("Lista de Frotas"));
		frotas.add(panelTableFrota);
		panelTableFrota.setLayout(null);
		
		scrollPaneFrota = new JScrollPane();
		scrollPaneFrota.setBounds(23, 35, 934, 251);
		panelTableFrota.add(scrollPaneFrota);
		
		tableFrota = new JTable();
		scrollPaneFrota.setViewportView(tableFrota);
		
		panelButtonFrota = new JPanel();
		panelButtonFrota.setBounds(892, 352, 121, 49);
		frotas.add(panelButtonFrota);
		panelButtonFrota.setBackground(Color.WHITE);
		panelButtonFrota.setLayout(null);
		
		btnBuscarFrota = new JButton("Buscar");
		btnBuscarFrota.setBounds(10, 11, 90, 27);
		panelButtonFrota.add(btnBuscarFrota);
			
			veiculos = new JPanel();
			veiculos.setBackground(Color.WHITE);
			viewPesquisa.addTab("Veiculo", null, veiculos, null);
			veiculos.setLayout(null);
			
			panelButton = new JPanel();
			panelButton.setBackground(Color.WHITE);
			panelButton.setBounds(1003, 497, 277, 61);
			veiculos.add(panelButton);
			panelButton.setLayout(null);
			
				btnRemove = new JButton("Remover");
				btnRemove.setBounds(28, 11, 102, 29);
				panelButton.add(btnRemove);
				
				btnBuscarVeiculo = new JButton("Buscar");
				btnBuscarVeiculo.setBounds(154, 11, 102, 29);
				panelButton.add(btnBuscarVeiculo);
				
		panelTableVeiculo = new JPanel();
		panelTableVeiculo.setBackground(Color.WHITE);
		panelTableVeiculo.setBorder(BorderFactory.createTitledBorder("Lista de Veiculos"));
		panelTableVeiculo.setBounds(13, 123, 1267, 313);
		veiculos.add(panelTableVeiculo);
		panelTableVeiculo.setLayout(null);
		
		scrollPaneVeiculo = new JScrollPane();
		scrollPaneVeiculo.setBounds(10, 34, 1233, 251);
		panelTableVeiculo.add(scrollPaneVeiculo);
		
		tableVeiculo = new JTable();
		tableVeiculo.setBackground(Color.WHITE);
		scrollPaneVeiculo.setViewportView(tableVeiculo);
		
		panelFilter = new JPanel();
		panelFilter.setBackground(Color.WHITE);
		panelFilter.setBounds(13, 23, 690, 70);
		veiculos.add(panelFilter);
		panelFilter.setLayout(null);
		
		JLabel lblRelatorioPlaca = new JLabel("Placa:");
		lblRelatorioPlaca.setBounds(10, 31, 46, 14);
		panelFilter.add(lblRelatorioPlaca);
		
		textRelatorioPlaca = new JFormattedTextField();
		textRelatorioPlaca.setBounds(54, 28, 86, 20);
		panelFilter.add(textRelatorioPlaca);
		textRelatorioPlaca.setColumns(10);
		mascara.mascaraPlaca(textRelatorioPlaca);
		
		JLabel lblRelatorioRenavam = new JLabel("Renavam:");
		lblRelatorioRenavam.setBounds(179, 31, 86, 14);
		panelFilter.add(lblRelatorioRenavam);
		
		textRelatorioRenavam = new JFormattedTextField();
		textRelatorioRenavam.setBounds(251, 28, 86, 20);
		panelFilter.add(textRelatorioRenavam);
		textRelatorioRenavam.setColumns(10);
		mascara.mascaraRenavam(textRelatorioRenavam);
		
		comboRelatorioTipo = new JComboBox();
		comboRelatorioTipo.setModel(new DefaultComboBoxModel(new String[] {"Todos","Caminh\u00E3o", "Carro", "Van", "Carroceria"}));
		comboRelatorioTipo.setBounds(447, 27, 123, 22);
		panelFilter.add(comboRelatorioTipo);
		
		lblRelatorioTipo = new JLabel("Tipo:");
		lblRelatorioTipo.setBounds(391, 31, 46, 14);
		panelFilter.add(lblRelatorioTipo);
		
	// PEDIDO
		
			JPanel pedidos = new JPanel();
			pedidos.setBackground(Color.WHITE);
			viewPesquisa.addTab("Pedidos", null, pedidos, null);		
			viewPesquisa.setBackgroundAt(3, Color.WHITE);
			pedidos.setLayout(null);
			
			JPanel panelButtonPedido = new JPanel();
			panelButtonPedido.setLayout(null);
			panelButtonPedido.setBackground(Color.WHITE);
			panelButtonPedido.setBounds(1026, 357, 251, 61);
			pedidos.add(panelButtonPedido);
			
			JButton btnRemovePedido = new JButton("Cancelar");
			btnRemovePedido.setBounds(20, 11, 89, 29);
			panelButtonPedido.add(btnRemovePedido);
			
			JButton btnBuscarPedido = new JButton("Buscar");
			btnBuscarPedido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnBuscarPedido.setBounds(144, 11, 89, 29);
			panelButtonPedido.add(btnBuscarPedido);
			
			JPanel panelTablePedido = new JPanel();
			panelTablePedido.setBorder(BorderFactory.createTitledBorder("Lista de Pedidos"));
			panelTablePedido.setBackground(Color.WHITE);
			panelTablePedido.setBounds(10, 82, 1267, 264);
			pedidos.add(panelTablePedido);
			panelTablePedido.setLayout(null);
			
			JScrollPane scrollPanePedido = new JScrollPane();
			scrollPanePedido.setBounds(10, 34, 1233, 205);
			panelTablePedido.add(scrollPanePedido);
			
			tablePedido = new JTable();
			scrollPanePedido.setViewportView(tablePedido);
			
			panelPedidoAdd = new JPanel();
			panelPedidoAdd.setBackground(Color.WHITE);
			panelPedidoAdd.setBounds(10, 11, 767, 60);
			pedidos.add(panelPedidoAdd);
			panelPedidoAdd.setLayout(null);
			
			comboBoxPedidoStatus = new JComboBox();
			comboBoxPedidoStatus.setBounds(76, 11, 123, 22);
			comboBoxPedidoStatus.setModel(new DefaultComboBoxModel(new String[] {"Todos","Encaminhado","Em viagem","Finalizado","Cancelado"}));
			panelPedidoAdd.add(comboBoxPedidoStatus);
			
			lblStatus = new JLabel("Status:");
			lblStatus.setBounds(10, 15, 46, 14);
			panelPedidoAdd.add(lblStatus);
			
			JLabel lblDataPostagem = new JLabel("Data Postagem:");
			lblDataPostagem.setBounds(239, 15, 104, 14);
			panelPedidoAdd.add(lblDataPostagem);
			
			campoDataPostagem = new JFormattedTextField();
			campoDataPostagem.setBounds(353, 12, 90, 20);
			panelPedidoAdd.add(campoDataPostagem);
			mascara.mascaraDataPostagem(campoDataPostagem);
			
			JLabel lblDataEntrega = new JLabel("Data Entrega:");
			lblDataEntrega.setBounds(492, 15, 82, 14);
			panelPedidoAdd.add(lblDataEntrega);
			
			campoDt_entrega = new JFormattedTextField();
			campoDt_entrega.setBounds(584, 12, 95, 20);
			panelPedidoAdd.add(campoDt_entrega);
			mascara.mascaraDataEntrega(campoDt_entrega);
			
	// Cliente/Destinatario		
			
			comboBoxTipoPessoa = new JComboBox();
			comboBoxTipoPessoa.setModel(new DefaultComboBoxModel(new String[] {"Fisica","Juridica"}));
			comboBoxTipoPessoa.setBounds(284, 11, 83, 20);
			panelAddCliente.add(comboBoxTipoPessoa);
			
			lbldoc = new JLabel("CPF:");
			lbldoc.setBounds(10, 14, 68, 14);
			panelAddCliente.add(lbldoc);
			
			campoTipoCliente  = new JComboBox();
			campoTipoCliente.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Destinatario"}));
			campoTipoCliente.setBounds(456, 10, 135, 22);
			panelAddCliente.add(campoTipoCliente);
			
			lblTipoCliente = new JLabel("Tipo:");
			lblTipoCliente.setBounds(410, 14, 46, 14);
			panelAddCliente.add(lblTipoCliente);
			
			lblTipoPessoa = new JLabel("Tipo Pessoa:");
			lblTipoPessoa.setBounds(200, 14, 74, 14);
			panelAddCliente.add(lblTipoPessoa);
			
			lblRzs_Nome = new JLabel("Nome:");
			lblRzs_Nome.setBounds(10, 51, 83, 14);
			panelAddCliente.add(lblRzs_Nome);
			
			textFieldNOME = new JTextField();
			textFieldNOME.setBounds(90, 48, 123, 20);
			panelAddCliente.add(textFieldNOME);
			textFieldNOME.setColumns(10);
			
			textFieldCPF = new JTextField();
			textFieldCPF.setBounds(88, 11, 102, 20);
			panelAddCliente.add(textFieldCPF);
			textFieldCPF.setColumns(10);
			
			textRazaoSocial = new JTextField();
			textRazaoSocial.setBounds(90, 48, 123, 20);
			panelAddCliente.add(textRazaoSocial);
			textRazaoSocial.setColumns(10);
			
			JButton btnBuscarCliente = new JButton("Buscar");
			btnBuscarCliente.setBounds(10, 11, 89, 37);
			panelButtonCliente.add(btnBuscarCliente);

			
// Botao Cliente/Destinatario
			
			// AÇÃO DE MUDANÇA DE TIPO-PESSOA PARA PF(0),PJ(1) QUE ALTERA ALGUN COMPONENTES DA TELA
			comboBoxTipoPessoa.addItemListener(new ItemListener() {
		    	public void itemStateChanged(ItemEvent arg0) {
		    		//CHAMA O METODO PARA A MECANICA DA TELA
		    		mecanicaDeTela();	
		    	}
		    });
			
			btnBuscarCliente.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					refreshTableClienteDestinatario();
				}
			});
			
			
			

			
// Botao Veiculo			
			
		btnRemove.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				onRemoverVeiculo();
				
			}
		});
				
				btnBuscarVeiculo.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent e) {
						
						refreshTableVeiculo();
					}
					
				});
				
				
	    enableFild(false);
		
		
		
// Botao FROTAS
		
		btnBuscarFrota.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				refreshTableFrota();
				enableFild(true);
			}
		});
		
// Botao PEDIDO
		
		btnBuscarPedido.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				refreshTablePedido();
				enableFild(true);
			}
		});
		
		btnRemovePedido.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				onRemoverPedido();
				
			}
		});

	}
	

	/*
	 *  Metodos acao tabela frotas
	 * 
	 * Author Lucas Gabriel
	 * */
	

	public void refreshTableClienteDestinatario(){
		
		Relatorio relatorio = new Relatorio();
		
		// flag que valida tipo do relatorio
		relatorio.setStatusRelatorio(4);
		
		relatorio.setComboBoxTipoPessoa(String.valueOf(comboBoxTipoPessoa.getSelectedIndex()));
		relatorio.setComboBoxTipoCliente(String.valueOf(campoTipoCliente.getSelectedIndex()));
		
		if (relatorio.getComboBoxTipoCliente().equals("0")){
			
			if(relatorio.getComboBoxTipoPessoa().equals("0")){
				
				relatorio.setCpf(textFieldCPF.getText());
				relatorio.setNome(textFieldNOME.getText());
				relatorio.setCnpf(textFieldCnpj.getText());
				relatorio.setRazaoSocial(textRazaoSocial.getText());
				relatorio.setComboBoxTipoPessoa(String.valueOf(comboBoxTipoPessoa.getSelectedIndex()));
				relatorio.setComboBoxTipoCliente(String.valueOf(campoTipoCliente.getSelectedIndex()));
		
				clienteList = new RelatorioController().findAll(relatorio);
				
				if(clienteList != null){
					
					tableClienteDestinatario.setModel( new RelatorioTableModelClienteFisica(clienteList));
				
				//	tableVeiculo.setDefaultRenderer(Object.class, new RelatorioCellRenderer());
				}
			}
			if(relatorio.getComboBoxTipoPessoa().equals("1")){
				
				relatorio.setCpf(textFieldCPF.getText());
				relatorio.setNome(textFieldNOME.getText());
				relatorio.setCnpf(textFieldCnpj.getText());
				relatorio.setRazaoSocial(textRazaoSocial.getText());
				relatorio.setComboBoxTipoPessoa(String.valueOf(comboBoxTipoPessoa.getSelectedIndex()));
				relatorio.setComboBoxTipoCliente(String.valueOf(campoTipoCliente.getSelectedIndex()));
		
				clienteList = new RelatorioController().findAll(relatorio);
				
				if(clienteList != null){
					
					tableClienteDestinatario.setModel( new RelatorioTableModelClienteJuridica(clienteList));
				
				//	tableVeiculo.setDefaultRenderer(Object.class, new RelatorioCellRenderer());
				}
			}
			
		}
		
		if (relatorio.getComboBoxTipoCliente().equals("1")){
				
				relatorio.setCpf(textFieldCPF.getText());
				relatorio.setNome(textFieldNOME.getText());
				relatorio.setCnpf(textFieldCnpj.getText());
				relatorio.setRazaoSocial(textRazaoSocial.getText());
				relatorio.setComboBoxTipoPessoa(String.valueOf(comboBoxTipoPessoa.getSelectedIndex()));
				relatorio.setComboBoxTipoCliente(String.valueOf(campoTipoCliente.getSelectedIndex()));
		
				clienteList = new RelatorioController().findAll(relatorio);
				
				if(clienteList != null){
					
					tableClienteDestinatario.setModel( new RelatorioTableModelDestinatario(clienteList));
				
				//	tableVeiculo.setDefaultRenderer(Object.class, new RelatorioCellRenderer());
				}
		}	
		
	}
	
	public void onSaveClienteFisica(Relatorio relatorio){
		
		relatorio.setStatusRelatorio(4);
	
		relatorio.setComboBoxTipoPessoa(String.valueOf(0));
		relatorio.setComboBoxTipoCliente(String.valueOf(0));
		
		relatorio.getComboBoxTipoPessoa();
		
		boolean result = new RelatorioController().update(relatorio);
	
		if(result == true){
		
		JOptionPane.showMessageDialog(this, "Cliente fisica Atualizado com sucesso");
		enableFild(false);
		onCancelar();
		
		refreshTableClienteDestinatario();
		
		}
		
		else{
			JOptionPane.showMessageDialog(this, "Tente Novamente");
		}	
	}
	
	public void onSaveClienteJuridica(Relatorio relatorio){
		
		relatorio.setStatusRelatorio(4);
	
		relatorio.setComboBoxTipoPessoa(String.valueOf(1));
		relatorio.setComboBoxTipoCliente(String.valueOf(0));
		
		relatorio.getComboBoxTipoPessoa();
		
		boolean result = new RelatorioController().update(relatorio);
	
		if(result == true){
		
		JOptionPane.showMessageDialog(this, "Cliente juridica Atualizado com sucesso");
		enableFild(false);
		onCancelar();
		
		refreshTableClienteDestinatario();
		
		}
		
		else{
			JOptionPane.showMessageDialog(this, "Tente Novamente");
		}	
	}
	
	public void onSaveClienteDestinatario(Relatorio relatorio){
		
		relatorio.setStatusRelatorio(4);
	
		relatorio.setComboBoxTipoCliente(String.valueOf(1));

		boolean result = new RelatorioController().update(relatorio);
	
		if(result == true){
		
		JOptionPane.showMessageDialog(this, "Destinatario Atualizado com sucesso");
		enableFild(false);
		onCancelar();
		
		refreshTableClienteDestinatario();
		
		}
		
		else{
			JOptionPane.showMessageDialog(this, "Tente Novamente");
		}	
	}
	
	
// 	FROTAS
	
	private void refreshTableFrota(){
		
		Relatorio relatorio = new Relatorio();
		
		relatorio.setStatusRelatorio(2);
		
		frotaList = new RelatorioController().findAll(relatorio);
		
		if(frotaList != null){
			
			tableFrota.setModel(new RelatorioTableModelFrota(frotaList));
		//	tableVeiculo.setDefaultRenderer(Object.class, new RelatorioCellRenderer());
		}
		
	}
	
	
// VEICULO	
	
	public void refreshTableVeiculo(){
		
		Relatorio relatorio = new Relatorio();
		
		relatorio.setStatusRelatorio(1);
		relatorio.setPlaca(textRelatorioPlaca.getText());
		relatorio.setRenavam(textRelatorioRenavam.getText());
		relatorio.setComboTipoVeiculo(String.valueOf(comboRelatorioTipo.getSelectedItem()));
		
		
		if(relatorio.getComboTipoVeiculo().equals("Todos")){
			relatorio.setComboTipoVeiculo("");
		}
		
		if(relatorio.getRenavam().equals("           ")){
			
			relatorio.setRenavam("");
		}
		
		if(relatorio.getPlaca().equals("   -    ")){
			
			relatorio.setPlaca("");
		}
		
		veiculoList = new RelatorioController().findAll(relatorio);
		
		if(veiculoList != null){
			
			tableVeiculo.setModel(new RelatorioTableModelVeiculo(veiculoList));
		//	tableVeiculo.setDefaultRenderer(Object.class, new RelatorioCellRenderer());
		}
		
	}
	
	
	private void onRemoverVeiculo(){
		
		int rowIndex =  tableVeiculo.getSelectedRow();
		
		// se a tabela nao tiver nenhuma linha selecionada
		if(rowIndex == -1){
			JOptionPane.showMessageDialog(this, "selecione o veiculo a ser removido");
			return;
		}
		
		Relatorio lineTableVeiculo = new RelatorioTableModelVeiculo(veiculoList).get(rowIndex);
		
		lineTableVeiculo.setStatusRelatorio(1);
		
		int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusao?", "Excluir Veiculo", JOptionPane.YES_NO_OPTION);
		
		if(confirm != 0){
			return;
		}
		
		boolean result = new RelatorioController().remove(lineTableVeiculo);
		

		if(result == true){
			
			JOptionPane.showMessageDialog(this, "Valor removido com sucesso");
			refreshTableVeiculo();
		}
		else{
			JOptionPane.showMessageDialog(this, "Tente novamente");
		}
		
	}
	
	private void onAlterarVeiculo(){
		
		int rowIndex =  tableVeiculo.getSelectedRow();
		
		// se a tabela nao tiver nenhuma linha selecionada
		if(rowIndex == -1){
			JOptionPane.showMessageDialog(this, "selecione o veiculo a ser alterado");
			return;
		}
		
		Relatorio veiculo = new RelatorioTableModelVeiculo(veiculoList).get(rowIndex);
		
		idVeiculo = veiculo.getPlaca();
		
//		txtPlaca.setText(veiculo.getPlaca());
//		txtRenavam.setText(veiculo.getRenavam());
//		texTipo.setText(veiculo.getComboTipoVeiculo());
//		textTara.setText(String.valueOf(veiculo.getTara()));
//		textCap_Comp_Carga.setText(String.valueOf(veiculo.getCompCapacidadeCarga()));
//		textLargura_Carga.setText(String.valueOf(veiculo.getLarguraCapacidadeCarga()));
//		textAltura_Carga.setText(String.valueOf(veiculo.getAlturaCapacidadeCarga()));
//		txtPesoCarga.setText(String.valueOf(veiculo.getPesoMaxCarga()));
//		textNumero_Eixo.setText(String.valueOf(veiculo.getNumeroEixos()));
//		textCap_Combustivel.setText(String.valueOf(veiculo.getCapacidadeTanqueComb()));
//		textModelo.setText(veiculo.getMarcaModelo());
//		textCombustivel.setText(veiculo.getCombustivel());
//		textAnoFabricacao.setText(String.valueOf(veiculo.getAnoFabricacao()));
		
		enableFild(true);
	}
	
	public void onSaveVeiculos(Relatorio relatorio){
			
			relatorio.setStatusRelatorio(1);
		
			boolean result = new RelatorioController().update(relatorio);
		
			if(result == true){
			
			JOptionPane.showMessageDialog(this, "Veiculo Atualizado com sucesso");
			enableFild(false);
			onCancelar();
			
			
			refreshTableVeiculo();
			
		
			}
			
			else{
				JOptionPane.showMessageDialog(this, "Tente Novamente");
			}	
		}
	
// Pedido	
		
	public void refreshTablePedido(){
		
		Relatorio relatorio = new Relatorio();
		
		relatorio.setStatusRelatorio(3);
		relatorio.setStatusPedido(String.valueOf(comboBoxPedidoStatus.getSelectedItem()));
		
		String dataPostagem = campoDataPostagem.getText();
		String dataEntrega = campoDt_entrega.getText();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
		if(dataPostagem.equals("  /  /    ")){
			
			dataPostagem = "";
			
		}
		if(dataEntrega.equals("  /  /    ")){
			
			dataEntrega = "";
			
		}
		
		if(!dataPostagem.equals("")){
			
			
			try {
				Date dt_postagem = formatar.parse(dataPostagem);

				String dt_postageFomatada = df.format(dt_postagem);

				relatorio.setDt_pedidoRelatorio(dt_postageFomatada);
				
			} catch (ParseException e) {
				System.out.println("Erro ao obter dataPostagem" + e);
			}  
			
			
		}
		
		if(!dataEntrega.equals("")){
			
			try {
				Date dt_entrega = formatar.parse(dataEntrega);

				String dt_entregaFormatada = df.format(dt_entrega);
				
				relatorio.setDt_entregaRelatorio(dt_entregaFormatada);
				
			} catch (ParseException e) {
				System.out.println("Erro ao obter dataEntrega" + e);
			}  
			
		}
		
		
		if(relatorio.getStatusPedido().equals("Todos")){
			relatorio.setStatusPedido("");
		}
		
		pedidoList = new RelatorioController().findAll(relatorio);
		
		if(pedidoList != null){
			
			tablePedido.setModel(new RelatorioTableModelPedido(pedidoList));
		//	tableVeiculo.setDefaultRenderer(Object.class, new RelatorioCellRenderer());
		}
		
	}
	
	
	private void onRemoverPedido(){
		
		int rowIndex =  tablePedido.getSelectedRow();
		
		// se a tabela nao tiver nenhuma linha selecionada
		if(rowIndex == -1){
			JOptionPane.showMessageDialog(this, "selecione o pedido a ser removido");
			return;
		}
		
		Relatorio lineTablePedido = new RelatorioTableModelVeiculo(pedidoList).get(rowIndex);
		
		lineTablePedido.setStatusRelatorio(3);
		
		int confirm = JOptionPane.showConfirmDialog(this, "Confirmar exclusao?", "Excluir Pedido", JOptionPane.YES_NO_OPTION);
		
		if(confirm != 0){
			return;
		}
		
		boolean result = new RelatorioController().remove(lineTablePedido);

		if(result == true){
			
			JOptionPane.showMessageDialog(this, "Valor removido com sucesso");
			refreshTablePedido();
		}
		else{
			JOptionPane.showMessageDialog(this, "Tente novamente");
		}
		
	}

	public void onCancelar(){
		
//		txtPlaca.setText("");
//		txtRenavam.setText("");
//		texTipo.setText("");
//		textTara.setText("");
//		textCap_Comp_Carga.setText("");
//		textLargura_Carga.setText("");
//		textAltura_Carga.setText("");
//		txtPesoCarga.setText("");
//		textNumero_Eixo.setText("");
//		textCap_Combustivel.setText("");
//		textModelo.setText("");
//		textCombustivel.setText("");
//		textAnoFabricacao.setText("");

		enableFild(false);
		
	}

	public void enableFild(boolean b){

	}
	
   public boolean confirmaExclusao() {
		
		int confirm = JOptionPane.showConfirmDialog(this, "Confirmar alteração?", "Alterar Veiculo", JOptionPane.YES_NO_OPTION);
		
		if(confirm != 0){
			
			return false;
		}
		
		return true;
	}
   
	public boolean error(){

		JOptionPane.showMessageDialog(this, "Esse campo não pode ser alterado");
		
		return false;
	}
	
private void mecanicaDeTela(){
	

		// PESSOA FISICA CLIENTE
		if(comboBoxTipoPessoa.getSelectedIndex() == 0 && campoTipoCliente.getSelectedIndex() == 0){
			
			lbldoc.setText("CPF:");
			lblRzs_Nome.setText("Nome:");
			textFieldCnpj.enable(true);
			textFieldNOME.enable(true);

			
			
		// PESSOA JURIDICA CLIENTE	
		}else if(comboBoxTipoPessoa.getSelectedIndex() == 1 && campoTipoCliente.getSelectedIndex() == 0){
			lbldoc.setText("CNPJ:");
			lblRzs_Nome.setText("Razão Social:");
			textFieldCnpj.enable(true);
			textRazaoSocial.enable(true);

		}
		
		// PESSOA FISICA DESTINATARIO
		else if(comboBoxTipoPessoa.getSelectedIndex() == 0 && campoTipoCliente.getSelectedIndex() == 1){
			
			lbldoc.setText("CPF/CNPJ:");
			lblRzs_Nome.setText("Nome:");
			textFieldCnpj.enable(true);
			textFieldNOME.enable(true);
			
		// PESSOA JURIDICA DESTINATARIO	
		}else if(comboBoxTipoPessoa.getSelectedIndex() == 1 && campoTipoCliente.getSelectedIndex() == 1){
			lbldoc.setText("CPF/CNPJ:");
			lblRzs_Nome.setText("Nome");
			textFieldCnpj.enable(true);
			textRazaoSocial.enable(true);
			
		}
		
	}
}
