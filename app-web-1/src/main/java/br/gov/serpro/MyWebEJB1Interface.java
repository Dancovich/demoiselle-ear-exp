package br.gov.serpro;

import javax.ejb.Local;

@Local
public interface MyWebEJB1Interface {

	public abstract String webMethod();

}