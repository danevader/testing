package com.talkingparents.pageobjectsandroid.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class calendarDetailsPage extends AndroidActions {



    AndroidDriver driver;
	
	public calendarDetailsPage(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


    //Define locators as variables

    //Header elements

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Event details\"]")
    public WebElement eventDetailsHeaderText;

    @AndroidFindBy(accessibility = "Edit event")
    public WebElement editEventButton;

    @AndroidFindBy(accessibility = "Delete event")
    public WebElement deleteEventButton;

    @AndroidFindBy(accessibility = "Navigate up")
    public WebElement backButton;

    //Event Details elements

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"androidx.appcompat.widget.LinearLayoutCompat\").instance(1)")
    public WebElement detailsContainer;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/event_name")
    public WebElement eventName;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/event_date")
    public WebElement eventDate;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/event_time")
    public WebElement eventTime;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/event_recurring_text")
    public WebElement recurringValue;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/event_details")
    public WebElement eventDetails;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/shared_chip")
    public WebElement createdByChip;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/created_chip")
    public WebElement createdOnChip;

    @AndroidFindBy(id="com.talkingparents.tpandroid:id/viewed_chip")
    public WebElement eventViewedChip;































    
}
