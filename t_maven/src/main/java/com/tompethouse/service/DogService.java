package com.tompethouse.service;

import com.tompethouse.dao.IDogDao;
import com.tompethouse.entities.DogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DogService implements IDogService{
    @Autowired
    private IDogDao dogDao;

    @Override
    public List<DogEntity> findAllDog(Integer userID) {
        return dogDao.findByUserId(userID);
    }

    @Override
    public void deleteDog(Integer dogID) {
        dogDao.deleteById(dogID);
    }

    @Override
    public DogEntity findDogByID(Integer id) {
        return dogDao.findOneByDogId(id);
    }

    @Override
    public void addDogByUserID(Integer userID, String name, String breed, Date dob) {
        DogEntity dogEntity = new DogEntity();
        dogEntity.setUserId(userID);
        dogEntity.setName(name);
        dogEntity.setBreed(breed);
        dogEntity.setDoB(dob);
        dogDao.save(dogEntity);
    }

    @Override
    public void editDog(Integer dogID, Integer userID, String dogName, String dogBreed, Date dob) {
        DogEntity dogEntity = dogDao.findOneByDogId(dogID);
        dogEntity.setName(dogName);
        dogEntity.setBreed(dogBreed);
        dogEntity.setDoB(dob);
        dogDao.saveAndFlush(dogEntity);
    }
}
