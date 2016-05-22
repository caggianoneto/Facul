package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Relatorio;

public class RelatorioTableModelDestinatario extends AbstractTableModel{

	private static final int COL_NOMEDEST = 0;
	private static final int COL_CPFCNPJ = 1;
	private static final int COL_TELFONE_UM = 2;
	private static final int COL_TELFONE_DOIS = 3;
	private static final int COL_ENDERECO = 4;
	private static final int COL_NUMERO = 5;
	private static final int COL_COMPLEMENTO = 6;
	private static final int COL_BAIRRO = 7;
	private static final int COL_CEP = 8;
	private static final int COL_CIDADE = 9;
	private static final int COL_ESTADO = 10;

	private List<Relatorio> valores;
	
	public RelatorioTableModelDestinatario(List<Relatorio> valores){
		
		this.valores = valores;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex){  
		
		if(columnIndex == COL_NOMEDEST){
			return true;
		}
		else if(columnIndex == COL_CPFCNPJ){
			return true;
		}
		
		return false;
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {    
		Relatorio relatorio = valores.get(rowIndex);
		
	    if(columnIndex == COL_NOMEDEST){
			relatorio.setNomeDest((String)aValue);
		}
		else if(columnIndex == COL_CPFCNPJ){
			relatorio.setCpfcnpj((String)aValue);
		}
		
		Relatorios rel = new Relatorios();
		
		boolean verificaExclusao = rel.confirmaExclusao();
		
		if(verificaExclusao == true){
			
		rel.onSaveClienteDestinatario(relatorio);
			
			fireTableCellUpdated(rowIndex,columnIndex); 
			
		}
		else{
			rel.refreshTableClienteDestinatario();
		}
		
	}  
	
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 11;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return valores.size();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
	
		Relatorio relatorio = valores.get(rowIndex);
		

		if(columnIndex == COL_NOMEDEST){
			return relatorio.getNomeDest();
		}
		else if(columnIndex == COL_CPFCNPJ){
			return relatorio.getCpfcnpj();
		}
		else if(columnIndex == COL_TELFONE_UM){
			return relatorio.getTelefoneUmDestinatario();
		}
		else if(columnIndex == COL_TELFONE_DOIS){
			return relatorio.getTelefoneDoisDestinatario();
		}
		else if(columnIndex == COL_ENDERECO){
			return relatorio.getEndecoDestinatario();
		}
		else if(columnIndex == COL_COMPLEMENTO){
			return relatorio.getComplementoDestinatario();
		}
		else if(columnIndex == COL_BAIRRO){
			return relatorio.getBairroDestinatario();
		}
		else if(columnIndex == COL_CEP){
			return relatorio.getCepDestinatario();
		}
		else if(columnIndex == COL_CIDADE){
			return relatorio.getCidadeDestinatario();
		}
		else if(columnIndex == COL_ESTADO){
			return relatorio.getEstadoDestinatario();
		}
		
		return null;
	}
	
	public String getColumnName(int column){
		
		String coluna = "";
		
		switch (column) {

		case COL_NOMEDEST:
			coluna = "Nome Destinatario";
			break;
		case COL_CPFCNPJ:
			coluna = "CPF/CNPJ";
			break;
		case COL_TELFONE_UM:
			coluna = "IE";
			break;	
		case COL_TELFONE_DOIS:
			coluna = "TELEFONE DOIS";
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
	

		default:
			throw new IllegalArgumentException("Coluna invalida");
			
		}
		return coluna;
		
	}
	
	
	// tipo de dados que a coluna tem
	public Class<?> getColumnClass(int columnIndex){

	    if(columnIndex == COL_NOMEDEST){
			return String.class;
		}
		else if(columnIndex == COL_CPFCNPJ){
			return String.class;
		}
		else if(columnIndex == COL_TELFONE_UM){
			return String.class;
		}
		else if(columnIndex == COL_TELFONE_DOIS){
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
