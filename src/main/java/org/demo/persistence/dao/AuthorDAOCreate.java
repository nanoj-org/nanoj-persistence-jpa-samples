package org.demo.persistence.dao;

import javax.persistence.EntityManager;

import org.demo.entity.Author;
import org.nanoj.persistence.jpa.GenericDAO;

public class AuthorDAOCreate extends GenericDAO {

	public void create( Author entity ) {
		System.out.println("Author create...");
		EntityManager em = getEntityManager();
		em.persist( entity );
	}
}
