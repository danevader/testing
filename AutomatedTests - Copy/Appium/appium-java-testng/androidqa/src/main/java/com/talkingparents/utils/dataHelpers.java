package com.talkingparents.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class dataHelpers {



    //Generate Random String//

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    //Create text version of today's date for Calendar testing//

    public static void main(String[] args) {
        System.out.println("today is the " + getDayWithSuffix());
    }

    // Create text version of today's date for Calendar testing
    public static String getDayWithSuffix() {
        // Get today's date
        LocalDate today = LocalDate.now();
        
        // Extract the day value as an integer
        int day = today.getDayOfMonth();
        
        // Determine the suffix
        String suffix = getDaySuffix(day);
        
        // Return the day along with the suffix
        return day + suffix;
    }

    private static String getDaySuffix(int day) {
        // Determine the suffix based on the day of the month
        if (day >= 11 && day <= 13) {
            return "th";  // Special case for 11th, 12th, 13th
        }
        
        // Return the appropriate suffix based on the last digit
        switch (day % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }



    public static String getTodaysDate() {
            // Get today's date
            LocalDate today = LocalDate.now();
            
            // Define the desired format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            
            // Return the date in the specified format
            return today.format(formatter);

    }


    public static String getDateWeeksFromNow(int weeks) {
        // Get today's date
        LocalDate today = LocalDate.now();
        
        // Add one week to today's date
        LocalDate oneWeekFromNow = today.plusWeeks(weeks);
        
        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        // Return the date a week from now in the specified format
        return oneWeekFromNow.format(formatter);
    }

    public static String generateRandomTime() {
        // Create an instance of Random
        Random random = new Random();
        
        // Generate random hour and minute
        int hour = random.nextInt(1, 13);  // Random hour between 1 and 12
        int minute = random.nextInt(60); // Random minute between 0 and 59
        
        // Create a LocalTime object with the generated values
        LocalTime randomTime = LocalTime.of(hour, minute);
        
        // Define the desired 12-hour time format (hh:mm)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        
        // Return the formatted random time as a single string
        return randomTime.format(formatter);
        
    }

    public static String generateRandomTime30MinutesLater(String randomTime) {
        // Define the 12-hour time format (hh:mm a)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        // Parse the string time into a LocalTime object
        LocalTime parsedTime = LocalTime.parse(randomTime, formatter);

        // Add 30 minutes to the parsed time
        LocalTime timeAfter30Minutes = parsedTime.plusMinutes(30);

        // Return the time 30 minutes later in 12-hour format with AM/PM
        return timeAfter30Minutes.format(formatter);
        }

        public static String getCurrentTime() {
            // Define the desired format "h:mm a"
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
            
            // Get the current time
            LocalTime currentTime = LocalTime.now();
            
            // Format the time
            return currentTime.format(formatter);
        }
    }



