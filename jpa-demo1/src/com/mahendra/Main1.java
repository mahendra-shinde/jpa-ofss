package com.mahendra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		// Connect to DB, Create Statement, execute statement, get results, convert all
		// records into LIST of objects
		// close the connection!!
		List<Employee> employees = em.createQuery("select e from Employee e").setMaxResults(100).getResultList();

		System.out.println("Found records: " + employees.size());
		System.out.printf("%10s | %-15s | %-16s \n", "EMPLOYEE ID", "FIRST NAME", "LAST NAME");
		for (Employee e : employees) {
			System.out.printf("%10s | %-15s | %-16s | %s\n", e.getEmpId(), e.getFirstName(), e.getLastName(),
					e.getBirthDate());
		}

		Employee emp1 = em.find(Employee.class, 10003);
		System.out.println("Is emp1 there in cache? " + em.contains(emp1));
		System.out.println("Employee of the month " + emp1.getFirstName());

		// remove from cache
		em.clear();

		System.out.println("After em.clear() is emp1 in cache now ?" + em.contains(emp1));

		// Closing Persistence Context
		em.close();

	}

}
