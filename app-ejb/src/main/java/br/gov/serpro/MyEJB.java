package br.gov.serpro;

import java.util.ResourceBundle;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MyEJB {

	@Inject
	private ResourceBundle bundle;

	public void method() {
		String mensagem = bundle.getString("app.web.mensagem");
		System.out.println(mensagem + " em MyEJB.");
	}
}
