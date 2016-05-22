package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class PainelPrincipal extends JFrame {

	// ATRIBUTOS DA CLASSE
	private static final long serialVersionUID = 1L;
	public JPanel viewPrimaria;
	private JPanel genericPanel;
	private JMenuBar menuBar;
	private JPanel panel_1;
	private JButton btnCadastro2;
	private JButton btncadDist;
	private JButton btnRelatorio;
	private JButton button;
	private JLabel lblTelaPrincipal;
	
	
	
	// CLASSE PRINCIPAL
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelPrincipal frame = new PainelPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// JFRAME
	public PainelPrincipal() {
		setBackground(Color.WHITE);
		
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1335, 680);
		viewPrimaria = new JPanel();
		viewPrimaria.setBackground(Color.WHITE);
		viewPrimaria.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(viewPrimaria);
		viewPrimaria.setLayout(null);
		
		// BARRA DE MENU
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(5, 5, 432, 21);
		viewPrimaria.add(menuBar);
		
		JMenuItem btnPrincipal = new JMenuItem("Principal");
		btnPrincipal.setBackground(Color.WHITE);
		menuBar.add(btnPrincipal);
		
		// ITENS DO MENU
		JMenuItem btnCadastro = new JMenuItem("Cadastro");
		btnCadastro.setBackground(Color.WHITE);
		menuBar.add(btnCadastro);
		
		JMenuItem btnRelatorios = new JMenuItem("Relatorios");
		btnRelatorios.setBackground(Color.WHITE);
		menuBar.add(btnRelatorios);
		
		JMenuItem btnDistribuicao = new JMenuItem("Distribui\u00E7\u00E3o");
		btnDistribuicao.setBackground(Color.WHITE);
		menuBar.add(btnDistribuicao);
		
	    panel_1 = new JPanel();
	    panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(15, 34, 1302, 608);
		viewPrimaria.add(panel_1);
		panel_1.setLayout(null);
		
		btnCadastro2 = new JButton("Cadastro"); 
		btnCadastro2.setIcon(new ImageIcon("C:\\Java\\trm_amadeo\\src\\img\\icone_cadastro_.jpg"));
		btnCadastro2.setBorderPainted( false );
		btnCadastro2.setForeground(Color.BLACK);
		btnCadastro2.setBounds(272, 180, 142, 120);
		panel_1.add(btnCadastro2);
		
		btncadDist = new JButton("Distribrui\u00E7\u00E3o");
		btncadDist.setBorderPainted( false );
		btncadDist.setIcon(new ImageIcon("C:\\Java\\trm_amadeo\\src\\img\\icone_distribuicao.jpg"));
		btncadDist.setBounds(576, 180, 137, 120);
		panel_1.add(btncadDist);
		
		btnRelatorio = new JButton("Relatorios");
		btnRelatorio.setBorderPainted( false );
		btnRelatorio.setIcon(new ImageIcon("C:\\Java\\trm_amadeo\\src\\img\\icone_relatorios.jpg"));
		btnRelatorio.setBounds(844, 189, 142, 103);
		panel_1.add(btnRelatorio);
		
		button = new JButton("");
		button.setBorderPainted( false );
		button.setIcon(new ImageIcon("C:\\Java\\trm_amadeo\\src\\img\\icone_logo.jpg"));
		button.setBounds(347, 364, 509, 215);
	
		panel_1.add(button);
		
		genericPanel = new JPanel();
		genericPanel.setBounds(0, 0, 1300, 700);
		//desktopPane.add(genericPanel);
		
		// TELA PRINCIPAL QUE É CHAMADA NO INICIO DA APLICAÇÃO
		lblTelaPrincipal = new JLabel("Tela principal");
		lblTelaPrincipal.setBounds(58, 11, 88, 14);
		
		
// ************************************ AÇOES DOS BOTOES DO MENU PRINCIPAL *****************************************************//
		
		//BOTÃO PRINCIPAL
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				revalidaTelaPrincipal();
			
			}
		});
		
		// BOTAO CADASTRO
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cadastro cadastro = new Cadastro();
				removeTela(viewPrimaria);
				cadastro.setVisible(true);
		        cadastro.setSize(viewPrimaria.getSize());
		        viewPrimaria.add(cadastro);
		        viewPrimaria.revalidate();        
		        viewPrimaria.repaint();
			}
		});
		
		
		
		// BOTAO PESQUISA
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Relatorios relatorio = new Relatorios();
				removeTela(viewPrimaria);
				relatorio.setVisible(true); 
				relatorio.setSize(viewPrimaria.getSize());
		        viewPrimaria.add(relatorio);
		        viewPrimaria.revalidate();        
		        viewPrimaria.repaint();
				
			}
		});
		// BTN REL 2
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatorios relatorio = new Relatorios();
				removeTela(viewPrimaria);
				relatorio.setVisible(true); 
				relatorio.setSize(viewPrimaria.getSize());
		        viewPrimaria.add(relatorio);
		        viewPrimaria.revalidate();        
		        viewPrimaria.repaint();
			}
		});
		
		// BOTAO DISTRIBUIÇAO
		btnDistribuicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Distribuicao distribuicao = new Distribuicao();
				removeTela(viewPrimaria);
				distribuicao.setVisible(true); 
				distribuicao.setSize(viewPrimaria.getSize());
		        viewPrimaria.add(distribuicao);
		        viewPrimaria.revalidate();        
		        viewPrimaria.repaint();
				
			}
		});
		
		// DIST 2
		btncadDist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Distribuicao distribuicao = new Distribuicao();
				removeTela(viewPrimaria);
				distribuicao.setVisible(true); 
				distribuicao.setSize(viewPrimaria.getSize());
		        viewPrimaria.add(distribuicao);
		        viewPrimaria.revalidate();        
		        viewPrimaria.repaint();
			}
		});
	
	}
	
	public void revalidaTelaPrincipal(){
		
		removeTela(viewPrimaria);
		panel_1 = new JPanel();
	    panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(15, 34, 1302, 608);
		viewPrimaria.add(panel_1);
		panel_1.setLayout(null);
		
		btnCadastro2 = new JButton("Cadastro"); 
		btnCadastro2.setIcon(new ImageIcon("C:\\Java\\trm_amadeo\\src\\img\\icone_cadastro_.jpg"));
		btnCadastro2.setBorderPainted( false );
		btnCadastro2.setForeground(Color.BLACK);
		btnCadastro2.setBounds(272, 180, 142, 120);
		panel_1.add(btnCadastro2);
		
		btncadDist = new JButton("Distribrui\u00E7\u00E3o");
		btncadDist.setBorderPainted( false );
		btncadDist.setIcon(new ImageIcon("C:\\Java\\trm_amadeo\\src\\img\\icone_distribuicao.jpg"));
		btncadDist.setBounds(576, 180, 137, 120);
		panel_1.add(btncadDist);
		
		btnRelatorio = new JButton("Relatorios");
		btnRelatorio.setBorderPainted( false );
		btnRelatorio.setIcon(new ImageIcon("C:\\Java\\trm_amadeo\\src\\img\\icone_relatorios.jpg"));
		btnRelatorio.setBounds(844, 189, 142, 103);
		panel_1.add(btnRelatorio);
		
		button = new JButton("");
		button.setBorderPainted( false );
		button.setIcon(new ImageIcon("C:\\Java\\trm_amadeo\\src\\img\\icone_logo.jpg"));
		button.setBounds(347, 364, 509, 215);
	
		panel_1.add(button);
		
		genericPanel = new JPanel();
		genericPanel.setBounds(0, 0, 1300, 700);
		//desktopPane.add(genericPanel);
		
		// TELA PRINCIPAL QUE É CHAMADA NO INICIO DA APLICAÇÃO
		lblTelaPrincipal = new JLabel("Tela principal");
		lblTelaPrincipal.setBounds(58, 11, 88, 14);
		
		
		
	}
	
	
	public void removeTela(JPanel painelPrincipal){
		
		Component[] comp = painelPrincipal.getComponents();
        for (Component component : comp) {  
            if ( component instanceof JPanel ) {  
            	painelPrincipal.remove(component);  
            	painelPrincipal.repaint();  
            }

        }  	
	}
}
