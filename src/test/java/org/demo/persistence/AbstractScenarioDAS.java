package org.demo.persistence;

import java.util.List;

import org.demo.entity.Author;
import org.demo.persistence.das.AuthorDAS;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbstractScenarioDAS {

	@Test 
	public void mytest1() {
		System.out.println("@Test / mytest1");
		AuthorDAS service = new AuthorDAS() ;
		List<Author> list = service.loadAllAuthors();
		System.out.println("List size = " + list.size() );
	}

	@Test
	public void mytest2() {
		System.out.println("@Test / mytest2");
		AuthorDAS service = new AuthorDAS() ;
		List<Author> list = service.loadAllAuthorsBis();
		System.out.println("List size = " + list.size() );
	}
	
}
