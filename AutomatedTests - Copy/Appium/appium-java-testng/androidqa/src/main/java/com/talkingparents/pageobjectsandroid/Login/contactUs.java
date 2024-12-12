package com.talkingparents.pageobjectsandroid.Login;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



import com.talkingparents.utils.AndroidActions;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//Set up driver for tests

public class contactUs extends AndroidActions{
	
	AndroidDriver driver;
	
	public contactUs(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


// Define locators as variables //


////Contact Us ////

//fields

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/full_name_edit_text")
    public WebElement fullNameField;
    
    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/email_edit_text")
    public WebElement emailField;

    @AndroidFindBy(id="com.talkingparents.tpandroid:id/issue_edit_text")
    public WebElement issueField;


//button

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/reason_spinner")
    public WebElement categoryPickerButton;

    @AndroidFindBy(id ="android.widget.CheckBox")
    public WebElement supportAgreeBox;

    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"Send inquiry\")")
    public WebElement submitTicketButton;


//dropdown

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Accountable Calling℠\"]")
    public WebElement accountableCalling;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Attachments\"]")
    public WebElement attachments;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Creating Account\"]")
    public WebElement createAccount;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Domestic Violence\"]")
    public WebElement domesticViolence;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Free\"]")
    public WebElement free;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Notifications\"]")
    public WebElement notifications;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Other\"]")
    public WebElement other;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Payment\"]")
    public WebElement payment;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Professional Inquiry\"]")
    public WebElement proInquiry;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Received Error Message\"]")
    public WebElement errorMessageReceived;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Records\"]")
    public WebElement records;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Sign In\"]")
    public WebElement signIn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Suggestion\"]")
    public WebElement suggestion;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Timestamps\"]")
    public WebElement timestamps;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Co-Parenting & Coffee Event\"]")
    public WebElement coparentAndCoffee;


//text

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Our support team works hard to respond to you within two business days. During weekends or holidays, our team will respond within the following two business days.\")")
    public WebElement supportHelperText;


//errors

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/text_input_error_icon\").instance(0)")
    public WebElement fullNameIconError;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter a valid name\")")
    public WebElement validNameTextError;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/text_input_error_icon\").instance(1)")
    public WebElement validEmailIconError;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter a valid email address\")")
    public WebElement validEmailTextError;

    @AndroidFindBy(id="com.talkingparents.tpandroid:id/tos_error_text_view")
    public WebElement tosTextError;




























}


