package com.mahendra;

import java.util.*;

import javax.persistence.*;

import com.mahendra.entities.Customer;
import com.mahendra.entities.Loan;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo3");
		
		EntityManager em = factory.createEntityManager();
		
		Loan loan1 = new Loan(10011, 5000000D, 240, "HOME LOAN");
		Loan loan2 = new Loan(10012, 200000D, 36, "APPLIANCE");
		Customer customer = new Customer(203046,"Sonali","Shinde","Navi Mumbai");
		
		loan1.setCustomer(customer);
		loan2.setCustomer(customer);
		
		List<Loan> loans = new LinkedList<>();
		loans.add(loan1);
		loans.add(loan2);
		
		EntityTransaction tn = em.getTransaction();
		
		try {
			tn.begin();
			em.persist(loan1);
			em.persist(loan2);
			em.persist(customer);
			System.out.println("Creating loan and customer records !");
			tn.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			if(tn!=null) {
				tn.rollback();
			}
		}
		em.close();
		factory.close();
	}

}
