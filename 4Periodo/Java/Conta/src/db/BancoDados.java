package db;

import java.util.HashSet;
import java.util.Set;

import interfaces.ContaItf;

public class BancoDados {

	private static BancoDados bd = null;
	
	private Set<ContaItf> core;
	
	private BancoDados() {
		core = new HashSet<>();
	}
	
	public static BancoDados getInstance() {
		if(bd == null) {
			bd = new BancoDados();
		}
		
		return bd;
	}
	
	public boolean adicionar(ContaItf conta) {
		return core.add(conta);
	}
	
	public boolean remover(ContaItf conta) {
		return core.remove(conta);
	}
	
	public ContaItf procurar(ContaItf conta) {
		for(ContaItf c:core) {
			if(c.equals(conta)) {
				return c;
			}
		}
		
		return null;
	}
	
	public Set<ContaItf> clone() {
		Set<ContaItf> novoBD = new HashSet<>();
		for(ContaItf c:core) {
			novoBD.add(c);
		}
		
		return novoBD;
	}
}
