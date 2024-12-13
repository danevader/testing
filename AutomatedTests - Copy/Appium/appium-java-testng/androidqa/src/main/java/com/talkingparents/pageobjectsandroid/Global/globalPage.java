package com.talkingparents.pageobjectsandroid.Global;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


//Set up driver for tests

public class globalPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public globalPage(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}



    // Define locators as variables //


	//Navigation Bottom Menu

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/messaging_graph")
	public WebElement messagesFeature;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/calling_graph")
	public static WebElement callingFeature;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/calendar_graph")
	public WebElement calendarFeature;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/payments_graph")
	public WebElement paymentsFeature;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/settings_graph")
	public static WebElement moreSettings;

	//More section//

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/info_library")
	public static WebElement infoLibraryFeature;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/journal")
	public static WebElement journalFeature;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/vault")
	public WebElement vaultFeature;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/records")
	public WebElement recordsFeature;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/account_settings")
	public WebElement accountSettings;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/contact_us")
	public WebElement contactUs;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/about")
	public WebElement aboutButton;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/help_center")
	public WebElement helpCenter;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Sign out\"]")
	public WebElement signOutButton;

	// Sign out modal //

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/alertTitle")
	public WebElement signOutModalTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
	public WebElement signOutModalSubText;

	@AndroidFindBy(id = "android:id/button2")
	public WebElement signOutModalNo;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement signOutModalYes;




	//Info icons

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/message_info_item")
	public WebElement messagesInfo;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/info_item")
	public WebElement callingInfo;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/calendar_info_item")
	public WebElement calendarInfo;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/menu_item_info")
	public WebElement infoLibraryInfo;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/journal_item_info")
	public WebElement journalInfo;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/item_info")
	public WebElement vaultInfo;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/records_item_info")
	public WebElement recordsInfo;

	//Onboarding sheet

	
	@AndroidFindBy(id="com.talkingparents.tpandroid:id/header_image_view")
	public WebElement onboardHeaderImage;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/title_text_view")
	public static WebElement onboardHeader;
	
	@AndroidFindBy(id="com.talkingparents.tpandroid:id/description_text_view")
	public static WebElement onboardText;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(0)")
	public static WebElement firstIcon;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(1)")
	public static WebElement secondIcon;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(2)")
	public static WebElement thirdIcon;
	
	@AndroidFindBy(id="com.talkingparents.tpandroid:id/get_started_button")
	public static WebElement onboardContinueButton;


	/// Empty States -- Global

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/empty_view")
	public static WebElement mainEmptyState;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/empty_list_view")
	public static WebElement mainEmptyStateListView;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/empty_view_image")
	public static WebElement emptyStateImage;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/empty_view_title")
	public static WebElement emptyStateTitle;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/empty_view_subtitle")
	public  static WebElement emptyStateSubtitle;

	/// Empty States - Calendar

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
	public WebElement calendarImage;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/no_events_text_view")
	public WebElement noEventsTextView;

	//Empty States - Info Library (Template List)

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/get_started_title")
	public WebElement getStartedTitleText;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/template_layout")
	public WebElement infoLibraryTemplateLayout;

	@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/template_name\" and @text=\"Medical Information\"]")
	public WebElement medicalInfoCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/template_name\" and @text=\"School Information\"]" )
	public WebElement schoolInfoCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/template_name\" and @text=\"Clothing Information\"]" )
	public WebElement clothingInfoCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/template_name\" and @text=\"Babysitter\"]" )
	public WebElement babysitterInfoCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/template_name\" and @text=\"Emergency Contact\"]" )
	public WebElement emergencyInfoCard;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/new_card_button")
	public WebElement newCardButton;


	//Empty States - Journal

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/empty_journal_view")
	public WebElement emptyJournalView;


	//Empty States - Vault

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/all_files")
	public WebElement allFilesSection;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/favorite_files")
	public WebElement favoriteFilesSection;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/deleted_files")
	public WebElement recentlyDeletedSection;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/quota_text_view")
	public WebElement vaultStorageQouta;


	//Empty States - Records

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Unalterable Records\")")
	public WebElement recordsHeader;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/card_layout\").instance(0)")
	public WebElement messageRecordCard;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/timezone_title_text_view")
	public WebElement timeZoneTitle;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/time_zone_spinner")
	public WebElement timeZoneSpinner;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/send_records_button")
	public WebElement sendRecordsButton;


	  /////////////////////////////
	 // Gatekeeping -- Payments //
	/////////////////////////////

	//Missing verified phone number

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Phone Number Required\")")
	public WebElement phoneNumberRequiredText;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add Phone Number\")")
	public WebElement addPhoneNumberButton;

	//MFA disabled

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Security Required\")")
	public WebElement securityRequired;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enable Authentication\")")
	public WebElement enableAuthButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Update Phone Number\")")
	public WebElement updatePhoneNumberButton;









}