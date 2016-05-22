package controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Cliente;
import model.Destinatario;
import model.Frota;
import model.Pedido;
import model.Veiculo;
import dao.ClienteDAO;
import dao.DestinatarioDAO;
import dao.FrotaDAO;
import dao.VeiculoDAO;


public class DistribuicaoController {
	
	public ArrayList<Destinatario> listaDestinatarios;
	DestinatarioDAO destDao = new DestinatarioDAO();
	
	// METODO RESPONSAVEL POR TODO O CALCULO DE PEDIDOS E FROTAS E SUAS REGIOES
	public Veiculo vinculaPedidoAfrota(Pedido pedido, int regiaoRem){
		
		FrotaDAO ftDao                    = new FrotaDAO();
		VeiculoDAO veiculoDao             = new VeiculoDAO();	
		ArrayList<Frota> listaFrotas      = new ArrayList<Frota>();
		ArrayList<Veiculo> listaVeiculos;
		
		// Lista onde terao gravadas as listas de veiculo	
		ArrayList<ArrayList<Veiculo>> listasDeVeiculos = new ArrayList<ArrayList<Veiculo>>();
		
		// PUXA A LISTA DE FROTAS PARA A REGIAO DO REMETENTE
		listaFrotas = ftDao.buscaFrotasPorRegiao(regiaoRem);
		
		for (int i = 0; i < listaFrotas.size(); i++) {
			System.out.println("frotas com regiao do remetente --> "+listaFrotas.get(i).getIdFrota());
			listaVeiculos = new ArrayList<Veiculo>();
			// Busca veiculos das frotas da regiao do remetente com status disponivel para ver se existe espaço para a entrega
			listaVeiculos = veiculoDao.buscaVeiculosPelaFrota(listaFrotas.get(i).getIdFrota());
			listasDeVeiculos.add(listaVeiculos);
		}
		
		// retorna lista de veiculos disponiveis das frotas da regiao do remetente
		int contaVeiculos = 0;	
			
		for (int i = 0; i < listasDeVeiculos.size(); i++) {
			for (int k = 0; k < listasDeVeiculos.get(i).size(); k++) {
				contaVeiculos++;
				System.out.println("Lista de veiculos retornada para a frota "+ listasDeVeiculos.get(i).get(k).getIdVeiculo() );
				
				//*************** INICIO DAS VERIFICAÇÕES DE VOLUME DA ENTREGA ***************************//
				
				/* PEGA AS INFORMAÇÕES DE CAPACIDADES DO VEICULO DA LISTA DE VEICULOS DENTRO DAS LISTAS DE LISTAS 
				*  DE VEICULOS DISPONIVEIS PARA A REGIAO DO REMETENTE PARA REALIZAR OS CALCULOS NECESSARIOS
				*  PARA A VINCULAÇÃO DA ENTREGA
				*/ 
				
				// DA PRIORIDADE PARA OS VEICULOS QUE ESTAO COM PEDIDOS ENCAMINHADOS
				// VERIFICA SE EXISTE VEICULO COM ENTREGAS COM STATUS ENCAMINHADO PARA VER SE TEM ESPAÇO PARA A PROX
				VeiculoController Vcontrol = new VeiculoController();
				Veiculo veiculoChecado = new Veiculo();
				veiculoChecado = Vcontrol.checaVeiculo(listasDeVeiculos.get(i).get(k).getIdVeiculo());
				
				if(veiculoChecado != null){
					// VERIFICA ESPAÇO INTERNO DO VEICULO RETORNADO PARA VER SE CABE O PEDIDO
					if(verificaEspacoInternoRestante(veiculoChecado, pedido))
						return veiculoChecado;
				}else{
					if( verificaEspacoInterno(listasDeVeiculos.get(i).get(k) , pedido) )
						return listasDeVeiculos.get(i).get(k);		
				}
			
			}		
		}
			
		if(contaVeiculos == 0){
			JOptionPane.showMessageDialog(null, "Nenhum veiculo disponivel para a região do remetente!!");
		}
			
		return null;
		
	}
	
	public JComboBox carregaListaDestinatarios(JComboBox combobox){
		
		listaDestinatarios = new ArrayList<Destinatario>();
		
		listaDestinatarios = destDao.buscaDestinatario();
		
		for (int i = 0; i < listaDestinatarios.size(); i++) {
			combobox.insertItemAt("Cod: "+listaDestinatarios.get(i).getIdDest()+" Nome: "+listaDestinatarios.get(i).getNome(), i);
		}
		
		combobox.setSelectedIndex(0);
		
		return combobox;
	
	}
	
	public JComboBox carregaListaClientes(JComboBox combobox){
		
		ClienteDAO cliente = new ClienteDAO();
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		
		listaClientes = cliente.buscaCliente();
		
		for (int i = 0; i < listaClientes.size(); i++) {
			combobox.insertItemAt("Cod: "+listaClientes.get(i).getIdCliente()+" Nome: "+listaClientes.get(i).getNome(), i);
		}
		
		combobox.setSelectedIndex(0);
		
		return combobox;
	
	}
	
