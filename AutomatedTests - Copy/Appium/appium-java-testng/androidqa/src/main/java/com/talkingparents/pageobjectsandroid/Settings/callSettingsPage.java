package com.talkingparents.pageobjectsandroid.Settings;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;




//Set up driver for tests

public class callSettingsPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public callSettingsPage(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


    // Define locators as variables //

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enable recorded calls\")")
    public WebElement callSettingEnableText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/title_text_view\" and @text=\"Phone calls\"]")
    public WebElement phoneCallsTitleText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Make or receive recorded phone calls. A verified phone number is required (it will never be shared with your co-parent).\"]")
    public WebElement phoneCallsInfoText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.talkingparents.tpandroid:id/title_text_view\" and @text=\"Video calls\"]")
    public WebElement videoCallsTitleText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Make or receive recorded video calls. You must allow access to your device's camera and microphone. Video calls do not required a verified phone number.\"]")
    public WebElement videoCallsInfoText;

    @AndroidFindBy(xpath ="//android.widget.TextView[@text=\"Available Minutes\"]")
    public WebElement availableMinutesSectionHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/toggle\").instance(0)")
    public WebElement phoneCallToggle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/toggle\").instance(1)")
    public WebElement videoCallToggle;

    @AndroidFindBy(id = "android.widget.Button")
    public WebElement addMinutesButton;









































}