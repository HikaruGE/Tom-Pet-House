package com.tompethouse.dao;

import com.tompethouse.entities.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDogDao extends JpaRepository<DogEntity,Integer> {
    List<DogEntity> findByUserId(Integer userID);
    DogEntity save(DogEntity dog);
    DogEntity saveAndFlush(DogEntity dog);
    void deleteById(Integer id);
    DogEntity findOneByDogId(Integer id);
}
