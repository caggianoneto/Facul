package model;

import java.text.NumberFormat;

import exception.WithdrawException;
import interfaces.ContaItf;

public class ContaSalario implements ContaItf {
	
	private int numero;
	private String titular;
	private double saldo;

	public ContaSalario() {

	}

	public ContaSalario(int numero, String titular, double saldo) {
		this.saldo = saldo;
		this.numero = numero;
		this.titular = titular;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public double saque(double valor) throws WithdrawException {
		// TODO Auto-generated method stub
		if(valor == saldo) {
			saldo -= valor;
		} else {
			throw new WithdrawException(numero, saldo);
		}
		
		return saldo;
	}

	@Override
	public double deposito(double valor) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return "Conta Salário número: " + numero + 
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
		ContaSalario other = (ContaSalario) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
}
