package com.talkingparents.methods;

import com.talkingparents.pageobjectsandroid.InfoLibrary.newCardPage;

public class infoLibrary {

         public static boolean verifyCardDetails(newCardPage newCardPage, String title) {
                 boolean isVerified = true;
             
                 if (!newCardPage.titleTextField.getText().equals(title)) {
                     System.out.println("Title does not match.");
                     isVerified = false;
                 }
             
                 return isVerified;
             }
             
             public static boolean verifyCardDetails(newCardPage newCardPage, String title, String description) {
                     boolean isVerified = verifyCardDetails(newCardPage, title); // Call the simpler method
        
            if (!newCardPage.descriptionTextField.getText().equals(description)) {
                System.out.println("Description does not match.");
                isVerified = false;
            }
        
            return isVerified;
        }
        
        public static boolean verifyCardDetails(newCardPage newCardPage, String title, String description, String name) {
                boolean isVerified = verifyCardDetails(newCardPage, title, description); // Chain calls
        
            if (!newCardPage.nameTextField.getText().equals(name)) {
                System.out.println("Name does not match.");
                isVerified = false;
            }
        
            return isVerified;
        }
        
        public static boolean verifyCardDetails(newCardPage newCardPage, String title, String description, String name, String email) {
                boolean isVerified = verifyCardDetails(newCardPage, title, description, name); // Chain calls
        
            if (!newCardPage.emailTextField.getText().equals(email)) {
                System.out.println("Email does not match.");
                isVerified = false;
            }
        
            return isVerified;
        }
        
        // Add additional overloaded methods as needed
        public static boolean verifyCardDetails(newCardPage newCardPage, String title, String description, String name, String email, String phone) {
                boolean isVerified = verifyCardDetails(newCardPage, title, description, name, email);
        
            if (!newCardPage.phoneTextField.getText().equals(phone)) {
                System.out.println("Phone number does not match.");
                isVerified = false;
            }
        
            return isVerified;
        }
        
        public static boolean verifyCardDetails(newCardPage newCardPage, String title, String description, String name, String email, String phone, String address) {
                boolean isVerified = verifyCardDetails(newCardPage, title, description, name, email, phone);
        
            if (!newCardPage.addressTextField.getText().equals(address)) {
                System.out.println("Address does not match.");
                isVerified = false;
            }
        
            return isVerified;
        }
    
        public static boolean verifyCardDetails(newCardPage newCardPage, String title, String description, String name, String email, String phone, String address, String city, String state, String zip) {
            boolean isVerified = verifyCardDetails(newCardPage, title, description, name, email, phone, address);
    
        if (!newCardPage.cityTextField.getText().equals(city)) {
            System.out.println("City does not match.");
            isVerified = false;
        }
        if (!newCardPage.stateTextField.getText().equals(state)) {
            System.out.println("State does not match.");
            isVerified = false;
        }
        if (!newCardPage.zipTextField.getText().equals(zip)) {
            System.out.println("Zip code does not match.");
            isVerified = false;
        }
    
        return isVerified;
    }

    public static void enterCardDetails(newCardPage newCardPage, String title) {
        newCardPage.titleTextField.sendKeys(title);
        System.out.println("Card details entered with only title.");
    }
    
    public static void enterCardDetails(newCardPage newCardPage, String title, String description) {
        enterCardDetails(newCardPage, title); // Call the base method
        newCardPage.descriptionTextField.sendKeys(description);
        System.out.println("Card details entered with title and description.");
    }
    
    public static void enterCardDetails(newCardPage newCardPage, String title, String description, String name) {
        enterCardDetails(newCardPage, title, description); // Call the previous method
        newCardPage.nameTextField.sendKeys(name);
        System.out.println("Card details entered with title, description, and name.");
    }
    
    public static void enterCardDetails(newCardPage newCardPage, String title, String description, String name, String email) {
        enterCardDetails(newCardPage, title, description, name); // Call the previous method
        newCardPage.emailTextField.sendKeys(email);
        System.out.println("Card details entered with title, description, name, and email.");
    }
    
    // Add more overloads as needed for additional fields
    public static void enterCardDetails(newCardPage newCardPage, String title, String description, String name, String email, String phone) {
            enterCardDetails(newCardPage, title, description, name, email);
            newCardPage.phoneTextField.sendKeys(phone);
            System.out.println("Card details entered with title, description, name, email, and phone.");
        }
        
        public static void enterCardDetails(newCardPage newCardPage, String title, String description, String name, String email, String phone, String address) {
                enterCardDetails(newCardPage, title, description, name, email, phone);
            newCardPage.addressTextField.sendKeys(address);
            System.out.println("Card details entered with title, description, name, email, phone, and address.");
        }
        
        public static void enterCardDetails(newCardPage newCardPage, String title, String description, String name, String email, String phone, String address, String city, String state, String zip) {
            enterCardDetails(newCardPage, title, description, name, email, phone, address); // Call the previous method
        newCardPage.cityTextField.sendKeys(city);
        newCardPage.stateTextField.sendKeys(state);
        newCardPage.zipTextField.sendKeys(zip);
        System.out.println("Card details entered with all fields.");
    }
    


    
}
