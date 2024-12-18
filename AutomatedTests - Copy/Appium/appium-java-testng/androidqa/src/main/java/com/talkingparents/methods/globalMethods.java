package com.talkingparents.methods;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.talkingparents.pageobjectsandroid.Global.globalPage;
import com.talkingparents.pageobjectsandroid.InfoLibrary.infoLibraryFeaturePage;
import com.talkingparents.pageobjectsandroid.Login.loginPages;
import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class globalMethods extends AndroidActions{

    public static WebDriverWait wait;
    
        static AndroidDriver driver;
                
                public globalMethods(AndroidDriver driver) 
                {
                    super(driver);
                    this.driver =driver;
                    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
                    
                }
            
            
    public static  void loginFreshInstall(String email, String password) {
            
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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


    public void login(String email, String password) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login and get past the messages welcome sheet
        loginPages loginPage = new loginPages(driver);
        loginPage.existingAccountLink.click();
        loginPage.setEmailField(email);
        loginPage.setPasswordField(password);
        loginPage.signInButton.click();
        globalPage globalPage = new globalPage(driver);
    }


        public static void featureStateCheck() {
        infoLibraryFeaturePage infoLibFeatPage = new infoLibraryFeaturePage(driver);
        boolean isTemplateLayoutVisible = false; // Flag for template layout visibility
        boolean isCardFilterOptionsVisible = false; // Flag for card filter options visibility
    
        try {
            // Check if the template layout is visible
            try {
                if (wait.until(ExpectedConditions.visibilityOf(infoLibFeatPage.templateLayout)).isDisplayed()) {
                    isTemplateLayoutVisible = true;
                    infoLibFeatPage.newCardButton.click();
                }
            } catch (org.openqa.selenium.TimeoutException e) {
                System.out.println("Template layout is not visible within the specified timeout.");
            }
    
            // Check if the card filter options are visible
            try {
                if (wait.until(ExpectedConditions.visibilityOf(infoLibFeatPage.cardFilterOptions)).isDisplayed()) {
                    isCardFilterOptionsVisible = true;
                    infoLibFeatPage.newCardButton.click();
    
                    // Add a small delay between the clicks
                    Thread.sleep(500); // Delay in milliseconds (adjust as needed)
    
                    infoLibFeatPage.newCardButton.click();
                }
            } catch (org.openqa.selenium.TimeoutException e) {
                System.out.println("Card filter options are not visible within the specified timeout.");
            }
    
            // Log the visibility status
            System.out.println("Template Layout Visibility: " + isTemplateLayoutVisible);
            System.out.println("Card Filter Options Visibility: " + isCardFilterOptionsVisible);
    
        } catch (InterruptedException e) {
            // Handle Thread.sleep interruption
            System.err.println("Thread was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore the interrupted status
        } catch (Exception e) {
            // Catch-all for any other unexpected exceptions
            System.err.println("An error occurred during feature state check: " + e.getMessage());
        }
    }






    
}
