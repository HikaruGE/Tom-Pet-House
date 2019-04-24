package com.tompethouse.service;


import org.springframework.web.bind.annotation.RequestParam;

import com.tompethouse.entities.UserEntity;

import java.util.List;

public interface IUserService {
    boolean checkUser(String email,String password);
    boolean checkUser(String email);
    void addUser(String email,String password);
    void editUser(Integer id,
				String name,
				String homeAddr,
				String mobile,
				String homeNum,
				String workNum);
    UserEntity searchByEmail(String email);
    UserEntity searchByUserID(Integer id);
    List<UserEntity> findAll();
}
