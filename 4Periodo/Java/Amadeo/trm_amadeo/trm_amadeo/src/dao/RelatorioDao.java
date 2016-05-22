package dao;






import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.xml.crypto.Data;

import model.Cliente;
import model.Relatorio;

public class RelatorioDao implements IRelatorioDao{

	
	private static final String SQL_INSERT = "insert into LIVRO (EDITORA, TITULO, ISBN) VALUES (?, ?, ?)";
	
	private static final String SQL_UPDATE_VEICULO = "UPDATE VEICULO SET placa = ?, renavam = ?, tipo = ?, status_veiculo = ?," +
				   							 "tara = ?,comp_cap_carga = ?,larg_cap_carga = ?,alt_cap_carga = ?,"+
				   							 "peso_max_carga = ?,numero_eixos = ?,cap_tanque_comb = ?,"+
				   							 "marca_modelo = ?,combustivel = ?,ano_fab = ?,vinculo_frota = ?"+
				   							 " WHERE IDVEICULO = ?";
	
	private static final String SQL_UPDATE_FROTA = "UPDATE FROTAS SET QTD_VEICULOS = ?, QTD_VEICULOS_DISPONIVEIS = ?,"+
													"ENTREGAS_REALIZADAS = ?, ENTREGAS_EM_PROGRESSO = ?, ENTREGAS_NAO_FINALIZADAS = ?, REGIAO = ?"+
													" WHERE ID_FROTA = ?";
	
	private static final String SQL_UPDATE_CLIENTE_FISICA = "UPDATE CLIENTE_F SET NOME_CLIENTE = ?, CPF = ?, RG = ?, EMAIL = ?, ENDERECO = ?" +
//					" COMPLEMENTO = ?, BAIRRO = ?, CEP = ?, CIDADE = ?" +
//					"ESTADO = ?, TELEFONE_1 = ?, TELEFONE_2 = ?"+
					" WHERE IDCLIENTE = ?";	
	
	private static final String SQL_UPDATE_CLIENTE_JURIDICA = "UPDATE CLIENTE_J SET RAZAOSOCIAL = ?, CNPJ = ?" +
//			" COMPLEMENTO = ?, BAIRRO = ?, CEP = ?, CIDADE = ?" +
//			"ESTADO = ?, TELEFONE_1 = ?, TELEFONE_2 = ?"+
			" WHERE IDCLIENTE = ?";
	
	private static final String SQL_UPDATE_DESTINATARIO = "UPDATE DESTINATARIO SET NOME_DEST = ?, CPFCNPJ = ?" +
			" WHERE ID_DEST = ?";	
	
	private static final String SQL_REMOVE_VEICULO = "delete from veiculo where PLACA = ?";
	
	private static final String SQL_REMOVE_FROTA = "delete from FROTAS where ID_FROTA = ?";
	
	private static final String SQL_REMOVE_PEDIDO = "update PEDIDOS set STATUS_PEDIDO = 'Cancelado' where ID_PEDIDO = ?";
	
	private static final String SQL_FIND_ALL_VEICULO = "select * from veiculo";
	
	private static final String SQL_FIND_ALL_FROTA = "select * from FROTAS";
	
	private static final String SQL_FIND_ALL_PEDIDOS = "select * from PEDIDOS";
	

	
	public int save(Relatorio relatorio) {
	
		return 0;
	}


