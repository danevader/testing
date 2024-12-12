package com.talkingparents.pageobjectsandroid.Journal;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



import com.talkingparents.utils.AndroidActions;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class journalfeaturePage extends AndroidActions {

    AndroidDriver driver;
	
	public journalfeaturePage(AndroidDriver driver) 
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


	// Header and List elements

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/toolbar")
	public WebElement journalHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Personal Journal\"]")
	public WebElement journalHeaderText;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/journal_recyclerview")
	public WebElement journalListView;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(5)")
	public WebElement journalEntryElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/journal_title\" and @text=\"Can you see the attachment names on this entry\"]")
	public WebElement journalEntryTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/journal_text\" and @text=\"Trying to see if they are returned in the API\"]")
	public WebElement journalEntrytext;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/journal_date_time\" and @text=\"December 02, 2024\"]")
	public WebElement journalEntryDateTime;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/attachment_image")
	public WebElement attachmentIcon;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/more_menu\").instance(0)")
	public WebElement listViewMoreMenu;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/total_count")
	public WebElement entryTotal;


	//Buttons and icons

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/search_journal")
	public WebElement journalSearchIcon;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/journal_item_info")
	public WebElement journalInfoIcon;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/new_entry_fab")
	public WebElement journalNewEntryButton;




    
}