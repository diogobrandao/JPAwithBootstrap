package org.academiadecodigo.bootcamp.joined_table_inheritance;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    private Integer id;
    private Integer maxSpeed;
}
