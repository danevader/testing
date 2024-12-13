package com.talkingparents.positive.infoLibrary;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talkingparents.setUpConfigNative;
import com.talkingparents.pageobjectsandroid.Global.globalPage;
import com.talkingparents.pageobjectsandroid.InfoLibrary.infoLibraryFeaturePage;
import com.talkingparents.pageobjectsandroid.InfoLibrary.newCardPage;
import com.talkingparents.pageobjectsandroid.Login.loginPages;
import com.talkingparents.utils.AndroidActions;

public class createSharedCard extends setUpConfigNative {

    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        // Wait for a max of 10 seconds
    }

    @Test(priority = 1, dataProvider = "getData")
    public void login(String email, String password) {
        // Login and get past the messages welcome sheet
        loginPages loginPage = new loginPages(driver);
        loginPage.existingAccountLink.click();
        loginPage.setEmailField(email);
        loginPage.setPasswordField(password);
        loginPage.signInButton.click();
        globalPage globalPage = new globalPage(driver);

        // Wait for the element to be visible before interacting with it
        wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeaderImage));
        Assert.assertTrue(globalPage.onboardHeaderImage.isDisplayed());
        globalPage.onboardContinueButton.click();
    }

    @Test(priority = 2)
    public void createShared() throws TimeoutException {
        infoLibraryFeaturePage infoLibFeatPage = new infoLibraryFeaturePage(driver);
        newCardPage newcardpage = new newCardPage(driver);

        // Navigate to Journal feature
        wait.until(ExpectedConditions.visibilityOf(globalPage.moreSettings));
        globalPage.moreSettings.click();

        wait.until(ExpectedConditions.visibilityOf(globalPage.infoLibraryFeature));
        globalPage.infoLibraryFeature.click();

        wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed();
        globalPage.onboardContinueButton.click();

        wait.until(ExpectedConditions.visibilityOf(infoLibFeatPage.newCardButton)).isDisplayed();
        
        featureStateCheck();

        wait.until(ExpectedConditions.visibilityOf(newcardpage.newCardHeaderText)).isDisplayed();
        
       

        // Call enterCardDetails
        enterCardDetails(newcardpage, title, description, name, email, phone, address, city, state, zip);
        
    }

    @Test(priority = 3)
    public void checkDetailEntry(){

        newCardPage newcardPage = new newCardPage(driver);

        verifyCardDetails(newcardPage, title, description, name, email, phone, address, city, state, zip);

    }

    @Test(priority = 4)
    public void shareAndSaveCard(){

        newCardPage newcardpage = new newCardPage(driver);

        newcardpage.shareCardToggle.click();

        AndroidActions.scrollToTextAction("Save");

        wait.until(ExpectedConditions.visibilityOf(newcardpage.saveCardButton)).isDisplayed();

        newcardpage.saveCardButton.click();

    }


