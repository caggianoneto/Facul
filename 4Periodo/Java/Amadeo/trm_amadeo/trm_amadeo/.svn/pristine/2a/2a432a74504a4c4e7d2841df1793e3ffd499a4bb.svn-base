package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

import view.PainelPrincipal;
import dao.ClienteDAO;
import dao.DestinatarioDAO;
import model.Cliente;
import model.Endereco;
import model.Destinatario;

public class ClienteDestinatarioController {
	
	// ATRIBUTOS DE CLIENTE / DESTINATARIO
	private int tipoCliente;
	private int tipoPessoa;
	private String cnpj;
	private String cpf;
	private String rg;
	private String nome;
	private String Ie;
	private String Im;
	private String contato;
	private String email;
	private String razaoSocial;
	private Date dataNascFund;
	private Cliente cliente;
	private ClienteDAO clienteDao;
	private Destinatario destinatario;
	private DestinatarioDAO destinatarioDao;
	
	// ATRIBUTOS DE ENDERECO
	private String endereco;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;
	private String bairro;
	private String complemento;
	private String telefone1;
	private String telefone2;
	private Endereco enderecoCliente;
	
	// CONSTRUTOR PADRAO
	public ClienteDestinatarioController(){}
	
	public boolean init(ClienteDestinatarioController clienteDestinatario, ClienteDestinatarioController endereco){
		
		switch (clienteDestinatario.tipoCliente) {
		case 0:
			try {
				enderecoCliente = endereco.ValidaEndereco(endereco);
				cliente = clienteDestinatario.ValidaCliente(clienteDestinatario);
				
				// INSTANCIA CLIENTE-DAO PARA INCLUSAO NO BANCO
				clienteDao = new ClienteDAO();
				
				if(cliente.getTipoPessoa() == 0){
				   if(clienteDao.inclusaoFisica(cliente, enderecoCliente)){
					   return true;
				   }else{
					   return false;
				   }
				}else{
					if(clienteDao.inclusaoJuridica(cliente, enderecoCliente)){
						   return true;
					   }else{
						   return false;
					   }
				}
			}catch (Exception e) {
				return false;
			}

		case 1:
			try {
				enderecoCliente = endereco.ValidaEndereco(endereco);
				destinatario = clienteDestinatario.ValidaDestinatario(clienteDestinatario);
				
				// INSTANCIA DESTINATARIO-DAO PARA INCLUSAO NO BANCO
				destinatarioDao = new DestinatarioDAO();
				if(destinatario.getTipoPessoa() == 0){
					if(destinatarioDao.inclusaoDestinatarioF(destinatario, enderecoCliente)){
						return true;
					}else{
						return false;
					}
				}else{
					if(destinatarioDao.inclusaoDestinatarioJ(destinatario, enderecoCliente)){
						return true;
					}else{
						return false;
					}
				}
			}catch (Exception e) {
				return false;
			}
		}
		
		return true;
	}

	private Endereco ValidaEndereco(ClienteDestinatarioController end){
		
		 enderecoCliente = new Endereco(end.endereco, end.numero, end.cep, end.cidade, end.estado);
		 enderecoCliente.setComplemento(end.complemento);
		 enderecoCliente.setBairro(end.bairro);
		 enderecoCliente.setNumero(end.numero);
		 enderecoCliente.setTelefone1(end.telefone1);
		 enderecoCliente.setTelefone2(end.telefone2);
		 return enderecoCliente;
	}
	
	private Cliente ValidaCliente(ClienteDestinatarioController obj){
	    Cliente cliFj;
		// 0 = PESSOA FÍSICA
		if(obj.tipoPessoa == 0){
			Cliente clienteF = new Cliente( obj.cpf, obj.rg, obj.nome, obj.dataNascFund);
			clienteF.setEmail(obj.email);
			clienteF.setTipoCliente(obj.tipoCliente);
			clienteF.setTipoPessoa(obj.tipoPessoa);
			cliFj = clienteF;
		// 0 = PESSOA JURIDICA	
		}else{
			Cliente clienteJ = new Cliente( obj.razaoSocial, obj.cnpj, obj.Ie);
			clienteJ.setInscricaoMunicipal(obj.Im);
			clienteJ.setNomeContato(obj.contato);
			clienteJ.setEmail(obj.email);
			clienteJ.setTipoCliente(obj.tipoCliente);
			clienteJ.setTipoPessoa(obj.tipoPessoa);
			cliFj = clienteJ;
		}
		
		return cliFj;
	}
	
