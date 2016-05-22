/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.FornecedorDao;
import model.Fornecedor;

/**
 *
 * @author NIB2
 */
public class FornecedorBO {
    
    public boolean incluir(Fornecedor f) {
        
        FornecedorDao f2 = new FornecedorDao();
        
        return f2.incluir(f);
        
    }
    
    public boolean alterar(Fornecedor f,int codigo){
        
        FornecedorDao f2 = new FornecedorDao();
        
        return f2.alterar(f,codigo);
    }
    
    public boolean selecionarCod(Fornecedor f){
        
        FornecedorDao f2 = new FornecedorDao();
        
        return f2.selecionarCod(f);
        
    }
    
    
    
}
