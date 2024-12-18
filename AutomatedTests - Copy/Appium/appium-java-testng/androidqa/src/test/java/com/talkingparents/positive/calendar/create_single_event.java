package com.talkingparents.positive.calendar;

import com.talkingparents.setUpConfigNative;







import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.talkingparents.pageobjectsandroid.Calendar.calendarDetailsPage;
import com.talkingparents.pageobjectsandroid.Calendar.calendarHomePage;
import com.talkingparents.pageobjectsandroid.Calendar.createEventPage;
import com.talkingparents.pageobjectsandroid.Global.globalPage;
import com.talkingparents.pageobjectsandroid.Login.loginPages;
import com.talkingparents.utils.*;;

public class create_single_event extends setUpConfigNative {

    

    private WebDriverWait wait;

        @BeforeMethod
        public void setUp() {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a max of 10 seconds
            
        }

        //Declare random message string//
        String todaysDate = dataHelpers.getDayWithSuffix();


    @Test(priority = 1, dataProvider = "getData")
    public void create__event(String email, String password) {

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

        //Navigate to Calendar feature

        wait.until(ExpectedConditions.visibilityOf(globalpage.calendarFeature));
        globalpage.calendarFeature.click();

        //Wait for onboarding welcome screen and click get started

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardHeader)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardText)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.firstIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.secondIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.thirdIcon)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(globalPage.onboardContinueButton)).isDisplayed());
        
        globalPage.onboardContinueButton.click();

        // You are now on the Calendar home screen.

        calendarHomePage calendarhomepage = new calendarHomePage(driver);
        createEventPage createeventpage = new createEventPage(driver);
        AndroidActions androidactions = new AndroidActions(driver);
        calendarDetailsPage calendardetailspage = new calendarDetailsPage(driver);

        wait.until(ExpectedConditions.visibilityOf(calendarhomepage.newEventButton));

        // Select the Create Event button //

        calendarhomepage.newEventButton.click();


        //Confirm Create event form elements are displayed

        wait.until(ExpectedConditions.visibilityOf(createeventpage.repeatEventToggle));
        wait.until(ExpectedConditions.visibilityOf(createeventpage.eventNameLayout));
        wait.until(ExpectedConditions.visibilityOf(createeventpage.eventDetailsLayout));
        wait.until(ExpectedConditions.visibilityOf(createeventpage.startDateLayout));

        //Set the event detail variables, randomize texts details //

        String eventName = dataHelpers.generateRandomString(12);
        String eventDetails = dataHelpers.generateRandomString(20);

        String weekFromNow = dataHelpers.getDateWeeksFromNow(1);

        //Break down start times into variables

        /* 
        String startTimeHour = startTime.substring(0, 2);
        String startTimeMinutes = startTime.substring(3, 5);

        String endTimeHour = startTime.substring(0, 2);
        String endTimeMinutes = startTime.substring(3, 5);

        */

        // Set the event name and details///

        createeventpage.eventNameEditText.sendKeys(eventName);
        createeventpage.eventDetailsEditText.sendKeys(eventDetails);


        //Set the Start and End Date

        createeventpage.startDateEditText.click();
        wait.until(ExpectedConditions.visibilityOf(createeventpage.monthDateEditPencil));
        createeventpage.monthDateEditPencil.click();
        wait.until(ExpectedConditions.visibilityOf(createeventpage.monthDateTextInputDate));
        createeventpage.monthDateTextField.sendKeys(weekFromNow);
        createeventpage.monthDateOkButton.click();

        /* 
        createeventpage.endDateEditText.click();
        wait.until(ExpectedConditions.visibilityOf(createeventpage.monthDateEditPencil));
        createeventpage.monthDateEditPencil.click();
        wait.until(ExpectedConditions.visibilityOf(createeventpage.monthDateTextInputDate));
        createeventpage.monthDateTextInputDate.click();
        createeventpage.monthDateTextField.sendKeys(weekFromNow);
        createeventpage.monthDateOkButton.click();
        */

        

        // Generate random hour and minute
        Random random = new Random();
        int startHour = random.nextInt(1, 13);

        int endHour;

        // Check if startHour is 12
        if (startHour == 12) {
            // If start hour is 12, set end hour to 1
            endHour = 1;
        } else {
            // Otherwise, set end hour to start hour + 1
            endHour = startHour + 1;
        }

        //Set the Start Time and End Time using the clock wheel. Event is one hour long.
        createeventpage.startTimeEditText.click();
        wait.until(ExpectedConditions.visibilityOf(createeventpage.clockDisplayAndToggle));
        WebElement startClockTime = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"" + startHour + " o'clock\"]"));
        startClockTime.click();
        createeventpage.eventTimeOkButton.click();

        createeventpage.endTimeEditText.click();
        wait.until(ExpectedConditions.visibilityOf(createeventpage.clockDisplayAndToggle));
        WebElement endClockTime = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"" + endHour + " o'clock\"]"));
        endClockTime.click();
        createeventpage.eventTimeOkButton.click();


        //Create the event

        wait.until(ExpectedConditions.visibilityOf(createeventpage.createEventButton));
        createeventpage.createEventButton.click();

        //You are navigated back to the list view. Confirm list view is loaded.
        wait.until(ExpectedConditions.visibilityOf(createeventpage.createEventButton));

        //Scroll to created event//

       androidactions.scrollToTextAction(eventName);
       WebElement listViewTitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/event_time_text_view\" and @text=\""+ eventName +"\"]"));
       Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(listViewTitle)).isDisplayed());

       listViewTitle.click();

       //Check event details

       wait.until(ExpectedConditions.visibilityOf(calendardetailspage.eventDetailsHeaderText));
       WebElement eventElement = wait.until(ExpectedConditions.visibilityOf(calendardetailspage.eventName));

       // Assert that the text contains the event name
       Assert.assertTrue(eventElement.getText().contains(eventName));

       WebElement eventTimeElement = calendardetailspage.eventTime;

       String eventTimeText = eventTimeElement.getText();

        // Split the time range by the " - " separator to get the start and end times
        String[] times = eventTimeText.split(" - ");

        // Extract the start time (first part of the array)
        String startTime = times[0]; // "11:46 AM"

        // Extract the end time (second part of the array)
        String endTime = times[1]; // "12:16 PM"

        // Extract the hour values from the start and end times
        int startingHour = Integer.parseInt(startTime.split(":")[0].trim());  // Extracts 11 from "11:46 AM"
            int endingHour = Integer.parseInt(endTime.split(":")[0].trim());      // Extracts 12 from "12:16 PM"

        // TestNG assertions to compare the extracted hours with the stored values
        Assert.assertEquals(startHour, startingHour, "Start hour does not match the expected value.");
        Assert.assertEquals(endHour, endingHour, "End hour does not match the expected value.");

        Assert.assertTrue(calendardetailspage.eventDetails.getText().contains(eventDetails));

        calendardetailspage.backButton.click();





























    }










    




























    /////////////////////// TESTING CONDITIONAL EVENT TEXT SAMPLE ///////////////////////////////

       /*  //Select Repeat toggle//

        createeventpage.repeatEventToggle.click();

        wait.until(ExpectedConditions.visibilityOf(createeventpage.monthlyPill));
        createeventpage.monthlyPill.click();

        //Scroll down
        androidactions.scrollToTextAction("Stop repeating this event");

        createeventpage.MonthlyOnSpinner.click();

        wait.until(ExpectedConditions.visibilityOf(createeventpage.lastDayOfMonth));

        // Check Current Date //

        By currentDateFormat = By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"the " + todaysDate + "\"]");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(currentDateFormat)).isDisplayed());

        */









    


 @DataProvider
public Object[][] getData()
		{
			return new Object[][] { {"hotwatermusic0+12@gmail.com", "1ndyJon35!"} };		
		}


 }


