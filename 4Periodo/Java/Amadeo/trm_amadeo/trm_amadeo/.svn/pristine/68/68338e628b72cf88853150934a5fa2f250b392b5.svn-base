package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegiaoDAO {

	public int buscaRegiaoPorId(String cidade){
		
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		
		int idRegiaoRem = -1;
		
		conn = Conexao.getConexao();
		
		String query = "SELECT ID_REGIAO FROM REGIOES WHERE ESTADO = ? ";	
		
		try {	
			
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, cidade);
			
			rs = pstm.executeQuery();
			
			while(rs.next()){
				idRegiaoRem = rs.getInt("ID_REGIAO");					
			}
		
		}catch(Exception e){
			System.err.println(e);
			
		}	
		
		return idRegiaoRem;
	}
	
}
