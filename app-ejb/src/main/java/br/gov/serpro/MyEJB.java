package br.gov.serpro;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class MyEJB implements Serializable,MyEJBInterface{

	private static final long serialVersionUID = 1L;

	@Inject
	private ResourceBundle bundle;

	public void method() {
		String mensagem = bundle.getString("app.web.mensagem");
		System.out.println(mensagem + " em MyEJB.");
	}
}
