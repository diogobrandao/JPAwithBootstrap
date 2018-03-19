package org.academiadecodigo.bootcamp.joined_table_inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "boat1")
public class Boat extends Vehicle {
    private Integer engines;
}
