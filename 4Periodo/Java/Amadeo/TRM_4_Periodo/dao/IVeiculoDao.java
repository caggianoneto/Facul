/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Veiculo;

/**
 *
 * @author NIB
 */
public interface IVeiculoDao {
    
    public boolean incluir(Veiculo v);
    
    public boolean alterar(Veiculo v, int codigo);
    
    
}