	private Destinatario ValidaDestinatario(ClienteDestinatarioController obj){
		
		destinatario = new Destinatario();
		
		// DESTINATARIO PESSOA FISICA
		if(obj.tipoPessoa == 0){
			
			destinatario.setNome(obj.nome);
			destinatario.setCpf(obj.cpf);
			destinatario.setRg(obj.rg);
			destinatario.setTipoCliente(obj.tipoCliente);
			destinatario.setTipoPessoa(obj.tipoPessoa);
		// DESTINATARIO PESSOA JURIDICA	
		}else{
			
			destinatario.setRazaoSocial(obj.razaoSocial);
			destinatario.setCnpj(obj.cnpj);
			destinatario.setInscricaoEstadual(obj.Ie);
			destinatario.setInscricaoMunicipal(obj.Im);
			destinatario.setNomeContato(obj.contato);
			destinatario.setEmail(obj.email);
			destinatario.setTipoCliente(obj.tipoCliente);
			destinatario.setTipoPessoa(obj.tipoPessoa);
		}
		
		return destinatario;	
	}
	
	public boolean calculaIdade(String dataNasc){

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;

		try {

		data= dateFormat.parse(dataNasc);

		} catch (Exception e) {}


		Calendar dataDeNsc = new GregorianCalendar();

		dataDeNsc.setTime(data);

		// Cria um objeto calendar com a data atual

		Calendar hoje = Calendar.getInstance();

		// Obtém a idade baseado no ano

		int idade = hoje.get(Calendar.YEAR) - dataDeNsc.get(Calendar.YEAR);

		dataDeNsc.add(Calendar.YEAR, idade);

		if (hoje.before(dataDeNsc)) {

			idade--;

		}
		
		if(idade >= 18){
			return true;
		}

		return false;
	}

	public ArrayList<Cliente> buscaCliente(){
		
		clienteDao = new ClienteDAO();
		return clienteDao.buscaCliente();
		
	}
	
	public int verificaRegiaoRemSelecionado(int codRem){
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();	
		
		clientes = buscaCliente();
		int idRegiao = -1;
		
		// PEGA A REGIAO DO CLIENTE SELECIONADO
		for (int i = 0; i < clientes.size(); i++) {
			
			if(clientes.get(i).getIdCliente() == codRem){
				idRegiao = clienteDao.buscaIdPorRegiaoRemF(codRem);
			}
		}
		
		// VERIFICA SE NAO ENCONTROU A REGIAO DO CLIENTE E TENTA PARA O TIPO CLIENTE_J
		if(idRegiao == -1){
			for (int i = 0; i < clientes.size(); i++) {
				
				if(clientes.get(i).getIdCliente() == codRem){
					idRegiao = clienteDao.buscaIdPorRegiaoRemj(codRem);
				}
			}
		}
		return idRegiao;
		
	}
	
	
	// GETTERS AND SETTERS
	public int getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public int getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIe() {
		return Ie;
	}

	public void setIe(String ie) {
		Ie = ie;
	}

	public String getIm() {
		return Im;
	}

	public void setIm(String im) {
		Im = im;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Date getDataNascFund() {
		return dataNascFund;
	}

	public void setDataNascFund(Date dataNascFund) {
		this.dataNascFund = dataNascFund;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDAO getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public DestinatarioDAO getDestinatarioDao() {
		return destinatarioDao;
	}

	public void setDestinatarioDao(DestinatarioDAO destinatarioDao) {
		this.destinatarioDao = destinatarioDao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public Endereco getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(Endereco enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	
	
		
	

}
