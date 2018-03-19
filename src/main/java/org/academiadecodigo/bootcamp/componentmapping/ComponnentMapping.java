package org.academiadecodigo.bootcamp.componentmapping;

import org.academiadecodigo.bootcamp.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class ComponnentMapping {

    private EntityManagerFactory emf;

    public static void main(String[] args) {
    ComponnentMapping componnentMapping = new ComponnentMapping();
    componnentMapping.emf = Persistence.createEntityManagerFactory("test");

        User user1 = new User();
        user1.setEmail("davide@");
        user1.setName("davide");
        user1.setId(2);
        componnentMapping.addUser(user1);
        componnentMapping.findById(2).getName();
        System.out.println(componnentMapping.findById(2).getName());

    }

    public User findById(Integer id) {

        // open a new connection to the database
        EntityManager em = emf.createEntityManager();
        try {
            // fetch a new user using its id
            return em.find(User.class, 1); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    public User addUser(User user) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            User savedCustomer = em.merge(user);
            em.getTransaction().commit(); // close transaction
            return savedCustomer;

        } catch (RollbackException ex) {

            // something went wrong, make sure db is consistent
            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }


        }

    }
}
