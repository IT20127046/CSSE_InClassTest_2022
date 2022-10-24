package com.refactoring.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
	** Transformation Class
	* Transform EmployeeRequest.xml to EmployeeResponse.xml structure based o nEmployee-modified.xsl
 */
public class Transformation extends CommonUtil {

	/* Initialize employeeList - Array List for store employees*/
	private static final ArrayList<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();

	/* Initialize employeeMap - Map for store employee*/
	private static Map<String, String> employeeMap = null;

	/**
	 * Transform XML
	 * @param employeeRequestXML - get employee request XML file
	 * @param employeeModifiedXSL - get employee modified XSL file
	 * @param employeeResponseXML - get employee response XML file
	 * @throws Exception
	 */
	public static void requestTransform() throws IOException,TransformerException,XPathException,TransformerConfigurationException,TransformerFactoryConfigurationError,SAXException,ParserConfigurationException,XPathExpressionException {

		Source employeeRequestXML = new StreamSource(new File(CommonConstants.EMPLOYEE_REQUEST_XML_PATH));
		Source employeeModifiedXSL = new StreamSource(new File(CommonConstants.EMPLOYEE_MODIFIED_XSL_PATH));
		Result employeeResponseXML = new StreamResult(new File(CommonConstants.EMPLOYEE_RESPONSE_XML_PATH));
		TransformerFactory.newInstance().newTransformer(employeeModifiedXSL).transform(employeeRequestXML, employeeResponseXML);
	}

	/**
	 * @param responseDocument - 
	 * @param employeeCount - get employee count in the XML file
	 * @return employeeList - return employee Map 
	 * @throws Exception
	 */
	public static ArrayList<Map<String, String>> xmlPaths() throws Exception {

		Document responseDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(CommonConstants.EMPLOYEE_RESPONSE_XML_PATH);
		XPath employeeRequestXML = XPathFactory.newInstance().newXPath();
		int employeeCount = Integer.parseInt((String) employeeRequestXML.compile("count(//Employees/Employee)").evaluate(responseDocument, XPathConstants.STRING));
		for (int i = 1; i <= employeeCount; i++) {
			employeeMap = new HashMap<String, String>();
			employeeMap.put(CommonConstants.XPATH_EMPLOYEE_ID, (String) employeeRequestXML.compile("//Employees/Employee[" + i + "]/EmployeeID/text()")
					.evaluate(responseDocument, XPathConstants.STRING));
			employeeMap.put(CommonConstants.XPATH_EMPLOYEE_FULLNAME, (String) employeeRequestXML.compile("//Employees/Employee[" + i + "]/EmployeeFullName/text()")
					.evaluate(responseDocument, XPathConstants.STRING));
			employeeMap.put(CommonConstants.XPATH_EMPLOYEE_ADDRESS,
					(String) employeeRequestXML.compile("//Employees/Employee[" + i + "]/EmployeeFullAddress/text()").evaluate(responseDocument,
							XPathConstants.STRING));
			employeeMap.put(CommonConstants.XPATH_EMPLOYEE_FACULTYNAME, (String) employeeRequestXML.compile("//Employees/Employee[" + i + "]/FacultyName/text()")
					.evaluate(responseDocument, XPathConstants.STRING));
			employeeMap.put(CommonConstants.XPATH_EMPLOYEE_DEPARTMENT, (String) employeeRequestXML.compile("//Employees/Employee[" + i + "]/Department/text()")
					.evaluate(responseDocument, XPathConstants.STRING));
			employeeMap.put(CommonConstants.XPATH_EMPLOYEE_DESIGNATION, (String) employeeRequestXML.compile("//Employees/Employee[" + i + "]/Designation/text()")
					.evaluate(responseDocument, XPathConstants.STRING));
			employeeList.add(employeeMap);
		}
		return employeeList;
	}
}
