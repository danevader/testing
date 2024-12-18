package com.talkingparents.pageobjectsandroid.Messages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.talkingparents.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class threadView  extends AndroidActions{

    AndroidDriver driver;
	
	
	
	public threadView(AndroidDriver driver) {
		
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

    //Message Details

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/phone_call")
	public WebElement phoneCallButton;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/video_call")
	public WebElement videoCallButton;



	@AndroidFindBy(id ="com.talkingparents.tpandroid:id/message_text_view")
	public  WebElement messageTextView;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/timestamp_text_view")
	public WebElement messageTimeStampView;
	
	@AndroidFindBy(id="com.talkingparents.tpandroid:id/messages_recycler_view")
	public  WebElement recylcerThreadView;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/message_edit_text")
	public  WebElement replyMessageField;
	
	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/text_input_end_icon")
	public  WebElement replySendButton ;

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/attachment_image_view")
	public WebElement attachmentIcon;

	//Attachment menu options

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\").instance(0)")
	public WebElement addAttachment;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\").instance(1)")
	public WebElement takePicture;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\").instance(2)")
	public WebElement takeVideo;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/content\").instance(3)")
	public WebElement vaultItem;

	
	
	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"sample reply\").instance(0)")
	public  WebElement subjectNameHeader;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"I created this message subject as an example\")")
	public  WebElement messageReplyBubbleText;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.ViewGroup\").instance(6)")
	public  WebElement conversationBackButton;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Rustic Metal Mouse\")")
	public  WebElement replySubject;

	@AndroidFindBy(accessibility = "Navigate up")
	public WebElement messageBackButton;

	@AndroidFindBy(accessibility = "Show roots")
	public WebElement androidMenuRoot;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Downloads\"]")
	public WebElement androidDownloads;

	@AndroidFindBy(id = "com.google.android.documentsui:id/header_title")
	public WebElement filesInDownloadHeader;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.google.android.documentsui:id/icon_thumb\").instance(0)")
	public WebElement rockonScott;


    
}
