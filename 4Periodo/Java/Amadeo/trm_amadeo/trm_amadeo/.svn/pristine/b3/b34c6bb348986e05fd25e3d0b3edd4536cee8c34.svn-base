package view;

import java.util.ArrayList;

public class ChecaEstado {
	
	public ChecaEstado(){}
	
	private String ufCombobox;
	private int valor;
	private String arrayUfs[] = {"AC","AP","AM","BA","CE","DF",
								 "ES","GO","MA","MT","MS","MG",
								 "PA","PB","PR","PE","PI","RJ",
								 "RN","RS","RO","RR","SC","SP",
								 "SE","TO"};
	
	public int retornaUfSelecionado(String uf){
		
		ufCombobox = uf;
		
		for(int i=0; i < arrayUfs.length ;i++){
			
			if(arrayUfs[i].equals(ufCombobox)){
				valor = i+1;
			}	
		}
		return valor;	
	}
	
}
