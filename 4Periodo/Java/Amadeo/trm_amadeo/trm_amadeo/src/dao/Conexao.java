package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	
	public static Connection getConexao() {

		String url = "jdbc:sqlserver://basealuno.spei.br\\SQLEXPRESS;databaseName=20141grupo1;";
		//String url = "jdbc:sqlserver://localhost;databaseName=20141grupo1;";
		String usuario = "sa";
		//String usuario = "20141grupo1";
		//String senha = "147258369";
		String senha = "123456";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection conn = DriverManager.getConnection(url, usuario, senha);
			return conn;
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			System.out.println("Falha ao conectar no banco");
			
			return null;

		} catch (ClassNotFoundException ex) {
			
			System.out.println("Problemas ao tentar conectar com o banco de dados: "+ ex);
			
			return null;
		}

	}

	public void desconectar(Connection conexao) {

		try {

			conexao.close();
		}

		catch (Exception e) {

			System.out.println("Não foi possivel fechar a conexão com Banco de Dados."+ e.getMessage());

		}
	
	}
	
}



	




