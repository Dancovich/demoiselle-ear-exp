package br.gov.serpro.app.producers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;


/**
 * This factory creates ResourceBundles with the application scopes.
 * 
 * @author SERPRO
 */
@ApplicationScoped
public class ResourceBundleProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	protected Locale locale;

	private final Map<String, ResourceBundle> map = new HashMap<String, ResourceBundle>();

	public ResourceBundleProducer() {
		this.locale = Locale.getDefault();
	}

	/**
	 * This constructor should be used by classes that can not inject ResourceBundle.
	 * 
	 * @param Locale
	 *            locale
	 */
	public ResourceBundleProducer(Locale locale) {
		this.locale = locale;
	}

	/**
	 * This method should be used by classes that can not inject ResourceBundle, to create the ResourceBundle.
	 * 
	 * @param String
	 *            baseName
	 */
	public ResourceBundle create(String baseName) {
		return getResourceBundle(baseName);
	}

	/**
	 * This method is the factory default for ResourceBundle. It creates the ResourceBundle based on a file called
	 * messages.properties.
	 */
	@Produces
	@Default
	public ResourceBundle create(InjectionPoint ip, Locale locale) {
		this.locale = locale;
		String baseName = "messages";
		return create(baseName);
	}

	/**
	 * This method checks if the bundle was created already. If the bundle has not been created, it creates and saves
	 * the bundle on a Map.
	 */
	private ResourceBundle getResourceBundle(String baseName) {
		ResourceBundle bundle = null;

		if (map.containsKey(baseName + "-" + this.locale)) {
			bundle = map.get(baseName + "-" + this.locale);

		} else {
			bundle = new ResourceBundleProxy(ResourceBundle.getBundle(baseName, this.locale));
			map.put(baseName + "-" + this.locale, bundle);
		}

		return bundle;
	}

}
