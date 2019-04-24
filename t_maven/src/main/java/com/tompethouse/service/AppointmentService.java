package com.tompethouse.service;

import com.tompethouse.dao.IAppointmentDao;
import com.tompethouse.entities.AppointmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    IAppointmentDao appointmentDao;

//    public void test() {
////    	List<AppointmentEntity> allAppoint = appointmentDao.findAll();
////    	for (AppointmentEntity app : allAppoint) {
////    		System.out.println(app.getTime());
////    	}
//    }
    
    @Override
    public void addAppointment(Integer userID,Integer dogID,Date dateTime,Integer optionID,String comment) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setUser(userID);
        appointmentEntity.setDog(dogID);
        appointmentEntity.setTime(dateTime);
        appointmentEntity.setOption(optionID);
        appointmentEntity.setComment(comment);
        appointmentDao.save(appointmentEntity);
    }

    @Override
    public void editAppointment(Integer appointmentID, Integer userID, Integer dogID, Date dateTime, Integer optionID, String comment) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setId(appointmentID);
        appointmentEntity.setUser(userID);
        appointmentEntity.setDog(dogID);
        appointmentEntity.setTime(dateTime);
        appointmentEntity.setOption(optionID);
        appointmentEntity.setComment(comment);
        appointmentDao.saveAndFlush(appointmentEntity);
    }

    @Override
    public List<Date> findAvailableTime() { //return available time within three days

        List<AppointmentEntity> allAppoint = appointmentDao.findAll();
        List<String> existTime = new ArrayList<>();
        List<Date> availableTime = new ArrayList<>();

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date start = calendar.getTime();
        Date end;
        Date now = calendar.getTime();
        List<String> dayList = new ArrayList<>();
        Date nowDay;

        try{
            for(int i = 0;i<3;i++){
                nowDay = sdf1.parse(sdf1.format(now));
                dayList.add(sdf1.format(nowDay));
                calendar.add(Calendar.DAY_OF_YEAR,1);
                now = calendar.getTime();
            }
            calendar.add(Calendar.DAY_OF_YEAR,-1);
            end = sdf.parse(sdf1.format(calendar.getTime())+" 23:59:59");

            List<String> timeList = new ArrayList<>();
            timeList.add(" 09:00");
            timeList.add(" 10:30");
            timeList.add(" 14:00");
            timeList.add(" 15:30");
            timeList.add(" 16:11");

            for(AppointmentEntity x: allAppoint){
                if(x.getTime().after(start) && x.getTime().before(end)){
                    existTime.add(sdf.format(x.getTime()));
                }
            }

            for(String x:dayList){
                for(String y:timeList){
                    String datetime = x+y;
                    Date date = sdf.parse(datetime);
                    if(!existTime.contains(datetime) && date.after(new Date())){
                        availableTime.add(date);
                    }
                }
            }

        }catch (ParseException e) {
            e.printStackTrace();
        }

        return availableTime;
    }

    @Override
    public AppointmentEntity searchByID(Integer id) {
        return appointmentDao.findOneById(id);
    }

    @Override
    public void deleteAppointment(Integer id) {
        appointmentDao.deleteById(id);
    }
    
    public IAppointmentDao getIAppDao() {
    	return appointmentDao;
    }
}
