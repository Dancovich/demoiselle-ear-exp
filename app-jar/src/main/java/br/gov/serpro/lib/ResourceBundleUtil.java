package br.gov.serpro.lib;

import java.util.ResourceBundle;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

public class ResourceBundleUtil {

	@Produces
	@Default
	public static ResourceBundle getResourceBundle() {
		return ResourceBundle.getBundle("messages");
	}

}
