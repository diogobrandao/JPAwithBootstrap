package org.academiadecodigo.bootcamp.one_to_one;

import org.academiadecodigo.bootcamp.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class OneToOne {
    private EntityManagerFactory emf;

    public static void main(String[] args) {
        OneToOne oneToOne = new OneToOne();
        oneToOne.emf = Persistence.createEntityManagerFactory("test");

        Car car = new Car();
        Car car1 = new Car();
        Owner owner = new Owner();
        Owner owner1 = new Owner();
        car.setId(1);
        car1.setId(2);
        owner.setId(1);
        owner1.setId(2);
        car.setOwner(owner);
        car1.setOwner(owner1);
        car.setMake("Opel");
        car1.setMake("Hyundai");
        car.setModel("Corsa");
        car1.setModel("Accent");
        owner.setName("Diogo");
        owner.setCar(car);
        owner.setId(1);
        owner1.setName("Luís");
        owner1.setCar(car1);
        owner1.setId(2);

        oneToOne.findById(1);
        oneToOne.findById(2);
        oneToOne.addOwner(owner);
        oneToOne.addOwner(owner1);
        System.out.println(oneToOne.findById(2).getName());







    }

    public void addOwner(Owner owner) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction

            Owner savedOwner = em.merge(owner);

            em.getTransaction().commit(); // close transaction

        } catch (RollbackException ex) {


        } finally {
            if (em != null) {
                em.close();
            }


        }

    }

    public Owner findById(Integer id) {

        // open a new connection to the database
        EntityManager em = emf.createEntityManager();
        try {
            // fetch a new user using its id
            return em.find(Owner.class, 1); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }


}

