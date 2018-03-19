package org.academiadecodigo.bootcamp.inheritance_mapping;

import org.academiadecodigo.bootcamp.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class InheritanceMapping {

    private EntityManagerFactory emf;

    public static void main(String[] args) {
        InheritanceMapping inheritanceMapping = new InheritanceMapping();
        inheritanceMapping.emf = Persistence.createEntityManagerFactory("test");

        User user2 = new User();
        user2.setName("Angelo");
        user2.setEmail("angelo@");
        user2.setId(3);
        inheritanceMapping.addUser(user2);
        inheritanceMapping.findById(3);
        inheritanceMapping.findById(3).getName();
        System.out.println(inheritanceMapping.findById(3).getName());

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
