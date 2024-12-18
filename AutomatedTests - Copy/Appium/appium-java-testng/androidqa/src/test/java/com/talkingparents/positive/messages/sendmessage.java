package com.talkingparents.positive.messages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talkingparents.setUpConfigNative;
import com.talkingparents.pageobjectsandroid.Global.globalPage;
import com.talkingparents.pageobjectsandroid.Login.loginPages;
import com.talkingparents.pageobjectsandroid.Messages.messageFeaturePage;
import com.talkingparents.pageobjectsandroid.Messages.threadView;
import com.talkingparents.utils.dataHelpers;

public class sendmessage extends setUpConfigNative {

     private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a max of 10 seconds
        
    
    }

    @Test(priority = 1, dataProvider = "loginData")
    public void login(String email, String password) throws Exception {

        // Set up page drivers //
        loginPages loginpage = new loginPages(driver);
        globalPage globalpage = new globalPage(driver);
        messageFeaturePage messagingpage = new messageFeaturePage(driver);

        //Login//
        loginpage.loginAction(email, password); 

        //Close Welcome screen
        wait.until(ExpectedConditions.visibilityOf(globalpage.onboardHeaderImage));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        globalPage.onboardContinueButton.click();

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(messagingpage.newMessageButton)).isDisplayed());


    }
     
    @Test(priority = 2)
    public void send_message() throws Exception {

        globalPage globalpage = new globalPage(driver);
        messageFeaturePage messagingpage = new messageFeaturePage(driver);
        threadView threadview = new threadView(driver);

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(messagingpage.newMessageButton)).isDisplayed());
        messagingpage.newMessageButton.click();
        wait.until(ExpectedConditions.visibilityOf(messagingpage.newMessageBody));
        wait.until(ExpectedConditions.visibilityOf(messagingpage.newMessageSubject));

        //Enter message details

        String sentTime = dataHelpers.getCurrentTime();

        messagingpage.newMessageSubject.sendKeys(randomSubject);
        messagingpage.newMessageBody.sendKeys(randomMessage);
        messagingpage.newMessageSendIcon.click();

        //Wait for reply view
        wait.until(ExpectedConditions.visibilityOf(threadview.messageTextView));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(threadview.messageTextView)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(threadview.messageTimeStampView)).isDisplayed());


        //Check Subject Header and created date

        By subjectTitle = By.xpath("//android.widget.TextView[@text=\"" + randomSubject + "\"]");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(subjectTitle)).isDisplayed());

        By createdDate = By.xpath("//android.widget.TextView[@text='Created by " + parentFirstName + " on " + currentDate + "']");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(createdDate)).isDisplayed());


        //Check Message text

        WebElement textElement = driver.findElement(By.id("com.talkingparents.tpandroid:id/message_text_view"));
        String actualMessageText = textElement.getText();
        Assert.assertEquals(actualMessageText, randomMessage, "The time stamp text does not match!");



        //Check timestamp text

        WebElement timeStampElement = driver.findElement(By.id("com.talkingparents.tpandroid:id/timestamp_text_view"));
        String actualTimestampText = timeStampElement.getText();
        Assert.assertEquals(actualTimestampText, sentTime, "The time stamp text does not match!");

    }
    

    @Test(priority = 2)
    public void send_reply_with_attachment() throws Exception {

        globalPage globalpage = new globalPage(driver);
        messageFeaturePage messagingpage = new messageFeaturePage(driver);
        threadView threadview = new threadView(driver);

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(threadview.replyMessageField)).isDisplayed());
  
        //Enter message details

        String sentTime = dataHelpers.getCurrentTime();

        threadview.replyMessageField.sendKeys(randomMessage + " and some more text to make this interesting");

        threadview.attachmentIcon.click();
        wait.until(ExpectedConditions.visibilityOf(threadview.addAttachment));
        threadview.addAttachment.click();

        wait.until(ExpectedConditions.visibilityOf(threadview.androidMenuRoot));
        threadview.androidMenuRoot.click();
        wait.until(ExpectedConditions.visibilityOf(threadview.androidDownloads));
        threadview.androidDownloads.click();
        wait.until(ExpectedConditions.visibilityOf(threadview.filesInDownloadHeader));

        wait.until(ExpectedConditions.visibilityOf(threadview.rockonScott));
        threadview.rockonScott.click();
        wait.until(ExpectedConditions.visibilityOf(messagingpage.newMessageSendIcon));
        threadview.replySendButton.click();


        //Wait for reply view
        wait.until(ExpectedConditions.visibilityOf(threadview.messageTextView));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(threadview.messageTextView)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(threadview.messageTimeStampView)).isDisplayed());


        //Check Subject Header and created date

        By subjectTitle = By.xpath("//android.widget.TextView[@text=\"" + randomSubject + "\"]");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(subjectTitle)).isDisplayed());

        By createdDate = By.xpath("//android.widget.TextView[@text='Created by " + parentFirstName + " on " + currentDate + "']");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(createdDate)).isDisplayed());


        //Check Message text

        WebElement textElement = driver.findElement(By.id("com.talkingparents.tpandroid:id/message_text_view"));
        String actualMessageText = textElement.getText();
        Assert.assertEquals(actualMessageText, randomMessage, "The time stamp text does not match!");



        //Check timestamp text

        WebElement timeStampElement = driver.findElement(By.id("com.talkingparents.tpandroid:id/timestamp_text_view"));
        String actualTimestampText = timeStampElement.getText();
        Assert.assertEquals(actualTimestampText, sentTime, "The time stamp text does not match!");


    }













        // Define variables

        @DataProvider
        public Object[][] loginData()
                {
                    return new Object[][] { {"hotwatermusic0+12@gmail.com", "1ndyJon35!"} };		
                }


        String randomSubject = dataHelpers.generateRandomString(20);
        String randomMessage = dataHelpers.generateRandomString(10 ) + " and then there was " + dataHelpers.generateRandomString(6);
        String currentDate = dataHelpers.getTodaysDate();
        String parentFirstName = "Kelly";    


        





        // Helper Methods



        
    }





    



























