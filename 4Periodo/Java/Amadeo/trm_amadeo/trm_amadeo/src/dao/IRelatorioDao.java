package dao;

import java.util.List;

import model.Relatorio;

public interface IRelatorioDao {

	int save(Relatorio relatorio);
	
	boolean update(Relatorio relatorio);
	
	boolean remove(Relatorio relatorio);
	
	List<Relatorio> findAll(Relatorio relatorio);
	
}
