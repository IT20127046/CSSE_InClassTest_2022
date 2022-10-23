
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Properties;

public class c1 {

	public static final Properties p = new Properties();
	public static final Logger log = Logger.getLogger(Exception.class.getName());

	static {
		try {
			p.load(c2.class.getResourceAsStream("../config/config.properties"));
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());

		}
	}
}
