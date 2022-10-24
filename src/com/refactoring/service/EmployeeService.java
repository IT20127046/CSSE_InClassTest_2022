package com.refactoring.service;

import com.refactoring.model.Employee;
import com.refactoring.util.CommonConstants;
import com.refactoring.util.CommonUtil;
import com.refactoring.util.DBConnectionUtil;
import com.refactoring.util.Query;
import com.refactoring.util.Transformation;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Abstract class for template method
 *
 */
public abstract class EmployeeService extends CommonUtil {
	
	abstract void setEmployees();
	abstract void createEmployeeTable();
	abstract void addEmployee();
	abstract void getEmployeeByID(String eid);
	abstract void deleteEmployee(String eid);
	abstract void getEmployees();
	abstract void diplayEmployees(ArrayList<Employee> employeeList);
	

	private static Connection connection;
	public static final Logger log = Logger.getLogger(EmployeeService.class.getName());

	/**
	 * Create EmployeeService constructor and build database connection
	 */

	public EmployeeService() {
		try {
			connection = DBConnectionUtil.getDBConnection();

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	
	   // Template method for get all employees 
	   public final void getAllEmployees() {
		   setEmployees();
		   createEmployeeTable();
		   addEmployee();
		   getEmployees();
	   }
	   
	   // Template method for get all employee by id
	   public final void getEmployeeById(String eid) {
		   setEmployees();
		   createEmployeeTable();
		   addEmployee();
		   getEmployeeByID(eid);
	   }
	   
	   // Template method for delete employee by id
	   public final void deleteEmployeeById(String eid) {
		   setEmployees();
		   createEmployeeTable();
		   addEmployee();
		   deleteEmployee(eid);
	   }
		
}
