package view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Relatorio;

public class RelatorioTableModelClienteJuridica extends AbstractTableModel {

			private static final int COL_RAZAO_SOCIAL = 0;
			private static final int COL_CNPJ = 1;
			private static final int COL_IE = 2;
			private static final int COL_IM = 3;
			private static final int COL_CONTATO = 4;
			private static final int COL_EMAIL = 5;
			private static final int COL_ENDERECO = 6;
			private static final int COL_NUMERO = 7;
			private static final int COL_COMPLEMENTO = 8;
			private static final int COL_BAIRRO = 9;
			private static final int COL_CEP = 10;
			private static final int COL_CIDADE = 11;
			private static final int COL_ESTADO = 12;
			private static final int COL_TELFONE_UM = 13;
			private static final int COL_TELFONE_DOIS = 14;

			private List<Relatorio> valores;
			
			public RelatorioTableModelClienteJuridica(List<Relatorio> valores){
				
				this.valores = valores;
			}
			
			
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return 15;
			}

			public int getRowCount() {
				// TODO Auto-generated method stub
				return valores.size();
			}
			
			public boolean isCellEditable(int rowIndex, int columnIndex){  
				
				if(columnIndex == COL_RAZAO_SOCIAL){
					return true;
				}
				else if(columnIndex == COL_CNPJ){
					return true;
				}
				
				return false;
			}
			
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {    
				Relatorio relatorio = valores.get(rowIndex);
				
			    if(columnIndex == COL_RAZAO_SOCIAL){
					relatorio.setRazaoSocial((String)aValue);
				}
				else if(columnIndex == COL_CNPJ){
					relatorio.setCnpf((String)aValue);
				}

				Relatorios rel = new Relatorios();
				
				boolean verificaExclusao = rel.confirmaExclusao();
				
				if(verificaExclusao == true){
					
				rel.onSaveClienteJuridica(relatorio);
					
					fireTableCellUpdated(rowIndex,columnIndex); 
					
				}
				else{
					rel.refreshTableClienteDestinatario();
				}
				
			} 
			
			public Object getValueAt(int rowIndex, int columnIndex) {
			
				Relatorio relatorio = valores.get(rowIndex);
				

				if(columnIndex == COL_RAZAO_SOCIAL){
					return relatorio.getRazaoSocial();
				}
				else if(columnIndex == COL_CNPJ){
					return relatorio.getCnpf();
				}
				else if(columnIndex == COL_IE){
					return relatorio.getIe();
				}
				else if(columnIndex == COL_IM){
					return relatorio.getIm();
				}
				else if(columnIndex == COL_CONTATO){
					return relatorio.getContato();
				}
				else if(columnIndex == COL_EMAIL){
					return relatorio.getEmailJuridica();
				}
				else if(columnIndex == COL_ENDERECO){
					return relatorio.getEnderecoJuridica();
				}
				else if(columnIndex == COL_NUMERO){
					return relatorio.getNumeroJuridica();
				}
				else if(columnIndex == COL_COMPLEMENTO){
					return relatorio.getComplementoJuridica();
				}
				else if(columnIndex == COL_BAIRRO){
					return relatorio.getBairroJuridica();
				}
				else if(columnIndex == COL_CEP){
					return relatorio.getCepJuridica();
				}
				else if(columnIndex == COL_CIDADE){
					return relatorio.getCidadeJuridica();
				}
				else if(columnIndex == COL_ESTADO){
					return relatorio.getEstadoJuridica();
				}
				else if(columnIndex == COL_TELFONE_UM){
					return relatorio.getTelefoneUmJuridica();
				}
				else if(columnIndex == COL_TELFONE_DOIS){
					return relatorio.getTelefoneDoisJuridica();
				}
				
				return null;
			}
			
			public String getColumnName(int column){
				
				String coluna = "";
				
				switch (column) {

				case COL_RAZAO_SOCIAL:
					coluna = "Razão Social";
					break;
				case COL_CNPJ:
					coluna = "CNPJ";
					break;
				case COL_IE:
					coluna = "IE";
					break;	
				case COL_IM:
					coluna = "IM";
					break;
				case COL_CONTATO:
					coluna = "CONTATO";
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

			    if(columnIndex == COL_RAZAO_SOCIAL){
					return String.class;
				}
				else if(columnIndex == COL_CNPJ){
					return String.class;
				}
				else if(columnIndex == COL_IE){
					return String.class;
				}
				else if(columnIndex == COL_IM){
					return String.class;
				}
				else if(columnIndex == COL_CONTATO){
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
