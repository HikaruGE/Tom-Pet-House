package com.tompethouse.dao;

import com.tompethouse.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAppointmentDao extends JpaRepository<AppointmentEntity,Integer> {
    List<AppointmentEntity> findAll();
    AppointmentEntity save(AppointmentEntity appointmentEntity);
    AppointmentEntity saveAndFlush(AppointmentEntity appointmentEntity);
    AppointmentEntity findOneById(Integer id);
    void deleteById(Integer id);
}
