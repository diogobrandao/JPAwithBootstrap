package org.academiadecodigo.bootcamp.single_table_inheritance;

import org.academiadecodigo.bootcamp.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class SingleTableInheritance {

    private EntityManagerFactory emf;

    public static void main(String[] args) {
        SingleTableInheritance singleTableInheritance = new SingleTableInheritance();
        singleTableInheritance.emf = Persistence.createEntityManagerFactory("test");

        Boat boat = new Boat();
        boat.setEngines(2);
        singleTableInheritance.addUser(boat);


    }

    public Vehicle addUser(Vehicle vehicle) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            Vehicle savedCustomer = em.merge(vehicle);
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
