package view;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.tools.DiagnosticCollector;

import model.Cliente;
import model.Destinatario;
import model.Pedido;
import model.Veiculo;
import controller.ClienteDestinatarioController;
import controller.DistribuicaoController;
import controller.FrotaController;
import controller.PedidoController;
import controller.VeiculoController;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentListener;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Panel;
import java.awt.Color;



public class Distribuicao extends JPanel {
	
	private MascaraCampos mascara = new MascaraCampos();
	private DistribuicaoController distribuicao = new DistribuicaoController();
	private String tipoRem;
	private JTextField campoPrazo;
	private JTextField campoAlt;
	private JTextField campoPeso;
	private JTextField campoLarg;
	private JTextField campoComp;
	private JComboBox comboBoxDestinatario;
	private JComboBox comboBoxRemetente;
	private JFormattedTextField campoDocDest;
	private JButton btnBuscarDocRem;
	private JFormattedTextField campoDocRem;
	
	// VARIAVEIS USADAS EM DESPACHO DE VEICULOS E PEDIDOS
	private DefaultListModel model;
	private JScrollPane scrollPane;
	private JList listaVeiculos;
	private ArrayList<Veiculo> veiculosAsair = new ArrayList<Veiculo>();
	private PedidoController p = new PedidoController();
	
	// VARIAVEIS USADAS EM FECHAMENTO DE PEDIDO
	private DefaultListModel modelEntregas;
	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
	private JList listaPedidosEmViagem;
	
