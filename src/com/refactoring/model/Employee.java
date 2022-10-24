package com.refactoring.model;
public class Employee {

	//Properties
	private String employeeId;
	private String fullName;
	private String address;
	private String facultyName;
	private String department;
	private String designation;

	/**
	 * @return the employeeID
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the facultyName
	 */
	public String getFacultyName() {
		return facultyName;
	}

	/**
	 * @param facultyName the facultyName to set
	 */
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {

		return "Employee ID = " + employeeId + "\n" +
			   "FullName = " + fullName + "\n" +
			   "Address = " + address + "\n" + 
			   "Faculty Name = " + facultyName + "\n" + 
			   "Department = " + department + "\n" + 
			   "Designation = "	+ designation;
	}
}