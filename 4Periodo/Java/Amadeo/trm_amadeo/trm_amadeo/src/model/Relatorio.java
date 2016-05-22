package model;

import java.util.Date;

import javax.xml.crypto.Data;

public class Relatorio {

	// Atributos veiculo relatorio
	private int idVeiculo;
	private String valor;
	private String placa;
	private String renavam;
	private String comboTipoVeiculo;
	private float tara; 
	private float compCapacidadeCarga; 
	private float larguraCapacidadeCarga; 
	private float alturaCapacidadeCarga; 
	private String marcaModelo;
	private String combustivel;
	private float pesoMaxCarga; 
	private int numeroEixos; 
	private int capacidadeTanqueComb;
	private int statusVeiculo;
	private int anoFabricacao;
	private int vinculoFrota;
	
	private int statusRelatorio;
	
	// Atributos frotas relatorio
	
	private int idFrota;
	private int qtd_veiculos;
	private int qtd_veiculos_disponivel;
	private int entregas_realizadas;
	private int entrega_em_progresso;
	private int entrega_nao_finalizada;
	private int regiao;
	
	// Atributos Pedidos
	
	private int idPedido;
	private Date dta_cadastro;
	private Date dta_entrega;
	private String statusPedido;
	private String justificativaPedido;
	private Float compPedido;
	private Float altPedido;
	private Float largPedido;
	private Float pesoPedido;
	private int prazoEntregaPedido;
	private String dt_pedidoRelatorio;
	private String dt_entregaRelatorio;
	private String nome_dest;
	
	
	// atributos cliente fisica
	private int idClienteFisica;
	private String nome;
	private String cpf;
	private String rg;
	private String emailFisica;
	private String enderecoFisica;
	private String numeroFisica;
	private String complementoFisica;
	private String bairroFisica;
	private String cepFisica;
	private String cidadeFisica;
	private String estadoFisica;
	private String telefoneUmFisica;
	private String telefoneDoisFisica;
	
	
	// atributos cliente juridica
	private int idClienteJuridica;
	private String RazaoSocial;
	private String cnpf;
	private String ie;
	private String im;
	private String contato;
	private String emailJuridica;
	private String enderecoJuridica;
	private String numeroJuridica;
	private String complementoJuridica;
	private String bairroJuridica;
	private String cepJuridica;
	private String cidadeJuridica;
	private String estadoJuridica;
	private String telefoneUmJuridica;
	private String telefoneDoisJuridica;
	private String comboBoxTipoPessoa;
	private String comboBoxTipoCliente;
	
	// atributos destinatario

	private int idDest;
	private String nomeDest;
	private String cpfcnpj;
	private String telefoneUmDestinatario;
	private String telefoneDoisDestinatario;
	private String endecoDestinatario;
	private String numeroDestinatario;
	private String complementoDestinatario;
	private String bairroDestinatario;
	private String cepDestinatario;
	private String cidadeDestinatario;
	private String estadoDestinatario;
	
	

	
	
	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getComboTipoVeiculo() {
		return comboTipoVeiculo;
	}

	public void setComboTipoVeiculo(String comboTipoVeiculo) {
		this.comboTipoVeiculo = comboTipoVeiculo;
	}

	public float getTara() {
		return tara;
	}

	public void setTara(float tara) {
		this.tara = tara;
	}

	public float getCompCapacidadeCarga() {
		return compCapacidadeCarga;
	}

	public void setCompCapacidadeCarga(float compCapacidadeCarga) {
		this.compCapacidadeCarga = compCapacidadeCarga;
	}

	public float getLarguraCapacidadeCarga() {
		return larguraCapacidadeCarga;
	}

	public void setLarguraCapacidadeCarga(float larguraCapacidadeCarga) {
		this.larguraCapacidadeCarga = larguraCapacidadeCarga;
	}

	public float getAlturaCapacidadeCarga() {
		return alturaCapacidadeCarga;
	}

