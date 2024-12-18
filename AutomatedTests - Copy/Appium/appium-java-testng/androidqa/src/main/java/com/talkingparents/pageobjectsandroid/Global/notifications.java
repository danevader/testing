package com.talkingparents.pageobjectsandroid.Global;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class notifications extends AndroidActions{


    AndroidDriver driver;
	
	public notifications(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}



    // Define locators as variables //


    //Messages//

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/new_indicator_image_view")
	public WebElement newMessageRedDot;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Messaging, 1 new notification\"]")
	public WebElement messageFeatureCounter;


    //Calendar//

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/calendar_new_event_filter")
	public WebElement calendarNewEventBell;

    @AndroidFindBy(accessibility = "1 new notification")
	public WebElement calendarNewEventBellDot;

    @AndroidFindBy(accessibility = "Calendar, 1 new notification")
	public WebElement calendarFeatureCounter;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/subject_text_view")
	public WebElement newEventCreated;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/created_when_text_view")
	public WebElement newEventCreatedWhen;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/notification_image_view")
	public WebElement newEventFilterDot;




/*
   @AndroidFindBy()
	public WebElement ;

     @AndroidFindBy()
	public WebElement ;

     @AndroidFindBy()
	public WebElement ;

     @AndroidFindBy()
	public WebElement ;

     @AndroidFindBy()
	public WebElement ;

     @AndroidFindBy()
	public WebElement ;
*/ 


    












}
