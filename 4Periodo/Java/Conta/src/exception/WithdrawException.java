package exception;

public class WithdrawException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int numero;
	private double saldo;
	
	public WithdrawException(int numero, double saldo) {
		super("Numero da conta: " + numero + 
			  " - Saldo insuficiente! Saldo atual: " + saldo);
		this.numero = numero;
		this.saldo = saldo;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
