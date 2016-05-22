/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author NIB2
 */
public interface IClienteDao {
    
    public boolean incluir(Cliente c);
    
    public boolean selecionarCod(Cliente c);
	
    public boolean alterar(Cliente c, int codigo);
    
	
    
}
