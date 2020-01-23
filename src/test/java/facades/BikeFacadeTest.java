package facades;


import entities.Bike;
import entities.Storage;

import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class BikeFacadeTest {

    private static EntityManagerFactory emf;
    private static BikeFacade facade;
   
  
    private Bike b1, b2;
    private Storage s1, s2;

    public BikeFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = BikeFacade.getFacadeExample(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = BikeFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        b1 = new Bike("Testbike2", 2, "male", 12, 10.00);
        b2 = new Bike("Testbike2", 2, "male", 10, 10.00);

      //  s1 = new Storage("StorageTest", 10, null);
        //s2 = new Storage("StorageTest", 10, null);


        try {
            em.getTransaction().begin();
            em.createNamedQuery("Bike.deleteAllRows").executeUpdate();
          //  em.createNamedQuery("Storage.deleteAllRows").executeUpdate();

        

            em.persist(b1);
            em.persist(b2);


            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    @Test
    public void testGetMovies() {
        Assertions.assertEquals(2, facade.getAllBikes().size());
    }
    
    @Disabled
    @Test
    public void testGetActors() {
        //Assertions.assertTrue(facade.getAllMovies().);
    }
}
