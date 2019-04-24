package com.tompethouse.service;

import com.tompethouse.entities.CombineAppointment;

import java.util.List;

public interface ICombineAppointmentService {
    List<CombineAppointment> findAppoByUserID(Integer userID);
    List<CombineAppointment> searchAll();
}
