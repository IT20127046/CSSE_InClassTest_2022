package com.refactoring.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Properties;

public class CommonUtil {

	public static final Properties properties = new Properties();
	public static final Logger log = Logger.getLogger(Exception.class.getName());

	static {
		try {
			properties.load(Query.class.getResourceAsStream("./config.properties"));
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
