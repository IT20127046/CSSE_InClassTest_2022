package com.refactoring.util;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class Query extends CommonUtil {

	/**
	 * This method is used to get the information from the xml file and arrange them
	 */
	public static String Query(String id) throws Exception {
		NodeList nodeList;
		Element element = null;

		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(CommonConstants.EMPLOYEE_QUERY_PATH)).getElementsByTagName(CommonConstants.QUERY);
		for (int index = 0; index < nodeList.getLength(); index++) {
			element = (Element) nodeList.item(index);
			if (element.getAttribute(CommonConstants.ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
}
