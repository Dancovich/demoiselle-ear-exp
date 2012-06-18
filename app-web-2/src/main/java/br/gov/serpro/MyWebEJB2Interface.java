package br.gov.serpro;

import javax.ejb.Local;

@Local
public interface MyWebEJB2Interface {

	public abstract String webMethod();

}