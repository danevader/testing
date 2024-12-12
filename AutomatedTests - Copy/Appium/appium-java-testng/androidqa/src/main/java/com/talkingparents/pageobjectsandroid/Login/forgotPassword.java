package com.talkingparents.pageobjectsandroid.Login;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



import com.talkingparents.utils.AndroidActions;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


//Set up driver for tests

public class forgotPassword extends AndroidActions{
	
	AndroidDriver driver;
	
	public forgotPassword(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


// Define locators as variables //


////Forgot password ////


//fields

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/email_address")
    public WebElement emailField;


//buttons

    @AndroidFindBy(id="com.talkingparents.tpandroid:id/submit_button")
    public WebElement submitButton;


//images

    @AndroidFindBy(id="com.talkingparents.tpandroid:id/logo")
    public WebElement tpLogo;

//Links

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/need_help_button")
    public WebElement  needHelpLink;


//text

    @AndroidFindBy(id= "com.talkingparents.tpandroid:id/helper_header")
    public WebElement helperTextHeader;

    @AndroidFindBy(id= "com.talkingparents.tpandroid:id/helper_1")
    public WebElement helperTextOne;

    @AndroidFindBy(id= "com.talkingparents.tpandroid:id/helper_2")
    public WebElement helperTextTwo;

















}




