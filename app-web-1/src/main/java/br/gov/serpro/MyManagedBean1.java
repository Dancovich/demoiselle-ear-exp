package br.gov.serpro;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class MyManagedBean1 implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private MyEJBInterface ejb;
	
	public void action() {
		String mensagem = "Mensagem do app 1";//bundle.getString("app.web.mensagem");
		System.out.println(mensagem + " em MyManagedBean 1.");

		ejb.method();
	}

}
