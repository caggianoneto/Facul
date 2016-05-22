/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Endereco;

/**
 *
 * @author NIB2
 */
public interface IEnderecoDao {
    
     public boolean incluir(Endereco e);
     
     public boolean selecionar(Endereco e);
     
     public boolean alterar(Endereco e, int codigo);
	
}
