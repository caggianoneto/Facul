package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Endereco;
import model.Destinatario;
import model.Veiculo;

public class DestinatarioDAO {

	
	public boolean inclusaoDestinatarioF(Destinatario t, Endereco e) {
		
		Connection conn;
		
		PreparedStatement pstm;
		
		String query = "INSERT INTO dbo.DESTINATARIO (NOME_DEST, CPFCNPJ, TELEFONE1, TELEFONE2, ENDERECO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)"+ 
				        "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		conn = Conexao.getConexao();
		int i=1;
		
		try {
			
			pstm = conn.prepareStatement(query);
			
			pstm.setString(i++,  t.getNome());
			pstm.setString(i++,  t.getCpf());
			pstm.setString(i++,  e.getTelefone1());
			pstm.setString(i++,  e.getTelefone2());
			pstm.setString(i++,  e.getLogradouro());
			pstm.setString(i++,  e.getNumero());
			pstm.setString(i++,  e.getComplemento());
			pstm.setString(i++,  e.getBairro());
			pstm.setString(i++,  e.getCep());
			pstm.setString(i++,  e.getCidade());
			pstm.setString(i++,  e.getEstado());
			
			if(pstm.executeUpdate() > 0){
                pstm.close();
                return true;
            }else{
                pstm.close();
                System.err.println("Erro ao tentar incluir destinatario_f no banco ");
                return false;
            }
			
	}catch(Exception f){
		System.err.println("Erro ao tentar incluir destinatario_f no banco "+ f);
		return false;
	}	
			
 }

	public boolean inclusaoDestinatarioJ(Destinatario t, Endereco e){
		
		Connection conn;
		
		PreparedStatement pstm;
		
		String query = "INSERT INTO dbo.DESTINATARIO (NOME_DEST, CPFCNPJ, TELEFONE1, TELEFONE2, ENDERECO, NUMERO, COMPLEMENTO, BAIRRO, CEP, CIDADE, ESTADO)"+ 
				        "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		conn = Conexao.getConexao();
		int i=1;
		
		try {
			
			pstm = conn.prepareStatement(query);
			
			pstm.setString(i++,  t.getRazaoSocial());
			pstm.setString(i++,  t.getCnpj());
			pstm.setString(i++,  e.getTelefone1());
			pstm.setString(i++,  e.getTelefone2());
			pstm.setString(i++,  e.getLogradouro());
			pstm.setString(i++,  e.getNumero());
			pstm.setString(i++,  e.getComplemento());
			pstm.setString(i++,  e.getBairro());
			pstm.setString(i++,  e.getCep());
			pstm.setString(i++,  e.getCidade());
			pstm.setString(i++,  e.getEstado());
			
			if(pstm.executeUpdate() > 0){
                pstm.close();
                return true;
            }else{
                pstm.close();
                System.err.println("Erro ao tentar incluir destinatario_j no banco ");
                return false;
            }
			
	}catch(Exception f){
		System.err.println("Erro ao tentar incluir destinatario_j no banco "+ f);
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

	
	public ArrayList<Destinatario> buscaDestinatario() {
		
		Connection conn;
		ResultSet rs;
		Statement stmt;
		
		ArrayList<Destinatario> destinatarios = new ArrayList<Destinatario>();
	
		try {
			conn = Conexao.getConexao();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT ID_DEST , NOME_DEST FROM DESTINATARIO");		
			
			while ( rs.next() ) {
				Destinatario destinatario = new Destinatario();
				
				destinatario.setIdDest(rs.getInt("ID_DEST"));
				destinatario.setNome(rs.getString("NOME_DEST")); 
				
				destinatarios.add(destinatario);
	        }
			
	        conn.close();
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return destinatarios;
		
	}

	
	public Destinatario buscaPorDoc(String documento){
		
		Connection conn;
		ResultSet rs;
		
		Destinatario dest = new Destinatario();
		PreparedStatement pstm;
		
		String query = ("SELECT ID_DEST, NOME_DEST FROM DESTINATARIO WHERE CPFCNPJ LIKE ? ");
		
		conn = Conexao.getConexao();
		try {
			
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1,  documento + "%");
			
			rs = pstm.executeQuery();
			
			while ( rs.next() ) {	
				dest.setIdDest(rs.getInt("ID_DEST"));
				dest.setNome(rs.getString("NOME_DEST"));
	        }
	        conn.close();
	        
		} catch (Exception e) {
			System.out.println("-->> "+ e);
		}
		
		return dest;
	}
}

  