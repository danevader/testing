package com.talkingparents.positive.messages;
/* 
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talkingparents.pageobjectsandroid.*;
import com.talkingparents.pageobjectsandroid.Login.loginPages;
import com.talkingparents.pageobjectsandroid.Messages.messagingPage;
import com.talkingparents.setUpConfigNative;
import io.appium.java_client.AppiumDriver;

public class messagesTests extends setUpConfigNative{
	

	@BeforeMethod
	public void preSetup() {
	
		messagingPage messagingpage = new messagingPage(driver);
		messagingpage.setActivity();
	}
	
	public void signInAction(String email, String password)
	{
		loginPages loginpage = new loginPages(driver);
		loginpage.setEmailField(email);
		loginpage.setPasswordField(password);
		loginpage.clickToSignIn();	
	}
	

	// Tests //
	
	@Test(priority=1)
	public void messaging_onboardingScreenTest() 
	
	{
		messagingPage messagingpage = new messagingPage(driver);

		//Login
		loginPages loginpage = new loginPages(driver);
		loginpage.existingAccountSignIn();
		signInAction("tpdevtesting+0001@gmail.com", "1ndyJon35!");

		//Check Onboarding screen
		Assert.assertTrue(messagingpage.onboardMessagingHeader.isDisplayed());
		Assert.assertTrue(messagingpage.onboardHeaderImage.isDisplayed());
		Assert.assertTrue(messagingpage.onboardMessagingText.isDisplayed());
		Assert.assertTrue(messagingpage.onboardContinueButton.isDisplayed());
		messagingpage.onboardContinueButton.click();
		Assert.assertTrue(messagingpage.secureMessagingHeader.isDisplayed());
		
	}

	@Test (priority=2)
	public void messaging_infoIconTest()
	{
		messagingPage messagingpage = new messagingPage(driver);

		//Login
		loginPages loginpage = new loginPages(driver);
		loginpage.existingAccountSignIn();
		signInAction("tpdevtesting+0001@gmail.com", "1ndyJon35!");
		messagingpage.onboardContinueButton.click();

		//Check info icon screen
		messagingpage.secureMessagingInfoIcon.click();
		Assert.assertTrue(messagingpage.onboardMessagingHeader.isDisplayed());
		Assert.assertTrue(messagingpage.onboardHeaderImage.isDisplayed());
		Assert.assertTrue(messagingpage.onboardMessagingText.isDisplayed());
		Assert.assertTrue(messagingpage.onboardContinueButton.isDisplayed());
		
	}
	 
	@Test (priority=3, dataProvider="sampleMessage")
	public void messaging_newSubjectTest(String subject, String message)
	{
		messagingPage messagingpage = new messagingPage(driver);

		//Login
		loginPages loginpage = new loginPages(driver);
		loginpage.existingAccountSignIn();
		signInAction("tpdevtesting+0001@gmail.com", "1ndyJon35!");
		messagingpage.onboardContinueButton.click();

		//Check and select new message button
		Assert.assertTrue(messagingpage.newMessageButton.isDisplayed());
		messagingpage.newMessageButton.click();

		// Check New Message screen elements
		Assert.assertTrue(messagingpage.newMessageHeader.isDisplayed());
		Assert.assertTrue(messagingpage.newMessageSubject.isDisplayed());
		Assert.assertTrue(messagingpage.newMessageBody.isDisplayed());
		Assert.assertTrue(messagingpage.newMessageSendIcon.isDisplayed());

		//Create new message subject
		messagingpage.createNewSubject(subject, message);

		//Check send button is enabled and select
		Assert.assertTrue(messagingpage.newMessageSendIcon.isEnabled());
		messagingpage.newMessageSendIcon.click();

		//Check for updated message details view
		messagingpage.messageDetailsCheck(subject, message);

		
	}

	// End Tests //


	@AfterMethod
	public void tearDown() 
	{
        if (driver != null) {
            // Reset app by uninstalling and reinstalling
            driver.removeApp("com.talkingparents.tpandroid"); // Replace with your app's package name
            driver.installApp("\\Program Files\\APKS\\app-qa-release.apk"); // Replace with path to your APK

		}
	}


	@DataProvider
	public Object[][] sampleMessage()
		{
				return new Object[][] { {"Sample Reply", "I created this as an example"} };		
		}

	public Object[][] premiumUserA()
		{
			return new Object[][] { {"tpdevtesting+0001@gmail.com", "1ndyJon35!"} };		
		}
		
	
}
		*/


	


