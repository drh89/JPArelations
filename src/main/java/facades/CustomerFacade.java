/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Address;
import entities.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dennis
 */
public class CustomerFacade {

    private static CustomerFacade cf;
    private static EntityManagerFactory emf;

    //private to ensure singleton
    private CustomerFacade() {

    }

    public static CustomerFacade getFacadeExample(EntityManagerFactory _emf) {
        if (cf == null) {
            emf = _emf;
            cf = new CustomerFacade();
        }

        return cf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Customer addCustomer(Customer cus) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cus);
        cus.getAddress().forEach((ad) -> {

            em.persist(ad);
        });
        em.getTransaction().commit();
        em.close();
        return cus;
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade cf = CustomerFacade.getFacadeExample(emf);

        Customer cus = new Customer(0, "Jens", "Hansen");
        cus.getAddress().add(new Address(0, "Haraldsgade", "Copenhagen"));
        cus.getAddress().add(new Address(0, "Husumgade", "Copenhagen"));
        
//        cus.addHobby("Football");
//        cus.addHobby("Handball");
//        cus.addPhone("22334455", "Jens' private phone");
//        cus.addPhone("22334466", "Jens' work phone");
        Customer cus1 = new Customer(0, "Hans", "Jensen");
        cus1.getAddress().add(new Address(0, "Nansensgade", "Copenhagen"));
        cus1.getAddress().add(new Address(0, "Haraldsgade", "Copenhagen"));
        
        

//        cus1.addPhone("55443322", "Hans' private phone");
//        cus1.addPhone("55443399", "Hans' work phone");
//        cus1.addHobby("VolleyBall");
//        cus1.addHobby("Badminton");
        cf.addCustomer(cus);
        cf.addCustomer(cus1);
    }
}
