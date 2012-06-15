package br.gov.serpro.app.producers;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Proxy criado para delegar funções ao verdadeiro {@link ResourceBundle} e implementar a interface
 * {@link Serializable}, que a classe {@link ResourceBundle} original não implementa. Ao não implementar
 * esta interface, o CDI impede a injeção de objetos desta classe, daí a necessidade do proxy.
 * 
 * @author 81986912515
 *
 */
public class ResourceBundleProxy extends ResourceBundle implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient java.util.ResourceBundle delegate;

	public ResourceBundleProxy(java.util.ResourceBundle resourceBundle) {
		this.delegate = resourceBundle;
	}

	@Override
	public boolean containsKey(String key) {
		return delegate.containsKey(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return delegate.getKeys();
	}

	@Override
	public Locale getLocale() {
		return delegate.getLocale();
	}

	@Override
	public Set<String> keySet() {
		return delegate.keySet();
	}

	@Override
	protected Object handleGetObject(String key) {
		Object result;

		try {
			Method method = delegate.getClass().getMethod("handleGetObject", String.class);

			method.setAccessible(true);
			result = method.invoke(delegate, key);
			method.setAccessible(false);

		} catch (Exception cause) {
			throw new RuntimeException(cause);
		}
		return result;
	}

}
