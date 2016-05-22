package controller;
import java.awt.Dialog;
import java.awt.JobAttributes.DialogType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BuscaCEP {
	
	
    public static String getEndereco(String CEP) throws IOException {

        try{

        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(70000)
                  .get();
        Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
        for (Element urlEndereco : urlPesquisa) {
                return urlEndereco.text();
        }

        } catch (SocketTimeoutException e) {
        	System.err.println(e);
        	CEP = "";
        } catch (HttpStatusException w) {
        	System.err.println(w);
        	CEP = "";
        } catch (UnknownHostException h){
        	System.err.println(h);
        	CEP = "";
        	
        }
        return CEP;
    }

    public static String getBairro(String CEP) throws IOException {

        try{

        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(70000)
                  .get();
        Elements urlPesquisa = doc.select("td:gt(1)");
        for (Element urlBairro : urlPesquisa) {
                return urlBairro.text();
        }

        } catch (SocketTimeoutException e) {
        	System.err.println(e);
        	CEP = "";
        } catch (HttpStatusException w) {
        	System.err.println(w);
        	CEP = "";
        } catch (UnknownHostException h){
        	System.err.println(h);
        	CEP = "";
        }
        return CEP;
    }

    public static String getCidade(String CEP) throws IOException {

        try{

        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(70000)
                  .get();
        Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
        for (Element urlCidade : urlPesquisa) {
                return urlCidade.text();
        }

        } catch (SocketTimeoutException e) {
        	System.err.println(e);
        	CEP = "";
        } catch (HttpStatusException w) {
        	System.err.println(w);
        	CEP = "";
        } catch (UnknownHostException h){
        	System.err.println(h);
        	CEP = "";
        }
        return CEP;
    }

    public static String getUF(String CEP) throws IOException {

        try{

        Document doc = Jsoup.connect("http://www.qualocep.com/busca-cep/"+CEP)
                  .timeout(70000)
                  .get();
        Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
        for (Element urlUF : urlPesquisa) {
        		
                return urlUF.text();
        }

        } catch (SocketTimeoutException e) {
        	System.err.println(e);
        	CEP = "";
        } catch (HttpStatusException w) {
        	System.err.println(w);
        	CEP = "";
        } catch (UnknownHostException h){
        	System.err.println(h);
        	CEP = "";
        }
        return CEP;
    }
}