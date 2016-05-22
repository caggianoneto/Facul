/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author NIB2
 */
public class MaskFormater {
    
    public static void mascaraData(JFormattedTextField field)
    {
        try {
             MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(field);
        } catch (Exception e) {
            System.out.println("Erro!");
        }
    }
    
    public static void mascaraCPF(JFormattedTextField field){
        
        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.install(field);
        } catch (Exception e) {
            System.out.println("Erro!");
        }
    }
    
    public static void mascaraFoneRes(JFormattedTextField field){
        
        try {
            MaskFormatter foneResMask = new MaskFormatter("(##) ####-####");
            foneResMask.install(field);
        } catch (Exception e) {
            System.out.println("Erro!");
        }
    }
    
    public static void mascaraCEP(JFormattedTextField field){
        
        try {
            MaskFormatter cepMask = new MaskFormatter("#####-###");
            cepMask.install(field);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    
    public static void mascaraVD(JFormattedTextField field){
        
        try {
            MaskFormatter placaMask = new MaskFormatter("###-####");
            placaMask.install(field);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    
    public static void mascaraCNPJ(JFormattedTextField field){
        
        try {
            MaskFormatter cnpjMask = new MaskFormatter("##.###.###/###-##");
            cnpjMask.install(field);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    
    public static void mascaraPlaca(JFormattedTextField field){
        
        try {
            MaskFormatter placaMask = new MaskFormatter("***-####");
            placaMask.install(field);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    
    public static void mascaraRenavam(JFormattedTextField field){
        
        try {
            
            MaskFormatter renavamMask = new MaskFormatter("########-#");
            renavamMask.install(field);
            
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    
    public static void mascaraChassi(JFormattedTextField field){
        
        try {
            
            MaskFormatter chassiMask = new MaskFormatter("*****************");
            chassiMask.install(field);
            
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
    
    public static void mascaraCnh(JFormattedTextField field){
        
        try {
            MaskFormatter cnhMask = new MaskFormatter("**********");
            cnhMask.install(field);
            
        } catch (Exception e) {
            System.out.println("Erro");
        }
        
    }
}
