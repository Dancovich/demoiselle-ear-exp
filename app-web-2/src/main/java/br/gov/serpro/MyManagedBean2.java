package br.gov.serpro;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class MyManagedBean2 {

	@Inject
	private ResourceBundle bundle;

	@Inject
	private MyEJB ejb;

	public void action() {
		String mensagem = bundle.getString("app.web.mensagem");
		System.out.println(mensagem + " em MyManagedBean 2.");

		ejb.method();
	}
}
