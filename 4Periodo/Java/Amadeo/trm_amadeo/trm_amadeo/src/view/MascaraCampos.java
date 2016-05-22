package view;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class MascaraCampos {
	
	public void mascaraData(JFormattedTextField field)
    {   
        try {
             MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(field);
        } catch (Exception e) {
            System.out.println("Erro na mascara 1!");
        }
    }
    
    public void mascaraCPF(JFormattedTextField field){
        
        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.install(field);
        } catch (Exception e) {
        	System.out.println("Erro na mascara 2!");
        }
    }
    
    public void mascaraFoneRes(JFormattedTextField field){
        
        try {
            MaskFormatter foneResMask = new MaskFormatter("(##) ####-####");
            foneResMask.install(field);
        } catch (Exception e) {
        	System.out.println("Erro na mascara 3!");
        }
    }
    
    public void mascaraCEP(JFormattedTextField field){
        
        try {
            MaskFormatter cepMask = new MaskFormatter("#####-###");
            cepMask.install(field);
        } catch (Exception e) {
        	System.out.println("Erro na mascara 4!");
        }
    }
    
    public void mascaraVD(JFormattedTextField field){
        
        try {
            MaskFormatter placaMask = new MaskFormatter("###-####");
            placaMask.install(field);
        } catch (Exception e) {
        	System.out.println("Erro na mascara 5!");
        }
    }
    
    public void mascaraCNPJ(JFormattedTextField field){
        
        try {
            MaskFormatter cnpjMask = new MaskFormatter("##.###.###/####-##");
            cnpjMask.install(field);
        } catch (Exception e) {
        	System.out.println("Erro na mascara 6!");
        }
    }
    
    public void mascaraPlaca(JFormattedTextField field){
        
        try {
            MaskFormatter placaMask = new MaskFormatter("***-####");
            placaMask.install(field);
        } catch (Exception e) {
        	System.out.println("Erro na mascara 7!");
        }
    }
    
    public void mascaraRenavam(JFormattedTextField field){
        
        try {
            
            MaskFormatter renavamMask = new MaskFormatter("***********");
            renavamMask.setValidCharacters("0123456789");
            renavamMask.install(field);
            
        } catch (Exception e) {
        	System.out.println("Erro na mascara 8!");
        }
    }
    
    public void mascaraChassi(JFormattedTextField field){
        
        try {
            
            MaskFormatter chassiMask = new MaskFormatter("*****************");
            chassiMask.install(field);
            
        } catch (Exception e) {
        	System.out.println("Erro na mascara 9!");
        }
    }
    
    public void mascaraCnh(JFormattedTextField field){
        
        try {
            MaskFormatter cnhMask = new MaskFormatter("**********");
            cnhMask.install(field);
            
        } catch (Exception e) {
        	System.out.println("Erro na mascara 10!");
        }
		
    }
    
    public void mascaraFloat(JFormattedTextField field){
        
    	MaskFormatter moeda;
		try {
			moeda = new MaskFormatter("*****");
			moeda.setValidCharacters("0123456789."); 
	    	moeda.install(field);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    		
    }
    
    public void mascaraSoNumeros(JFormattedTextField field){
        
    	MaskFormatter numeros;
		try {
			numeros = new MaskFormatter("**************");
			numeros.setValidCharacters("0123456789"); 
			numeros.install(field);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    		
    }
    
    public void mascaraComprimentos(JFormattedTextField field){
        
    	MaskFormatter numeros;
		try {
			numeros = new MaskFormatter("**.**");
			numeros.setValidCharacters("0123456789"); 
			numeros.install(field);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    		
    }
    
public void mascaraDataPostagem(JFormattedTextField field){
        
    	MaskFormatter dataPostagem;
		try {
			dataPostagem = new MaskFormatter("##/##/####");
			dataPostagem.install(field);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    		
    }
    
    public void mascaraDataEntrega(JFormattedTextField field){
        
    	MaskFormatter dataEntrega;
		try {
			dataEntrega = new MaskFormatter("##/##/####");
			dataEntrega.install(field);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    		
    }

    
   
}
