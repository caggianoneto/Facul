package controller;

import java.util.ArrayList;

import dao.VeiculoDAO;
import model.Veiculo;

public class VeiculoController{
	
	//ATRIBUTOS
	private int idVeiculo;
	private String placa;
	private String renavam;
	private String tipo;
	private String marcaModelo;
	private String combustivel;
	private String capacidadeTanqueComb;
	private String anoFab;
	private String pesoMaxCarga;
	private String tara;
	private String compCapacidadeCarga;
	private String larguraCapacidadeCarga;
	private String alturaCapacidadeCarga;
	private int numeroEixos;
	private int statusVeiculo;
	private Veiculo veiculoModel = null;
	
	// CONSTRUTOR PADRÃO
	public VeiculoController(){}
	
	// CONSTRUTOR DA CLASSE
	public VeiculoController(String placa, String renavam, String tipo,
			String marcaModelo, String combustivel, int statusVeiculo) {
		
		this.placa = placa;
		this.renavam = renavam;
		this.tipo = tipo;
		this.marcaModelo = marcaModelo;
		this.combustivel = combustivel;
		this.statusVeiculo = statusVeiculo;	
	}
	
	// METODO PRINCIPAL
	public boolean init(VeiculoController veiculo){
		
		boolean retorno = false;
		
		if(veiculo.processaValores()){
				 
			// INSTANCIA PARA INSERÇÃO NO BD
			VeiculoDAO veiculoDao = new VeiculoDAO();
			
			if(veiculoDao.inclusao(veiculoModel)){
				retorno = true;
			}	
		}
		return retorno;
	}
	
	private boolean processaValores(){
		
		// INSTANCIA VEICULO
		veiculoModel = new Veiculo(this.placa, this.renavam, this.tipo, this.marcaModelo, this.combustivel, this.statusVeiculo);
		
		 try{
			 veiculoModel.setAnoFabricacao(Integer.parseInt(this.anoFab)); 
			 veiculoModel.setCapacidadeTanqueComb(Integer.parseInt(this.capacidadeTanqueComb)); 
			 veiculoModel.setPesoMaxCarga(Float.parseFloat(this.pesoMaxCarga));
			 veiculoModel.setTara(Float.parseFloat(this.tara)); 
			 veiculoModel.setCompCapacidadeCarga(Float.parseFloat(this.compCapacidadeCarga)); 
			 veiculoModel.setLarguraCapacidadeCarga(Float.parseFloat(this.larguraCapacidadeCarga)); 
			 veiculoModel.setAlturaCapacidadeCarga(Float.parseFloat(this.alturaCapacidadeCarga));
			 veiculoModel.setNumeroEixos(this.numeroEixos);
			
	        }catch(NumberFormatException ex){       
	        	return false;
	        }
		 	
		return true;     			
	}
	
	public ArrayList<Veiculo> listaVeiculos(){
		
		VeiculoDAO veiculoDao = new VeiculoDAO();
		
		return veiculoDao.buscaVeiculos();
	}
	
	public boolean alteraStatus(int idVeiculo, int status){
		
		VeiculoDAO veiculoDao = new VeiculoDAO();
		
		if(veiculoDao.alteraStatus(idVeiculo, status))
			return true;
		else
			return false;
	}
	
	public Veiculo buscaVeiculosId(int idVeiculo){
		
		Veiculo v = new Veiculo();
		VeiculoDAO vDao = new VeiculoDAO();
		
		v = vDao.buscaVeiculosPorId(idVeiculo);
		
		return v;
	}
	
	public boolean cadastraAsair(Veiculo veiculo){
		
		VeiculoDAO veiculoDao = new VeiculoDAO();
		
		return veiculoDao.cadastraAsair(veiculo);
		
	}
	
	public Veiculo checaVeiculo(int idVeiculo){
		
		VeiculoDAO veiculoDao = new VeiculoDAO();
		Veiculo v = new Veiculo();
		
		v = veiculoDao.checaVeiculo(idVeiculo);
		
		return v;
	}

	public boolean atualizaEspacoInternoRestante(Veiculo v){
		
		VeiculoDAO veiculoDao = new VeiculoDAO();
		
		 return veiculoDao.atualizaEspacoInternoRestante(v);
	}

	public boolean iniciaEspacoInternoRestante(Veiculo v){
		
		VeiculoDAO veiculoDao = new VeiculoDAO();
		
		return veiculoDao.iniciaEspacoInternoRestante(v);	
	}
	
	public boolean atualizaVeiculosAsair(int idVeiculo){
		
		VeiculoDAO veiculoDao = new VeiculoDAO();
		
		return veiculoDao.atualizaVeiculosAsair(idVeiculo);
		
		
	}
	
	
	// GETTERS E SETTERS
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCapacidadeTanqueComb() {
		return capacidadeTanqueComb;
	}

	public void setCapacidadeTanqueComb(String capacidadeTanqueComb) {
		this.capacidadeTanqueComb = capacidadeTanqueComb;
	}

	public String getAnoFab() {
		return anoFab;
	}

	public void setAnoFab(String anoFab) {
		this.anoFab = anoFab;
	}

	public String getPesoMaxCarga() {
		return pesoMaxCarga;
	}

	public void setPesoMaxCarga(String pesoMaxCarga) {
		this.pesoMaxCarga = pesoMaxCarga;
	}

	public String getTara() {
		return tara;
	}

	public void setTara(String tara) {
		this.tara = tara;
	}

	public String getCompCapacidadeCarga() {
		return compCapacidadeCarga;
	}

	public void setCompCapacidadeCarga(String compCapacidadeCarga) {
		this.compCapacidadeCarga = compCapacidadeCarga;
	}

	public String getLarguraCapacidadeCarga() {
		return larguraCapacidadeCarga;
	}

	public void setLarguraCapacidadeCarga(String larguraCapacidadeCarga) {
		this.larguraCapacidadeCarga = larguraCapacidadeCarga;
	}

	public String getAlturaCapacidadeCarga() {
		return alturaCapacidadeCarga;
	}

	public void setAlturaCapacidadeCarga(String alturaCapacidadeCarga) {
		this.alturaCapacidadeCarga = alturaCapacidadeCarga;
	}

	public int getStatusVeiculo() {
		return statusVeiculo;
	}

	public void setStatusVeiculo(int statusVeiculo) {
		this.statusVeiculo = statusVeiculo;
	}

	public int getNumeroEixos() {
		return numeroEixos;
	}

	public void setNumeroEixos(int numeroEixos) {
		this.numeroEixos = numeroEixos;
	}
	
}
