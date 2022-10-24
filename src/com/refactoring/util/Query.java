package com.refactoring.util;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Query extends CommonUtil {

	/**
	 * This method is used to get the information from the xml file and arrange them
	 * in a list of node
	 * 
	 * @param id is the id of the query that need to be retrieved
	 * 
	 * @return Formatted query string
	 * 
	 */
	public static String queryById(String id) throws ParserConfigurationException, SAXException, IOException {
		NodeList nodeList;
		Element element = null;

		// Write each query to a node
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(CommonConstants.EMPLOYEE_QUERY_PATH))
				.getElementsByTagName(CommonConstants.QUERY_TAG_NAME);

		// Get the node with the given id from the node list
		for (int index = 0; index < nodeList.getLength(); index++) {
			element = (Element) nodeList.item(index);
			if (element.getAttribute(CommonConstants.QUERY_ATTRIBUTE_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
}