	public void setAlturaCapacidadeCarga(float alturaCapacidadeCarga) {
		this.alturaCapacidadeCarga = alturaCapacidadeCarga;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public float getPesoMaxCarga() {
		return pesoMaxCarga;
	}

	public void setPesoMaxCarga(float pesoMaxCarga) {
		this.pesoMaxCarga = pesoMaxCarga;
	}

	public int getNumeroEixos() {
		return numeroEixos;
	}

	public void setNumeroEixos(int numeroEixos) {
		this.numeroEixos = numeroEixos;
	}

	public int getCapacidadeTanqueComb() {
		return capacidadeTanqueComb;
	}

	public void setCapacidadeTanqueComb(int capacidadeTanqueComb) {
		this.capacidadeTanqueComb = capacidadeTanqueComb;
	}

	public int getStatusVeiculo() {
		return statusVeiculo;
	}

	public void setStatusVeiculo(int statusVeiculo) {
		this.statusVeiculo = statusVeiculo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getVinculoFrota() {
		return vinculoFrota;
	}

	public void setVinculoFrota(int vinculoFrota) {
		this.vinculoFrota = vinculoFrota;
	}

	public int getIdFrota() {
		return idFrota;
	}

	public void setIdFrota(int idFrota) {
		this.idFrota = idFrota;
	}

	public int getQtd_veiculos() {
		return qtd_veiculos;
	}

	public void setQtd_veiculos(int qtd_veiculos) {
		this.qtd_veiculos = qtd_veiculos;
	}

	public int getQtd_veiculos_disponivel() {
		return qtd_veiculos_disponivel;
	}

	public void setQtd_veiculos_disponivel(int qtd_veiculos_disponivel) {
		this.qtd_veiculos_disponivel = qtd_veiculos_disponivel;
	}

	public int getEntregas_realizadas() {
		return entregas_realizadas;
	}

	public void setEntregas_realizadas(int entregas_realizadas) {
		this.entregas_realizadas = entregas_realizadas;
	}

	public int getEntrega_em_progresso() {
		return entrega_em_progresso;
	}

	public void setEntrega_em_progresso(int entrega_em_progresso) {
		this.entrega_em_progresso = entrega_em_progresso;
	}

	public int getEntrega_nao_finalizada() {
		return entrega_nao_finalizada;
	}

	public void setEntrega_nao_finalizada(int entrega_nao_finalizada) {
		this.entrega_nao_finalizada = entrega_nao_finalizada;
	}

	public int getRegiao() {
		return regiao;
	}

	public void setRegiao(int regiao) {
		this.regiao = regiao;
	}

	public int getStatusRelatorio() {
		return statusRelatorio;
	}

	public void setStatusRelatorio(int statusRelatorio) {
		this.statusRelatorio = statusRelatorio;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDta_cadastro() {
		return dta_cadastro;
	}

	public void setDta_cadastro(Date dta_cadastro) {
		this.dta_cadastro = dta_cadastro;
	}

	public Date getDta_entrega() {
		return dta_entrega;
	}

	public void setDta_entrega(Date dta_entrega) {
		this.dta_entrega = dta_entrega;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public String getJustificativaPedido() {
		return justificativaPedido;
	}

	public void setJustificativaPedido(String justificativaPedido) {
		this.justificativaPedido = justificativaPedido;
	}

	public Float getCompPedido() {
		return compPedido;
	}

	public void setCompPedido(Float compPedido) {
		this.compPedido = compPedido;
	}

	public Float getAltPedido() {
		return altPedido;
	}

	public void setAltPedido(Float altPedido) {
		this.altPedido = altPedido;
	}

	public Float getLargPedido() {
		return largPedido;
	}

	public void setLargPedido(Float largPedido) {
		this.largPedido = largPedido;
	}

	public Float getPesoPedido() {
		return pesoPedido;
	}

	public void setPesoPedido(Float pesoPedido) {
		this.pesoPedido = pesoPedido;
	}

	public int getPrazoEntregaPedido() {
		return prazoEntregaPedido;
	}

	public void setPrazoEntregaPedido(int prazoEntregaPedido) {
		this.prazoEntregaPedido = prazoEntregaPedido;
	}

	public String getNome_dest() {
		return nome_dest;
	}

	public void setNome_dest(String nome_dest) {
		this.nome_dest = nome_dest;
	}

	public int getIdClienteFisica() {
		return idClienteFisica;
	}

	public void setIdClienteFisica(int idClienteFisica) {
		this.idClienteFisica = idClienteFisica;
	}

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

	public String getEmailFisica() {
		return emailFisica;
	}

	public void setEmailFisica(String emailFisica) {
		this.emailFisica = emailFisica;
	}

	public String getEnderecoFisica() {
		return enderecoFisica;
	}

	public void setEnderecoFisica(String enderecoFisica) {
		this.enderecoFisica = enderecoFisica;
	}

	public String getNumeroFisica() {
		return numeroFisica;
	}

	public void setNumeroFisica(String numeroFisica) {
		this.numeroFisica = numeroFisica;
	}

	public String getComplementoFisica() {
		return complementoFisica;
	}

	public void setComplementoFisica(String complementoFisica) {
		this.complementoFisica = complementoFisica;
	}

	public String getBairroFisica() {
		return bairroFisica;
	}

	public void setBairroFisica(String bairroFisica) {
		this.bairroFisica = bairroFisica;
	}

	public String getCepFisica() {
		return cepFisica;
	}

	public void setCepFisica(String cepFisica) {
		this.cepFisica = cepFisica;
	}

	public String getCidadeFisica() {
		return cidadeFisica;
	}

	public void setCidadeFisica(String cidadeFisica) {
		this.cidadeFisica = cidadeFisica;
	}

	public String getEstadoFisica() {
		return estadoFisica;
	}

	public void setEstadoFisica(String estadoFisica) {
		this.estadoFisica = estadoFisica;
	}

	public String getTelefoneUmFisica() {
		return telefoneUmFisica;
	}

	public void setTelefoneUmFisica(String telefoneUmFisica) {
		this.telefoneUmFisica = telefoneUmFisica;
	}

	public String getTelefoneDoisFisica() {
		return telefoneDoisFisica;
	}

	public void setTelefoneDoisFisica(String telefoneDoisFisica) {
		this.telefoneDoisFisica = telefoneDoisFisica;
	}

	public int getIdClienteJuridica() {
		return idClienteJuridica;
	}

	public void setIdClienteJuridica(int idClienteJuridica) {
		this.idClienteJuridica = idClienteJuridica;
	}

	public String getCnpf() {
		return cnpf;
	}

	public void setCnpf(String cnpf) {
		this.cnpf = cnpf;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getIm() {
		return im;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmailJuridica() {
		return emailJuridica;
	}

	public void setEmailJuridica(String emailJuridica) {
		this.emailJuridica = emailJuridica;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}

	public String getEnderecoJuridica() {
		return enderecoJuridica;
	}

	public void setEnderecoJuridica(String enderecoJuridica) {
		this.enderecoJuridica = enderecoJuridica;
	}

	public String getComplementoJuridica() {
		return complementoJuridica;
	}

	public void setComplementoJuridica(String complementoJuridica) {
		this.complementoJuridica = complementoJuridica;
	}

	public String getBairroJuridica() {
		return bairroJuridica;
	}

	public void setBairroJuridica(String bairroJuridica) {
		this.bairroJuridica = bairroJuridica;
	}

	public String getCepJuridica() {
		return cepJuridica;
	}

	public void setCepJuridica(String cepJuridica) {
		this.cepJuridica = cepJuridica;
	}

	public String getCidadeJuridica() {
		return cidadeJuridica;
	}

	public void setCidadeJuridica(String cidadeJuridica) {
		this.cidadeJuridica = cidadeJuridica;
	}

	public String getEstadoJuridica() {
		return estadoJuridica;
	}

	public void setEstadoJuridica(String estadoJuridica) {
		this.estadoJuridica = estadoJuridica;
	}

	public String getTelefoneUmJuridica() {
		return telefoneUmJuridica;
	}

	public void setTelefoneUmJuridica(String telefoneUmJuridica) {
		this.telefoneUmJuridica = telefoneUmJuridica;
	}

	public String getTelefoneDoisJuridica() {
		return telefoneDoisJuridica;
	}

	public void setTelefoneDoisJuridica(String telefoneDoisJuridica) {
		this.telefoneDoisJuridica = telefoneDoisJuridica;
	}

	public String getComboBoxTipoPessoa() {
		return comboBoxTipoPessoa;
	}

	public void setComboBoxTipoPessoa(String comboBoxTipoPessoa) {
		this.comboBoxTipoPessoa = comboBoxTipoPessoa;
	}

	public String getComboBoxTipoCliente() {
		return comboBoxTipoCliente;
	}

	public void setComboBoxTipoCliente(String comboBoxTipoCliente) {
		this.comboBoxTipoCliente = comboBoxTipoCliente;
	}

	public String getNumeroJuridica() {
		return numeroJuridica;
	}

	public void setNumeroJuridica(String numeroJuridica) {
		this.numeroJuridica = numeroJuridica;
	}

	public String getDt_pedidoRelatorio() {
		return dt_pedidoRelatorio;
	}

	public void setDt_pedidoRelatorio(String dt_pedidoRelatorio) {
		this.dt_pedidoRelatorio = dt_pedidoRelatorio;
	}

	public String getDt_entregaRelatorio() {
		return dt_entregaRelatorio;
	}

	public void setDt_entregaRelatorio(String dt_entregaRelatorio) {
		this.dt_entregaRelatorio = dt_entregaRelatorio;
	}

	public int getIdDest() {
		return idDest;
	}

	public void setIdDest(int idDest) {
		this.idDest = idDest;
	}

	public String getNomeDest() {
		return nomeDest;
	}

	public void setNomeDest(String nomeDest) {
		this.nomeDest = nomeDest;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getTelefoneUmDestinatario() {
		return telefoneUmDestinatario;
	}

	public void setTelefoneUmDestinatario(String telefoneUmDestinatario) {
		this.telefoneUmDestinatario = telefoneUmDestinatario;
	}

	public String getTelefoneDoisDestinatario() {
		return telefoneDoisDestinatario;
	}

	public void setTelefoneDoisDestinatario(String telefoneDoisDestinatario) {
		this.telefoneDoisDestinatario = telefoneDoisDestinatario;
	}

	public String getEndecoDestinatario() {
		return endecoDestinatario;
	}

	public void setEndecoDestinatario(String endecoDestinatario) {
		this.endecoDestinatario = endecoDestinatario;
	}

	public String getNumeroDestinatario() {
		return numeroDestinatario;
	}

	public void setNumeroDestinatario(String numeroDestinatario) {
		this.numeroDestinatario = numeroDestinatario;
	}

	public String getComplementoDestinatario() {
		return complementoDestinatario;
	}

	public void setComplementoDestinatario(String complementoDestinatario) {
		this.complementoDestinatario = complementoDestinatario;
	}

	public String getBairroDestinatario() {
		return bairroDestinatario;
	}

	public void setBairroDestinatario(String bairroDestinatario) {
		this.bairroDestinatario = bairroDestinatario;
	}

	public String getCepDestinatario() {
		return cepDestinatario;
	}

	public void setCepDestinatario(String cepDestinatario) {
		this.cepDestinatario = cepDestinatario;
	}

	public String getCidadeDestinatario() {
		return cidadeDestinatario;
	}

	public void setCidadeDestinatario(String cidadeDestinatario) {
		this.cidadeDestinatario = cidadeDestinatario;
	}

	public String getEstadoDestinatario() {
		return estadoDestinatario;
	}

	public void setEstadoDestinatario(String estadoDestinatario) {
		this.estadoDestinatario = estadoDestinatario;
	}
	
	
	
	
}
