package org.demo.persistence.das;

import java.util.List;

import org.demo.entity.Author;
import org.demo.persistence.dao.AuthorDAOSelect;
import org.nanoj.persistence.jpa.Persistence;
import org.nanoj.persistence.jpa.PersistenceEnvironment;
import org.nanoj.persistence.jpa.PersistenceTransaction;

public class AuthorDAS {

	public List<Author> loadAllAuthors() {
		List<Author> list ;
		try ( PersistenceTransaction tx = Persistence.beginTransaction() ) {
			
			AuthorDAOSelect service = new AuthorDAOSelect() ;
			list = service.findAll();
			System.out.println("List size = " + list.size() );
			
			tx.commit();
		}
		return list ;
	}

	public List<Author> loadAllAuthorsBis() {
		List<Author> list ;
		try ( PersistenceEnvironment env = Persistence.getPersistenceEnvironment() ) {
			
			AuthorDAOSelect service = new AuthorDAOSelect() ;
			list = service.findAll();
			System.out.println("List size = " + list.size() );
		}		
		return list ;
	}
}
