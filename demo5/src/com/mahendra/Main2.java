package com.mahendra;

import java.util.*;

import javax.persistence.*;

import com.mahendra.entities.Customer;
import com.mahendra.entities.Loan;


public class Main2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo3");
		
		EntityManager em = factory.createEntityManager();
		
		Customer customer = em.find(Customer.class, 203046);
		System.out.println("Customer : "+customer.getFirstName()+" "+customer.getLastName());
		System.out.println("Have "+customer.getLoans().size()+" loans with bank");
		System.out.println("-------------------------------------------------------------");
		System.out.printf("|%14s | %-20s | %20s","Loan Account","Loan type","Loan Amount |");
		System.out.println("\n-------------------------------------------------------------");
		for(Loan loan: customer.getLoans()) {
			System.out.printf("|%14d | %-20s | %18.2f |\n",loan.getLoanAccId() ,loan.getType(),loan.getAmount());
		}
		System.out.println("-------------------------------------------------------------");
		em.close();
		factory.close();
	}

}
