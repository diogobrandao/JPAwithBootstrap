package org.academiadecodigo.bootcamp.joined_table_inheritance;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JoinedTableInheritance {

    private EntityManagerFactory emf;

    public static void main(String[] args) {
        JoinedTableInheritance joinedTableInheritance = new JoinedTableInheritance();
        joinedTableInheritance.emf = Persistence.createEntityManagerFactory("test");


    }
}
