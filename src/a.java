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

public class a extends c1 {

	private final ArrayList<b> employeeList = new ArrayList<b>();
	private static Connection connection;
	private static Statement statement;
	private PreparedStatement preparedStatement;
	public static final Logger log = Logger.getLogger(a.class.getName());

	public a() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		} 
	}

	public void a2() {

		try {
			int s = c3.XMLXPATHS().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = c3.XMLXPATHS().get(i);
				b EMPLOYEE = new b();
				EMPLOYEE.eMPLOYEEiD(l.get("XpathEmployeeIDKey"));
				EMPLOYEE.fULLnAME(l.get("XpathEmployeeNameKey"));
				EMPLOYEE.aDDRESS(l.get("XpathEmployeeAddressKey"));
				EMPLOYEE.fACULTYNAME(l.get("XpathFacultyNameKey"));
				EMPLOYEE.dEPARTMENT(l.get("XpathDepartmentKey"));
				EMPLOYEE.dESIGNATION(l.get("XpathDesignationKey"));
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
			statement.executeUpdate(c2.Query(CommonConstants.QUERY2));
			statement.executeUpdate(c2.Query(CommonConstants.QUERY1));
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	public void a4() {
		try {
			preparedStatement = connection.prepareStatement(c2.Query(CommonConstants.QUERY3));
			connection.setAutoCommit(false);
			for(b employee: employeeList) {
				preparedStatement.setString(1, employee.EMPLOYEEiDgET());
				preparedStatement.setString(2, employee.fULLnAMEgET());
				preparedStatement.setString(3, employee.aDDRESSgET());
				preparedStatement.setString(4, employee.fACULTYnAMEgET());
				preparedStatement.setString(5, employee.dEPARTMENTgET());
				preparedStatement.setString(6, employee.dESIGNATIONgET());
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

		b employee = new b();
		try {
			preparedStatement = connection.prepareStatement(c2.Query(CommonConstants.QUERY4));
			preparedStatement.setString(1, eid);
			ResultSet resultTest = preparedStatement.executeQuery();
			while (resultTest.next()) {
				employee.eMPLOYEEiD(resultTest.getString(1));
				employee.fULLnAME(resultTest.getString(2));
				employee.aDDRESS(resultTest.getString(3));
				employee.fACULTYNAME(resultTest.getString(4));
				employee.dEPARTMENT(resultTest.getString(5));
				employee.dESIGNATION(resultTest.getString(6));
			}
			ArrayList<b> list = new ArrayList<b>();
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
			preparedStatement = connection.prepareStatement(c2.Query(CommonConstants.QUERY6));
			preparedStatement.setString(1, eid);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void a5() {

		ArrayList<b> list = new ArrayList<b>();
		try {
			preparedStatement = connection.prepareStatement(c2.Query(CommonConstants.QUERY5));
			ResultSet r = preparedStatement.executeQuery();
			while (r.next()) {
				b e = new b();
				e.eMPLOYEEiD(r.getString(1));
				e.fULLnAME(r.getString(2));
				e.aDDRESS(r.getString(3));
				e.fACULTYNAME(r.getString(4));
				e.dEPARTMENT(r.getString(5));
				e.dESIGNATION(r.getString(6));
				list.add(e);
			}
		} catch (Exception e) {
		}
		eMPLOYEEoUTPUT(list);
	}
	
	public void eMPLOYEEoUTPUT(ArrayList<b> list){
		
		log.log(Level.INFO, "Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		log.log(Level.INFO, "================================================================================================================");
		for(b employee: list){
			log.log(Level.INFO, employee.EMPLOYEEiDgET() + "\t" + employee.fULLnAMEgET() + "\t\t"
					+ employee.aDDRESSgET() + "\t" + employee.fACULTYnAMEgET() + "\t" + employee.dEPARTMENTgET() + "\t"
					+ employee.dESIGNATIONgET() + "\n");
			log.log(Level.INFO, "----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
