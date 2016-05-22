package model;

import java.text.NumberFormat;

import exception.WithdrawException;
import interfaces.ContaItf;

public class ContaCorrente implements ContaItf {
	
	private int numero;
	private String titular;
	private double saldo;
	private double limite;

	public ContaCorrente() {

	}

	public ContaCorrente(int numero, String titular, double saldo, double limite) {
		this.saldo = saldo;
		this.limite = limite;
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
	
	public double getLimite() {
		return limite;
	}
	
	public void setLimite(double limiteCredito) {
		limite = limiteCredito;
	}

	@Override
	public double saque(double valor) throws WithdrawException {
		// TODO Auto-generated method stub
		if(valor <= (saldo+limite)) {
			saldo -= valor;
		} else {
			throw new WithdrawException(numero, saldo+limite);
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
		return "Conta Corrente número: " + numero + 
				" com saldo de: " + 
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
		ContaCorrente other = (ContaCorrente) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
}
