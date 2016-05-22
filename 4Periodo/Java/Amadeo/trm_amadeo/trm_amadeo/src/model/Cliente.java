package model;

import java.util.Date;

public class Cliente{
		
		// ATRIBUTOS DE CLIENTE PF
		private int idCliente;
		private String nome;
		private String cpf;
		private String rg;
		// ATRIBUTOS DE CLIENTE PJ
		private String razaoSocial;
		private String cnpj;
		private String nomeFantasia;
		private String inscricaoEstadual;
		private String inscricaoMunicipal;
		// ATRIBUTOS VALIDOS PARA AMBOS
		private int tipoCliente;
		private int tipoPessoa;
		private Date dataNascFund;
		private String nomeContato;
		private String email;
	    
	    // CONSTRUTOR PADRÃO
	    public Cliente() {}
	    
	    // CONSTRUTOR CLIENTE PF
 		public Cliente(String cpf, String rg, String nome, Date dataNascFund) {
 			this.cpf = cpf;
 			this.rg = rg;
 			this.nome = nome;
 			this.dataNascFund = dataNascFund;
 		}
	    
	    // CONSTRUTOR CLIENTE PJ
		public Cliente(String razaoSocial, String cnpj, String inscricaoEstadual) {
	
			this.razaoSocial = razaoSocial;
			this.cnpj = cnpj;
			this.inscricaoEstadual = inscricaoEstadual;

		}
		
		// getter e setters
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
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

		public String getRazaoSocial() {
			return razaoSocial;
		}

		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getNomeFantasia() {
			return nomeFantasia;
		}

		public void setNomeFantasia(String nomeFantasia) {
			this.nomeFantasia = nomeFantasia;
		}

		public String getInscricaoEstadual() {
			return inscricaoEstadual;
		}

		public void setInscricaoEstadual(String inscricaoEstadual) {
			this.inscricaoEstadual = inscricaoEstadual;
		}

		public String getInscricaoMunicipal() {
			return inscricaoMunicipal;
		}

		public void setInscricaoMunicipal(String inscricaoMunicipal) {
			this.inscricaoMunicipal = inscricaoMunicipal;
		}

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

		public Date getDataNascFund() {
			return dataNascFund;
		}

		public void setDataNascFund(Date dataNascFund) {
			this.dataNascFund = dataNascFund;
		}

		public String getNomeContato() {
			return nomeContato;
		}

		public void setNomeContato(String nomeContato) {
			this.nomeContato = nomeContato;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}
		
	
		
}
