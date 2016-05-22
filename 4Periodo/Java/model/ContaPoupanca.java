package model;

import java.text.NumberFormat;

import interfaces.ContaItf;

public class ContaPoupanca implements ContaItf {
	
	private int numero;
	private String titular;
	private double saldo;

	public ContaPoupanca() {

	}

	public ContaPoupanca(int numero, String titular, double saldo) {
		this.saldo = saldo;
		this.numero = numero;
		this.titular = titular;
	}
	
	public int getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public double saque(double valor) {
		// TODO Auto-generated method stub
		if(valor <= saldo) {
			saldo -= valor;
		}
		
		return saldo;
	}

	@Override
	public double deposito(double valor) {
		// TODO Auto-generated method stub
		saldo += valor;
		
		return saldo;
	}
	
	@Override
	public String toString() {
		return "O saldo é: " + 
				NumberFormat.getCurrencyInstance().format(saldo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaPoupanca other = (ContaPoupanca) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
}
