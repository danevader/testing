package com.talkingparents.pageobjectsandroid.Calendar;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



import com.talkingparents.utils.AndroidActions;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class calendarHomePage extends AndroidActions{
	
	AndroidDriver driver;
	
	public calendarHomePage(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


    // Define locators as variables //


    // Onboarding screen

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/header_image_view")
	public static WebElement onboardHeaderImage;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/title_text_view")
	public static WebElement onboardMessagingHeader;
	
	@AndroidFindBy(id="com.talkingparents.tpandroid:id/description_text_view")
	public static WebElement onboardMessagingText;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(0)")
	public static WebElement firstIcon;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(1)")
	public WebElement secondIcon;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(2)")
	public WebElement thirdIcon;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/get_started_button\")")
	public WebElement onboardContinueButton;


	// Empty State

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
	public WebElement calendarImage;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/no_events_text_view")
	public WebElement noEventsTextView;

	//Buttons

	@AndroidFindBy(accessibility = "New event")
	public WebElement newEventBell;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/calendar_info_item")
	public WebElement calendarInfoIcon;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/delete_button")
	public WebElement deletedEventsButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"androidx.appcompat.widget.LinearLayoutCompat\").instance(1)")
	public WebElement monthListViewButton;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/calendar_button")
	public WebElement calendarViewButton;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/previous_month_button")
	public WebElement previousMonthButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageButton\").instance(3)")
	public WebElement nextMonthButton;

	@AndroidFindBy(accessibility = "Create New Event")
	public WebElement newEventButton;

	//Event List

	






























    
}
