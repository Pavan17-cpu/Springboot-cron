package com.example;


//Importing required classes
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//Annotation
@Component
//Class
public class ScheduledTask {

 // Method
 // To trigger the scheduler every one minute
 // between 19:00 PM to 19:59 PM
 @Scheduled(cron = "0 * 18 * * ?")
 public void scheduleTask()
 {
     SimpleDateFormat dateFormat = new SimpleDateFormat(
         "dd-MM-yyyy HH:mm:ss.SSS");

     String strDate = dateFormat.format(new Date());

     System.out.println(
         "Cron job Scheduler: Job running at - "
         + strDate);
 }
}