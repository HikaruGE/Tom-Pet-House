package com.tompethouse.entities;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Immutable
@Table(name="combineappointment")
public class CombineAppointment  {
    @Id
    @Column(name="ID")
    private Integer appointmentID;
    @Column(name="userID")
    private Integer userID;
    @Column(name="dogID")
    private Integer dogID;
    @Column(name="time")
    private Date time;
    @Column(name="option")
    private Integer optionID;
    @Column(name="comment")
    private String comment;
    @Column(name="dogName")
    private String dogName;
    @Column(name="optionName")
    private String optionName;

    public Integer getAppointmentID() {
        return appointmentID;
    }

    public Integer getUserID() {
        return userID;
    }

    public Integer getDogID() {
        return dogID;
    }

    public Date getTime() {
        return time;
    }

    public Integer getOptionID() {
        return optionID;
    }

    public String getComment() {
        return comment;
    }

    public String getDogName() {
        return dogName;
    }

    public String getOptionName() {
        return optionName;
    }
}
