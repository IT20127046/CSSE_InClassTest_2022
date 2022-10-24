package com.refactoring.util;


public class CommonConstants {

    /** Constant for url key for MySQL stored in config.properties */
    public static final String URL = "url";

    /** Constant for username for MySQL stored in config.properties */
    public static final String USERNAME = "username";

    /** Constant for password for MySQL stored in config.properties */
    public static final String PASSWORD = "password";

    /** Constant for driver name in config.properties */
	public static final String DRIVER_NAME = "driverName";

    /** Constant for classname */
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";

    /** Constant for the path for the EmployeeQuery.xml */
    public static final String EMPLOYEE_QUERY_PATH = "src/com/refactoring/resources/EmployeeQuery.xml";
    public static final String PROPERTIES_PATH = "./config.properties";
    public static final String QUERY = "query";

    
    /** Constant for tag name query */
    public static final String QUERY_TAG_NAME = "query";


    /** Constant for id attribute in the query tag */
    public static final String QUERY_ATTRIBUTE_ID = "id";

    /** Constant for id of query for create table in EmployeeQuery.xml */
    public static final String QUERY_ID_CREATE_TABLE = "q1";

    /** Constant for id of query for drop table in EmployeeQuery.xml */
    public static final String QUERY_ID_DROP_TABLE = "q2";

    /** Constant for id of query for insert in EmployeeQuery.xml */
    public static final String QUERY_ID_INSERT = "q3";

    /** Constant for id of query for get records by id in EmployeeQuery.xml */
    public static final String QUERY_ID_RETRIEVE_BY_ID = "q4";

    /** Constant for id of query for get all records in EmployeeQuery.xml */
    public static final String QUERY_ID_RETRIEVE_ALL = "q5";

    /** Constant for id of query for delete record in EmployeeQuery.xml */
    public static final String QUERY_ID_DELETE = "q6";

    /** Constant for source object of EmployeeRequestXML in Transformation.java */
    public static final String EMPLOYEE_REQUEST_XML_PATH = "src/com/refactoring/resources/EmployeeRequest.xml";

    /** Constant for source object of EmployeeModifiedXSL in Transformation.java */
    public static final String EMPLOYEE_MODIFIED_XSL_PATH = "src/com/refactoring/resources/Employee-modified.xsl";
    
    /** Constant for source object of EmployeeResponseXML in Transformation.java */
    public static final String EMPLOYEE_RESPONSE_XML_PATH = "src/com/refactoring/resources/EmployeeResponse.xml";
    
    /** Constant for xpath key for employee id */
    public static final String XPATH_EMPLOYEE_ID = "XpathEmployeeIDKey";

    /** Constant for xpath key for employee name */
    public static final String XPATH_EMPLOYEE_FULLNAME = "XpathEmployeeNameKey";

    /** Constant for xpath key for employee age */
    public static final String XPATH_EMPLOYEE_ADDRESS = "XpathEmployeeAddressKey";

    /** Constant for xpath key for employee faculty name */
    public static final String XPATH_EMPLOYEE_FACULTYNAME = "XpathFacultyNameKey";

    /** Constant for xpath key for employee department */
    public static final String XPATH_EMPLOYEE_DEPARTMENT = "XpathDepartmentKey";

    /** Constant for xpath key for employee designation */
    public static final String XPATH_EMPLOYEE_DESIGNATION = "XpathDesignationKey";

    /** Constant for line break */
    public static final String LINE_BREAK = "\n";
}
