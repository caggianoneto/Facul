/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ClienteDao;

/**
 *
 * @author NIB
 */
public class Cliente {
    
    //atributos do cliente
    
    private static int codigo = 0;
    private String cpf;
    private String rg;
    private String sexo;
    private String dataNasc;
    private String profissao;
    private String nacionalidade;
    private String estadoCivil;
    private String nomeCompleto;
    private String numeroCNH;
    private String telefoneCel;
    private String telefoneRes;
    
    
    // contrutor
    public Cliente(String cpf, String rg, String nomeCompleto, String numeroCNH, String sexo, String dataNasc, String nacionalidade, String estadoCivil,
             String profissao,String telefoneRes, String telefoneCel) {
        codigo++;
        this.cpf = cpf;
        this.rg = rg;
        this.nomeCompleto = nomeCompleto;
        this.numeroCNH = numeroCNH;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.nacionalidade = nacionalidade;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
        this.telefoneRes = telefoneRes;
        this.telefoneCel = telefoneCel;
        
        System.out.println("Criado um cliente com sucesso, codigo : "+codigo+" Nome : "+nomeCompleto+ "CPF "+ cpf);
    }

    // getters e setters :
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefoneCel() {
        return telefoneCel;
    }

    public void setTelefoneCel(String telefoneCel) {
        this.telefoneCel = telefoneCel;
    }

    public String getTelefoneRes() {
        return telefoneRes;
    }

    public void setTelefoneRes(String telefoneRes) {
        this.telefoneRes = telefoneRes;
    }
    
    
    
    // campos que terão apenas gets
    public static int getCodigo() {
        return codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public static void setCodigo(int codigo) {
        Cliente.codigo = codigo;
    }
    
    
    

    ClienteDao tCliente = new ClienteDao();
    
    
}
