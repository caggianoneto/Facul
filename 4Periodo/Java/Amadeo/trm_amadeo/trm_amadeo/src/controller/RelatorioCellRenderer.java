
package controller;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;




public class RelatorioCellRenderer extends DefaultTableCellRenderer {

	
	// cores tabela
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelect, boolean hasFocus, int row, int column){
		
		super.getTableCellRendererComponent(table, value, isSelect, hasFocus, row, column);
		
//		if(row % 2 == 0){
//			setBackground(Color.YELLOW);
//			
//		}
//		else{
//			setBackground(null);
//		}
		
		
		if(isSelect){
			setBackground(Color.GREEN);
		}
		
		
		//tamanho colunas
		
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setMaxWidth(400);
		table.getColumnModel().getColumn(2).setMaxWidth(500);
		table.getColumnModel().getColumn(3).setMaxWidth(200);
		
		return this;
	}
	

}
	
	
	

