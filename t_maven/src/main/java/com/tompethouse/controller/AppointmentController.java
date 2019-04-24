package com.tompethouse.controller;

import com.tompethouse.entities.*;
import com.tompethouse.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @Autowired
    private IDogService dogService;

    @Autowired
    private IOptionService optionService;

    @Autowired
    private ICombineAppointmentService combineAppointmentService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/user/add_appointment/{id}")
    public String toAddAppointment(Model model, @PathVariable("id") Integer userId){
        List<Date> times = appointmentService.findAvailableTime();
        model.addAttribute("times",times);
        List<DogEntity> dogs = dogService.findAllDog(userId);
        model.addAttribute("dogs",dogs);
        List<OptionEntity> options = optionService.searchOptions();
        model.addAttribute("options",options);
        AppointmentEntity appointment = null;
        model.addAttribute("appointment",appointment);
        model.addAttribute("isAdd",0);
        model.addAttribute("user",userId);
        return "appointment";
    }

    @PostMapping(value = "/user/add_appointment_finish/{id}")
    public String addAppointment(Model model,
                                  @PathVariable("id") Integer userID,
                                  @RequestParam("time") String time,
                                  @RequestParam("dogID") Integer dogID,
                                  @RequestParam("optionID") Integer optionID,
                                  @RequestParam("comment") String comment){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateTime = null;
        try {
            dateTime= sdf.parse(time);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        appointmentService.addAppointment(userID,dogID,dateTime,optionID,comment);

        UserEntity user = userService.searchByUserID(userID);
        model.addAttribute("user",user);
        List<DogEntity> dogs = dogService.findAllDog(user.getId());
        model.addAttribute("dogList",dogs);
        List<CombineAppointment> appoints = combineAppointmentService.findAppoByUserID(user.getId());
        model.addAttribute("appointmentList",appoints);
        return "profile";
    }

    @GetMapping(value = "/user/edit_appointment/{id1}/{id2}")
    public String editAppointment(Model model,
                                  @PathVariable("id1") Integer userID,
                                  @PathVariable("id2") Integer appointmentID){
        List<Date> times = appointmentService.findAvailableTime();
        model.addAttribute("times",times);
        List<DogEntity> dogs = dogService.findAllDog(userID);
        model.addAttribute("dogs",dogs);
        List<OptionEntity> options = optionService.searchOptions();
        model.addAttribute("options",options);
        AppointmentEntity appointment = appointmentService.searchByID(appointmentID);
        model.addAttribute("appointment",appointment);
        model.addAttribute("user",userID);
        return  "editappointment";
    }

    @PostMapping(value = "/user/edit_appointment_finish/{id1}/{id2}")
    public String editAppointment(Model model,
                                 @PathVariable("id1") Integer userID,
                                 @PathVariable("id2") Integer appointmentID,
                                 @RequestParam("time") String time,
                                 @RequestParam("dogID") Integer dogID,
                                 @RequestParam("optionID") Integer optionID,
                                 @RequestParam("comment") String comment){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateTime = null;
        try {
            dateTime= sdf.parse(time);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        appointmentService.editAppointment(appointmentID,userID,dogID,dateTime,optionID,comment);

        UserEntity user = userService.searchByUserID(userID);
        model.addAttribute("user",user);
        List<DogEntity> dogs = dogService.findAllDog(user.getId());
        model.addAttribute("dogList",dogs);
        List<CombineAppointment> appoints = combineAppointmentService.findAppoByUserID(user.getId());
        model.addAttribute("appointmentList",appoints);
        return "profile";
    }

    @GetMapping(value = "/user/delete_appointment/{id1}/{id2}")
    public String deleteAppointment(Model model,
                                    @PathVariable("id1") Integer userID,
                                    @PathVariable("id2") Integer appointmentID){

        appointmentService.deleteAppointment(appointmentID);

        UserEntity user = userService.searchByUserID(userID);
        model.addAttribute("user",user);
        List<DogEntity> dogs = dogService.findAllDog(user.getId());
        model.addAttribute("dogList",dogs);
        List<CombineAppointment> appoints = combineAppointmentService.findAppoByUserID(user.getId());
        model.addAttribute("appointmentList",appoints);
        return "profile";
    }
}
