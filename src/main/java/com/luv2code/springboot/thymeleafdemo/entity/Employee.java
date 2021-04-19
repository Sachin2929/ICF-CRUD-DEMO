package com.luv2code.springboot.thymeleafdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employee")
public class Employee {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name", nullable = false)
	@NotNull
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	@NotNull
	private String lastName;	

	@Column(name="email", nullable = false)
	@NotNull
	private String email;
	
	@Column(name="employement_id", nullable = false)
	@NotNull
	private String employementId;
	
	@Column (name="start_date", nullable = false)
	@NotNull
	private String startDate;
	
	@Column (name="designation", nullable = false)
	@NotNull
	private String designation;
	
	@Column (name="department", nullable = false)
	@NotNull
	private String department;
	
	@Column (name="end_date", nullable = false)
	@NotNull
	private String endDate;
	
	@Column (name="Status", nullable = false)
	@NotNull
	private String status;
	
	@Column (name="dob", nullable = false)
	@NotNull
	private String dob;
	
	@Column (name="reporting_manager", nullable = false)
	@NotNull
	private String reportingManager;
	
	@Column (name="gender", nullable = false)
	@NotNull
	private String gender;
	
	@Column (name="blood_group", nullable = false)
	@NotNull
	private String bloodGroup;
	
	@Column (name="Address", nullable = false)
	@NotNull
	private String address;
	
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getGender() {
		return gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
		
	// define constructors
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	
	public String getEmployementId() {
		return employementId;
	}

	public void setEmployementId(String employementId) {
		this.employementId = employementId;
	}
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// define tostring

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
		
}











