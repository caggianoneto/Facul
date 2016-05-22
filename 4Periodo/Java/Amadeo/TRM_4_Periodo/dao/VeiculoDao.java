/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.Veiculo;

/**
 *
 * @author NIB
 */
public class VeiculoDao implements IVeiculoDao{

    @Override
    public boolean incluir(Veiculo v) {
        
        Connection conn = ConnectionFactory.getConexao();      
	PreparedStatement pstm;
                
                	
	String query = "INSERT INTO veiculo (placa, numChassi, marca, modelo, renavam,"
                + " cor, valorDiaria, valorSeguro, opcionais, fornecedor, ano, motor, cambio, portas, "
                + "combustivel, status, cod_venda, locado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        // try catch para tentar inserir
        try {
            
            //prepara a string para inser��o
	    pstm = conn.prepareStatement(query);
            
            //passa os parametros
                       
            pstm.setString(1, v.getPlaca());
            pstm.setString(2, v.getNumChassi());
            pstm.setString(3, v.getMarca());
            pstm.setString(4, v.getModelo());
            pstm.setString(5, v.getRenavam());
            pstm.setString(6, v.getCor());
            pstm.setFloat(7, v.getValorDiaria());
            pstm.setFloat(8, v.getValorSeguro());
            pstm.setString(9, v.getOpcionais());
            pstm.setString(10, v.getFornecedor());
            pstm.setInt(11, v.getAno());
            pstm.setString(12, v.getMotor());
            pstm.setString(13, v.getCambio());
            pstm.setInt(14, v.getPortas());
            pstm.setString(15, v.getCombustivel());           
            pstm.setBoolean(16, v.getStatus());
            pstm.setInt(17, v.getCodVenda());
            pstm.setBoolean(18, false);
            
            
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
    
    public boolean alterar(Veiculo v, int codigo){
        
        Connection conn = ConnectionFactory.getConexao();      
	PreparedStatement pstm;
        
        String query = "UPDATE veiculo SET modelo = ?, placa = ?, renavam = ?,"
                + "cor = ?, marca = ?, numChassi = ?, valorDiaria = ?, valorSeguro = ?,"
                + " status = ?, ano = ?, motor = ?, cambio = ?, portas = ?, combustivel = ?,"
                + "opcionais = ?, fornecedor = ?, cod_venda = ? WHERE codigo = "+codigo+" ";
        
        try {
            pstm = conn.prepareStatement(query);
            
            pstm.setString(1, v.getModelo());
            pstm.setString(2, v.getPlaca());
            pstm.setString(3, v.getRenavam());
            pstm.setString(4, v.getCor());
            pstm.setString(5, v.getMarca());
            pstm.setString(6, v.getNumChassi());
            pstm.setFloat(7, v.getValorDiaria());
            pstm.setFloat(8, v.getValorSeguro());
            pstm.setBoolean(9, v.getStatus());
            pstm.setInt(10, v.getAno());
            pstm.setString(11, v.getMotor());
            pstm.setString(12, v.getCambio());
            pstm.setInt(13, v.getPortas());
            pstm.setString(14, v.getCombustivel());
            pstm.setString(15, v.getOpcionais());
            pstm.setString(16, v.getFornecedor());
            pstm.setInt(17, v.getCodVenda());
            
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
    

    
    
    
}
