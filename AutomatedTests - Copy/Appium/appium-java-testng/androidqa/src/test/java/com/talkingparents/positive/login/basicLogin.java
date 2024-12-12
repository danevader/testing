package com.talkingparents.positive.login;



import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talkingparents.setUpConfigNative;
import com.talkingparents.pageobjectsandroid.Login.loginPages;
import com.talkingparents.pageobjectsandroid.Global.*;


public class basicLogin extends setUpConfigNative {


	private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a max of 10 seconds
        
    }
	
	
	@Test (priority = 1, dataProvider="getData")
	public void loginTest_positiveFlow(String email, String password) throws MalformedURLException, URISyntaxException{
		
		//Sign into account\\
		loginPages loginpage = new loginPages(driver);
		globalPage globalpage = new globalPage(driver);
		loginpage.existingAccountLink.click();
		Assert.assertTrue(loginpage.tpLogo.isDisplayed());
		loginpage.emailField.sendKeys(email);
		loginpage.passwordField.sendKeys(password);
		loginpage.signInButton.click();

		// Wait for the element to be visible before interacting with it
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

		@DataProvider
	public Object[][] getData()
			{
				return new Object[][] { {"tpdevtesting+0001@gmail.com", "1ndyJon35!"} };		
			}

	}




