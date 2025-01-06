package com.example;

// Importing required classes
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// Annotation
@Component
// Class
public class ScheduledTask {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

    // Method to trigger the scheduler every minute between 19:00 to 19:59
    @Scheduled(cron = "0 * 19 * * ?")
    public void scheduleTask() {
        logTime("Task triggered by cron expression");
    }

    // Method to trigger the scheduler at a fixed rate of 5 seconds
    @Scheduled(fixedRate = 5000)
    public void fixedRateTask() {
        logTime("Task triggered at a fixed rate");
    }

    // Method to trigger the scheduler with a fixed delay of 10 seconds
    @Scheduled(fixedDelay = 10000)
    public void fixedDelayTask() {
        logTime("Task triggered with a fixed delay");
    }

    // Method to trigger the scheduler with an initial delay of 10 seconds and then every 15 seconds
    @Scheduled(fixedDelay = 15000, initialDelay = 10000)
    public void initialDelayTask() {
        logTime("Task triggered with an initial delay");
    }

    // Method to trigger the scheduler using cron expression to execute at 6 AM every Monday
    @Scheduled(cron = "0 0 6 ? * MON")
    public void weeklyMondayTask() {
        logTime("Task triggered every Monday at 6 AM");
    }

    // Method to trigger the scheduler every day at midnight
    @Scheduled(cron = "0 0 0 * * ?")
    public void dailyMidnightTask() {
        logTime("Task triggered at midnight every day");
    }

    // Helper method to log the current date and time with a custom message
    private void logTime(String message) {
        String strDate = dateFormat.format(new Date());
        System.out.println(message + " - Current time: " + strDate);
    }
}
