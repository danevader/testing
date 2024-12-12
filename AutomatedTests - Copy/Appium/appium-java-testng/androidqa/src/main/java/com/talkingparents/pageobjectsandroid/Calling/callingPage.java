package com.talkingparents.pageobjectsandroid.Calling;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



import com.talkingparents.utils.AndroidActions;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


//Set up driver for tests

public class callingPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public callingPage(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}



    // Define locators as variables //



    // NavMenu icon //
    @AndroidFindBy(id="com.talkingparents.tpandroid:id/calling_graph")
    public static WebElement callingFeatureMenuIcon;

    // Onboarding screen

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/header_image_view")
	public static WebElement onboardHeaderImage;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/title_text_view")
	public static WebElement onboardCallingHeader;
	
	@AndroidFindBy(id="com.talkingparents.tpandroid:id/description_text_view")
	public static WebElement onboardCallingText;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(0)")
	public static WebElement recordIcon;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(1)")
	public WebElement transcriptIcon;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(2)")
	public WebElement minutesIcon;
	
	@AndroidFindBy(id="com.talkingparents.tpandroid:id/get_started_button")
	public WebElement onboardContinueButton;


    //Header

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Accountable Calling℠\")")
    public WebElement callingListHeader;

    @AndroidFindBy(id="com.talkingparents.tpandroid:id/search_calls")
    public WebElement callingSearchIcon;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/info_item")
	public WebElement callingInfoIcon;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/call_settings")
	public WebElement callSettingsButton;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/search_plate")
	public WebElement callingSearchBar;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/search_src_text")
	public WebElement callingSearchPlaceholderText;

	@AndroidFindBy(accessibility = "Collapse")
	public WebElement callingSearchBackButton;

    // Filter Buttons

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/button_all")
	public WebElement allFilterPill;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/button_phone")
	public WebElement phoneCallsFilterPill;

	@AndroidFindBy(id ="com.talkingparents.tpandroid:id/button_video")
	public WebElement videoCallsFilterPill;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/button_voicemail")
	public WebElement voicemailFilterPill;


	// Call list 

	@AndroidFindBy (id = "com.talkingparents.tpandroid:id/start_call_button")
	public WebElement startCallButton;

	@AndroidFindBy (id = "com.talkingparents.tpandroid:id/start_video_call_button")
	public WebElement startVideoCallButton;

	@AndroidFindBy (id = "com.talkingparents.tpandroid:id/start_call_button")
	public WebElement startPhoneCallButton;


	// Calling sheet

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/call_type_image_view")
	public WebElement sheetCallIcon;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/coparent_name_text_view")
	public WebElement coparentNameTextView;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/minutes_available_title")
	public WebElement avaliableMinutesTitle;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/minutes_available_text_view")
	public WebElement availableMinutesBalance;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/add_minutes_button")
	public WebElement addMinutesButton;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/start_call_button" )
	public WebElement startCallSheetButton;










}