/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EnderecoDao;
import model.Endereco;

/**
 *
 * @author NIB2
 */
public class EnderecoBO {
    
    public boolean incluir(Endereco e) {
        
        EnderecoDao e2 = new EnderecoDao();
        
        return e2.incluir(e);
        
    }
    
    public boolean alterar(Endereco e, int codigo){
        
        EnderecoDao e2 = new EnderecoDao();
        
        return e2.alterar(e, codigo);
    }
    
}
