/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Member;
import entities.Bike;
import entities.Storage;
import entities.Bike;
import entities.Rental;
import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Razz
 */
public class SetupScript {

    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);

        EntityManager em = emf.createEntityManager();

        Bike b1 = new Bike("S-works", 2, "male", 27, 100.0);
        Bike b2 = new Bike("Cannondale", 1, "female", 22, 90.0);
        Bike b3 = new Bike("Azzio", 1, "male", 23, 80.0);
        Bike b4 = new Bike("Something", 3, "male", 24, 95.0);
        Bike b5 = new Bike("IngenHjul", 1, "Both", 1, 10.0);
        Bike b6 = new Bike("S-works", 4, "male", 21, 112.0);
        Bike b7 = new Bike("S-works carbon light super speed 2.0", 2, "female", 40, 233.0);

        Storage s1 = new Storage("BikeStreet 23", 100, null);
        Storage s2 = new Storage("WrongWay street 1000323", 10, null);
        Storage s3 = new Storage("Noway ave", 100, null);
        Storage s4 = new Storage("WeCantKeepBikeingThisWay", 1, null);

        Rental r1 = new Rental("21-21-21", b1);
        Rental r2 = new Rental("21-21-21", b2);
        Rental r3 = new Rental("21-21-21", b3);
        Rental r4 = new Rental("21-21-21", b4);

        User user = new User("user", "");
        User admin = new User("admin", "");
        User both = new User("user_admin", "");

        try {

            em.getTransaction().begin();

            s1.addBiketoStroage(s1, b1);
            s1.addBiketoStroage(s2, b2);

            s2.addBiketoStroage(s2, b3);
            s2.addBiketoStroage(s2, b4);
            s2.addBiketoStroage(s2, b5);

            em.persist(b1);
            em.persist(b2);
            em.persist(b3);
            em.persist(b4);
            em.persist(b5);
            em.persist(b6);
            em.persist(b7);

            em.persist(r1);
            em.persist(r2);
            em.persist(r3);
            em.persist(r4);

            Role userRole = new Role("user");
            Role adminRole = new Role("admin");
            user.addRole(userRole);
            admin.addRole(adminRole);
            both.addRole(userRole);
            both.addRole(adminRole);
            em.persist(userRole);
            em.persist(adminRole);
            em.persist(user);
            em.persist(admin);
            em.persist(both);

            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }
}
