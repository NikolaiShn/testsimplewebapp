package com.mastery.java.task.dto;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Long employeeId;
    private String firstName;
	private String lastName;
    private int departmentId;
    private String jobTitle;
    private Gender gender;
    private String dateOfBirth;
    
	public Employee() {
		
	}
	
	
	
    public Employee(Long employeeId, String firstName, String lastName, int departamentId, String jobTitle,
			Gender gender, String dateOfBirth) {
		//super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departamentId;
		this.jobTitle = jobTitle;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departamentId) {
		this.departmentId = departamentId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, departmentId, employeeId, firstName, gender, jobTitle, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && departmentId == other.departmentId
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(firstName, other.firstName)
				&& gender == other.gender && Objects.equals(jobTitle, other.jobTitle)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", departamentId=" + departmentId + ", jobTitle=" + jobTitle + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
		
}
