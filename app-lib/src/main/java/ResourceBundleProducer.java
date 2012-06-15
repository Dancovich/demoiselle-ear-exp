import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;


public class ResourceBundleProducer {
	
	@Produces
	public static ResourceBundle produce(){
		return ResourceBundle.getBundle("/messages");
	}

}
