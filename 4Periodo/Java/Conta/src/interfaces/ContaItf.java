package interfaces;

import exception.WithdrawException;

public interface ContaItf {
	public double saque(double valor) throws WithdrawException;
	public double deposito(double valor);
}
