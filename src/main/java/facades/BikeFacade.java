package facades;

import entities.Bike;

import entities.RenameMe;
import entities.Rental;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BikeFacade {

    private static BikeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private BikeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BikeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BikeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Bike> getAllBikes() {
        EntityManager em = getEntityManager();
        List<Bike> bikes = new ArrayList<>();
        try {
            
            bikes = em.createQuery("select b from Bike b", Bike.class).getResultList();
            
            return bikes;
        } finally {
            em.close();
        }

    }

    public List<Bike> searchForBike(String make) {
        EntityManager em = getEntityManager();
        List<Bike> bikes = getAllBikes();
        List<Bike> result = new ArrayList();
        for (Bike b : bikes) {
            if (b.getMake().toLowerCase().contains(make.toLowerCase())) {
                result.add(b);
            }

        }
        return result;

    }
    
    public Bike addBike(String make, int size, String gender, int gears, double day_price) {
        EntityManager em = getEntityManager();
        Bike b = new Bike(make, size, gender, gears, day_price);
        try {
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
        return b;
        } finally {
            em.close();
        }
    }


}
