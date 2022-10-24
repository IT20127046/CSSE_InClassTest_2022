package com.refactoring.main;


import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.refactoring.service.EmployeeService;
import com.refactoring.service.EmployeeServiceImpl;
import com.refactoring.util.Transformation;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Transformation.requestTransform();
			
			// Get singleton instance form EmployeeServiceImpl class
			EmployeeService employeeService = EmployeeServiceImpl.getInstance();
			
			employeeService.getAllEmployees();
			
			//employeeService.getEmployeeById("EMP10004");
			//employeeService.deleteEmployeeById("EMP10001");

		} catch (Exception e) {
		}

	}

}
