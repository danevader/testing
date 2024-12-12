package com.talkingparents.pageobjectsandroid.Messages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import org.testng.Assert;

import com.talkingparents.utils.AndroidActions;
import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class messagingPage extends AndroidActions{

	AndroidDriver driver;
	
	
	
	public messagingPage(AndroidDriver driver) {
		
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Notifications pop-up

	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	public static WebElement notificationAccept;
	
	// Onboarding screen

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/header_image_view")
	public static WebElement onboardHeaderImage;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/title_text_view")
	public static WebElement onboardMessagingHeader;
	
	@AndroidFindBy(id="com.talkingparents.tpandroid:id/description_text_view")
	public static WebElement onboardMessagingText;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(0)")
	public static WebElement eyeIcon;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(1)")
	public WebElement attachmentIcon;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/icon\").instance(2)")
	public WebElement pinIcon;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/get_started_button\")")
	public WebElement onboardContinueButton;
	
	// Subject list view

	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Secure Messaging\")")
	public WebElement secureMessagingHeader;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/message_info_item\")")
	public WebElement secureMessagingInfoIcon;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/create_thread_fab\")")
	public WebElement newMessageButton;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/search_conversation\")")
	public  WebElement messageSearchIcon;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/search_src_text\")")
	public WebElement messageSearchField;

	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.talkingparents.tpandroid:id/recycler_view\"]/android.view.ViewGroup[1]")
	public WebElement firstSubject;


	//New Message

	@AndroidFindBy (uiAutomator="new UiSelector().text(\"New message\")")
	public  WebElement newMessageHeader;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/message_edit_text")
	public  WebElement newMessageBody;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/subject_edit_text")
	public  WebElement newMessageSubject;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/text_input_end_icon")
	public  WebElement newMessageSendIcon;

	@AndroidFindBy(uiAutomator="new UiSelector().className(\"androidx.appcompat.widget.LinearLayoutCompat\").instance(2)")
	public  WebElement firstMessage;

	
	
	//Message Details

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/message_text_view\")")
	public  WebElement recentUserMessageBubble;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Subject\")")
	public  WebElement replySubjectField;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Type your message\")")
	public  WebElement replyMessageField;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Send\")")
	public  WebElement replySendButton ;
	
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

	


	//Methods

	public void iconCheck()
	{
		Assert.assertTrue(eyeIcon.isDisplayed());
		Assert.assertTrue(attachmentIcon.isDisplayed());
		Assert.assertTrue(pinIcon.isDisplayed());
	}
	
	
	public void createNewSubject(String subject, String message)
	{
		newMessageSubject.sendKeys(subject);
		newMessageBody.sendKeys(message);
	}
	
	public void messageDetailsCheck(String subject, String message)
	{
		WebElement subjectText = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+subject+"\")"));
		Assert.assertTrue(recentUserMessageBubble.isDisplayed());
		Assert.assertEquals(recentUserMessageBubble.getText(), message);
		Assert.assertTrue(subjectText.isDisplayed());
	
	}
	
	
	
	/*public void setActivity()
	{
		//screen to home page
				Activity activity = new Activity("com.talkingparents.tpandroid", "com.talkingparents.tpandroid.EntryActivity");
				((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.talkingparents.tpandroid/com.talkingparents.tpandroid.EntryActivity"));
				
	}
				*/
	
}
