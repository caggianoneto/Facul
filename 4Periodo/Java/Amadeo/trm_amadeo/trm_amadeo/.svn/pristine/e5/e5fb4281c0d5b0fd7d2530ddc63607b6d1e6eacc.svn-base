package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.util.ArrayList;

import model.Pedido;

public class PedidoDAO {
	
	public boolean inserePedido(Pedido p){
		
		 String query;
		 Connection conn;
		 PreparedStatement pstm;
		 
		 query = "INSERT INTO PEDIDOS ( DATA_CADASTRO, STATUS_PEDIDO, COMP, ALT, LARG, PESO, PRAZO_ENTREGA, ID_REM, ID_DEST, ID_VEICULO, ID_FROTA )"+ 
		         "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		 
		  try {
			    conn = Conexao.getConexao();
				pstm = conn.prepareStatement(query);
		
				pstm.setDate(1, (Date) p.getDataCadastro());
				pstm.setString(2, p.getStatus());
				pstm.setFloat(3, p.getComprimento());
				pstm.setFloat(4, p.getAltura());
				pstm.setFloat(5, p.getLargura());
				pstm.setFloat(6, p.getPeso());
				pstm.setInt(7, p.getPrazo());
				pstm.setInt(8, p.getIdRemetente());
				pstm.setInt(9, p.getIdDestinatario());
				pstm.setInt(10, p.getIdVeiculoVinculado());
				pstm.setInt(11, p.getIdFrotaVinculada());
				
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
	
	public ArrayList<Pedido> buscaEncaminhados(String status){
		
		 String query;
		 Connection conn;
		 PreparedStatement pstm;
		 ResultSet rs;
		 ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		 
		 query = "SELECT ID_PEDIDO, ID_VEICULO, DATA_CADASTRO, PRAZO_ENTREGA FROM PEDIDOS WHERE STATUS_PEDIDO = ? ";
		         
		 
		 try {
			  conn = Conexao.getConexao();
			  pstm = conn.prepareStatement(query);
		
			  pstm.setString(1, status);
			  
			  rs = pstm.executeQuery();
			  
			  while(rs.next()){
				  Pedido pedido = new Pedido();
				  pedido.setIdPedido(rs.getInt("ID_PEDIDO"));
				  pedido.setIdVeiculoVinculado(rs.getInt("ID_VEICULO"));
				  pedido.setDataCadastro(rs.getDate("DATA_CADASTRO"));
				  pedido.setPrazo(rs.getInt("PRAZO_ENTREGA"));
				 
				  pedidos.add(pedido);
			  }
			  	
		} catch (Exception e) {
			System.out.println(e);
		}
			  
		 return pedidos;	
	}
	
	public boolean mudaStatusPorIdVeiculo( int idVeiculo ,String status){
	
		 String query;
		 Connection conn;
		 PreparedStatement pstm;
		 
		 query = "UPDATE PEDIDOS SET STATUS_PEDIDO = ? WHERE ID_VEICULO = ? ";
		         
		 
		 try {
			  conn = Conexao.getConexao();
			  pstm = conn.prepareStatement(query);
		
			  pstm.setString(1, status);
			  pstm.setInt(2, idVeiculo);
			  
			  
			  if(pstm.executeUpdate() > 0){
				  return true;
			  }else{
				  return false;
			  }	  		 
			  	
		} catch (Exception e) {
			System.out.println(e);
		}
			  
		
		return false;
	}
	
	public boolean finalizaPedido(int idPedido){
		
		 String query;
		 Connection conn;
		 PreparedStatement pstm;
		 String status = "Finalizado";
		 
		 query = "UPDATE PEDIDOS SET STATUS_PEDIDO = ?, DATA_ENTREGA = ? WHERE ID_PEDIDO = ? ";
		         
		 
		 try {
			  conn = Conexao.getConexao();
			  pstm = conn.prepareStatement(query);
		
			  pstm.setString(1, status);
			  pstm.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
			  pstm.setInt(3, idPedido);
			  
			  
			  if(pstm.executeUpdate() > 0){
				  return true;
			  }else{
				  return false;
			  }	  		 
			  	
		} catch (Exception e) {
			System.out.println(e);
		}
			  
		
		return false;
		
	}
}
