package com.tompethouse.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="dog")
public class DogEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="dogID")
    private Integer dogId;
    @Column(name="userID")
    private Integer userId;
    @Column(name="name")
    private String name;
    @Column(name="breed")
    private String breed;
    @Column(name="DoB")
    private Date doB;

    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }
}
