package com.tompethouse.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tompethouse.entities.CombineAppointment;
import com.tompethouse.entities.DogEntity;
import com.tompethouse.entities.UserEntity;
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
public class dogController {
    @Autowired
    private IAppointmentService appointmentService;

    @Autowired
    private IDogService dogService;

    @Autowired
    private ICombineAppointmentService combineAppointmentService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/user/adddog/{id}")
    public String toAddDog(Model model,
                           @PathVariable("id") Integer userID){
        model.addAttribute("user",userID);
        return "adddog";
    }

    @PostMapping(value = "/user/adddog_finish/{id}")
    public String addDogFinish(Model model,
                               @PathVariable("id") Integer userID,
                               @RequestParam("name") String dogName,
                               @RequestParam("breed") String dogBreed,
                               @RequestParam("dob") Date dob){

        dogService.addDogByUserID(userID,dogName,dogBreed,dob);

        UserEntity user = userService.searchByUserID(userID);
        model.addAttribute("user",user);
        List<DogEntity> dogs = dogService.findAllDog(user.getId());
        model.addAttribute("dogList",dogs);
        List<CombineAppointment> appoints = combineAppointmentService.findAppoByUserID(user.getId());
        model.addAttribute("appointmentList",appoints);
        return "profile";
    }

    @GetMapping(value = "/user/dogEdit/{id1}/{id2}")
    public String editDog(Model model,
                          @PathVariable("id1") Integer userID,
                          @PathVariable("id2") Integer dogID){
        DogEntity dogEntity = dogService.findDogByID(dogID);
        model.addAttribute("dog",dogEntity);
        model.addAttribute("user",userID);
        return "editdog";
    }

    @PostMapping(value = "/user/eidtdog_finish/{id1}/{id2}")
    public String editDog(Model model,
                          @PathVariable("id1") Integer userID,
                          @PathVariable("id2") Integer dogID,
                          @RequestParam("name") String dogName,
                          @RequestParam("breed") String dogBreed,
                          @RequestParam("dob") Date dob){

        dogService.editDog(dogID,userID,dogName,dogBreed,dob);

        UserEntity user = userService.searchByUserID(userID);
        model.addAttribute("user",user);
        List<DogEntity> dogs = dogService.findAllDog(user.getId());
        model.addAttribute("dogList",dogs);
        List<CombineAppointment> appoints = combineAppointmentService.findAppoByUserID(user.getId());
        model.addAttribute("appointmentList",appoints);
        return "profile";
    }


    @GetMapping(value = "/user/dogDelete/{id1}/{id2}")
    public String deleteAppointment(Model model,
                                    @PathVariable("id1") Integer userID,
                                    @PathVariable("id2") Integer dogID){

        dogService.deleteDog(dogID);

        UserEntity user = userService.searchByUserID(userID);
        model.addAttribute("user",user);
        List<DogEntity> dogs = dogService.findAllDog(user.getId());
        model.addAttribute("dogList",dogs);
        List<CombineAppointment> appoints = combineAppointmentService.findAppoByUserID(user.getId());
        model.addAttribute("appointmentList",appoints);
        return "profile";
    }

}
