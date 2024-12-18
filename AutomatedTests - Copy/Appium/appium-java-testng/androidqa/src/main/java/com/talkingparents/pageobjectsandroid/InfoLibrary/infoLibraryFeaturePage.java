package com.talkingparents.pageobjectsandroid.InfoLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class infoLibraryFeaturePage extends AndroidActions{
	
	AndroidDriver driver;
	
	public infoLibraryFeaturePage(AndroidDriver driver) 
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

	// Template View

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/template_layout")
	public WebElement templateLayout;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/medical_card")
	public WebElement medicalCard;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/school_card")
	public WebElement schoolCard;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/clothing_card")
	public WebElement clothingCard;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/emergency_contact_card")
	public WebElement babysitterCard;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/emergency_contact_card")
	public WebElement emergencyCard;

	// Buttons

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/new_card_button")
	public WebElement newCardButton;

	@AndroidFindBy(id ="com.talkingparents.tpandroid:id/new_tab_button")
	public WebElement newTabButton;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/template_button")
	public WebElement cardFromTemplateButton;

	//List View

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/menu_item_search")
	public WebElement searchIcon;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/filter_options")
	public WebElement cardFilterOptions;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/my_cards")
	public WebElement allCards;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/private_cards")
	public WebElement privateCards;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/shared_by_me")
	public WebElement sharedByMe;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/shared_with_me")
	public WebElement sharedWithMe;



	










    
}

