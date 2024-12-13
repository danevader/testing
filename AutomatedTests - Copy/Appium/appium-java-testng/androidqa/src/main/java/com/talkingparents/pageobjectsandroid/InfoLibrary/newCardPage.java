package com.talkingparents.pageobjectsandroid.InfoLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class newCardPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public newCardPage(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


    // Define locators as variables //


    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Create new card\"]")
    public WebElement newCardHeaderText;

    //Form Fields

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/title_text_layout")
    public WebElement titleForm;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/description_text_layout")
    public WebElement decriptionForm;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/name_text_layout")
    public WebElement nameForm;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/phone_text_layout")
    public WebElement phoneForm;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/email_text_layout")
    public WebElement emailForm;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/address_text_layout")
    public WebElement addressForm;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/city_text_layout")
    public WebElement cityForm;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/state_text_layout")
    public WebElement stateForm;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/zip_text_layout")
    public WebElement zipForm;

    //Form text entry fields

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/title_edit_text")
    public WebElement titleTextField;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/description_edit_text")
    public WebElement descriptionTextField;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/name_edit_text")
    public WebElement nameTextField;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/phone_edit_text")
    public WebElement phoneTextField;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/email_edit_text")
    public WebElement emailTextField;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/address_edit_text")
    public WebElement addressTextField;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/city_edit_text")
    public WebElement cityTextField;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/state_edit_text")
    public WebElement stateTextField;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/zip_edit_text")
    public WebElement zipTextField;

    // Toggle and Buttons

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/share_card")
    public WebElement shareCardToggle;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/save_card")
    public WebElement saveCardButton;


    /* 
    @AndroidFindBy(id = "")
    public WebElement 

    @AndroidFindBy(id = "")
    public WebElement 

        @AndroidFindBy(id = "")
    public WebElement 
    */

    





}