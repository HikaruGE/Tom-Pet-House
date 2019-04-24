package com.tompethouse.service;

import com.tompethouse.dao.IOptionDao;
import com.tompethouse.entities.OptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService implements IOptionService {

    @Autowired
    private IOptionDao optionDao;

    @Override
    public List<OptionEntity> searchOptions() {
        return optionDao.findAll();
    }
}