	public boolean update(Relatorio relatorio) {
		
		Connection conn = Conexao.getConexao();
		PreparedStatement pstm = null;
		int result = 0;
		
		if(relatorio.getStatusRelatorio() == 1){
			
			try {
				pstm = conn.prepareStatement(SQL_UPDATE_VEICULO);
				pstm.setString(1, relatorio.getPlaca());
				pstm.setString(2, relatorio.getRenavam());
				pstm.setString(3, relatorio.getComboTipoVeiculo());
				pstm.setInt(4, relatorio.getStatusVeiculo());
				pstm.setFloat(5, relatorio.getTara());
				pstm.setFloat(6, relatorio.getCompCapacidadeCarga());
				pstm.setFloat(7, relatorio.getLarguraCapacidadeCarga());
				pstm.setFloat(8, relatorio.getAlturaCapacidadeCarga());
				pstm.setFloat(9, relatorio.getPesoMaxCarga());
				pstm.setInt(10, relatorio.getNumeroEixos());
				pstm.setFloat(11, relatorio.getCapacidadeTanqueComb());
				pstm.setString(12, relatorio.getMarcaModelo());
				pstm.setString(13, relatorio.getCombustivel());
				pstm.setInt(14, relatorio.getAnoFabricacao());
				pstm.setInt(15, relatorio.getVinculoFrota());
				pstm.setInt(16, relatorio.getIdVeiculo());
				
				result = pstm.executeUpdate();
				
				if(result == 1){
					
					return true;
				}
				
			} catch (SQLException e) {
				
				System.out.println("Erro ao atualizar tabela veiculos" + e.getMessage());

			}
		}
		
		else if(relatorio.getStatusRelatorio() == 2){
			
			try {
				pstm = conn.prepareStatement(SQL_UPDATE_FROTA);
				
				pstm.setInt(1, relatorio.getQtd_veiculos());
				pstm.setInt(2, relatorio.getQtd_veiculos_disponivel());
				pstm.setInt(3, relatorio.getEntregas_realizadas());
				pstm.setInt(4, relatorio.getEntrega_em_progresso());
				pstm.setInt(5, relatorio.getEntrega_nao_finalizada());
				pstm.setInt(6, relatorio.getRegiao());
				pstm.setInt(7, relatorio.getIdFrota());
				
				result = pstm.executeUpdate();
				
				if(result == 1){
					
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("Erro ao atualizar tabela frotas" + e.getMessage());
			}
			
		}
		
		else if(relatorio.getStatusRelatorio() == 4){
			
			try {
				
				if(relatorio.getComboBoxTipoCliente().equals("0")){
					
					if(relatorio.getComboBoxTipoPessoa().equals("0")){
					
						pstm = conn.prepareStatement(SQL_UPDATE_CLIENTE_FISICA);
						
						pstm.setString(1, relatorio.getNome());
						pstm.setString(2, relatorio.getCpf());
						pstm.setString(3, relatorio.getRg());
						pstm.setString(4, relatorio.getEmailFisica());
						pstm.setString(5, relatorio.getEnderecoFisica());
//						pstm.setString(6, relatorio.getNumeroFisica().toString());
//						pstm.setString(6, relatorio.getComplementoFisica());
//						pstm.setString(7, relatorio.getBairroFisica());
//						pstm.setString(8, relatorio.getCepFisica());
//						pstm.setString(9, relatorio.getCidadeFisica());
//						pstm.setString(10, relatorio.getEstadoFisica());
//						pstm.setString(11, relatorio.getTelefoneUmFisica());
//						pstm.setString(12, relatorio.getTelefoneDoisFisica());
						pstm.setInt(6, relatorio.getIdClienteFisica());
						
						result = pstm.executeUpdate();
						
						if(result == 1){
							
							return true;
						}
					}
					if(relatorio.getComboBoxTipoPessoa().equals("1")){
						
						pstm = conn.prepareStatement(SQL_UPDATE_CLIENTE_JURIDICA);
						
						pstm.setString(1, relatorio.getRazaoSocial());
						pstm.setString(2, relatorio.getCnpf());
						pstm.setInt(3, relatorio.getIdClienteFisica());
						
						result = pstm.executeUpdate();
						
						if(result == 1){
							
							return true;
						}
					}
					
				}
				
				else if(relatorio.getComboBoxTipoCliente().equals("1")){
					
						pstm = conn.prepareStatement(SQL_UPDATE_DESTINATARIO);
						
						pstm.setString(1, relatorio.getNomeDest());
						pstm.setString(2, relatorio.getCpfcnpj());
						pstm.setInt(3, relatorio.getIdDest());
						
						result = pstm.executeUpdate();
						
						if(result == 1){
							
							return true;
						}
					
				}
				
			} catch (SQLException e) {
				System.out.println("Erro ao atualizar tabela frotas" + e.getMessage());
			}
			
		}

		return false;
	}

	
	public boolean remove(Relatorio relatorio) {
		
		Connection conn = Conexao.getConexao();
		PreparedStatement pstm = null;
		int result = 0;
		
		
		if(relatorio.getStatusRelatorio() == 1){
			
			String placa = relatorio.getPlaca();
			
			try {
				pstm = conn.prepareStatement(SQL_REMOVE_VEICULO);
				pstm.setString(1, placa);
				
				result = pstm.executeUpdate();
				
				if(result == 1){
					
					return true;
				}
				
			} catch (SQLException e) {
				
				System.out.println("erro ao remover conteudo da tabela Veiculos" + e.getMessage());

			}
		}
		else if(relatorio.getStatusRelatorio() == 2){
			
			int idFrota = relatorio.getIdFrota();
			
			try {
				
				pstm = conn.prepareStatement(SQL_REMOVE_FROTA);
				pstm.setInt(1, idFrota);
				
				result = pstm.executeUpdate();
				
				if(result == 1){
					
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("erro ao remover conteudo da tabela Frota" + e.getMessage());
			}
			
		}
		
		else if(relatorio.getStatusRelatorio() == 3){
			
			int idPedido = relatorio.getIdPedido();
			
			try {
				
				pstm = conn.prepareStatement(SQL_REMOVE_PEDIDO);
				pstm.setInt(1, idPedido);
				
				result = pstm.executeUpdate();
				
				if(result == 1){
					
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("erro ao remover conteudo da tabela Frota" + e.getMessage());
			}
			
		}

		return false;
	}


	public List<Relatorio> findAll(Relatorio relatorio) {
		
		Connection conn = Conexao.getConexao();
		PreparedStatement pstm = null;
		
		
		
		if(relatorio.getStatusRelatorio() == 1){
			
			try {
				
				StringBuffer sql = new StringBuffer();
				
				sql.append(" SELECT * FROM veiculo ");
				
				if(!relatorio.getPlaca().equals("")){
						sql.append(" WHERE placa = '" + relatorio.getPlaca() + "' ");
					
					if(!relatorio.getRenavam().equals("")){
						sql.append("AND renavam = '" + relatorio.getRenavam() + "' ");
					}
					if(!relatorio.getComboTipoVeiculo().equals("")){
						sql.append("AND tipo = '" + relatorio.getComboTipoVeiculo() + "' ");
					}
						
						
				}
				else if(!relatorio.getRenavam().equals("")){
					
						sql.append(" WHERE renavam = '" + relatorio.getRenavam() + "' ");
					
				    if(!relatorio.getPlaca().equals("")){
				    	sql.append(" AND placa = '" + relatorio.getPlaca() + "' ");
				    }
				    if(!relatorio.getComboTipoVeiculo().equals("")){
				    	 sql.append(" AND tipo = '" + relatorio.getComboTipoVeiculo() + "' ");
				    }
				   
				}
				else if(!relatorio.getComboTipoVeiculo().equals("")){
					     sql.append("WHERE tipo = '" + relatorio.getComboTipoVeiculo() + "' ");

					 if(!relatorio.getPlaca().equals("")){
						 sql.append(" AND placa = '" + relatorio.getPlaca() + "' ");
					 }
					 if(!relatorio.getRenavam().equals("")){
							sql.append("AND renavam = '" + relatorio.getRenavam() + "' ");
					 }
				}
				
				String sqlFormatado = sql.toString();
				pstm = conn.prepareStatement(sqlFormatado);
				ResultSet rs = pstm.executeQuery();
				
				List<Relatorio> relatoriosVeiculo = new ArrayList<Relatorio>();
				
				while(rs.next()){
					
					Relatorio buscaInformacoes = new Relatorio();
					
					buscaInformacoes.setIdVeiculo(rs.getInt("idveiculo"));
					buscaInformacoes.setPlaca(rs.getString("placa"));
					buscaInformacoes.setRenavam(rs.getString("renavam"));
					buscaInformacoes.setComboTipoVeiculo(rs.getString("tipo"));
					buscaInformacoes.setStatusVeiculo(rs.getInt("STATUS_VEICULO"));
					buscaInformacoes.setTara(rs.getFloat("tara"));
					buscaInformacoes.setCompCapacidadeCarga(rs.getFloat("comp_cap_carga"));
					buscaInformacoes.setLarguraCapacidadeCarga(rs.getFloat("larg_cap_carga"));
					buscaInformacoes.setAlturaCapacidadeCarga(rs.getFloat("alt_cap_carga"));
					buscaInformacoes.setPesoMaxCarga(rs.getFloat("peso_max_carga"));
					buscaInformacoes.setNumeroEixos(rs.getInt("numero_eixos"));
					buscaInformacoes.setCapacidadeTanqueComb(rs.getInt("cap_tanque_comb"));
					buscaInformacoes.setMarcaModelo(rs.getString("marca_modelo"));
					buscaInformacoes.setCombustivel(rs.getString("combustivel"));
					buscaInformacoes.setAnoFabricacao(rs.getInt("ano_fab"));
					buscaInformacoes.setVinculoFrota(rs.getInt("vinculo_frota"));
					
					relatoriosVeiculo.add(buscaInformacoes);
				}
				
				return relatoriosVeiculo;
				
			} catch (SQLException e) {
				
				System.out.println("Erro ao Listar tabela veiculo" + e.getMessage());	
				
			}
			
		}
		// Relatorio frota
		else if(relatorio.getStatusRelatorio() == 2){
			
			try {
				
				pstm = conn.prepareStatement(SQL_FIND_ALL_FROTA);
				ResultSet rs = pstm.executeQuery();
				
				List<Relatorio> relatoriosFrota = new ArrayList<Relatorio>();
				
				while(rs.next()){
					
					Relatorio buscaInformacoes = new Relatorio();
					
					buscaInformacoes.setIdFrota(rs.getInt("ID_FROTA"));
					buscaInformacoes.setQtd_veiculos(rs.getInt("QTD_VEICULOS"));
					buscaInformacoes.setQtd_veiculos_disponivel(rs.getInt("QTD_VEICULOS_DISPONIVEIS"));
					buscaInformacoes.setEntregas_realizadas(rs.getInt("ENTREGAS_REALIZADAS"));
					buscaInformacoes.setEntrega_em_progresso(rs.getInt("ENTREGAS_EM_PROGRESSO"));
					buscaInformacoes.setEntrega_nao_finalizada(rs.getInt("ENTREGAS_NAO_FINALIZADAS"));
					buscaInformacoes.setRegiao(rs.getInt("REGIAO"));
					
					relatoriosFrota.add(buscaInformacoes);
					
				}
				
				return relatoriosFrota;
				
			} catch (SQLException e) {
				
				System.out.println("Erro ao Listar tabela frota" + e.getMessage());	
			}
			
		}
		// pedido
		else if(relatorio.getStatusRelatorio() == 3){
			
			try {
				
				StringBuffer sql = new StringBuffer();
				
				sql.append(" SELECT d.nome_dest,p.status_pedido,p.prazo_entrega,p.data_cadastro,p.data_entrega,p.id_pedido ");
				sql.append(" FROM pedidos p  ");
				sql.append(" INNER JOIN DESTINATARIO d  ON p.id_dest = d.id_dest ");

				if(!relatorio.getStatusPedido().equals("")){
					
					sql.append(" WHERE STATUS_PEDIDO = '" + relatorio.getStatusPedido()+ "' ");
					
					if(relatorio.getDt_pedidoRelatorio() != null){
						
						sql.append(" AND DATA_CADASTRO = '" + relatorio.getDt_pedidoRelatorio()+ "' ");
					}
					
					if(relatorio.getDt_entregaRelatorio() != null){
						
						sql.append(" AND DATA_ENTREGA = '" + relatorio.getDt_entregaRelatorio()+ "' ");
					}
					
				}
				else if(relatorio.getDt_pedidoRelatorio() != null){
					
					sql.append(" WHERE DATA_CADASTRO = '" + relatorio.getDt_pedidoRelatorio()+ "' ");
					
					if(relatorio.getDt_entregaRelatorio() != null){
						
						sql.append(" AND DATA_ENTREGA = '" + relatorio.getDt_entregaRelatorio()+ "' ");
					}
				}
				else if(relatorio.getDt_entregaRelatorio() != null){
					
					sql.append(" WHERE DATA_ENTREGA = '" + relatorio.getDt_entregaRelatorio()+ "' ");
					
					if(relatorio.getDt_pedidoRelatorio() != null){
						
						sql.append(" AND DATA_CADASTRO = '" + relatorio.getDt_pedidoRelatorio()+ "' ");
					}
				}
				
				
				String sqlFormatado = sql.toString();
				pstm = conn.prepareStatement(sqlFormatado);
				ResultSet rs = pstm.executeQuery();
				
				List<Relatorio> relatoriosPedidos = new ArrayList<Relatorio>();
				
				while(rs.next()){
					
					Relatorio buscaInformacoes = new Relatorio();
					
					buscaInformacoes.setNome_dest(rs.getString("nome_dest"));
					buscaInformacoes.setStatusPedido(rs.getString("STATUS_PEDIDO"));
					buscaInformacoes.setPrazoEntregaPedido(rs.getInt("PRAZO_ENTREGA"));
					buscaInformacoes.setDta_cadastro(rs.getDate("DATA_CADASTRO"));
					buscaInformacoes.setDta_entrega(rs.getDate("DATA_ENTREGA"));
					buscaInformacoes.setIdPedido(rs.getInt("ID_PEDIDO"));
					
					relatoriosPedidos.add(buscaInformacoes);
					
				}
				
				return relatoriosPedidos;
				
			} catch (SQLException e) {
				
				System.out.println("Erro ao Listar tabela pedido" + e.getMessage());	
			}
		}
		//cliente/destinatario
		else if(relatorio.getStatusRelatorio() == 4){
			
			try {
				
				StringBuffer sql = new StringBuffer();
				String sqlFormatado;
				ResultSet rs;
				
				// tipo cliente
				if(relatorio.getComboBoxTipoCliente().equals("0")){
					
					//pessoa fisica
					if(relatorio.getComboBoxTipoPessoa().equals("0")){
						
						sql.append(" SELECT * FROM CLIENTE_F ");
						
						if(!relatorio.getCnpf().equals("")){
							
							sql.append(" WHERE CPF = '" + relatorio.getCnpf()+ "' ");
							
							if(!relatorio.getNome().equals("")){
								
							sql.append(" AND NOME_CLIENTE = '" + relatorio.getNome()+ "' ");
								
							}
						}
						
						else if(!relatorio.getNome().equals("")){
							
							sql.append(" WHERE NOME_CLIENTE = '" + relatorio.getNome()+ "' ");
							
							if(!relatorio.getCnpf().equals("")){
								
								sql.append(" AND CPF = '" + relatorio.getCnpf()+ "' ");
							}
						}
						

						sqlFormatado = sql.toString();
						pstm = conn.prepareStatement(sqlFormatado);
					    rs = pstm.executeQuery();
						
						List<Relatorio> relatoriosClienteFisica = new ArrayList<Relatorio>();
						
						while(rs.next()){
							
							Relatorio buscaInformacoes = new Relatorio();
							
							buscaInformacoes.setIdClienteFisica(rs.getInt("IDCLIENTE"));
							buscaInformacoes.setNome(rs.getString("NOME_CLIENTE"));
							buscaInformacoes.setCpf(rs.getString("CPF"));
							buscaInformacoes.setRg(rs.getString("RG"));
							buscaInformacoes.setEmailFisica(rs.getString("EMAIL"));	
							buscaInformacoes.setEnderecoFisica(rs.getString("ENDERECO"));
							buscaInformacoes.setNumeroFisica(String.valueOf(rs.getString("NUMERO")));
							buscaInformacoes.setComplementoFisica(rs.getString("COMPLEMENTO"));
							buscaInformacoes.setBairroFisica(rs.getString("BAIRRO"));
							buscaInformacoes.setCepFisica(String.valueOf(rs.getString("CEP")));
							buscaInformacoes.setCidadeFisica(rs.getString("CIDADE"));
							buscaInformacoes.setEstadoFisica(rs.getString("ESTADO"));
							buscaInformacoes.setTelefoneUmFisica(rs.getString("TELEFONE_1"));
							buscaInformacoes.setTelefoneDoisFisica(rs.getString("TELEFONE_2"));

							relatoriosClienteFisica.add(buscaInformacoes);
							
						}
						
						return relatoriosClienteFisica;
						
					}
					//pessoa juridica
					if(relatorio.getComboBoxTipoPessoa().equals("1")){
						
						sql.append(" SELECT * FROM CLIENTE_J ");
						
						if(!relatorio.getCnpf().equals("")){
							
							sql.append(" WHERE CNPJ = '" + relatorio.getCnpf()+ "' ");
							
							if(!relatorio.getNome().equals("")){
								
							sql.append(" AND RAZAOSOCIAL = '" + relatorio.getNome()+ "' ");
								
							}
						}
						
						else if(!relatorio.getNome().equals("")){
							
							sql.append(" WHERE RAZAOSOCIAL = '" + relatorio.getNome()+ "' ");
							
							if(!relatorio.getCnpf().equals("")){
								
								sql.append(" AND CNPJ = '" + relatorio.getCnpf()+ "' ");
							}
						}
						

						sqlFormatado = sql.toString();
						pstm = conn.prepareStatement(sqlFormatado);
					    rs = pstm.executeQuery();
						
						List<Relatorio> relatoriosClienteJuridica = new ArrayList<Relatorio>();
						
						while(rs.next()){
							
							Relatorio buscaInformacoes = new Relatorio();
							
							buscaInformacoes.setIdClienteFisica(rs.getInt("IDCLIENTE"));
							buscaInformacoes.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
							buscaInformacoes.setCnpf(rs.getString("CNPJ"));
							buscaInformacoes.setIe(rs.getString("IE"));
							buscaInformacoes.setIm(rs.getString("IM"));
							buscaInformacoes.setContato(rs.getString("CONTATO"));
							buscaInformacoes.setEmailJuridica(rs.getString("EMAIL"));
							buscaInformacoes.setEnderecoJuridica(rs.getString("ENDERECO"));
							buscaInformacoes.setNumeroJuridica(String.valueOf(rs.getString("NUMERO")));
							buscaInformacoes.setComplementoJuridica(rs.getString("COMPLEMENTO"));
							buscaInformacoes.setBairroJuridica(rs.getString("BAIRRO"));
							buscaInformacoes.setCepJuridica(String.valueOf(rs.getString("CEP")));
							buscaInformacoes.setCidadeJuridica(rs.getString("CIDADE"));
							buscaInformacoes.setEstadoJuridica(rs.getString("ESTADO"));
							buscaInformacoes.setTelefoneUmJuridica(rs.getString("TELEFONE_1"));
							buscaInformacoes.setTelefoneDoisJuridica(rs.getString("TELEFONE_2"));

							relatoriosClienteJuridica.add(buscaInformacoes);
							
						}
						return relatoriosClienteJuridica;
					}
					
				}
				
				if(relatorio.getComboBoxTipoCliente().equals("1")){
						
						sql.append(" SELECT * FROM DESTINATARIO ");
						
						if(!relatorio.getCnpf().equals("")){
							
							sql.append(" WHERE CPFCNPJ = '" + relatorio.getCnpf()+ "' ");
							
							if(!relatorio.getNome().equals("")){
								
							sql.append(" AND NOME_DEST = '" + relatorio.getNome()+ "' ");
								
							}
						}
						
						else if(!relatorio.getNome().equals("")){
							
							sql.append(" WHERE NOME_DEST = '" + relatorio.getNome()+ "' ");
							
							if(!relatorio.getCnpf().equals("")){
								
								sql.append(" AND CPFCNPJ = '" + relatorio.getCnpf()+ "' ");
							}
						}

						sqlFormatado = sql.toString();
						pstm = conn.prepareStatement(sqlFormatado);
					    rs = pstm.executeQuery();
						
						List<Relatorio> relatoriosDestinatario = new ArrayList<Relatorio>();
						
						while(rs.next()){
							
							Relatorio buscaInformacoes = new Relatorio();
							
							buscaInformacoes.setIdDest(rs.getInt("ID_DEST"));
							buscaInformacoes.setNomeDest(rs.getString("NOME_DEST"));
							buscaInformacoes.setCpfcnpj(rs.getString("CPFCNPJ"));
							buscaInformacoes.setTelefoneUmDestinatario(rs.getString("TELEFONE1"));
							buscaInformacoes.setTelefoneDoisDestinatario(rs.getString("TELEFONE2"));
							buscaInformacoes.setEndecoDestinatario(rs.getString("ENDERECO"));
							buscaInformacoes.setNumeroDestinatario(String.valueOf(rs.getString("NUMERO")));
							buscaInformacoes.setComplementoDestinatario(rs.getString("COMPLEMENTO"));
							buscaInformacoes.setBairroDestinatario(rs.getString("BAIRRO"));
							buscaInformacoes.setCepDestinatario(String.valueOf(rs.getString("CEP")));
							buscaInformacoes.setCidadeDestinatario(rs.getString("CIDADE"));
							buscaInformacoes.setEstadoDestinatario(rs.getString("ESTADO"));

							relatoriosDestinatario.add(buscaInformacoes);
							
						}
						
						return relatoriosDestinatario;
					}
				
			} catch (SQLException e) {
				
				System.out.println("Erro ao Listar tabela frota" + e.getMessage());	
			}
		}
		
		return null;
	}
			
			
}
		
		
		

		

	
	
	
	
	
	
	
	
	
	
	
	

//    Statement stm;
//
//    Conexao dao = new Conexao();
//
//    Connection con = dao.getConexao();
//    
//    ResultSet rs;
//    
//    JTable table;
//// public List<Cliente> getLista(Cliente cliente) {
//	public ArrayList<Cliente> getLista(Cliente cliente) {
//	
//		StringBuffer sql = new StringBuffer();
//			
//		if(cliente.getTipoPessoa() == 0){
//			sql.append(" SELECT NOME_CLIENTE,CPF,RG,EMAIL FROM CLIENTE_f");	
//			
//			if(!cliente.getNome().equals("") && !cliente.getCpf().equals("")){
//				
//				if(!cliente.getNome().equals("")){
//					sql.append(" WHERE NOME_CLIENTE = " + "'"+ cliente.getNome() + "'");
//				}
//				
//				if(!cliente.getCpf().equals("")){
//					sql.append(" AND CPF = " + "'"+ cliente.getCpf() + "'");
//				}
//				
//			}
//			
//			if(!cliente.getNome().equals("")){
//				sql.append(" WHERE NOME_CLIENTE = " + "'"+ cliente.getNome() + "'");
//			}
//			
//			if(!cliente.getCpf().equals("")){
//				sql.append(" WHERE CPF = " + "'"+ cliente.getCpf() + "'");
//			}
//			
//		}
//		
//		if(cliente.getTipoPessoa() == 1){
//			
//			sql.append(" SELECT RAZAOSOCIAL,CNPJ,IE,IM FROM CLIENTE_J ");
//			
//			
//			if(!cliente.getRazaoSocial().equals("") && !cliente.getCnpj().equals("")){
//				
//				if(!cliente.getRazaoSocial().equals("")){
//					sql.append(" WHERE RAZAOSOCIAL = " +  "'"+ cliente.getRazaoSocial() + "'");
//				}
//				if(!cliente.getCnpj().equals("")){
//					sql.append(" AND CNPJ = " +  "'"+ cliente.getCnpj() + "'");
//				}
//				
//			}
//			if(!cliente.getRazaoSocial().equals("")){
//				sql.append(" WHERE RAZAOSOCIAL = " + "'"+ cliente.getRazaoSocial() + "'");
//			}
//			if(!cliente.getCnpj().equals("")){
//				sql.append(" WHERE CNPJ = " + "'"+ cliente.getCnpj() + "'");
//			}
//			
//
//		}
//		
//		
//		ArrayList<Cliente> relatorios = new ArrayList<Cliente>();
//		
//		try {
//			
//			stm = con.createStatement();
//			String sqlFormatado = sql.toString();
//			ResultSet rs = stm.executeQuery(sqlFormatado);
//			
//			while (rs.next()){
//				
//				Cliente buscaCliente = new Cliente();
//				
//				buscaCliente.setNome(rs.getString("NOME_CLIENTE"));
//				buscaCliente.setCpf(rs.getString("CPF"));
//				buscaCliente.setRg(rs.getString("RG"));
//				buscaCliente.setEmail(rs.getString("EMAIL"));
//			
//				relatorios.add(buscaCliente);
//				
//			}
//	
//			
////			relatorios.setModel(DbUtils.resultSetToTableModel(rs));
//			
////			table.setModel(DbUtils.resultSetToTableModel(rs));
//			
//	
//			
//			
//		} catch (SQLException e) {
//			
//			e.getSQLState();
//		}
//		return relatorios;
//		
//	}
//	
//	
//	// Relatorio veiculo
//	
//	public ArrayList<Relatorio> getListaVeiculo(Relatorio relatorio) {
//
//		StringBuffer sql = new StringBuffer();
//
//		sql.append("SELECT placa,renavam,tipo,status_veiculo,tara,comp_cap_carga,larg_cap_carga,alt_cap_carga,"
//				+ " peso_max_carga,numero_eixos,cap_tanque_comb,marca_modelo,combustivel,ano_fab,vinculo_frota "
//				+ " FROM VEICULO");
//
//		if(!relatorio.getPlaca().equals("")){
//			sql.append(" WHERE placa = " + "'"+ relatorio.getPlaca() + "'");	
//			
//			if(!relatorio.getRenavam().equals("")){
//				sql.append(" AND renavam = " + "'"+ relatorio.getRenavam() + "'");
//			}
//			if(!relatorio.getComboTipoVeiculo().equals("0")){
//				sql.append(" AND tipo = " + "'"+ relatorio.getComboTipoVeiculo() + "'");
//			}
//
//		}
//		else if(!relatorio.getRenavam().equals("")){
//			sql.append(" WHERE renavam = " + "'"+ relatorio.getRenavam() + "'");
//
//			if(!relatorio.getComboTipoVeiculo().equals("0")){
//				sql.append(" AND tipo = " + "'"+ relatorio.getComboTipoVeiculo() + "'");
//			}
//
//		}
//		else if(!relatorio.getComboTipoVeiculo().equals("0")){
//			sql.append(" WHERE tipo = " + "'"+ relatorio.getComboTipoVeiculo() + "'");
//		}
//
//		ArrayList<Relatorio> relatorios = new ArrayList<Relatorio>();
//
//		try {
//
//			stm = con.createStatement();
//			String sqlFormatado = sql.toString();
//			ResultSet rs = stm.executeQuery(sqlFormatado);
//
//			while (rs.next()){
//
//				Relatorio buscaInformacoes = new Relatorio();
//
//				buscaInformacoes.setPlaca(rs.getString("placa"));
//				buscaInformacoes.setRenavam(rs.getString("renavam"));
//				buscaInformacoes.setComboTipoVeiculo(rs.getString("tipo"));
//				buscaInformacoes.setTara(rs.getFloat("tara"));
//				buscaInformacoes.setCompCapacidadeCarga(rs.getFloat("comp_cap_carga"));
//				buscaInformacoes.setLarguraCapacidadeCarga(rs.getFloat("larg_cap_carga"));
//				buscaInformacoes.setAlturaCapacidadeCarga(rs.getFloat("alt_cap_carga"));
//				buscaInformacoes.setPesoMaxCarga(rs.getFloat("peso_max_carga"));
//				buscaInformacoes.setNumeroEixos(rs.getInt("numero_eixos"));
//				buscaInformacoes.setCapacidadeTanqueComb(rs.getInt("cap_tanque_comb"));
//				buscaInformacoes.setMarcaModelo(rs.getString("marca_modelo"));
//				buscaInformacoes.setCombustivel(rs.getString("combustivel"));
//				buscaInformacoes.setAnoFabricacao(rs.getInt("ano_fab"));
//				buscaInformacoes.setVinculoFrota(rs.getInt("vinculo_frota"));
//
//				relatorios.add(buscaInformacoes);
//
//			}
//
//		} catch (SQLException e) {
//
//			e.getSQLState();
//		}
//		return relatorios;
//
//	}
//		