	public Distribuicao() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		// TABELA DE PAINEIS DA DISTRIBUIÇAO
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 31, 1215, 658);
		add(tabbedPane);
		
		// *************************************     PARTE DE ENCAMINAR ENTREGA  ************************
		JPanel viewDistribuicaoCadastro = new JPanel();
		viewDistribuicaoCadastro.setBackground(Color.WHITE);
		tabbedPane.addTab("Encaminhar", null, viewDistribuicaoCadastro, null);
		viewDistribuicaoCadastro.setLayout(null);
		
		// LABELS DA TELA DE ENCAMINHAR ENTREGAS / PEDIDOS
		JLabel label = new JLabel("Propriedades do produto:");
		label.setBounds(61, 44, 185, 20);
		viewDistribuicaoCadastro.add(label);
		
		JLabel label_1 = new JLabel("Comprimento :");
		label_1.setBounds(61, 91, 91, 14);
		viewDistribuicaoCadastro.add(label_1);
		
		JLabel label_2 = new JLabel("Largura: ");
		label_2.setBounds(61, 132, 82, 14);
		viewDistribuicaoCadastro.add(label_2);
		
		JLabel label_3 = new JLabel("Peso:");
		label_3.setBounds(60, 170, 50, 14);
		viewDistribuicaoCadastro.add(label_3);
		
		JLabel label_4 = new JLabel("Altura: ");
		label_4.setBounds(61, 208, 47, 14);
		viewDistribuicaoCadastro.add(label_4);
		
		JLabel label_5 = new JLabel("Propriedades da Entrega:");
		label_5.setBounds(61, 268, 173, 14);
		viewDistribuicaoCadastro.add(label_5);
		
		JLabel label_6 = new JLabel("Prazo:");
		label_6.setBounds(61, 304, 46, 14);
		viewDistribuicaoCadastro.add(label_6);
		
		JLabel label_7 = new JLabel("Dias");
		label_7.setBounds(197, 304, 37, 14);
		viewDistribuicaoCadastro.add(label_7);
		
		JLabel label_8 = new JLabel("m");
		label_8.setBounds(264, 91, 46, 14);
		viewDistribuicaoCadastro.add(label_8);
		
		JLabel label_9 = new JLabel("m");
		label_9.setBounds(264, 132, 46, 14);
		viewDistribuicaoCadastro.add(label_9);
		
		JLabel label_10 = new JLabel("Kg");
		label_10.setBounds(264, 170, 46, 14);
		viewDistribuicaoCadastro.add(label_10);
		
		JLabel label_11 = new JLabel("m");
		label_11.setBounds(264, 208, 46, 14);
		viewDistribuicaoCadastro.add(label_11);
		
		JLabel label_12 = new JLabel("Inclus\u00E3o de Pedido De Entrega");
		label_12.setBounds(393, 11, 217, 14);
		viewDistribuicaoCadastro.add(label_12);
		
		JLabel label_13 = new JLabel("Pripriedades do Destinatario:");
		label_13.setBounds(425, 47, 185, 14);
		viewDistribuicaoCadastro.add(label_13);
		
		JLabel label_14 = new JLabel("Destinatario:");
		label_14.setBounds(393, 91, 77, 14);
		viewDistribuicaoCadastro.add(label_14);
		
		JLabel label_15 = new JLabel("Documento:");
		label_15.setBounds(393, 132, 77, 14);
		viewDistribuicaoCadastro.add(label_15);
		
		JLabel label_16 = new JLabel("Propriedades do Remetente:");
		label_16.setBounds(393, 170, 196, 14);
		viewDistribuicaoCadastro.add(label_16);
		
		campoDocDest = new JFormattedTextField();
		campoDocDest.setColumns(10);
		campoDocDest.setBounds(480, 129, 124, 20);
		viewDistribuicaoCadastro.add(campoDocDest);
		
		JLabel label_17 = new JLabel("Remetente:");
		label_17.setBounds(393, 208, 77, 14);
		viewDistribuicaoCadastro.add(label_17);
		
		JLabel label_18 = new JLabel("Documento: ");
		label_18.setBounds(393, 249, 76, 14);
		viewDistribuicaoCadastro.add(label_18);
		
		// TEXT FIELDS DE ENCAMINHAR ENTREGAS
		campoPrazo = new JTextField();
		campoPrazo.setColumns(10);
		campoPrazo.setBounds(118, 301, 55, 20);
		viewDistribuicaoCadastro.add(campoPrazo);	
		
		campoAlt = new JTextField();
		campoAlt.setColumns(10);
		campoAlt.setBounds(158, 205, 86, 20);
		viewDistribuicaoCadastro.add(campoAlt);
		
		campoPeso = new JTextField();
		campoPeso.setColumns(10);
		campoPeso.setBounds(158, 167, 86, 20);
		viewDistribuicaoCadastro.add(campoPeso);
		
		campoLarg = new JTextField();
		campoLarg.setColumns(10);
		campoLarg.setBounds(158, 129, 86, 20);
		viewDistribuicaoCadastro.add(campoLarg);
		
		campoComp = new JTextField();
		campoComp.setColumns(10);
		campoComp.setBounds(158, 88, 86, 20);
		viewDistribuicaoCadastro.add(campoComp);
		
	    campoDocRem = new JFormattedTextField();
		campoDocRem.setColumns(10);
		campoDocRem.setBounds(480, 246, 124, 20);
		viewDistribuicaoCadastro.add(campoDocRem);
		
		// COMBOBOX USADOS NA TELA DE ENCAMINHAMENTO
		comboBoxDestinatario = new JComboBox();
		comboBoxDestinatario.setBounds(480, 87, 217, 22);
		viewDistribuicaoCadastro.add(comboBoxDestinatario);
		
		comboBoxRemetente = new JComboBox();
		comboBoxRemetente.setBounds(480, 205, 217, 20);
		viewDistribuicaoCadastro.add(comboBoxRemetente);
		
		// BOTOES
	    btnBuscarDocRem = new JButton("Buscar");
		btnBuscarDocRem.setBounds(631, 245, 91, 23);
		viewDistribuicaoCadastro.add(btnBuscarDocRem);
		
		JButton btnBuscaDocDest = new JButton("Buscar");
		btnBuscaDocDest.setBounds(631, 128, 91, 23);
		viewDistribuicaoCadastro.add(btnBuscaDocDest);
		
		JButton btnCarregarLista = new JButton("Carregar Lista");
		btnCarregarLista.setBounds(734, 87, 131, 23);
		viewDistribuicaoCadastro.add(btnCarregarLista);
		
		JButton btnCarregaListRem = new JButton("Carregar Lista");
		btnCarregaListRem.setBounds(734, 204, 131, 23);
		viewDistribuicaoCadastro.add(btnCarregaListRem);
		
		JButton btnLimpaCampos = new JButton("Limpar");
		btnLimpaCampos.setBounds(10, 431, 91, 23);
		viewDistribuicaoCadastro.add(btnLimpaCampos);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(793, 431, 91, 23);
		viewDistribuicaoCadastro.add(btnEnviar);
		
		//ACAO DO BOTAO QUE POPULA O COMBOBOX DE DESTINATARIOS
		btnCarregarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxDestinatario = ( new DistribuicaoController().carregaListaDestinatarios(comboBoxDestinatario) );
			}
		});
		
		//ACAO DO BOTAO QUE POPULA O COMBOBOX DE REMETENTES(CLIENTES)
		btnCarregaListRem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				comboBoxRemetente  = ( new DistribuicaoController().carregaListaClientes(comboBoxRemetente) );
			}
		});
		
		//ACAO DO BOTAO QUE BUSCA O DESTINATARIO POR DOC
		btnBuscaDocDest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBoxDestinatario.getItemCount() == 0){
					comboBoxDestinatario = ( new DistribuicaoController().carregaListaDestinatarios(comboBoxDestinatario) );
				}
				
				int rowId = -1;
				Destinatario dest = new Destinatario();
				String documento;
				
				try {		
					// manda pra função que trata o documento para enviar ao banco
					documento = distribuicao.trataDocumento(campoDocDest.getText());
					
					if(documento.equals(campoDocDest.getText())){
						JOptionPane.showMessageDialog(null, "Informe um documento sem pontos virgulas, traços ou espaços e com no minímo 3 caracteres");
					}
					
					dest = distribuicao.buscaDestinatarioSelecionado(documento.toString());
					if(dest.getNome() == null){
						JOptionPane.showMessageDialog(null, "Nada Encontrado para esse documento");
					}else{
						
						for (int j = 0; j < comboBoxDestinatario.getItemCount(); j++) {
							
							if(comboBoxDestinatario.getItemAt(j).toString().equals("Cod: "+dest.getIdDest()+" Nome: "+dest.getNome()+"")){ // Cod: 11 Nome: Francisco da silva
								comboBoxDestinatario.setSelectedIndex(j);
							}	
						}
				
					}
						
				} catch (Exception e) {
					System.out.println("erro na view"+e);
				}
		
			}
		});
		
		//ACAO DO BOTAO QUE BUSCA O REMETENTE POR DOC
		btnBuscarDocRem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBoxRemetente.getItemCount() == 0){
					comboBoxRemetente  = ( new DistribuicaoController().carregaListaClientes(comboBoxRemetente) );
				}
				int rowId = -1;
				Cliente remetenteF = new Cliente();
				Cliente remetenteJ = new Cliente();
				String documento;
				
				try {		
					// manda pra função que trata o documento para enviar ao banco
					documento = distribuicao.trataDocumento(campoDocRem.getText());
					
					if(documento.equals(campoDocRem.getText())){
						JOptionPane.showMessageDialog(null, "Informe um documento sem pontos virgulas, traços ou espaços e com no minímo 3 caracteres");
					}
					
					remetenteF = distribuicao.buscaClienteSelecionadoF(documento.toString());
					if(remetenteF.getNome() == null){
						
						remetenteJ =  distribuicao.buscaClienteSelecionadoJ(documento.toString()); 
					
						if(remetenteJ.getRazaoSocial() == null){
							JOptionPane.showMessageDialog(null, "Nada Encontrado para esse documento");
						}else{
							
							for (int j = 0; j < comboBoxRemetente.getItemCount(); j++) {
								
								if(comboBoxRemetente.getItemAt(j).toString().equals("Cod: "+remetenteJ.getIdCliente()+" Nome: "+remetenteJ.getRazaoSocial()+"")){ 
									comboBoxRemetente.setSelectedIndex(j);
									
								}	
							}
						}
						
					}else{
						
						for (int j = 0; j < comboBoxRemetente.getItemCount(); j++) {
							
							if(comboBoxRemetente.getItemAt(j).toString().equals("Cod: "+remetenteF.getIdCliente()+" Nome: "+remetenteF.getNome()+"")){ 
								comboBoxRemetente.setSelectedIndex(j);
								
							}	
						}
				
					}
						
				} catch (Exception e1) {
					System.out.println("erro na view"+e1);
				}
				
			}
		});
		
		//ACAO DO BOTAO QUE CADASTRA A MERCADORIA PARA ENTREGA
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validaCampos()){
					// INSERE ENCOMENDA PARA UM VEICULO DE UMA FROTA DA REGIAO SELECIONADA (ATRAVES DO ENDEREÇO DO DESTINATARIO)
					pegaDados();
				}else{
					JOptionPane.showMessageDialog(null, "Campos necessários não preenchidos, por favor revise-os");
				}
			}
		});	
		
		
		// ******************** DESPACHO DE PEDIDOS E VEICULOS ************************* //
		
		JPanel viewDespacharPedido = new JPanel();
		viewDespacharPedido.setBackground(Color.WHITE);
		tabbedPane.addTab("Despachar", null, viewDespacharPedido, null);
		viewDespacharPedido.setLayout(null);
		
		JLabel lblVeiculosAguardandoSaida = new JLabel("Veiculos aguardando saida:");
		lblVeiculosAguardandoSaida.setBounds(24, 25, 194, 14);
		viewDespacharPedido.add(lblVeiculosAguardandoSaida);
		
		// LISTA DE VEICULOS HABILITADOS
		model = new DefaultListModel(); 
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(100, 50));
		scrollPane.setBounds(31, 68, 256,167);
		
		viewDespacharPedido.add(scrollPane);
		listaVeiculos = new JList(model);
		scrollPane.setViewportView(listaVeiculos);
		listaVeiculos.setBorder(BorderFactory.createLoweredBevelBorder());
		listaVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		listaVeiculos.setLayoutOrientation(JList.VERTICAL);
		
		// BOTAO QUE CARREGA LISTA DE VEICULOS COM PEDIDOS ENCAMINHADOS
		JButton btnCarrListVeiculos = new JButton("Carregar Lista");
		btnCarrListVeiculos.setBounds(31, 277, 130, 23);
		viewDespacharPedido.add(btnCarrListVeiculos);
		
		JButton btnDespachar = new JButton("Despachar");
		btnDespachar.setBounds(327, 277, 102, 23);
		viewDespacharPedido.add(btnDespachar);
		
		// ACAO DO BOTAO DE CARREGAR LISTA DE VEICULOS
		btnCarrListVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				model.clear();
				
				VeiculoController v = new VeiculoController();
				
				ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
				
				String status = "Encaminhado";
				
				listaPedidos = p.buscaPedidosEncaminhados(status);
				
				if(listaPedidos != null){
					
					for (int i = 0; i < listaPedidos.size(); i++) {
						Veiculo veiculo = new Veiculo();
						veiculo = v.buscaVeiculosId(listaPedidos.get(i).getIdVeiculoVinculado()); 
						veiculosAsair.add(veiculo);
					}	
					
					for(int i=0; i < veiculosAsair.size() ; i++){ 	
						model.addElement(veiculosAsair.get(i).getTipo()+"  "+veiculosAsair.get(i).getMarcaModelo()+"  "+veiculosAsair.get(i).getPlaca());
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao carregar lista");
				}
						
			}
		});
		
		// ACAO DO BOTAO DESPACHAR
		btnDespachar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String status = "Em viagem";
				VeiculoController vc = new VeiculoController();
				FrotaController ft   = new FrotaController();
				// ATUALIZA A TABELA TEMPORARIA DE VEICULOS E MUDA O STATUS DO PEDIDO E  ALTERA O STATUS DO VEICULO ENVIADO (ID)
			
				if(p.mudaStatusPedido(veiculosAsair.get(listaVeiculos.getSelectedIndex()).getIdVeiculo(), status) &&
				   vc.atualizaVeiculosAsair(veiculosAsair.get(listaVeiculos.getSelectedIndex()).getIdVeiculo())	  &&
				   vc.alteraStatus( veiculosAsair.get(listaVeiculos.getSelectedIndex()).getIdVeiculo(), 0 )      
				  /* ft.atualizaEstatisticas( veiculosAsair.get(listaVeiculos.getSelectedIndex()).getVinculoFrota() )*/ ){
					
					JOptionPane.showMessageDialog(null, "Veiculo despachado com sucesso para a entrega dos pedidos");
				}else{
					JOptionPane.showMessageDialog(null, "Falha ao despachar veiculo, por favor entre em contato com o suporte");
				}
			}
		});
		
		// ********************** VIEW DE FINALIZAR ENTREGAS ***************************
		Panel viewFinalizarEntrega = new Panel();
		viewFinalizarEntrega.setBackground(Color.WHITE);
		tabbedPane.addTab("Finalizar entrega", null, viewFinalizarEntrega, null);
		viewFinalizarEntrega.setLayout(null);
		
		JLabel lblListaDePedidos = new JLabel("Lista de Pedidos em viagem:");
		lblListaDePedidos.setBounds(21, 34, 200, 14);
		viewFinalizarEntrega.add(lblListaDePedidos);
		
		// LISTA DE VEICULOS HABILITADOS
		modelEntregas = new DefaultListModel(); 
		JScrollPane scrollPaneEntregas = new JScrollPane();
		scrollPaneEntregas.setPreferredSize(new Dimension(100, 50));
		scrollPaneEntregas.setBounds(31, 68, 370,167);
		
		viewFinalizarEntrega.add(scrollPaneEntregas);
		listaPedidosEmViagem = new JList(modelEntregas);
		scrollPaneEntregas.setViewportView(listaPedidosEmViagem);
		listaPedidosEmViagem.setBorder(BorderFactory.createLoweredBevelBorder());
		listaPedidosEmViagem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		listaPedidosEmViagem.setLayoutOrientation(JList.VERTICAL);
		
		JButton btnCarPed = new JButton("Carregar Pedidos");
		btnCarPed.setBounds(31, 353, 156, 23);
		viewFinalizarEntrega.add(btnCarPed);
		
		JButton btnFinalizarPedido = new JButton("Finalizar Pedido");
		btnFinalizarPedido.setBounds(363, 353, 131, 23);
		viewFinalizarEntrega.add(btnFinalizarPedido);
		
		
		btnCarPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				modelEntregas.clear();
				
				String status = "Em viagem";
				
				listaPedidos = p.buscaPedidosEncaminhados(status);
				
				if(listaPedidos != null){
					
					for(int i=0; i < listaPedidos.size() ; i++){ 	
						modelEntregas.addElement("Cod: "+listaPedidos.get(i).getIdPedido()+" Data Postagem: "+listaPedidos.get(i).getDataCadastro()+" Prazo: "+listaPedidos.get(i).getPrazo()+" Dias");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao carregar lista");
				}
				
			}
		});
		
		//ACAO DO BOTAO FINALIZA PEDIDO
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VeiculoController vc = new VeiculoController();
				FrotaController ft   = new FrotaController();
				
				if( p.finalizaPedido(listaPedidos.get(listaPedidosEmViagem.getSelectedIndex()).getIdPedido())  ){
					//ft.atualizaEstatisticas()
					System.out.println(listaPedidos.get(listaPedidosEmViagem.getSelectedIndex()).getIdVeiculoVinculado());
					int status = 1;
					vc.alteraStatus(listaPedidos.get(listaPedidosEmViagem.getSelectedIndex()).getIdVeiculoVinculado(), status);
					JOptionPane.showMessageDialog(null, "Pedido Finalizado com sucesso");
				}else{
					JOptionPane.showMessageDialog(null, "Falha ao finalizar pedido");
				}
				
			}
		});
		
		
	}
		
	
	// VALIDAÇÕES DOS CAMPOS OBRIGATORIOS DE PREENCHIMENTO
	private boolean validaCampos(){
		
		if(!campoAlt.getText().equals("") && !campoComp.getText().equals("")  &&
		   !campoPeso.getText().equals("") && !campoLarg.getText().equals("") &&
		   !campoPrazo.getText().equals("")){
				return true;
		}
		return false;	
	}
	
	private void pegaDados(){
		
		if(comboBoxDestinatario.getItemCount() > 0 && comboBoxRemetente.getItemCount() > 0){
			
			String codDest =  comboBoxDestinatario.getSelectedItem().toString();
			String codRem  =  comboBoxRemetente.getSelectedItem().toString();
			
			codDest = codDest.substring(5 , 7);
			codRem = codRem.substring(5 , 7);
		
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
		
			int idRegiaoRem = -1;
			Veiculo veiculoAdicionado = new Veiculo();
			Pedido pedido = null;
			
			try { 
				int intCodDest = Integer.parseInt(codDest.trim());
				int intCodRem  = Integer.parseInt(codRem.trim());
				
				ClienteDestinatarioController clienteControl = new ClienteDestinatarioController();
				
				idRegiaoRem = clienteControl.verificaRegiaoRemSelecionado(intCodRem);	
				
				pedido = new Pedido(intCodRem, intCodDest);
				
				pedido.setAltura(Float.parseFloat(campoAlt.getText()));
				pedido.setComprimento(Float.parseFloat(campoComp.getText()));
				pedido.setLargura(Float.parseFloat(campoLarg.getText()));
				pedido.setPeso(Float.parseFloat(campoPeso.getText()));
				pedido.setPrazo(Integer.parseInt(campoPrazo.getText()));
				pedido.setDataCadastro(data);
				pedido.setStatus("Postado");
				
				veiculoAdicionado = distribuicao.vinculaPedidoAfrota(pedido, idRegiaoRem);
						
			} catch (Exception e) {
				System.out.println("Erro no view do vinculo do pedido"+e);
			}
			
			if(!veiculoAdicionado.equals(null)){
				
				pedido.setIdVeiculoVinculado(veiculoAdicionado.getIdVeiculo());
				pedido.setIdFrotaVinculada(veiculoAdicionado.getVinculoFrota());
				pedido.setStatus("Encaminhado");
				
				// ENVIA O VEICULO PARA A TABELA DE VEICULOS A SAIR -- COM PEDIDOS ENCAMINHADOS
				//if(!vc.cadastraAsair(veiculoAdicionado)){
					//JOptionPane.showMessageDialog(null, "Falha em cadastrar o veiculo na tabela temporaria");
					
				// ENVIA DADOS DO PEDIDO PARA A INCLUSAO NO BANCO DE DADOS - TABELA PEDIDOS
				PedidoController pedidoControl = new PedidoController();
				
				if(pedidoControl.cadastraPedido(pedido)){
				
					JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso no veiculo: "+veiculoAdicionado.getPlaca()+" "+veiculoAdicionado.getMarcaModelo()+" frota: "+veiculoAdicionado.getVinculoFrota());
				}else
					JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar o pedido");
									
			}else{
				JOptionPane.showMessageDialog(null, "Nenhum veiculo disponivel para essa região, pedido nao encaminhado.");
			}
			
			
		}
		
		
	}
	
	
}
