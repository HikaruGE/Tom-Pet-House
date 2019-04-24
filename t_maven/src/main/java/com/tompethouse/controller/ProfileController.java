package com.tompethouse.controller;

import com.tompethouse.entities.CombineAppointment;
import com.tompethouse.entities.DogEntity;
import com.tompethouse.entities.UserEntity;
import com.tompethouse.service.ICombineAppointmentService;
import com.tompethouse.service.IDogService;
import com.tompethouse.service.IOptionService;
import com.tompethouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Column;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ProfileController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IDogService dogService;

    @Autowired
    private ICombineAppointmentService combineAppointmentService;


    @PostMapping(value = "/user/edit_profile/{id}")
    public String profile( @PathVariable("id") Integer userId,
                           @RequestParam("name") String name,
                           @RequestParam("homeAddr") String homeAddr,
                           @RequestParam("mobile") String mobile,
                           @RequestParam("homeNum") String homeNum,
                           @RequestParam("workNum") String workNum,    
                           Model model){
            userService.editUser(
                                userId,
            					name,
            					homeAddr,
            					mobile,
            					homeNum,
            					workNum);

        UserEntity user = userService.searchByUserID(userId);
        model.addAttribute("user",user);
        List<DogEntity> dogs = dogService.findAllDog(user.getId());
        model.addAttribute("dogList",dogs);
        List<CombineAppointment> appoints = combineAppointmentService.findAppoByUserID(user.getId());
        model.addAttribute("appointmentList",appoints);
        return "profile";
        
    }
}
