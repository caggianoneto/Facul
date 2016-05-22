package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Cliente;
import model.Destinatario;
import model.Endereco;


public class ClienteDAO {
	
	Connection conn;
	PreparedStatement pstm;
	
	
	public boolean inclusaoFisica(Cliente t, Endereco e) {
	
		  String query;
		  
		  query = "INSERT INTO dbo.CLIENTE_F ( NOME_CLIENTE, CPF, RG, EMAIL, ENDERECO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, TELEFONE_1, TELEFONE_2 )"+ 
		           "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 
		  try {
			    conn = Conexao.getConexao();
				pstm = conn.prepareStatement(query);
			
				pstm.setString(1, t.getNome());    
				pstm.setString(2, t.getCpf());
				pstm.setString(3, t.getRg());
				pstm.setString(4, t.getEmail());    
				pstm.setString(5, e.getLogradouro());
				pstm.setString(6, e.getNumero());
				pstm.setString(7, e.getComplemento());
				pstm.setString(8, e.getBairro());
				pstm.setString(9, e.getCep());
				pstm.setString(10, e.getCidade());
				pstm.setString(11, e.getEstado());
				pstm.setString(12, e.getTelefone1());
				pstm.setString(13, e.getTelefone2());
				
				if(pstm.executeUpdate() > 0){
	                pstm.close();
	                return true;
	            }else{
	                pstm.close();
	                System.err.println("Erro ao tentar incluir cliente_F no banco ");
	                return false;
	            }
		  }catch(Exception f){
				System.err.println("Erro ao tentar incluir cliente_F no banco "+ f);
				return false;
			}		
			  			
 }
	
	public boolean inclusaoJuridica(Cliente t, Endereco e){
		
		 String query;
		 
		 query = "INSERT INTO dbo.CLIENTE_J (RAZAOSOCIAL, CNPJ, IE, IM, CONTATO, EMAIL, ENDERECO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO, TELEFONE_1, TELEFONE_2 )"+ 
			        "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	  
		  try {
			    conn = Conexao.getConexao();
				pstm = conn.prepareStatement(query);
			
				pstm.setString(1, t.getRazaoSocial());    
				pstm.setString(2, t.getCnpj());
				pstm.setString(3, t.getInscricaoEstadual()); 
				pstm.setString(4, t.getInscricaoMunicipal()); 
				pstm.setString(5, t.getNomeContato()); 
				pstm.setString(6, t.getEmail());    
				pstm.setString(7, e.getLogradouro());
				pstm.setString(8, e.getNumero());
				pstm.setString(9, e.getComplemento());
				pstm.setString(10, e.getBairro());
				pstm.setString(11, e.getCep());
				pstm.setString(12, e.getCidade());
				pstm.setString(13, e.getEstado());
				pstm.setString(14, e.getTelefone1());
				pstm.setString(15, e.getTelefone2());		
				
				if(pstm.executeUpdate() > 0){
	                pstm.close();
	                return true;
	            }else{
	                pstm.close();
	                System.err.println("Erro ao tentar incluir cliente_J no banco ");
	                return false;
	            }
		  }catch(Exception f){
				System.err.println("Erro ao tentar incluir cliente_J no banco "+ f);
				return false;
		        }	
		
		
	}
	

	public boolean alteracao() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean exclusao() {
		// TODO Auto-generated method stub
		return false;
	}


