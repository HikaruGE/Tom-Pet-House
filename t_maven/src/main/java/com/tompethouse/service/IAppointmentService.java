package com.tompethouse.service;

import com.tompethouse.entities.AppointmentEntity;

import java.util.Date;
import java.util.List;

public interface IAppointmentService{
    List<Date> findAvailableTime();
    void addAppointment(Integer userID,Integer dogID,Date dateTime,Integer optionID,String comment);
    void editAppointment(Integer appointmentID,Integer userID,Integer dogID,Date dateTime,Integer optionID,String comment);
    AppointmentEntity searchByID(Integer id);
    void deleteAppointment(Integer id);
//    List<AppointmentEntity> findAllAppointment();
}
