package com.tompethouse.dao;

import com.tompethouse.entities.CombineAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICombineAppointmentDao extends JpaRepository<CombineAppointment,Integer> {
    List<CombineAppointment> findByUserID(Integer userID);
    List<CombineAppointment> findAll();
}
