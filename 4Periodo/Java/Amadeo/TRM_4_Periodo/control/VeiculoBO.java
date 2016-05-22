/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.VeiculoDao;
import model.Veiculo;

/**
 *
 * @author NIB
 */
public class VeiculoBO {
    
    
    public boolean incluir(Veiculo v) {
        
        VeiculoDao v2 = new VeiculoDao();
        
        return v2.incluir(v);
        
    }
    
    
    public boolean alterar(Veiculo v, int codigo){
        
        VeiculoDao v2 = new VeiculoDao();
        
        return v2.alterar(v,codigo);
    }
    
    
    
}
