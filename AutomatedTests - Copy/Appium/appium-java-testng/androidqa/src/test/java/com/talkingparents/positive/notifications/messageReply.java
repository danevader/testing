package com.talkingparents.positive.notifications;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talkingparents.pageobjectsandroid.Global.globalPage;
import com.talkingparents.pageobjectsandroid.Global.notifications;
import com.talkingparents.pageobjectsandroid.Login.loginPages;
import com.talkingparents.pageobjectsandroid.Messages.messageFeaturePage;

import com.talkingparents.setUpConfigNative;

import com.talkingparents.utils.ApiRequests;
import com.talkingparents.utils.dataHelpers;


public class messageReply extends setUpConfigNative{

     private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a max of 10 seconds
        
    }
        //Declare random message string//
        String message = dataHelpers.generateRandomString(10);


	
        // Tests //
        
      @Test(priority = 1, dataProvider = "loginData")
    public void parentLoginMessages(String email, String password) throws Exception {

        // Set up page drivers //
        loginPages loginpage = new loginPages(driver);
        globalPage globalpage = new globalPage(driver);



        //Login//
        loginpage.loginAction(email, password);
        
       // Wait for the welcome screen to be visible before interacting with it
        wait.until(ExpectedConditions.visibilityOf(globalpage.onboardHeaderImage));
        Assert.assertTrue(globalpage.onboardHeaderImage.isDisplayed());

        // Additional waits for other elements to ensure they are loaded. Checking onboarding screen.
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.firstIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.secondIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.thirdIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        
        globalPage.onboardContinueButton.click();


    }

        @Test(priority = 2, dataProvider = "messageData")
    public void coparentSendMessage(String username, String password, String baseUrl, String threadID) throws Exception{

        //Sign in and send a message as the coparent//


        String authToken = ApiRequests.getAuthToken(username, password, baseUrl);
    
        if (authToken != null) {
            String messageResponse = ApiRequests.sendMessage(baseUrl, authToken, threadID, message);
            System.out.println(authToken);
            System.out.println("Message Response: " + messageResponse);
        } else {
            System.out.println("Failed to obtain authToken.");
        }

    }

        @Test(priority = 3)
    public void notificationDisplayedCheck(){

        notifications notifpage = new notifications(driver);
        messageFeaturePage messagingpage = new messageFeaturePage(driver);
        globalPage globalpage = new globalPage(driver);

        //Check For red dot icon on list view//

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(notifpage.newMessageRedDot)).isDisplayed());

        //Check for Notification on feature icon //
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.messagesFeature)).isDisplayed()); 
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(notifpage.messageFeatureCounter)).isDisplayed()); 


        //View the new message //
        messagingpage.firstSubject.click();
        By newmessageText = By.xpath("//android.widget.TextView[@resource-id='com.talkingparents.tpandroid:id/message_text_view' and @text='" + message + "']");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(newmessageText)).isDisplayed());

        //Select the back arrow//

        messagingpage.messageBackButton.click();

        //Confirm notification elements are no longer displayed//
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(notifpage.newMessageRedDot)));


        //Confirm reply text is shown in list view//

        By listViewNewMessageText = By.xpath("//android.widget.TextView[@resource-id='com.talkingparents.tpandroid:id/message_text_view' and @text='" + message + "']");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(listViewNewMessageText)).isDisplayed());

    }






    @DataProvider
    public Object[][] messageData()
            {
                return new Object[][] { {"hotwatermusic0+11@gmail.com", "1ndyJon35!", "https://tpapi.qa1.talkingparentsdev.com/","3209892"} };		
            }

    @DataProvider
    public Object[][] loginData()
            {
                return new Object[][] { {"hotwatermusic0+12@gmail.com", "1ndyJon35!"} };		
            }
        

}



    
