package com.talkingparents.positive.journal;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talkingparents.setUpConfigNative;
import com.talkingparents.pageobjectsandroid.Global.globalPage;
import com.talkingparents.pageobjectsandroid.Journal.journalfeaturePage;
import com.talkingparents.pageobjectsandroid.Journal.newEntryPage;
import com.talkingparents.pageobjectsandroid.Login.loginPages;

public class create_entry extends setUpConfigNative {

    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a max of 10 seconds
        
    }


     @Test(priority = 1, dataProvider = "getData")
    public void login(String email, String password) {

        // Login and get past the messages welcome sheet
        loginPages loginpage = new loginPages(driver);
        loginpage.existingAccountLink.click();
        loginpage.setEmailField(email);
        loginpage.setPasswordField(password);
        loginpage.signInButton.click();
        globalPage globalpage = new globalPage(driver);
        
       // Wait for the element to be visible before interacting with it
        wait.until(ExpectedConditions.visibilityOf(globalpage.onboardHeaderImage));
        Assert.assertTrue(globalpage.onboardHeaderImage.isDisplayed());
        globalPage.onboardContinueButton.click();


        

}

@Test(priority = 2)
    public void createEntry() {

            journalfeaturePage journalfeaturepage = new journalfeaturePage(driver);
            newEntryPage newentrypage = new newEntryPage(driver);

              //Navigate to Journal feature

              wait.until(ExpectedConditions.visibilityOf(globalPage.moreSettings));
              globalPage.moreSettings.click();

              wait.until(ExpectedConditions.visibilityOf(globalPage.journalFeature));
              globalPage.journalFeature.click();

              wait.until(ExpectedConditions.visibilityOf(journalfeaturepage.journalNewEntryButton)).isDisplayed();
              journalfeaturepage.journalNewEntryButton.click();

              wait.until(ExpectedConditions.visibilityOf(newentrypage.saveEntrybutton));

              newentrypage.titleTextField.sendKeys("yay");
              newentrypage.descriptionTextField.sendKeys("it worked");

              newentrypage.saveEntrybutton.click();


}



 @DataProvider
public Object[][] getData()
		{
			return new Object[][] { {"hotwatermusic0+12@gmail.com", "1ndyJon35!"} };		
		}

}

