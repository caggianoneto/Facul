/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ClienteDao;
import model.Cliente;

/**
 *
 * @author NIB2
 */
public class ClienteBO {
    
    public boolean incluir(Cliente c) {
        
        ClienteDao c2 = new ClienteDao();
        
        return c2.incluir(c);
        
    }
    
    public boolean selecionarCod(Cliente c){
        
        ClienteDao c2 = new ClienteDao();
        
        return c2.selecionarCod(c);
        
    }
    
    public boolean alterar(Cliente c, int codigo){
        
        ClienteDao c2 = new ClienteDao();
        
        return c2.alterar(c,codigo);
        
    }
    
}
