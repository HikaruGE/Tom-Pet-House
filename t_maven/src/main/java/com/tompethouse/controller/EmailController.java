package com.tompethouse.controller;

import com.tompethouse.entities.CombineAppointment;
import com.tompethouse.entities.DogEntity;
import com.tompethouse.entities.UserEntity;
import com.tompethouse.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EmailController {
	
    @Autowired
    private IEmailService emailService;
    

    @GetMapping(value = "/activatereminders")
    public String email(Model model) {
    	//this loop will run perpetually, but only check for appointments every minute
    	boolean term = false;
    	SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
    	SimpleDateFormat interval = new SimpleDateFormat("mm");
    	String previousMinute = "";
    	while (!term) {
    		if (!interval.format(new Date()).equals(previousMinute)) {
    			previousMinute = interval.format(new Date());
    			Date dateToCheck = new Date();
    			
    			ArrayList<String> shortlistedEmails = emailService.shortlistEmails(dateToCheck);
    			for (String email : shortlistedEmails) {
    				System.out.println(email);
    			}
    			emailService.sendEmail(shortlistedEmails);
    			System.out.println(datetime.format(new Date()));
    		}
    	}
//    	String[] shortlistedEmails = emailService.shortlistEmails();
//        emailService.sendEmail(shortlistedEmails);
        return "viewer";
    }
}
