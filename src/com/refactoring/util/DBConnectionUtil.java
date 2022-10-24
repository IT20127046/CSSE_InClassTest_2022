package com.refactoring.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is use to create a database connection 
 */

public class DBConnectionUtil extends CommonUtil {
    private static Connection conn;

    // private constructor
    private DBConnectionUtil() {
	}

    /**
	 * Create a database connection
	 */

    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		
		if (conn == null || conn.isClosed()) {

			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			conn = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
		}
		return conn;
	}
    
}
