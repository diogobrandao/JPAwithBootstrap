package org.academiadecodigo.bootcamp.many_to_one;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOne {
    private EntityManagerFactory emf;

    public static void main(String[] args) {
        ManyToOne manyToOne = new ManyToOne();
        manyToOne.emf = Persistence.createEntityManagerFactory("test");

        Category category = new Category();
        Product product = new Product();



    }
}
