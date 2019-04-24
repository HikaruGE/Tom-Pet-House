package com.tompethouse.entities;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="userID")
    private Integer id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="home_addr")
    private String homeAddr;
    @Column(name="mobile_number")
    private String mobile;
    @Column(name="home_number")
    private String homeNumber;
    @Column(name="work_number")
    private String workNumber;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public String getMobile() {
        return mobile;
    }

    public String getHomeNum() {
        return homeNumber;
    }

    public String getWorkNum() {
        return workNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public void setHomeNum(String homeNum) {
        this.homeNumber = homeNum;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setWorkNum(String workNum) {
        this.workNumber = workNum;
    }
}
