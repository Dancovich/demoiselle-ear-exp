package br.gov.serpro.app.producers;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

public class LocaleProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Produces
	@Default
	public Locale create() {
		return Locale.getDefault();
	}

}