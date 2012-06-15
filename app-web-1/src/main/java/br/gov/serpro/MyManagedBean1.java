package br.gov.serpro;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class MyManagedBean1 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResourceBundle bundle;

	@EJB
	private MyEJBInterface ejb;
	
	public void action() {
		String mensagem = bundle.getString("app.web.mensagem");
		System.out.println(mensagem + " em MyManagedBean 1.");

		ejb.method();
	}

}
