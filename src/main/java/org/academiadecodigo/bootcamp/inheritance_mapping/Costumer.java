package org.academiadecodigo.bootcamp.inheritance_mapping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "costumer")
public class Costumer extends AbstractModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


