package com.tompethouse.dao;

import com.tompethouse.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserDao extends JpaRepository<UserEntity,Integer> {
    UserEntity findByEmailAndPassword(String email,String password);
    UserEntity findByEmail(String email);
    UserEntity findOneById(Integer id);
    UserEntity save(UserEntity userEntity);
    UserEntity saveAndFlush(UserEntity userEntity);
    List<UserEntity> findAll();
}
