/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Endereco;
import model.Fornecedor;

/**
 *
 * @author NIB2
 */
public class EnderecoDao implements IEnderecoDao{
    
    private static int codigo;
    
    public static void codFornecedor(Fornecedor f){
        
        codigo = f.getCodigo();
        System.out.println("Peguei codigo "+codigo);
    }
    
    public static void codCliente(Cliente c){
        
        codigo = c.getCodigo();
        System.out.println("Peguei cod "+codigo);
    }
    
    

    @Override
    public boolean incluir(Endereco e) {
        
        Connection conn;
	PreparedStatement pstm;
		
	String query = "INSERT INTO endereco (cod , Logradouro , numero , CEP, Pais, Complemento,"
                + " Bairro, estado, cidade) VALUES (?,?,?,?,?,?,?,?,?)";
        
        conn = ConnectionFactory.getConexao();
        
        try {
            //prepara a string para inser��o
	    pstm = conn.prepareStatement(query);
			
            //passa os parametros
            
            
            
            pstm.setInt(1, codigo);
            pstm.setString(2, e.getLogradouro());
            pstm.setString(3, e.getNumero());
            pstm.setString(4, e.getCep());
            pstm.setString(5, e.getPais());
            pstm.setString(6, e.getComplemento());
            pstm.setString(7, e.getBairro());
            pstm.setString(8, e.getEstado());
            pstm.setString(9, e.getCidade());
            
            
            
            // valida inserção
            
            if(pstm.executeUpdate() > 0){
                  pstm.close();
                  return true;
            }else{
                  pstm.close();
                  return false;
                 }
            
        } catch (Exception f) {
            
            f.printStackTrace();
	    return false;
        }
    }
    
    public boolean alterar(Endereco e, int codigo){
        
        Connection conn = ConnectionFactory.getConexao();;
                
	PreparedStatement pstm;
                	
	String query = "UPDATE endereco SET Logradouro = ?, numero = ?, CEP = ?,"
                + "Pais = ?, Complemento = ?, Bairro = ?, estado = ?, cidade = ? WHERE cod = "+codigo+" ";
        
        try {
            pstm = conn.prepareStatement(query);
            
            pstm.setString(1 ,e.getLogradouro());
            pstm.setString(2 ,e.getNumero());
            pstm.setString(3 ,e.getCep());
            pstm.setString(4 ,e.getPais());
            pstm.setString(5 ,e.getComplemento());
            pstm.setString(6 ,e.getBairro());
            pstm.setString(7 ,e.getEstado());
            pstm.setString(8 ,e.getCidade());
            
            
            
            
            
            if (pstm.executeUpdate() > 0) {
                pstm.close();
                return true;
            } else {
                pstm.close();
                return false;
            }
            
            
        } catch (Exception e1) {
            e1.printStackTrace();
            return false;
        }
        
    }
    
    
    
    public boolean selecionar(Endereco e){
        return false;
    }

    
    
}
