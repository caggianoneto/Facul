/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Fornecedor;

/**
 *
 * @author NIB2
 */
public interface IFornecedorDao {
    
    public boolean incluir(Fornecedor f);
    
    public boolean selecionarCod(Fornecedor f);
    
    public boolean alterar(Fornecedor f, int codigo);
}
