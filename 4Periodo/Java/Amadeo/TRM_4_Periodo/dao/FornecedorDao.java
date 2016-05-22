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
import model.Fornecedor;

/**
 *
 * @author NIB2
 */
public class FornecedorDao implements IFornecedorDao {

    @Override
    public boolean incluir(Fornecedor f) {
        
        // inclusão de fornecedor no BD
        
        Connection conn = ConnectionFactory.getConexao();;
                
	PreparedStatement pstm;
                	
	String query = "INSERT INTO fornecedor (razaoSocial , cnpj , nomeFantasia , IE,"
                        + " vendedor, telComercial, telCel, email) VALUES(?,?,?,?,?,?,?,?)";
        
        try {
            
            //prepara a string para inser��o
            pstm = conn.prepareStatement(query);
			
            //passa os parametros
            pstm.setString(1, f.getRazaoSocial());
            pstm.setString(2, f.getCnpj());
            pstm.setString(3, f.getNomeFantasia());
            pstm.setString(4, f.getIe());
            pstm.setString(5, f.getVendedor());
            pstm.setString(6, f.getTelefone1());
            pstm.setString(7, f.getTelefone2());
            pstm.setString(8, f.getEmail());     
            
            if(pstm.executeUpdate() > 0){
                   pstm.close();
                   return true;
               }else{
                   pstm.close();
                   return false;
                    }
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
	    return false;
        }
        
        
    }
    
    public boolean alterar(Fornecedor f, int codigo){
        
        Connection conn = ConnectionFactory.getConexao();;
                
	PreparedStatement pstm;
                	
	String query = "UPDATE fornecedor SET razaoSocial = ?, cnpj = ?, nomeFantasia = ?,"
                + "IE = ?, vendedor = ?, telComercial = ?, telCel = ?, email = ? WHERE codigo = "+codigo+" ";
        
        try {
            pstm = conn.prepareStatement(query);
            
            pstm.setString(1, f.getRazaoSocial());
            pstm.setString(2, f.getCnpj());
            pstm.setString(3, f.getNomeFantasia());
            pstm.setString(4, f.getIe());
            pstm.setString(5, f.getVendedor());
            pstm.setString(6, f.getTelefone1());
            pstm.setString(7, f.getTelefone2());
            pstm.setString(8, f.getEmail());
            
            
            if (pstm.executeUpdate() > 0) {
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
    
 

    @Override
    public boolean selecionarCod(Fornecedor f) {
        
        Connection conn = ConnectionFactory.getConexao();
            
            PreparedStatement pstm;
            
            String query =  "SELECT MAX(codigo) as maior FROM fornecedor";
            boolean ret;
            
            try {
                
                    pstm = conn.prepareStatement(query);
                    ResultSet rs = pstm.executeQuery(query);
                    
                    // itera no ResultSet // Pega os campos
                    while (rs.next()) {

                        f.setCodigo( rs.getInt("maior") );
                        EnderecoDao.codFornecedor(f);
                       
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
    
    
    
}
