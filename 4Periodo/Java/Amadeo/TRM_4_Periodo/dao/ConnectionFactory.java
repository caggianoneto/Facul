/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NIB2
 */
public class ConnectionFactory {
    
    //atributo de classe pribado para manter a conex�o como MySQL
	
	private static Connection conexao;
	
	
	//Construtor Privado
	private ConnectionFactory(){
				
	}
	
	public static Connection getConexao(){
		
		if(ConnectionFactory.conexao == null)
			ConnectionFactory.conecta();
		
		return ConnectionFactory.conexao;
			
	}

	private static void conecta() {
		
		String bd = "banco";
		
		String usuario = "root";
		
		String senha = "";
		
		try{
		ConnectionFactory.conexao= DriverManager.getConnection("jdbc:mysql://localhost/"+bd+"?user="+usuario + "&password"+senha);
		
		}catch(SQLException e){
			System.out.println("Erro de conexao");
			e.printStackTrace();
			
		}
		
		
	}
    
    
}
