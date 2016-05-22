package controller;

import java.util.ArrayList;

import model.Pedido;
import dao.PedidoDAO;

public class PedidoController {

	PedidoDAO pedidoDao;
	
	public boolean cadastraPedido(Pedido pedido){
		pedidoDao = new PedidoDAO();
		
		if(pedidoDao.inserePedido(pedido))
			return true;
		else
			return false;	
	}
	
	public ArrayList<Pedido> buscaPedidosEncaminhados(String status){
		pedidoDao = new PedidoDAO();
		
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		listaPedidos = pedidoDao.buscaEncaminhados(status);
			
		return listaPedidos;
	}
	
	public boolean mudaStatusPedido(int idVeiculo, String status){
		
		if(pedidoDao.mudaStatusPorIdVeiculo(idVeiculo, status ))
			return true;
		else
			return false;	
		
	}
	
	public boolean finalizaPedido(int idPedido){
		
		if(pedidoDao.finalizaPedido(idPedido))
			return true;
		else
			return false;	
		
	}
}
