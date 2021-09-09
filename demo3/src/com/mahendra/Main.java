package com.mahendra;

import javax.persistence.*;

import com.mahendra.entities.Customer;
import com.mahendra.entities.Loan;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo3");
		
		EntityManager em = factory.createEntityManager();
		
		Loan loan = new Loan(10010, 5000000D, 240, "HOME LOAN");
		Customer customer = new Customer(203045,"Mahendra","Shinde","Navi Mumbai");
		loan.setCustomer(customer);
		
		EntityTransaction tn = em.getTransaction();
		
		try {
			tn.begin();
			em.persist(loan);
			em.persist(customer);
			System.out.println("Creating loan and customer records !");
			tn.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			if(tn!=null) {
				tn.rollback();
			}
		}

	}

}
