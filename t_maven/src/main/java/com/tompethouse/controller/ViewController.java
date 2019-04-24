package com.tompethouse.controller;

import com.tompethouse.entities.CombineAppointment;
import com.tompethouse.entities.UserEntity;
import com.tompethouse.service.CombineAppointmentService;
import com.tompethouse.service.ICombineAppointmentService;
import com.tompethouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class ViewController {

    @Autowired
    IUserService userService;

    @Autowired
    ICombineAppointmentService combineAppointmentService;

    @RequestMapping(value = "/viewer")
    public String viewer(Model model){
        List<UserEntity> users = userService.findAll();
        List<CombineAppointment> appointments = combineAppointmentService.searchAll();
        model.addAttribute("userList",users);
        model.addAttribute("appointmentList",appointments);
        return "viewer";
    }
}
