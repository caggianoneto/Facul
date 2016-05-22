package model;

import java.util.ArrayList;

public class Frota {
	
	//Atributos da classe
	private int idFrota;
	private int qtdVeiculosTotal;
	private int qtdVeiculosDisponiveis;
	private ArrayList<Veiculo> listaVeiculos;
	
	//CONSTRUTOR PADRAO
	public Frota(){}
	
	public Frota(ArrayList<Veiculo> listaVeiculos){
		this.listaVeiculos = listaVeiculos;
	}

	// GETTERS E SETTERS
	public int getIdFrota() {
		return idFrota;
	}


	public void setIdFrota(int idFrota) {
		this.idFrota = idFrota;
	}


	public int getQtdVeiculosTotal() {
		return qtdVeiculosTotal;
	}


	public void setQtdVeiculosTotal(int qtdVeiculosTotal) {
		this.qtdVeiculosTotal = qtdVeiculosTotal;
	}


	public int getQtdVeiculosDisponiveis() {
		return qtdVeiculosDisponiveis;
	}


	public void setQtdVeiculosDisponiveis(int qtdVeiculosDisponiveis) {
		this.qtdVeiculosDisponiveis = qtdVeiculosDisponiveis;
	}


	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}


	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	
}
