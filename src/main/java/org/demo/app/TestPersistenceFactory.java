package org.demo.app;

import javax.persistence.EntityManager;

import org.nanoj.persistence.jpa.PersistenceFactory;



public class TestPersistenceFactory {
	public static void main(String[] args) {
		
		System.out.println("Testing PersistenceFactory");

		System.out.println("persistenceUnitName = " + PersistenceFactory.getPersistenceUnitName() );
		
		System.out.println("Getting EntityManager...");
		EntityManager em = PersistenceFactory.createEntityManager();
		System.out.println("EntityManager ready.");
		em.close();
	}

}
