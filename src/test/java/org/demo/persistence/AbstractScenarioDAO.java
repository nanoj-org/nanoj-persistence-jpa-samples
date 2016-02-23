package org.demo.persistence;

import java.util.List;

import org.demo.entity.Author;
import org.demo.persistence.dao.AuthorDAOCreate;
import org.demo.persistence.dao.AuthorDAODelete;
import org.demo.persistence.dao.AuthorDAOSelect;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.nanoj.persistence.jpa.Persistence;
import org.nanoj.persistence.jpa.PersistenceEnvironment;
import org.nanoj.persistence.jpa.PersistenceTransaction;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbstractScenarioDAO {

	@Test // @Ignore
	public void mytest1() {
		System.out.println("@Test / mytest1");
		try ( PersistenceEnvironment env = Persistence.getPersistenceEnvironment() ) {
			
			AuthorDAOSelect service = new AuthorDAOSelect() ;
			List<Author> list = service.findAll();
			System.out.println("List size = " + list.size() );
			
		}		
		
	}

	@Test
	public void mytest2() {
		System.out.println("@Test / mytest2");
		try ( PersistenceTransaction tx = Persistence.beginTransaction() ) {
			callPersistenceServices();
			tx.commit();
		}
	}
	
	public void callPersistenceServices() {
		System.out.println("----- callPersistenceServices()");
		callSelect();
		Author author = callSelect(777);
		try ( PersistenceTransaction tx = Persistence.beginTransaction() ) {
			if ( author != null ) {
				callDelete(author);
			}
			else {
				callCreate();
				//callCreate(); // Exception ( duplicated )
			}
			tx.commit();
		}
	}
	
	public Author callSelect(long id) {
		AuthorDAOSelect service = new AuthorDAOSelect() ;
		Author author = service.findOne(id);
		System.out.println("Author : " + author);
		return author;
	}
	
	public void callSelect() {
		AuthorDAOSelect service = new AuthorDAOSelect() ;
		List<Author> list = service.findAll();
		System.out.println("List size = " + list.size() );
	}
	
	public void callDelete(Author author) {
		AuthorDAODelete service = new AuthorDAODelete() ;
		service.delete(author);
		System.out.println("Author deleted : " + author);
	}
	public void callCreate() {
		AuthorDAOCreate service = new AuthorDAOCreate() ;
		Author author = new Author();
		java.util.Date now = new java.util.Date();
		author.setFirstName("new author 777 " + now.getTime());
		author.setId(777);
		service.create(author);
		System.out.println("Author created : " + author);
	}
	public void callCreate(Author author) {
		AuthorDAOCreate service = new AuthorDAOCreate() ;
		service.create(author);
		System.out.println("Author created : " + author);
	}

}
