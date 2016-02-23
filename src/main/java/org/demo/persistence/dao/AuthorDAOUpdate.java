package org.demo.persistence.dao;

import javax.persistence.EntityManager;

import org.demo.entity.Author;
import org.nanoj.persistence.jpa.GenericDAO;

public class AuthorDAOUpdate extends GenericDAO {

	public void update( Author entity ){
		EntityManager em = getEntityManager();
		em.merge( entity );
			
//		AuthorDALDelete authorDALDelete = new AuthorDALDelete();
//		authorDALDelete.deleteById(987654);
	}
}
