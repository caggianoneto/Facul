/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NIB
 */
public class Fornecedor {
    
    //atributos do fornecedor
        private static int codigo = 0;
        private String cnpj;
        private String razaoSocial;
        private String nomeFantasia;        
        private String telefone1;    
        private String telefone2;
        private String ie;
        private String vendedor;
        private String email;

        
        // construtor
    public Fornecedor(String cnpj, String razaoSocial, String nomeFantasia, String ie) {
        codigo++;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.ie = ie;
        
        System.out.println("Criado um fornecedor com sucesso, codigo : "+codigo+" Nome : "+nomeFantasia);
    }
    
    
    //getters e setters:
    
    public int getCodigo() {
        return codigo;
    }  

    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
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

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void setCodigo(int codigo) {
        Fornecedor.codigo = codigo;
    }
    
    
    
    
        
        
}
