package com.tompethouse.controller;

import com.tompethouse.entities.CombineAppointment;
import com.tompethouse.entities.DogEntity;
import com.tompethouse.entities.UserEntity;
import com.tompethouse.service.ICombineAppointmentService;
import com.tompethouse.service.IDogService;
import com.tompethouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IDogService dogService;

    @Autowired
    private ICombineAppointmentService combineAppointmentService;

    @PostMapping(value = "/user/register")
    public String register(Model model,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           Map<String,String> reply, HttpSession session){
        if(userService.checkUser(email)){
            userService.addUser(email,password);
            session.setAttribute("loginUser",email);


            UserEntity user = userService.searchByEmail(email);
            model.addAttribute("user",user);
            List<DogEntity> dogs = dogService.findAllDog(user.getId());
            model.addAttribute("dogList",dogs);
            List<CombineAppointment> appoints = combineAppointmentService.findAppoByUserID(user.getId());
            model.addAttribute("appointmentList",appoints);
            return "profile";
        }else{
            reply.put("info","Your e-mail is already registered!");
            return "register";
        }
    }
}
