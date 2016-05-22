package view;


import java.util.List;



import javax.swing.table.AbstractTableModel;

import model.Relatorio;

public class RelatorioTableModelClienteFisica extends AbstractTableModel{

	private static final int COL_NOME_CLIENTE = 0;
	private static final int COL_CPF = 1;
	private static final int COL_RG = 2;
	private static final int COL_EMAIL = 3;
	private static final int COL_ENDERECO = 4;
	private static final int COL_NUMERO = 5;
	private static final int COL_COMPLEMENTO = 6;
	private static final int COL_BAIRRO = 7;
	private static final int COL_CEP = 8;
	private static final int COL_CIDADE = 9;
	private static final int COL_ESTADO = 10;
	private static final int COL_TELFONE_UM = 11;
	private static final int COL_TELFONE_DOIS = 12;


	private List<Relatorio> valores;
	
	public RelatorioTableModelClienteFisica(List<Relatorio> valores){
		
		this.valores = valores;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex){  
		
		if(columnIndex == COL_NOME_CLIENTE){
			return true;
		}
		else if(columnIndex == COL_CPF){
			return true;
		}
		else if(columnIndex == COL_RG){
			return true;
		}
		
		return false;
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {    
		Relatorio relatorio = valores.get(rowIndex);
		
	    if(columnIndex == COL_NOME_CLIENTE){
			relatorio.setNome((String)aValue);
		}
		else if(columnIndex == COL_CPF){
			relatorio.setCpf((String)aValue);
		}
		else if(columnIndex == COL_RG){
			relatorio.setRg((String)aValue);
		}
		
		Relatorios rel = new Relatorios();
		
		boolean verificaExclusao = rel.confirmaExclusao();
		
		if(verificaExclusao == true){
			
		rel.onSaveClienteFisica(relatorio);
			
			fireTableCellUpdated(rowIndex,columnIndex); 
			
		}
		else{
			rel.refreshTableClienteDestinatario();
		}
		
	}  
	
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 13;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return valores.size();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
	
		Relatorio relatorio = valores.get(rowIndex);
		

		if(columnIndex == COL_NOME_CLIENTE){
			return relatorio.getNome();
		}
		else if(columnIndex == COL_CPF){
			return relatorio.getCpf();
		}
		else if(columnIndex == COL_RG){
			return relatorio.getRg();
		}
		else if(columnIndex == COL_EMAIL){
			return relatorio.getEmailFisica();
		}
		else if(columnIndex == COL_ENDERECO){
			return relatorio.getEnderecoFisica();
		}
		else if(columnIndex == COL_NUMERO){
			return relatorio.getNumeroFisica();
		}
		else if(columnIndex == COL_COMPLEMENTO){
			return relatorio.getComplementoFisica();
		}
		else if(columnIndex == COL_BAIRRO){
			return relatorio.getBairroFisica();
		}
		else if(columnIndex == COL_CEP){
			return relatorio.getCepFisica();
		}
		else if(columnIndex == COL_CIDADE){
			return relatorio.getCidadeFisica();
		}
		else if(columnIndex == COL_ESTADO){
			return relatorio.getEstadoFisica();
		}
		else if(columnIndex == COL_TELFONE_UM){
			return relatorio.getTelefoneUmFisica();
		}
		else if(columnIndex == COL_TELFONE_DOIS){
			return relatorio.getTelefoneDoisFisica();
		}
		
		return null;
	}
	
	public String getColumnName(int column){
		
		String coluna = "";
		
		switch (column) {

		case COL_NOME_CLIENTE:
			coluna = "Nome";
			break;
		case COL_CPF:
			coluna = "CPF";
			break;
		case COL_RG:
			coluna = "RG";
			break;	
		case COL_EMAIL:
			coluna = "EMAIL";
			break;
		case COL_ENDERECO:
			coluna = "ENDEREÇO";
			break;	
		case COL_NUMERO:
			coluna = "NUMERO";
			break;
		case COL_COMPLEMENTO:
			coluna = "COMPLEMENTO";
			break;	
		case COL_BAIRRO:
			coluna = "BAIRRO";
			break;	
		case COL_CEP:
			coluna = "CEP";
			break;	
		case COL_CIDADE:
			coluna = "CIDADE";
			break;	
		case COL_ESTADO:
			coluna = "ESTADO";
			break;	
		case COL_TELFONE_UM:
			coluna = "TELEFONE UM";
			break;	
		case COL_TELFONE_DOIS:
			coluna = "TELEFONE DOIS";
			break;	

		default:
			throw new IllegalArgumentException("Coluna invalida");
			
		}
		return coluna;
		
	}
	
	
	// tipo de dados que a coluna tem
	public Class<?> getColumnClass(int columnIndex){

	    if(columnIndex == COL_NOME_CLIENTE){
			return String.class;
		}
		else if(columnIndex == COL_CPF){
			return String.class;
		}
		else if(columnIndex == COL_RG){
			return String.class;
		}
		else if(columnIndex == COL_EMAIL){
			return String.class;
		}
		else if(columnIndex == COL_ENDERECO){
			return String.class;
		}
		else if(columnIndex == COL_NUMERO){
			return String.class;
		}
		else if(columnIndex == COL_COMPLEMENTO){
			return String.class;
		}
		else if(columnIndex == COL_BAIRRO){
			return String.class;
		}
		else if(columnIndex == COL_CEP){
			return String.class;
		}
		else if(columnIndex == COL_CIDADE){
			return String.class;
		}
		else if(columnIndex == COL_ESTADO){
			return String.class;
		}
		else if(columnIndex == COL_TELFONE_UM){
			return String.class;
		}
		else if(columnIndex == COL_TELFONE_DOIS){
			return String.class;
		}
		
		return null;
	}
	
	//oque contem na linha
	public Relatorio get(int row){
		
		return valores.get(row);
	}
	
	
	
}
