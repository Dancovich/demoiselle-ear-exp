package br.gov.serpro;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class MyWebEJB1 implements MyWebEJB1Interface,Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String webMethod(){
		return "Retorno de EJB interno 1";
	}

}
