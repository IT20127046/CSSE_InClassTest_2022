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

	public EmployeeService() {
		try {
			Class.forName(CommonConstants.CLASSNAME);
			connection = DriverManager.getConnection(p.getProperty(CommonConstants.URL), p.getProperty(CommonConstants.USERNAME), p.getProperty(CommonConstants.PASSWORD));
					p.getProperty(CommonConstants.PASSWORD);

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		} 
	}

	public void a2() {

		try {
			int s = Transformation.XMLXPATHS().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = Transformation.XMLXPATHS().get(i);
				Employee EMPLOYEE = new Employee();
				EMPLOYEE.setEmployeeId(l.get("XpathEmployeeIDKey"));
				EMPLOYEE.setFullName(l.get("XpathEmployeeNameKey"));
				EMPLOYEE.setAddress(l.get("XpathEmployeeAddressKey"));
				EMPLOYEE.setFacultyName(l.get("XpathFacultyNameKey"));
				EMPLOYEE.setDepartment(l.get("XpathDepartmentKey"));
				EMPLOYEE.setDesignation(l.get("XpathDesignationKey"));
				employeeList.add(EMPLOYEE);
				System.out.println(EMPLOYEE.toString() + "\n");
			}
		} catch (ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch(SAXException e){
			log.log(Level.SEVERE, e.getMessage());
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch(NumberFormatException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (XPathExpressionException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public void a3() {
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

	public void a4() {
		try {
			preparedStatement = connection.prepareStatement(Query.queryById(CommonConstants.QUERY_ID_INSERT));
			connection.setAutoCommit(false);
			for(Employee employee: employeeList) {
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
			log.log(Level.SEVERE,e.getMessage());
		}
	}

	public void eMPLOYEEGETBYID(String eid) {

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
			ArrayList<Employee> list = new ArrayList<Employee>();
			list.add(employee);
			eMPLOYEEoUTPUT(list);
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE,e.getMessage());
		}
	}

	public void EMPLOYEEDELETE(String eid) {

		try {
			preparedStatement = connection.prepareStatement(Query.queryById(CommonConstants.QUERY_ID_DELETE));
			preparedStatement.setString(1, eid);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void a5() {

		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(Query.queryById(CommonConstants.QUERY_ID_RETRIEVE_ALL));
			ResultSet r = preparedStatement.executeQuery();
			while (r.next()) {
				Employee e = new Employee();
				e.setEmployeeId(r.getString(1));
				e.setFullName(r.getString(2));
				e.setAddress(r.getString(3));
				e.setFacultyName(r.getString(4));
				e.setDepartment(r.getString(5));
				e.setDesignation(r.getString(6));
				list.add(e);
			}
		} catch (Exception e) {
		}
		eMPLOYEEoUTPUT(list);
	}
	
	public void eMPLOYEEoUTPUT(ArrayList<Employee> list){
		
		log.log(Level.INFO, "Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		log.log(Level.INFO, "================================================================================================================");
		for(Employee employee: list){
			log.log(Level.INFO, employee.getEmployeeId() + "\t" + employee.getFullName() + "\t\t"
					+ employee.getAddress() + "\t" + employee.getFacultyName() + "\t" + employee.getDepartment() + "\t"
					+ employee.getDesignation() + "\n");
			log.log(Level.INFO, "----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
