package laboratorio;

import db.BancoDados;
import exception.WithdrawException;
import interfaces.ContaItf;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.ContaSalario;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BancoDados meuDb = BancoDados.getInstance();
		ContaCorrente cc = new ContaCorrente(1, "Joao", 15000, 100000);

		meuDb.adicionar(cc);
		meuDb.adicionar(new ContaSalario(2, "Manoel", 3000));
		meuDb.adicionar(new ContaPoupanca(3, "Joana", 12700));

		try {
			if(cc.getSaldo() > 1000) {
				cc.saque(1000);
			}
		} catch (WithdrawException e) {
			e.getMessage();
			e.printStackTrace();
		}

		for (ContaItf c : meuDb.clone()) {
			System.out.println(c);
		}
	}

}
