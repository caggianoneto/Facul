/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NIB
 */
public class Endereco {
    
    
    // atributos do endereco
    
    private int codigo;
    private String logradouro; 
    private String numero; 
    private String cep; 
    private String pais;
    private String cidade; 
    private String estado; 
    private String bairro;
    private String complemento; 

    
    // construtor
    public Endereco(int codigo, String logradouro, String numero, String cep, String cidade, String estado, String pais
            , String bairro) {
        this.codigo = codigo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.bairro = bairro;
       
        
        System.out.println("Cadastrado endereço com sucesso, codigo do Cliente/Fornecedor : "+codigo);
        System.out.println("Rua "+logradouro+" numero "+numero);
    }
    
    
    // getters e setters
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    public int getCodigo() {
        return codigo;
    }

    public String getPais() {
        return pais;
    }
    
    
    
    
    
}
