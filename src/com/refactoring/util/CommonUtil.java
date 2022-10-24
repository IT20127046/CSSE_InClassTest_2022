package com.refactoring.util;

import com.refactoring.service.EmployeeService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;

/**
 * This class is used to load all property details.
 */

public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(CommonUtil.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			// Read property when load class
			properties.load(Query.class.getResourceAsStream(CommonConstants.PROPERTIES_PATH));

		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());

		} catch (NumberFormatException e) {
			log.log(Level.SEVERE, e.getMessage());

		} catch (NullPointerException e) {
			log.log(Level.SEVERE, e.getMessage());

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());

		}
	}
}
