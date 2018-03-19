package org.academiadecodigo.bootcamp.one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Table(name = "ownerOnetoOne")
public class Owner {

    @Id
    private Integer id;
    private String name;

    @OneToOne(
    cascade = {CascadeType.ALL},
    orphanRemoval = true,
    mappedBy = "owner"
    )
    private  Car car;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
