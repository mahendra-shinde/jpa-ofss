package com.mahendra;

import javax.persistence.*;

public class Main1 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		
		EntityManager em = factory.createEntityManager();
		
		// Transient object : record doesn't exists (YET)
		Department d1 = new Department();
		d1.setDeptId("d010");
		d1.setName("Taxes");
		
		EntityTransaction tn = em.getTransaction();
		
		try {
			tn.begin();
			System.out.println("Adding new transient object to persistence context");
			em.persist(d1);
			System.out.println("Casual changes to MANAGED INSTANCE");
			d1.setName("Income Tax");
			System.out.println("Now Sync all the changes to database");
			tn.commit();
		}catch(Exception ex) {
			if(tn != null) {
				tn.rollback();
			}
		}
		
		
		em.close(); // Closing peristence context
		
		// Detached object
		d1.setName("Govt Taxes");
		
		//Another entity manager
		em = factory.createEntityManager();
		EntityTransaction tn2 = em.getTransaction();
		
		try {
			tn2.begin();
			// Merge would first make d1 MANAGED with second persistence context
			em.merge(d1);
			// Update
			tn2.commit();
		}catch(Exception ex) {
			if(tn2 != null) {
				tn2.rollback();
			}
		}
		em.close();
		
		
		factory.close(); 
	}

}
