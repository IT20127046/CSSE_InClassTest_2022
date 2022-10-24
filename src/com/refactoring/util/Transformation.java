package com.refactoring.util;


import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathFactory;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import org.w3c.dom.Document;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;

/**
	** Transformation Class
 */

public class Transformation extends CommonUtil {

	private static final ArrayList<Map<String, String>> l = new ArrayList<Map<String, String>>();

	private static Map<String, String> m = null;

	public static void requestTransform() throws Exception {

		Source EmployeeRequestXML = new StreamSource(new File("src/com/refactoring/resources/EmployeeRequest.xml"));
		Source EmployeeModifiedXSL = new StreamSource(new File("src/com/refactoring/resources/Employee-modified.xsl"));
		Result EmployeeResponseXML = new StreamResult(new File("src/com/refactoring/resources/EmployeeResponse.xml"));
		TransformerFactory.newInstance().newTransformer(EmployeeModifiedXSL).transform(EmployeeRequestXML, EmployeeResponseXML);
	}

	public static ArrayList<Map<String, String>> XMLXPATHS() throws Exception {

		Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse("src/com/refactoring/resources/EmployeeResponse.xml");
		XPath EmployeeRequestXML = XPathFactory.newInstance().newXPath();
		int n = Integer.parseInt((String) EmployeeRequestXML.compile("count(//Employees/Employee)").evaluate(d, XPathConstants.STRING));
		for (int i = 1; i <= n; i++) {
			m = new HashMap<String, String>();
			m.put("XpathEmployeeIDKey", (String) EmployeeRequestXML.compile("//Employees/Employee[" + i + "]/EmployeeID/text()")
					.evaluate(d, XPathConstants.STRING));
			m.put("XpathEmployeeNameKey", (String) EmployeeRequestXML.compile("//Employees/Employee[" + i + "]/EmployeeFullName/text()")
					.evaluate(d, XPathConstants.STRING));
			m.put("XpathEmployeeAddressKey",
					(String) EmployeeRequestXML.compile("//Employees/Employee[" + i + "]/EmployeeFullAddress/text()").evaluate(d,
							XPathConstants.STRING));
			m.put("XpathFacultyNameKey", (String) EmployeeRequestXML.compile("//Employees/Employee[" + i + "]/FacultyName/text()")
					.evaluate(d, XPathConstants.STRING));
			m.put("XpathDepartmentKey", (String) EmployeeRequestXML.compile("//Employees/Employee[" + i + "]/Department/text()")
					.evaluate(d, XPathConstants.STRING));
			m.put("XpathDesignationKey", (String) EmployeeRequestXML.compile("//Employees/Employee[" + i + "]/Designation/text()")
					.evaluate(d, XPathConstants.STRING));
			l.add(m);
		}
		return l;
	}
}
