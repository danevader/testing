package com.talkingparents.pageobjectsandroid.Journal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class newEntryPage extends AndroidActions {

    AndroidDriver driver;
	
	public newEntryPage(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}



// Define locators as variables //

    //Form Elements

    @AndroidFindBy(accessibility ="Navigate up")
    public WebElement backbutton;

    @AndroidFindBy(id = "com.talkingparents.tpandroid:id/entry_date")
    public WebElement entryDate;

    @AndroidFindBy(id="com.talkingparents.tpandroid:id/subject_layout")
    public WebElement titleForm;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/title_text")
    public WebElement titleTextField;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/description_layout")
    public WebElement descriptionForm;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/message_edit_text")
    public WebElement descriptionTextField;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/attachment")
    public WebElement attachmentButton;

    @AndroidFindBy(id ="com.talkingparents.tpandroid:id/send_entry_button")
    public WebElement saveEntrybutton;














}