package com.tompethouse.service;

import com.tompethouse.dao.IUserDao;
import com.tompethouse.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public boolean checkUser(String email){//for register check
        UserEntity userEntity = userDao.findByEmail(email);
        if(userEntity == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkUser(String email, String password) {//for login check
        UserEntity userEntity = userDao.findByEmailAndPassword(email,password);
        if(userEntity == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void addUser(String email, String password) {//insert
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(password);
        userDao.save(user);
    }
    
    public void editUser(Integer id,
						String name,
						String homeAddr,
						String mobile,
						String homeNum,
						String workNum) {
    	UserEntity user =  userDao.findOneById(id);
    	user.setName(name);
    	user.setHomeAddr(homeAddr);
    	user.setMobile(mobile);
    	user.setHomeNum(homeNum);
    	user.setWorkNum(workNum);
    	userDao.saveAndFlush(user);
    }
    		
    
    @Override
    public UserEntity searchByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public UserEntity searchByUserID(Integer id) {
        return userDao.findOneById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }
}
