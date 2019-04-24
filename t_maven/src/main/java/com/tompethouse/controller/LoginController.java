package com.tompethouse.controller;

import com.tompethouse.entities.CombineAppointment;
import com.tompethouse.entities.DogEntity;
import com.tompethouse.entities.UserEntity;
import com.tompethouse.service.ICombineAppointmentService;
import com.tompethouse.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import com.tompethouse.service.IUserService;


@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IDogService dogService;

//    @Autowired
//    private IAppointmentService appointmentService;

    @Autowired
    private ICombineAppointmentService combineAppointmentService;

    @PostMapping(value = "/user/login")
    public String login(Model model,@RequestParam("email") String email,
                        @RequestParam("password") String password, HttpSession session){

        if(userService.checkUser(email,password)){//authentication success
            session.setAttribute("loginUser",email);
            UserEntity user = userService.searchByEmail(email);
            model.addAttribute("user",user);
            List<DogEntity> dogs = dogService.findAllDog(user.getId());
            model.addAttribute("dogList",dogs);
            List<CombineAppointment> appoints = combineAppointmentService.findAppoByUserID(user.getId());
            model.addAttribute("appointmentList",appoints);
            return "profile";
        }else{
            model.addAttribute("info","Your e-mail or password is wrong!");
            return "login";
        }

    }
}
