package com.refactoring.main;


import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.refactoring.service.EmployeeService;
import com.refactoring.util.Transformation;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeService();
		try {
			Transformation.requestTransform();
			employeeService.setEmployees();;
			employeeService.createEmployeeTable();;
			employeeService.addEmployee();;
//			employeeService.eMPLOYEEGETBYID("EMP10004");
//			employeeService.EMPLOYEEDELETE("EMP10001");
			employeeService.getEmployees();;
		} catch (Exception e) {
		}

	}

}
