package com.mahendra;

import java.io.Serializable;
import java.util.Date;

// JPA's base package is javax.persistence
// also contains lots of annotations used for mapping table to class (entity class)
import javax.persistence.*;

@Entity 					 	// Current class is ENTITY class
@Table(name="employees") 	 	// This entity is linked to table 'employees'
public class Employee implements Serializable {
		
	@Id							// Set the PRIMARY KEY
	@Column(name="emp_no")		// Set the name of mapped column
	private Integer empId;	
	
	@Column(name="first_name",length=14)	// Set the name and length of column / attribute
	private String firstName;
	
	@Column(name="last_name",length=16)
	private String lastName;
	
	@Column(name="gender",length=1)
	private String gender;
	
	@Column(name="hire_date")
	@Temporal(TemporalType.DATE)			// DB stores date/time as numberical, request JPA to convert
	private Date hireDate;					// values into java.util.Date object
	
	@Column(name="birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
