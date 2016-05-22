package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import view.Relatorios;
import dao.IRelatorioDao;
import dao.RelatorioDao;
import model.Cliente;
import model.Relatorio;
import model.Veiculo;

public class RelatorioController {

	private IRelatorioDao dao;
	
	public RelatorioController(){
		
		this.dao = new RelatorioDao();
	}
	
	public int save(Relatorio relatorio) {

		return dao.save(relatorio);
	}
	
	public boolean update(Relatorio relatorio) {

		return dao.update(relatorio);
	}
	
	public boolean remove(Relatorio relatorio) {
		
		return dao.remove(relatorio);
	}
	
	public List<Relatorio> findAll(Relatorio relatorio) {

		return dao.findAll(relatorio);
	}
	
	
	
	//public List<Cliente> informacoesPessoa(String cpf,String cnpj, String nome, String razaoSocial,int combo){
//	public ArrayList<Cliente> informacoesPessoa(String cpf,String cnpj, String nome, String razaoSocial,int combo){
//		
//		List<String> array = new ArrayList<String>();
//		
//		cliente.setCpf(cpf);
//		cliente.setCnpj(cnpj);
//		cliente.setNome(nome);
//		cliente.setRazaoSocial(razaoSocial);
//		cliente.setTipoPessoa(combo);
//		
//		ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
//		
//		listaCliente = relatorioDao.getLista(cliente);
//		
//		return listaCliente;
//		
//	}
//	
//	public void informacoesVeiculos(String placa, String renavam, Integer combo){
//		
//		
//		
//		Relatorio relatorios = new Relatorio();
//
//		relatorios.setPlaca(placa);
//		relatorios.setRenavam(renavam);
//		relatorios.setComboTipoVeiculo(combo.toString());
//		
//		relatorioDao.getListaVeiculo(relatorios);
//		
//		
//		
//		
//	}
	
}	
