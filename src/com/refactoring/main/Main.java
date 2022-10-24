package com.refactoring.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.refactoring.service.EmployeeService;
import com.refactoring.service.EmployeeServiceImpl;
import com.refactoring.util.Transformation;

public class Main {

	/**
	 * @param args
	 * @throws TransformerConfigurationException
	 * @throws XPathExpressionException
	 * @throws IOException
	 * @throws TransformerException
	 * @throws TransformerFactoryConfigurationError
	 */

	public static final Logger log = Logger.getLogger(Main.class.getName());
	public static void main(String[] args) throws TransformerConfigurationException, XPathExpressionException, IOException, TransformerException, XPathException, SAXException, ParserConfigurationException {

		
		try {
			Transformation.requestTransform();
			
			// Get singleton instance form EmployeeServiceImpl class
			EmployeeService employeeService = EmployeeServiceImpl.getInstance();
			
			// Execute the get employee method using template pattern
			employeeService.getAllEmployees();
			
			//employeeService.getEmployeeById("EMP10004");
			//employeeService.deleteEmployeeById("EMP10001");

		} catch (TransformerFactoryConfigurationError e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (XPathException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		}

	}

}
