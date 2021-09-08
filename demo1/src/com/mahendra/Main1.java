package com.mahendra;

import javax.persistence.*;

public class Main1 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		
		EntityManager em = factory.createEntityManager();
		
		Department d = em.find(Department.class, "d005");
		System.out.println(d.getName());
		
		em.close();
		factory.close(); 
	}

}
