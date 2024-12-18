package com.talkingparents.pageobjectsandroid.Payments;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



import com.talkingparents.utils.AndroidActions;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class paymentsPage extends AndroidActions {

    AndroidDriver driver;
	
	public paymentsPage(AndroidDriver driver) 
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


    
}