/* 
    @Test(priority = 5)
    public void checkCardListView(){

        
        infoLibraryFeaturePage infoLibFeatPage = new infoLibraryFeaturePage(driver);

 
    }
*/
    

    //Local Variables//

    String title = "Test title";
    String description = "Test description";
    String name = "Test name";
    String email = "testemail@emailtest.com";
    String phone = "+1234567890";
    String address = "101 Test Lane";
    String city = "Test City";
    String state = "FL";
    String zip = "12345";


     // Helper methods

    public void enterCardDetails(newCardPage newCardPage, String title, String description, String name, String email, String phone, String address, String city, String state, String zip) {
        
        
        // Enter details in the fields
        newCardPage.titleTextField.sendKeys(title);
        newCardPage.descriptionTextField.sendKeys(description);
        newCardPage.nameTextField.sendKeys(name);
        newCardPage.emailTextField.sendKeys(email);
        newCardPage.phoneTextField.sendKeys(phone);
        newCardPage.addressTextField.sendKeys(address);
        newCardPage.cityTextField.sendKeys(city);
        newCardPage.stateTextField.sendKeys(state);
        newCardPage.zipTextField.sendKeys(zip);

        // Optionally, add a logger or print statements for debugging
        System.out.println("Card details entered successfully.");
    }

    @SuppressWarnings("deprecation")
    public boolean verifyCardDetails(newCardPage newCardPage, String title, String description, String name, String email, String phone, String address, String city, String state, String zip) {
        boolean isVerified = true;
    
        // Verify that each field contains the correct value
        if (!newCardPage.titleTextField.getAttribute("text").equals(title)) {
            System.out.println("Title does not match.");
            isVerified = false;
        }
        if (!newCardPage.descriptionTextField.getAttribute("text").equals(description)) {
            System.out.println("Description does not match.");
            isVerified = false;
        }
        if (!newCardPage.nameTextField.getAttribute("text").equals(name)) {
            System.out.println("Name does not match.");
            isVerified = false;
        }
        if (!newCardPage.emailTextField.getAttribute("text").equals(email)) {
            System.out.println("Email does not match.");
            isVerified = false;
        }
        if (!newCardPage.phoneTextField.getAttribute("text").equals(phone)) {
            System.out.println("Phone number does not match.");
            isVerified = false;
        }
        if (!newCardPage.addressTextField.getAttribute("text").equals(address)) {
            System.out.println("Address does not match.");
            isVerified = false;
        }
        if (!newCardPage.cityTextField.getAttribute("text").equals(city)) {
            System.out.println("City does not match.");
            isVerified = false;
        }
        if (!newCardPage.stateTextField.getAttribute("text").equals(state)) {
            System.out.println("State does not match.");
            isVerified = false;
        }
        if (!newCardPage.zipTextField.getAttribute("text").equals(zip)) {
            System.out.println("Zip code does not match.");
            isVerified = false;
        }
    
        return isVerified;
    }


    public void featureStateCheck() {
        infoLibraryFeaturePage infoLibFeatPage = new infoLibraryFeaturePage(driver);
        boolean isTemplateLayoutVisible = false; // Flag for template layout visibility
        boolean isCardFilterOptionsVisible = false; // Flag for card filter options visibility
    
        try {
            // Check if the template layout is visible
            try {
                if (wait.until(ExpectedConditions.visibilityOf(infoLibFeatPage.templateLayout)).isDisplayed()) {
                    isTemplateLayoutVisible = true;
                }
            } catch (org.openqa.selenium.TimeoutException e) {
                System.out.println("Template layout is not visible within the specified timeout.");
            }
    
            // Check if the card filter options are visible
            try {
                if (wait.until(ExpectedConditions.visibilityOf(infoLibFeatPage.cardFilterOptions)).isDisplayed()) {
                    isCardFilterOptionsVisible = true;
                }
            } catch (org.openqa.selenium.TimeoutException e) {
                System.out.println("Card filter options are not visible within the specified timeout.");
            }
    
            // Log the state of the flags
            System.out.println("Template Layout Visible: " + isTemplateLayoutVisible);
            System.out.println("Card Filter Options Visible: " + isCardFilterOptionsVisible);
    
            // Perform actions based on the flags
            if (isTemplateLayoutVisible) {
                // Click newCardButton once
                infoLibFeatPage.newCardButton.click();
                System.out.println("Clicked newCardButton once as template layout is visible.");
            } else if (isCardFilterOptionsVisible) {
                // Click newCardButton twice with a small delay
                infoLibFeatPage.newCardButton.click();
                System.out.println("Clicked newCardButton first time as card filter options are visible.");
                
                // Add a small delay between the clicks
                Thread.sleep(500); // Delay in milliseconds (adjust as needed)
                
                infoLibFeatPage.newCardButton.click();
                System.out.println("Clicked newCardButton second time as card filter options are visible.");
            }
    
        } catch (InterruptedException e) {
            // Handle thread interruption during sleep
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted: " + e.getMessage());
        } catch (Exception e) {
            // Handle other unexpected exceptions
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    
    
    
    
        









    @DataProvider
    public Object[][] getData() {
        return new Object[][] { { "hotwatermusic0+12@gmail.com", "1ndyJon35!" } };
    }
}

