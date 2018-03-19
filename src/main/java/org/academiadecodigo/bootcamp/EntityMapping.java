package org.academiadecodigo.bootcamp;

import javax.persistence.*;

public class EntityMapping {

    private EntityManagerFactory emf;

    public static void main(String[] args) {
        EntityMapping entityMapping = new EntityMapping();
        entityMapping.emf = Persistence.createEntityManagerFactory("test");

        User user = new User();
        user.setEmail("diogobrandao@");
        user.setName("Diogo");
        user.setId(1);
        entityMapping.addUser(user);
        entityMapping.findById(1).getName();
        System.out.println(entityMapping.findById(1).getName());


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


