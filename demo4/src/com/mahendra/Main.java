package com.mahendra;

import javax.persistence.*;

import com.mahendra.entities.Customer;
import com.mahendra.entities.Loan;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo3");
		
		EntityManager em = factory.createEntityManager();
		
		Loan loan = em.find(Loan.class,  10010);
		
		System.out.println("Loan Details: ");
		em.close();
		
		
		System.out.println("Name of Borrower: "+loan.getCustomer().getFirstName()+" "+loan.getCustomer().getLastName());
		System.out.println("Amount : "+loan.getAmount());
		
		factory.close();
		
		
		
	}

}
