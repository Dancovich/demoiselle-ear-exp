package br.gov.serpro;

import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;

public class ResourceBundleProducer {
	
	public static @Produces ResourceBundle obterResourceBundle(){
		return ResourceBundle.getBundle("/messages");
	}

}