	public ArrayList<Cliente> buscaCliente() {
		
		Connection conn;
		ResultSet rs;
		Statement stmt;
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Cliente> clientesJ = new ArrayList<Cliente>();
		try {
			conn = Conexao.getConexao();
			stmt = conn.createStatement();
			
			rs  = stmt.executeQuery("SELECT IDCLIENTE, NOME_CLIENTE FROM CLIENTE_F");	
			
			
			
			while(rs.next() ) {
				Cliente clienteF = new Cliente();
				
				clienteF.setIdCliente(rs.getInt("IDCLIENTE"));
				clienteF.setNome(rs.getString("NOME_CLIENTE")); 
				
				clientes.add(clienteF);
	        }
			
	        conn.close();
	        
	        clientesJ = buscaCliente_J();
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for (int i = 0; i < clientesJ.size(); i++) {
			clientes.add(clientesJ.get(i));
		}
		
		return clientes;
		
	}
	
	public ArrayList<Cliente> buscaCliente_J() {
		
		Connection conn;
		ResultSet rs2;
		Statement stmt;
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
		try {
			conn = Conexao.getConexao();
			stmt = conn.createStatement();
			
			rs2 = stmt.executeQuery("SELECT IDCLIENTE, RAZAOSOCIAL FROM CLIENTE_J");
			
			
			while(rs2.next()){
				Cliente clienteJ = new Cliente();
				
				clienteJ.setIdCliente(rs2.getInt("IDCLIENTE"));
				clienteJ.setNome(rs2.getString("RAZAOSOCIAL")); 
				
				clientes.add(clienteJ);
			}
			
	        conn.close();
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return clientes;
		
	}
	
	public Cliente buscaPorDocF(String documento){

		Connection conn;
		ResultSet rs;
		
		Cliente clienteF = new Cliente();
		
		PreparedStatement pstm;
		
		String query = ("SELECT IDCLIENTE, NOME_CLIENTE FROM CLIENTE_F WHERE CPF LIKE ? ");
		
		conn = Conexao.getConexao();
		try {
			
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1,  documento + "%");
			
			rs = pstm.executeQuery();
			
			while ( rs.next() ) {	
				clienteF.setIdCliente(rs.getInt("IDCLIENTE"));
				clienteF.setNome(rs.getString("NOME_CLIENTE"));
	        }
	        conn.close();
	        
		} catch (Exception e) {
			System.out.println("buscaPorDoc ClienteF"+ e);
		}
		
		return clienteF;
		
	}
	
	public Cliente buscaPorDocJ(String documento){
		
		Connection conn;
		ResultSet rs;
		
		Cliente clienteJ = new Cliente();
		
		PreparedStatement pstm;
		
		String query = ("SELECT IDCLIENTE, RAZAOSOCIAL FROM CLIENTE_J WHERE CNPJ LIKE ? ");
		
		conn = Conexao.getConexao();
		try {
			
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1,  documento + "%");
			
			rs = pstm.executeQuery();
			
			while ( rs.next() ) {	
				clienteJ.setIdCliente(rs.getInt("IDCLIENTE"));
				clienteJ.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
	        }
	        conn.close();
	        
		} catch (Exception e) {
			System.out.println("buscaPorDoc ClienteJ"+ e);
		}
		
		return clienteJ;
		
	}
	
	public int buscaIdPorRegiaoRemF(int idRemetente) {	
		
		// retorna o ID da regiao do cliente
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		
		String estado = null;
		int idRegiaoRem;
		
		conn = Conexao.getConexao();
		
		String query = "SELECT ESTADO FROM CLIENTE_F WHERE IDCLIENTE = ? ";	
		
		try {
			
			pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, idRemetente);
			
			rs = pstm.executeQuery();
			
			while(rs.next()){
				estado = rs.getString("ESTADO");					
			}
		
		}catch(Exception e){
			System.err.println(e);
			
		}	
		RegiaoDAO regiao = new RegiaoDAO();
		
		idRegiaoRem = regiao.buscaRegiaoPorId(estado);
		
		return idRegiaoRem;
	}
	
	public int buscaIdPorRegiaoRemj(int idRemetente){
		
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		
		String cidade = null;
		int idRegiaoRem;
		
		conn = Conexao.getConexao();
		
		String query = "SELECT ESTADO FROM CLIENTE_J WHERE IDCLIENTE = ? ";	
		
		try {
			
			pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, idRemetente);
			
			rs = pstm.executeQuery();
			
			while(rs.next()){
				cidade = rs.getString("ESTADO");					
			}
		
		}catch(Exception e){
			System.err.println(e);
			
		}	
		RegiaoDAO regiao = new RegiaoDAO();
		
		idRegiaoRem = regiao.buscaRegiaoPorId(cidade);
		
		return idRegiaoRem;	
	}
}


