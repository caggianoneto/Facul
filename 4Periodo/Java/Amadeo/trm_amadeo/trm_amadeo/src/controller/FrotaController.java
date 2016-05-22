package controller;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

import model.Frota;
import model.Veiculo;
import view.ChecaEstado;
import dao.Conexao;
import dao.FrotaDAO;
import dao.VeiculoDAO;

public class FrotaController {
	
	public JComboBox estados;
	public JComboBox cidades;
	FrotaDAO ftDao = new FrotaDAO();
	
	public FrotaController(){}
	
	public boolean atualizaEstatisticas(int IdFrota){
		
		return ftDao.atualizaEstatisticas(IdFrota);
		
	}
	
 	public boolean insereNaFrota(ArrayList<Object> veiculosIncluidos, int regiaoFrota){
		
		regiaoFrota++;
	
		try {
			int veiculosVinculados = 0;
			int rowid = ftDao.incluiRegiao(regiaoFrota);
			
			for (int i = 0; i < veiculosIncluidos.size(); i++) {
				
				veiculosVinculados += ftDao.inclusaoFrota(veiculosIncluidos.get(i), rowid);			
			}
			
			if( veiculosVinculados > 0){
				// INICIA OS VALORES DE ESTATISTICA DA FROTA
				if(ftDao.iniciaFrota(veiculosVinculados, rowid)){
					return true;
				}else{
					return false;
				}	
			}
						
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return false;
		
	}
	
	public void populaComboboxRegioes(JComboBox estados, JComboBox cidades){
		
		this.cidades = new JComboBox();
		this.estados = new JComboBox();
		this.cidades = cidades;
		this.estados = estados;
		
		
		ftDao.preencheCombobox();
		
		for(String elemento: ftDao.cidades){  
			this.cidades.addItem(elemento);
		}  
		
		for(String elemento: ftDao.estados){  
			this.estados.addItem(elemento);
		}  						
	}
	


}
