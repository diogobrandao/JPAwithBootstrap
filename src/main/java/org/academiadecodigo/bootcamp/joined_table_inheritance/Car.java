package org.academiadecodigo.bootcamp.joined_table_inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car1")
public class Car extends Vehicle {
    private Integer gears;
}
