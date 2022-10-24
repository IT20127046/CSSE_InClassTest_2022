package com.refactoring.service;

import com.refactoring.model.Employee;
import com.refactoring.util.CommonConstants;
import com.refactoring.util.CommonUtil;
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

public class EmployeeService extends CommonUtil {

	private final ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private static Connection connection;
	private static Statement statement;
	private PreparedStatement preparedStatement;
	public static final Logger log = Logger.getLogger(EmployeeService.class.getName());

	/**
	 * Create EmployeeService constructor 
	 */
	public EmployeeService() {
		try {
			Class.forName(CommonConstants.CLASSNAME);
			connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Store employees details to Map
	 * 
	 * @throws ParserConfigurationException - Indicates a serious configuration error
	 * @throws SAXException - Encapsulate a general SAX error or warning
	 * @throws IOException - Exception produced by failed or interrupted I/O operations
	 * @throws NumberFormatException - 
	 * @throws XPathExpressionException - 
	 *
	 */
	public void setEmployees() {

		try {
			int XMLSize = Transformation.xmlPaths().size();
			for (int i = 0; i < XMLSize; i++) {
				Map<String, String> l = Transformation.xmlPaths().get(i);
				Employee Employee = new Employee();
				Employee.setEmployeeId(l.get(CommonConstants.XPATH_EMPLOYEE_ID));
				Employee.setFullName(l.get(CommonConstants.XPATH_EMPLOYEE_FULLNAME));
				Employee.setAddress(l.get(CommonConstants.XPATH_EMPLOYEE_ADDRESS));
				Employee.setFacultyName(l.get(CommonConstants.XPATH_EMPLOYEE_ADDRESS));
				Employee.setDepartment(l.get(CommonConstants.XPATH_EMPLOYEE_DEPARTMENT));
				Employee.setDesignation(l.get(CommonConstants.XPATH_EMPLOYEE_DESIGNATION));
				employeeList.add(Employee);
				System.out.println(Employee.toString() + CommonConstants.LINE_BREAK);
			}
		} catch (ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (NumberFormatException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (XPathExpressionException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Drop the Employees table and recreate table structure
	 * 
	 * @throws SQLException - Thrown when database access error occurs or this method is called on a closed connection
	 *                          
	 */
	public void createEmployeeTable() {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(Query.queryById(CommonConstants.QUERY_ID_DROP_TABLE));
			statement.executeUpdate(Query.queryById(CommonConstants.QUERY_ID_CREATE_TABLE));
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add employees to the employeeList
	 * 
	 * @throws SQLException - Thrown when database access error occurs or this method is called on a closed connection
	 */
	public void addEmployee() {
		try {
			preparedStatement = connection.prepareStatement(Query.queryById(CommonConstants.QUERY_ID_INSERT));
			connection.setAutoCommit(false);
			for (Employee employee : employeeList) {
				preparedStatement.setString(1, employee.getEmployeeId());
				preparedStatement.setString(2, employee.getFullName());
				preparedStatement.setString(3, employee.getAddress());
				preparedStatement.setString(4, employee.getFacultyName());
				preparedStatement.setString(5, employee.getDepartment());
				preparedStatement.setString(6, employee.getDesignation());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Get the employee by using given employee ID
	 * 
	 * @param eid - parameter for get employee ID
	 * @param empList - ArrayList to store the employee details
	 * 
	 * @see #diplayEmployees()
	 * 
	 * @throws SQLException - Thrown when database access error occurs or this method is called on a closed connection
	 */
	public void getEmployeeByID(String eid) {

		Employee employee = new Employee();
		try {
			preparedStatement = connection.prepareStatement(Query.queryById(CommonConstants.QUERY_ID_RETRIEVE_BY_ID));
			preparedStatement.setString(1, eid);
			ResultSet resultTest = preparedStatement.executeQuery();
			while (resultTest.next()) {
				employee.setEmployeeId(resultTest.getString(1));
				employee.setFullName(resultTest.getString(2));
				employee.setAddress(resultTest.getString(3));
				employee.setFacultyName(resultTest.getString(4));
				employee.setDepartment(resultTest.getString(5));
				employee.setDesignation(resultTest.getString(6));
			}
			ArrayList<Employee> empList = new ArrayList<Employee>();
			empList.add(employee);
			diplayEmployees(empList);
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Delete the given employee by using employee ID
	 * 
	 * @param eid - parameter for get employee ID
	 * 
	 * @throws SQLException - Thrown when database access error occurs or this method is called on a closed connection
	 */
	public void deleteEmployee(String eid) {

		try {
			preparedStatement = connection.prepareStatement(Query.queryById(CommonConstants.QUERY_ID_DELETE));
			preparedStatement.setString(1, eid);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get all employees and store to ArrayList
	 * 
	 * @param empList - ArrayList to store all the employees details
	 * @see #diplayEmployees()
	 * 
	 */
	public void getEmployees() {

		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(Query.queryById(CommonConstants.QUERY_ID_RETRIEVE_ALL));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee emplyoee = new Employee();
				emplyoee.setEmployeeId(resultSet.getString(1));
				emplyoee.setFullName(resultSet.getString(2));
				emplyoee.setAddress(resultSet.getString(3));
				emplyoee.setFacultyName(resultSet.getString(4));
				emplyoee.setDepartment(resultSet.getString(5));
				emplyoee.setDesignation(resultSet.getString(6));
				empList.add(emplyoee);
			}
		} catch (Exception e) {
		}
		diplayEmployees(empList);
	}
	
	/**
	 * Print all employee details according to the given structure
	 * 
	 * @param employeeList - get the employee details to the ArrayList
	 */
	public void diplayEmployees(ArrayList<Employee> employeeList) {

		log.log(Level.INFO, "Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		log.log(Level.INFO,
				"================================================================================================================");
		for (Employee employee : employeeList) {
			log.log(Level.INFO,
					employee.getEmployeeId() + "\t" + employee.getFullName() + "\t\t" + employee.getAddress() + "\t"
							+ employee.getFacultyName() + "\t" + employee.getDepartment() + "\t"
							+ employee.getDesignation() + "\n");
			log.log(Level.INFO,
					"----------------------------------------------------------------------------------------------------------------");
		}

	}
}
