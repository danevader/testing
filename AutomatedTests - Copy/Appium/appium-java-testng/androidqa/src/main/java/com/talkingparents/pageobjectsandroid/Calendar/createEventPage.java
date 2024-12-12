package com.talkingparents.pageobjectsandroid.Calendar;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class createEventPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public createEventPage(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


    // Define locators as variables //


    // Header//

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create event\")")
    public WebElement createEventHeaderText;

    @AndroidFindBy(accessibility = "Navigate up")
    public WebElement backButton;

    //Layouts for Fields

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/event_name_layout")
    public WebElement eventNameLayout;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/event_details_layout")
    public WebElement eventDetailsLayout;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/start_date_layout")
    public WebElement startDateLayout;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/end_date_layout")
    public WebElement endDateLayout;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/start_time_layout")
    public WebElement startTimeLayout;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/end_time_layout")
    public WebElement endTimeLayout;

    //Edit text entry for fields

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/event_name_edit_text")
    public WebElement eventNameEditText;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/event_details_edit_text")
    public WebElement eventDetailsEditText;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/start_date_edit_text")
    public WebElement startDateEditText;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/end_date_edit_text")
    public WebElement endDateEditText;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/start_time_edit_text")
    public WebElement startTimeEditText;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/end_time_edit_text")
    public WebElement endTimeEditText;

    //Edit Modals for event dates

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/mtrl_picker_header_toggle")
    public WebElement monthDateEditPencil;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/mtrl_picker_text_input_date")
    public WebElement monthDateTextInputDate;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement monthDateTextField;

    @AndroidFindBy (id ="com.talkingparents.tpandroid:id/confirm_button")
    public WebElement monthDateOkButton;


    // Edit modals for event times
    @AndroidFindBy(id="com.talkingparents.tpandroid:id/material_clock_display_and_toggle")
    public WebElement clockDisplayAndToggle;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/material_hour_tv")
    public WebElement eventTimeHour;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/material_minute_tv")
    public WebElement eventTimeMinute;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/material_clock_hand")
    public WebElement eventTimeClock;



    @AndroidFindBy( id="com.talkingparents.tpandroid:id/material_timepicker_mode_button")
    public WebElement eventTimeTextInput;

    @AndroidFindBy( id="new UiSelector().className(\"android.widget.LinearLayout\").instance(3)")
    public WebElement eventTimeEditText;

    @AndroidFindBy( id="com.talkingparents.tpandroid:id/material_timepicker_ok_button")
    public WebElement eventTimeOkButton;








    //Event Details Text

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"This event is scheduled for Friday, December 6, 2024 from 3:29 PM until 3:59 PM, Central Time\"]")
    public WebElement eventDetailsText;

    //Repeat event toggle//

    @AndroidFindBy(xpath = "//android.widget.Switch[@text=\"Repeat this event\"]")
    public WebElement repeatEventToggle;


    //Repeat Rules//


    //Daily, Weekly, Monthly pills//

    @AndroidFindBy(id="com.talkingparents.tpandroid:id/chip_daily")
    public WebElement dailyPill;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/chip_weekly")
    public WebElement weeklyPill;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/chip_monthly")
    public WebElement monthlyPill;


    //Default Repeat frequency spinner text for daily and weekly//

    @AndroidFindBy(id = "android:id/text1")
    public WebElement spinnerText;

    //Default Repeat frequency spinner text for monthly//

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"month\"]")
    public WebElement spinnerTextMonthly;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"the first\"]")
    public WebElement spinnerOnTextMonthly;

    //Daily repeat options//

    @AndroidFindBy( id = "com.talkingparents.tpandroid:id/frequency_daily_spinner")
    public WebElement dailySpinner;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"day\"]")
    public WebElement everyday;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"2 days\"]")
    public WebElement twoDays;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"3 days\"]")
    public WebElement threeDays ;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"4 days\"]")
    public WebElement fourDays;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"5 days\"]")
    public WebElement fiveDays;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"6 days\"]")
    public WebElement sixDays;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"7 days\"]")
    public WebElement sevenDays;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"8 days\"]")
    public WebElement eightDays;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"9 days\"]")
    public WebElement nineDays;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"10 days\"]")
    public WebElement tenDays;

   


    //Weekly repeat options//

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/frequency_weekly_spinner")
    public WebElement weeklySpinner;

    @AndroidFindBy(xpath ="//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"week\"]")
    public WebElement oneWeek;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"2 weeks\"]")
    public WebElement twoWeeks;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"3 weeks\"]")
    public WebElement threeWeeks;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"4 weeks\"]")
    public WebElement fourWeeks;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"5 weeks\"]")
    public WebElement fiveWeeks;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"6 weeks\"]")
    public WebElement sixWeeks;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"7 weeks\"]")
    public WebElement sevenWeeks;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"8 weeks\"]")
    public WebElement eightWeeks;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"9 weeks\"]")
    public WebElement nineWeeks;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"10 weeks\"]")
    public WebElement tenWeeks;


    //Weekly repeat options - Days //

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/chip_monday")
    public WebElement monday;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/chip_tuesday")
    public WebElement tuesday;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/chip_wednesday")
    public WebElement wednesday;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/chip_thursday")
    public WebElement thursday;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/chip_friday" )
    public WebElement friday;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/chip_saturday")
    public WebElement saturday;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/chip_sunday")
    public WebElement sunday;



    //Monthly repeat options//

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/months_spinner")
    public WebElement monthlySpinner;
    
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"month\"]")
    public WebElement oneMonth;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"2 months\"]")
    public WebElement twoMonths;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"3 months\"]")
    public WebElement threeMonths;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"4 months\"]")
    public WebElement fourMonths;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"5 months\"]")
    public WebElement fiveMonths;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"6 months\"]")
    public WebElement sixMonths;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"7 months\"]")
    public WebElement sevenMonths;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"8 months\"]")
    public WebElement eightMonths;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"9 months\"]")
    public WebElement nineMonths;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"10 months\"]")
    public WebElement tenMonths;

    // Monthly ON THE repeat options//

    @AndroidFindBy(id="com.talkingparents.tpandroid:id/frequency_monthly_spinner")
    public WebElement MonthlyOnSpinner;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"the first\"]")
    public WebElement theFirst;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"the second\"]")
    public WebElement theSecond;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"the third\"]")
    public WebElement theThird;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"the fourth\"]")
    public WebElement theFourth;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"the last\"]")
    public WebElement theLast;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"the last day of the month\"]")
    public WebElement lastDayOfMonth;


    //The text part of this will have to be updated depending on the test//
    @AndroidFindBy(xpath ="//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"the 6th\"]")
    public WebElement currentDate;
    
    
    //Create Event Button

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Create event\"]")
    public WebElement createEventButton;























}
