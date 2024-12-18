package com.talkingparents.positive.infoLibrary;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talkingparents.setUpConfigNative;

import com.talkingparents.methods.globalMethods;
import com.talkingparents.methods.infoLibrary;
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
    public void loginFirst(String email, String password)
     {
        loginPages loginPage = new loginPages(driver);
        globalMethods.loginFreshInstall(email, password);
    }

    @Test(priority = 2)
    public void enterDetails() throws TimeoutException {
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
        globalMethods.featureStateCheck();
        wait.until(ExpectedConditions.visibilityOf(newcardpage.newCardHeaderText)).isDisplayed();

        // Call enterCardDetails
        infoLibrary.enterCardDetails(newcardpage, title, description, name, email, phone, address, city, state, zip);
        
    }

    @Test(priority = 3)
    public void checkDetailEntry(){

        newCardPage newcardPage = new newCardPage(driver);
        infoLibrary.verifyCardDetails(newcardPage, title, description, name, email, phone, address, city, state, zip);

    }

    @Test(priority = 4)
    public void shareAndSaveCard(){

        newCardPage newcardpage = new newCardPage(driver);
        infoLibraryFeaturePage infolibfeatpage = new infoLibraryFeaturePage(driver);

        newcardpage.shareCardToggle.click();
        AndroidActions.scrollToTextAction("Save");
        wait.until(ExpectedConditions.visibilityOf(newcardpage.saveCardButton)).isDisplayed();
        newcardpage.saveCardButton.click();
        wait.until(ExpectedConditions.visibilityOf(infolibfeatpage.newCardButton)).isDisplayed();


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


    @DataProvider
    public Object[][] getData() {
        return new Object[][] { { "hotwatermusic0+12@gmail.com", "1ndyJon35!" } };
    }
}

