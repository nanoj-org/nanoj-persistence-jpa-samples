package org.demo.persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.nanoj.persistence.jpa.PersistenceFactory;
import org.nanoj.persistence.jpa.PersistenceManager;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScenarioDAOWithInitBeforeTest extends AbstractScenarioDAO {
	
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
		// OPEN the EntityManager before each test : like "Session In View"
		System.out.println("");
		System.out.println("@Before ------------------------------------------------");
		System.out.println("Opening EntityManager ...");
		PersistenceManager.openEntityManager();
		System.out.println("EntityManager is open");
		System.out.println("@Before ------------------------------------------------");
	}

	@After
	public void tearDown() throws Exception {
		// CLOSE the EntityManager after each test : like "Session In View"
		System.out.println("@After ------------------------------------------------");
		System.out.println("Closing EntityManager ...");
		PersistenceManager.closeEntityManager();
		System.out.println("EntityManager is closed");
		System.out.println("@After ------------------------------------------------");
	}

}
