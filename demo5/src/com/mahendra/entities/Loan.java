package com.mahendra.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="loans")
public class Loan implements Serializable {

	@Id
	@Column(name="loan_acc_no")
	private Integer loanAccId;
	
	private double amount;
	
	private int duration;
	
	@Column(name="loan_type", length=10)
	private String type;
	
	@ManyToOne // Many loans to ONE customers 
	@JoinColumn(name="cust_id") // FOREIGN KEY COLUMN
	private Customer customer;

	public Integer getLoanAccId() {
		return loanAccId;
	}

	public void setLoanAccId(Integer loanAccId) {
		this.loanAccId = loanAccId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(Integer loanAccId, double amount, int duration, String type) {
		super();
		this.loanAccId = loanAccId;
		this.amount = amount;
		this.duration = duration;
		this.type = type;
	}
	
	
}
