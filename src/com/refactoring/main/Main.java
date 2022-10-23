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

		EmployeeService a1 = new EmployeeService();
		try {
			Transformation.rEQUESTtRANSFORM();
			a1.a2();
			a1.a3();
			a1.a4();
//			employeeService.eMPLOYEEGETBYID("EMP10004");
//			employeeService.EMPLOYEEDELETE("EMP10001");
			a1.a5();
		} catch (Exception e) {
		}

	}

}
