package com.tompethouse.service;

import com.tompethouse.EmailSender;
import com.tompethouse.dao.IAppointmentDao;
import com.tompethouse.dao.IUserDao;
import com.tompethouse.entities.AppointmentEntity;
import com.tompethouse.entities.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmailService implements IEmailService {
	
    @Autowired
    IAppointmentDao appointmentDao;
    
    @Autowired
    IUserDao userDao;

    @Override
    public void sendEmail(ArrayList<String> emails) {
		EmailSender es = new EmailSender(emails);
    }
    
    public ArrayList<String> shortlistEmails(Date dateToCheck) {
		List<AppointmentEntity> allAppts = appointmentDao.findAll();
		ArrayList<Integer> shortlistedUserIDs = new ArrayList<Integer>();
    	ArrayList<String> shortlistedEmails = new ArrayList<String>();
		
		for (AppointmentEntity app : allAppts) {
			Date appTime = app.getTime();
			int timeDiff = (int)(((double)appTime.getTime() - (double)dateToCheck.getTime())/36000);
			//selects a user if the time difference is -24 hours
            if(timeDiff % 2 != 0){
                timeDiff++;
            }
			if (timeDiff == 2400) {
				shortlistedUserIDs.add(app.getUser());
			}			
//			System.out.println(timeDiff);
		}
		
		List<UserEntity> allUsers = userDao.findAll();
		
		for (UserEntity user : allUsers) {
			for (Integer i : shortlistedUserIDs) {
				if (i == user.getId()) {
					shortlistedEmails.add(user.getEmail());
				}
			}
			
		}
		
		//check for users

    	return shortlistedEmails;
    }
}
