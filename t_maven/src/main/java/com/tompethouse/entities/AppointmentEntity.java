package com.tompethouse.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="appointment")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appointmentID")
    private Integer id;
    @Column(name="appuserID")
    private Integer user;
    @Column(name="appdogID")
    private Integer dog;
    @Column(name="time")
    private Date time;
    @Column(name="appoptionID")
    private Integer option;
    @Column(name="comment")
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getDog() {
        return dog;
    }

    public void setDog(Integer dog) {
        this.dog = dog;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
