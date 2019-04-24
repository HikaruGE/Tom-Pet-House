package com.tompethouse.service;

import com.tompethouse.dao.ICombineAppointmentDao;
import com.tompethouse.entities.CombineAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombineAppointmentService implements ICombineAppointmentService {
    @Autowired
    ICombineAppointmentDao combineAppointmentDao;

    @Override
    public List<CombineAppointment> findAppoByUserID(Integer userID) {
        return combineAppointmentDao.findByUserID(userID);
    }

    @Override
    public List<CombineAppointment> searchAll() {
        return combineAppointmentDao.findAll();
    }
}
