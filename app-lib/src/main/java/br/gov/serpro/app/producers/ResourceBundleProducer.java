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
	 * @param ClassLoader classLoader
	 */
	public ResourceBundle create(String baseName,ClassLoader classLoader) {
		return getResourceBundle(baseName,classLoader);
	}

	/**
	 * This method is the factory default for ResourceBundle. It creates the ResourceBundle based on a file called
	 * messages.properties.
	 */
	@Produces
	@Default
	public ResourceBundle create(InjectionPoint ip, Locale locale) {
		//Armazena o classloader do ponto de injeção, usaremos este classloader para ler o resource.
		ClassLoader classLoader;
		
		try{
			classLoader = ip.getBean().getBeanClass().getClassLoader();
		}
		catch(Throwable t){
			classLoader = this.getClass().getClassLoader();
		}
		
		this.locale = locale;
		String baseName = "messages";
		return create(baseName,classLoader);
	}

	/**
	 * This method checks if the bundle was created already. If the bundle has not been created, it creates and saves
	 * the bundle on a Map.
	 */
	private ResourceBundle getResourceBundle(String baseName,ClassLoader classLoader) {
		ResourceBundle bundle = null;

		if (map.containsKey(baseName + "-" + this.locale)) {
			bundle = map.get(baseName + "-" + this.locale);

		} else {
			bundle = new ResourceBundleProxy(ResourceBundle.getBundle(baseName, this.locale,classLoader));
			map.put(baseName + "-" + this.locale, bundle);
		}

		return bundle;
	}

}
