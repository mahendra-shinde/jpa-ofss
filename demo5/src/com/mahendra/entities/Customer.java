package com.mahendra.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="customers")
public class Customer implements Serializable {
	
	@Id
	@Column(name="cust_no")
	private int custId;
	
	@Column(name="first_name", length=20)
	private String firstName;
	
	@Column(name="last_name", length=20)
	private String lastName;

	@Column(name="city", length=20)
	private String city;
	
	
	@OneToMany(mappedBy="customer")
	private List<Loan> loans;
	
	

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Customer(int custId, String firstName, String lastName, String city) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
