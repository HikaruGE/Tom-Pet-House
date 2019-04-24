package com.tompethouse.service;

import com.tompethouse.entities.DogEntity;

import java.util.Date;
import java.util.List;

public interface IDogService {
    List<DogEntity> findAllDog(Integer userID);
    void deleteDog(Integer dogID);
    void addDogByUserID(Integer userID, String name, String breed, Date dob);
    DogEntity findDogByID(Integer id);
    void editDog(Integer dogID,Integer userID,String dogName,String dogBreed,Date dob);
}
