package br.gov.serpro;

import java.io.Serializable;

import javax.inject.Named;

@Named
public class MyBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String property;
	
	public MyBean(){
		property = "Valor padrão";
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	

}
