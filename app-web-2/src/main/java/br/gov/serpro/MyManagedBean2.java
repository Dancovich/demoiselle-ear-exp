package br.gov.serpro;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class MyManagedBean2 implements Serializable{

	private static final long serialVersionUID = 1L;

	/*@Inject
	private ResourceBundle bundle;

	@EJB
	private MyEJBInterface ejb;*/

	public void action() {
		String mensagem = "Teste!!!";//bundle.getString("app.web.mensagem");
		System.out.println(mensagem + " em MyManagedBean 2.");

		//ejb.method();
	}
}
