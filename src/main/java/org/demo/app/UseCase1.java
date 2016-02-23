package org.demo.app;

import java.util.List;

import org.demo.entity.Author;
import org.demo.persistence.dao.AuthorDAOCreate;
import org.demo.persistence.dao.AuthorDAODelete;
import org.demo.persistence.dao.AuthorDAOSelect;
import org.demo.persistence.das.AuthorDAS;
import org.nanoj.persistence.jpa.Persistence;
import org.nanoj.persistence.jpa.PersistenceManager;
import org.nanoj.persistence.jpa.PersistenceTransaction;



public class UseCase1 {
	public static void main(String[] args) {
		
		caseWithoutEntityManager();  
		System.out.println("==============================================");
		caseWithEntityManagerReady();
		AuthorDAS authorDAS = new AuthorDAS();
		authorDAS.loadAllAuthorsBis();
	}
	
	public static void caseWithEntityManagerReady() {
		PersistenceManager.openEntityManager();
		try {
//			callPersistenceServices();
//			callPersistenceServices();
//			callPersistenceServices();
			superCallPersistenceServices();
			callPersistenceServices();
		}
//		catch(RuntimeException e) {
//			System.out.println("ERROR : " + e.getMessage());
//		}
		finally {
			PersistenceManager.closeEntityManager();
		}
	}
	
	public static void caseWithoutEntityManager() {
		superCallPersistenceServices();
	}
	
	public static void superCallPersistenceServices() {
		System.out.println("----- superCallPersistenceServices()");
		AuthorDAS authorDAS = new AuthorDAS();
		authorDAS.loadAllAuthors();
		try ( PersistenceTransaction tx = Persistence.beginTransaction() ) {
			callPersistenceServices();
			tx.commit();
		}
	}
	
	public static void callPersistenceServices() {
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
	
	public static Author callSelect(long id) {
		AuthorDAOSelect service = new AuthorDAOSelect() ;
		Author author = service.findOne(id);
		System.out.println("Author : " + author);
		return author;
	}
	
	public static void callSelect() {
		AuthorDAOSelect service = new AuthorDAOSelect() ;
		List<Author> list = service.findAll();
		System.out.println("List size = " + list.size() );
	}
	
	public static void callDelete(Author author) {
		AuthorDAODelete service = new AuthorDAODelete() ;
		service.delete(author);
		System.out.println("Author deleted : " + author);
	}
	public static void callCreate() {
		AuthorDAOCreate service = new AuthorDAOCreate() ;
		Author author = new Author();
		java.util.Date now = new java.util.Date();
		author.setFirstName("new author 777 " + now.getTime());
		author.setId(777);
		service.create(author);
		System.out.println("Author created : " + author);
	}
	public static void callCreate(Author author) {
		AuthorDAOCreate service = new AuthorDAOCreate() ;
		service.create(author);
		System.out.println("Author created : " + author);
	}
	

		
//		EntityManager em = EntityManagerThreadLocal.get();
//		System.out.println(" EM is null ? " + em == null );
//		
//		ServiceForBadges svc = new ServiceForBadges();
//		svc.getBadges();
//
//		
//		try ( TransactionWrapper tx = TransactionAccessor.openTransaction() ) {
//			ServiceForBadges svc2 = new ServiceForBadges();
//			svc2.getBadges();
//			
//			AuthorDALService authorDAL = new AuthorDALService();
//
//			authorDAL.deleteById(777L);
//			
////			EntityManager em = EntityManagerThreadLocal.get();
////			Author author = em.find( Author.class, 777 );
//			
//			Author author = new Author();
//			java.util.Date now = new java.util.Date();
//			author.setFirstName("new author 777 " + now.getTime());
//			author.setId(777);
//			AuthorDALCreate authorDALCreate = new AuthorDALCreate();
//			authorDALCreate.create(author);
//			
//			AuthorDALSelect authorDALSelect = new AuthorDALSelect();
//			Author aut2 = authorDALSelect.findOne(777);
//			System.out.println("Author found : " + aut2 );
//
//			//if ( true ) throw new RuntimeException("My ERROR");
//			
//			AuthorDALUpdate authorDALUpdate = new AuthorDALUpdate();
//			aut2.setLastName("Update lastName" + now.getTime());
//			authorDALUpdate.update(aut2);
//			
//			tx.commit();
//			
//			AuthorDALSelect authorSelect = new AuthorDALSelect() ;
//			List<Author> authors = authorSelect.findAll();
//			System.out.println("List size = " + authors.size());
//		} 
//
////		
////		try ( TransactionWrapper tx = TransactionAccessor.openTransaction() ) {
////			ServiceForBadges svc2 = new ServiceForBadges();
////			svc2.getBadges();			
////		} 

	
}
