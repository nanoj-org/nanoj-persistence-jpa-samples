package org.demo.persistence.dao;

import javax.persistence.EntityManager;

import org.demo.entity.Author;
import org.nanoj.persistence.jpa.GenericDAO;

public class AuthorDAODelete extends GenericDAO {
	
	private Author findOne( long entityId ){
		EntityManager em = getEntityManager();
		return em.find( Author.class, entityId );
	}

	public void delete( Author entity ){
		EntityManager em = getEntityManager();
		em.remove( entity );
	}
	public void deleteById( long entityId ){
		Author entity = findOne( entityId );
		if ( entity != null ) {
			delete( entity );
		}
//			if ( true ) throw new RuntimeException("My FAKE ERROR on DELETE");
//			delete( entity );
	}
}
