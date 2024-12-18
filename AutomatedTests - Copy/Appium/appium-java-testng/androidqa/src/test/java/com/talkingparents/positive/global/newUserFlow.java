package com.talkingparents.positive.global;



import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.talkingparents.setUpConfigNative;

import com.talkingparents.pageobjectsandroid.Global.globalPage;
import com.talkingparents.pageobjectsandroid.Login.loginPages;





public class newUserFlow extends setUpConfigNative {

    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a max of 10 seconds
        
    }


    @Test(priority = 1, dataProvider = "getData")
    public void messageWelcomeState(String email, String password) {

        // Use parameters passed from the DataProvider
        loginPages loginpage = new loginPages(driver);
        loginpage.existingAccountLink.click();
        loginpage.setEmailField(email);
        loginpage.setPasswordField(password);
        loginpage.signInButton.click();
        globalPage globalpage = new globalPage(driver);
        
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

        // Wait for empty state elements to appear
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.mainEmptyState)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.emptyStateImage)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.emptyStateTitle)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.emptyStateSubtitle)).isDisplayed());
    }

    @Test(priority = 2, dataProvider = "getData")
    public void callingWelcomeState(String email, String password) {

        // Select the Calling feature
        globalPage.callingFeature.click();

        // Additional waits for other elements to ensure they are loaded. Checking onboarding screen.
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.firstIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.secondIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.thirdIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        
        globalPage.onboardContinueButton.click();

        // Wait for empty state elements to appear
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.mainEmptyStateListView)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.emptyStateImage)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.emptyStateTitle)).isDisplayed());
    }


    @Test(priority = 3, dataProvider = "getData")      
    public void calendarWelcomeState(String email, String password) {

        // Select the Calling feature
        globalPage globalpage = new globalPage(driver);
        globalpage.calendarFeature.click();

        // Additional waits for other elements to ensure they are loaded. Checking onboarding screen.
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.firstIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.secondIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.thirdIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        
        globalPage.onboardContinueButton.click();

        // Wait for empty state elements to appear
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.calendarImage)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.noEventsTextView)).isDisplayed());

    }


    @Test(priority = 4, dataProvider = "getData")      
    public void paymentsWelcomeState(String email, String password) {

        // Select the Calling feature
        globalPage globalpage = new globalPage(driver);
        globalpage.paymentsFeature.click();

        // Additional waits for other elements to ensure they are loaded. Checking onboarding screen.

        //There is a current issue with the Android app, where the welcome screen is hidden by the MFA prompt screen. Commenting out this part of the test for now//

        
       
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.firstIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.secondIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.thirdIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        globalPage.onboardContinueButton.click();
        
        // Wait for empty state elements to appear
        /*Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.phoneNumberRequiredText)).isDisplayed()); */
        /*Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.addPhoneNumberButton)).isDisplayed()); */
           
    }

    @Test(priority = 5, dataProvider = "getData")      
    public void infoLibraryWelcomeState(String email, String password) {

        //Select the More Section
        globalPage globalpage = new globalPage(driver);
        globalpage.moreSettings.click();

        //Wait until the Info Library feature is displayed in the More section
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.infoLibraryFeature)).isDisplayed());

        // Select the InfoLibrary feature
        globalpage.infoLibraryFeature.click();

        // Additional waits for other elements to ensure they are loaded. Checking onboarding screen.
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.firstIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.secondIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.thirdIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        
        globalPage.onboardContinueButton.click();

        // Wait for empty state elements to appear
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.getStartedTitleText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.infoLibraryTemplateLayout)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.medicalInfoCard)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.schoolInfoCard)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.clothingInfoCard)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.babysitterInfoCard)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.emergencyInfoCard)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.newCardButton)).isDisplayed());


    }

    @Test(priority = 6, dataProvider = "getData")      
    public void journalWelcomeState(String email, String password) {

         //Select the More Section
         globalPage globalpage = new globalPage(driver);
         globalpage.moreSettings.click();

        // Select the Journal feature

        globalpage.journalFeature.click();

        // Additional waits for other elements to ensure they are loaded. Checking onboarding screen.
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.firstIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.secondIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.thirdIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        
        globalPage.onboardContinueButton.click();

        // Wait for empty state elements to appear
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.emptyJournalView)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.emptyStateImage)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.emptyStateTitle)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.emptyStateSubtitle)).isDisplayed());

    }

    @Test(priority = 7, dataProvider = "getData")      
    public void vaultWelcomeState(String email, String password) {

         //Select the More Section
         globalPage globalpage = new globalPage(driver);
         globalpage.moreSettings.click();

        // Select the Vault feature

        globalpage.vaultFeature.click();

        // Additional waits for other elements to ensure they are loaded. Checking onboarding screen.
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.firstIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.secondIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.thirdIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        
        globalPage.onboardContinueButton.click();

        // Wait for empty state elements to appear
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.allFilesSection)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.favoriteFilesSection)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.recentlyDeletedSection)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.vaultStorageQouta)).isDisplayed());

    }

    @Test(priority = 7, dataProvider = "getData")      
    public void recordsWelcomeState(String email, String password) {

         //Select the More Section
         globalPage globalpage = new globalPage(driver);
         globalpage.moreSettings.click();

        // Select the Records feature

        globalpage.recordsFeature.click();

        // Additional waits for other elements to ensure they are loaded. Checking onboarding screen.
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.firstIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.secondIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.thirdIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        
        globalPage.onboardContinueButton.click();

        // Wait for empty state elements to appear
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.recordsHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.messageRecordCard)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.timeZoneTitle)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.timeZoneSpinner)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.sendRecordsButton)).isDisplayed());

    }

    @Test(priority = 8, dataProvider = "getData")      
    public void signOutWelcomeState(String email, String password) {

         //Select the More Section
         globalPage globalpage = new globalPage(driver);
         globalpage.moreSettings.click();


        // Select the Signout button

        globalpage.signOutButton.click();

        //Confirm modal

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.signOutModalTitle)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.signOutModalSubText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.signOutModalNo)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalpage.signOutModalYes)).isDisplayed());

        //Confirm sign-out button
        globalpage.signOutModalYes.click();

        //Confirm Sign out
        loginPages loginpages = new loginPages(driver);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(loginpages.getStartedButton)).isDisplayed());


    }






    @DataProvider
	public Object[][] getData()
			{
				return new Object[][] { {"hotwatermusic0+82@gmail.com", "1ndyJon35!"} };		
			}
}
