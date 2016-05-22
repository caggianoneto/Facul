/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;


/**
 *
 * @author NIB2
 */
public class ClienteDao implements IClienteDao{
   

	@Override
	public boolean incluir(Cliente c) {
		Connection conn = ConnectionFactory.getConexao();
                
		PreparedStatement pstm;
                
                
		
		String query = "INSERT INTO cliente (CPF, RG, NomeCompleto, NumeroCNH,"
                        + " TelefoneRes, TelefoneCel, nacionalidade, sexo, estadoCivil,"
                        + " DataNasc, Profissao) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			//prepara a string para inser��o
			pstm = conn.prepareStatement(query);
			
			//passa os parametros
			
                        
                        pstm.setString(1, c.getCpf());
                        pstm.setString(2, c.getRg()); 
			pstm.setString(3, c.getNomeCompleto());
			pstm.setString(4, c.getNumeroCNH());
			pstm.setString(5, c.getTelefoneRes());
                        pstm.setString(6, c.getTelefoneCel());
			pstm.setString(7, c.getNacionalidade());
                        pstm.setString(8, c.getSexo());
                        pstm.setString(9, c.getEstadoCivil());
                        pstm.setString(10, c.getDataNasc());
                        pstm.setString(11, c.getProfissao());
                                                  
                        
			if(pstm.executeUpdate() > 0){
                            pstm.close();
                            return true;
                        }else{
                            pstm.close();
                            return false;
                        }
					
		}catch(SQLException e){
			
			e.printStackTrace();
			return false;	
		}
		
	}
        
        // método para selecionar dados de um cliente no banco
        public boolean selecionarCod(Cliente c){
            Connection conn = ConnectionFactory.getConexao();
            
            PreparedStatement pstm;
            
            String query =  "SELECT MAX(codigo) as maior FROM cliente";
            boolean ret;
            
            try {
                
                    pstm = conn.prepareStatement(query);
                    ResultSet rs = pstm.executeQuery(query);
                    
                    // itera no ResultSet // Pega os campos
                    while (rs.next()) {
                        
                        c.setCodigo( rs.getInt("maior") );
                        EnderecoDao.codCliente(c);
                    }
                    
                    pstm.close();
                    ret = true;
                    
            } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("erro");
			ret =  false;
            }
            return ret;
        }
        
        @Override
        public boolean alterar(Cliente c, int cod){
            
        Connection conn = ConnectionFactory.getConexao();      
	PreparedStatement pstm;
        
        String query = "UPDATE cliente SET CPF = ?, RG = ?, NomeCompleto = ?, NumeroCNH = ?,"
                + "TelefoneRes = ?, TelefoneCel = ?, nacionalidade = ?, sexo = ?,"
                + "estadoCivil = ?, DataNasc = ?, Profissao = ? WHERE codigo = "+cod+" ";
        
        try {
            pstm = conn.prepareStatement(query);
            
            pstm.setString(1, c.getCpf());
            pstm.setString(2, c.getRg());
            pstm.setString(3, c.getNomeCompleto());
            pstm.setString(4, c.getNumeroCNH());
            pstm.setString(5, c.getTelefoneRes());
            pstm.setString(6, c.getTelefoneCel());
            pstm.setString(7, c.getNacionalidade());
            pstm.setString(8, c.getSexo());
            pstm.setString(9, c.getEstadoCivil());
            pstm.setString(10, c.getDataNasc());
            pstm.setString(11, c.getProfissao());
            
            
            
            if (pstm.executeUpdate() > 0) {
                System.out.println("Update  = "+pstm.executeUpdate());
                pstm.close();
                return true;
            } else {
                pstm.close();
                return false;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
            
            
        }
        
        

}


