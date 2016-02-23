package org.demo.persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.nanoj.persistence.jpa.PersistenceFactory;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScenarioDAOWithoutInit extends AbstractScenarioDAO {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("\n@BeforeClass / setUpBeforeClass");
		
		// Just initialize the PersistenceFactory
		PersistenceFactory.init();
		System.out.println("PersistenceFactory ready " );		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("\n@AfterClass / tearDownAfterClass");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("@Before ------------------------------------------------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After ------------------------------------------------");
	}

}
