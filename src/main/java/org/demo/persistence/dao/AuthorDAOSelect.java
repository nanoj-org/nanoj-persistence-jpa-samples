package org.demo.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.demo.entity.Author;
import org.nanoj.persistence.jpa.GenericDAO;

public class AuthorDAOSelect extends GenericDAO {

	public Author findOne( long entityId ){
		EntityManager em = getEntityManager();
		return em.find( Author.class, entityId );
	}

	public List<Author> findAll(){
		EntityManager em = getEntityManager();
		@SuppressWarnings("unchecked")
		List<Author> list = em.createQuery( "from " + Author.class.getName() ).getResultList();
		return list ;
	}
}