	public Destinatario buscaDestinatarioSelecionado(String documento){
		
		return destDao.buscaPorDoc(documento);
		
	}
	
	public Cliente buscaClienteSelecionadoF(String documento){
		
		ClienteDAO clienteDao = new ClienteDAO();
		
		return clienteDao.buscaPorDocF(documento);
		
	}
	
	public Cliente buscaClienteSelecionadoJ(String documento){
		
		ClienteDAO clienteDao = new ClienteDAO();
		
		return clienteDao.buscaPorDocJ(documento);
		
	}
	
	public String trataDocumento(String doc){

		StringBuilder documento = new StringBuilder(doc); 
		
		if(doc.length() >= 3 && doc.length() < 6){
			documento.insert( 3, '.'); 
		
		}else if(doc.length() >= 6 && doc.length() < 9){
			documento.insert( 3, '.'); 
			documento.insert( 7, '.'); 
			
		}else if(doc.length() >= 9 && doc.length() <= 11)	{
			documento.insert( 3, '.'); 
			documento.insert( 7, '.'); 
			documento.insert( 11, '-'); 
		 
	  	}else if(doc.length() > 11){ 
			documento.insert( 2 , '.');  
			documento.insert( 6 , '.');
			documento.insert( 10 , '/');  
			documento.insert( 15 , '-');  
		}else{
			return doc;
		}
		return documento.toString();
		
	}
	
	public boolean verificaEspacoInterno(Veiculo v, Pedido pedido){
		
		float alturaCompartimentoCargaVeiculo = v.getAlturaCapacidadeCarga();
		float larguraCompCargaVeiculo         = v.getLarguraCapacidadeCarga();
		float comprimentoCompCargaVeiculo     = v.getCompCapacidadeCarga();
		float pesoMaxCarga                    = v.getPesoMaxCarga();
		
		float resultadoAltura = 0;
		float resultadoLargura = 0;
		float resultadoComp = 0;
		float resultadoPeso = 0;
		
		resultadoAltura  = alturaCompartimentoCargaVeiculo - pedido.getAltura();
		resultadoLargura = larguraCompCargaVeiculo - pedido.getLargura();
		resultadoComp    = comprimentoCompCargaVeiculo - pedido.getComprimento();
		resultadoPeso    = (pesoMaxCarga * 1000 )- pedido.getPeso();
		
		if( resultadoAltura >= 0 &&  resultadoLargura >= 0 && resultadoComp >= 0 && resultadoPeso >= 0){
			
			// SETA OS VALORES DE ESPAÇO DO VEICULO
			v.setAlturaCapacidadeCarga(resultadoAltura);
			v.setLarguraCapacidadeCarga(resultadoLargura);
			v.setCompCapacidadeCarga(resultadoComp);
			v.setPesoMaxCarga(resultadoPeso);
			
			// INSERE O VEICULO NA TABELA TEMPORARIA
			VeiculoController vc = new VeiculoController();
			
			return vc.iniciaEspacoInternoRestante(v);
			
		}
		
		return false;
	}
	
	public boolean verificaEspacoInternoRestante(Veiculo v, Pedido pedido){
		 
		float alturaCompartimentoCargaVeiculo = v.getAlturaCapacidadeCarga();
		float larguraCompCargaVeiculo         = v.getLarguraCapacidadeCarga();
		float comprimentoCompCargaVeiculo     = v.getCompCapacidadeCarga();
		float pesoMaxCarga                    = v.getPesoMaxCarga();
		
		float resultadoAltura = 0;
		float resultadoLargura = 0;
		float resultadoComp = 0;
		float resultadoPeso = 0;
		
		resultadoAltura  = alturaCompartimentoCargaVeiculo - pedido.getAltura();
		resultadoLargura = larguraCompCargaVeiculo - pedido.getLargura();
		resultadoComp    = comprimentoCompCargaVeiculo - pedido.getComprimento();
		resultadoPeso    = (pesoMaxCarga * 1000 )- pedido.getPeso();
	
		
		if( resultadoAltura >= 0 &&  resultadoLargura >= 0 && resultadoComp >= 0 && resultadoPeso >= 0){
			
			// ATUALIZA OS VALORES DE CAPACIDADES NO OBJETO VEICULO
			v.setAlturaCapacidadeCarga(resultadoAltura);
			v.setLarguraCapacidadeCarga(resultadoLargura);
			v.setCompCapacidadeCarga(resultadoComp);
			v.setPesoMaxCarga(resultadoPeso);
			
			// INSERE NOVOS VALORES DE ESPAÇOS NO VEICULO DA TABELA TEMPORARIA
			VeiculoController vc = new VeiculoController();
			
			return vc.atualizaEspacoInternoRestante(v);
			
		}
		
		return false;
	}
}
