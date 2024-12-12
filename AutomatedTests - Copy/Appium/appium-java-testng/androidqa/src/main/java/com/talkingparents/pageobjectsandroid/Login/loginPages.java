package com.talkingparents.pageobjectsandroid.Login;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



import com.talkingparents.utils.AndroidActions;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


//Set up driver for tests

public class loginPages extends AndroidActions{
	
	AndroidDriver driver;
	
	public loginPages(AndroidDriver driver) 
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void loginAction(String email, String password){

		loginPages loginpage = new loginPages(driver);

		loginpage.existingAccountLink.click();
        loginpage.setEmailField(email);
        loginpage.setPasswordField(password);
        loginpage.signInButton.click();

	}




// Define locators as variables //


////App Welcome Screen//


//Links

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/logo_image_view")
	public WebElement welcomeTpLogo;

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.talkingparents.tpandroid:id/sign_into_existing_account_textview\")")
	public WebElement existingAccountLink;

//Buttons

	@AndroidFindBy(id = "com.talkingparents.tpandroid:id/get_started_button")
	public WebElement getStartedButton;

//Text

	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Co-parenting in one easy app, so you can focus on what matters most.\")")
	public WebElement welcomeText;

	


////Login screen//


//Fields

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/email_edit_text")
	public WebElement emailField;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/password_edit_text")
	public WebElement passwordField;

//Links

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/logo_image_view")
	public WebElement tpLogo;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/forgot_password_text_view")
	public WebElement forgotPasswordLink;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/contact_us_text_view")
	public WebElement contactUsLink;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/privacy_policy")
	public WebElement privacyPolicyLink;

	@AndroidFindBy(uiAutomator ="new UiSelector().text(\"Terms of service\")")
	public WebElement tosLink;


//Buttons

	@AndroidFindBy(accessibility = "Show password")
	public WebElement showPasswordIcon;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/create_account_button")
	private WebElement createAccountButton;

	@AndroidFindBy(id="com.talkingparents.tpandroid:id/sign_in_button")
	public WebElement signInButton;

//Text
	
	@AndroidFindBy(id="com.talkingparents.tpandroid:id/copyright_text_view")
	public WebElement copyrightText;


	

// Page Methods

	public void signInAction(String email, String password)
	{
		existingAccountSignIn();
		setEmailField(email);
		setPasswordField(password);
		clickToSignIn();
	}

	public void existingAccountSignIn()
	{
		existingAccountLink.click();
	}
	
	
	public void setEmailField(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void setPasswordField(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickToSignIn()
	{
		signInButton.click();
	}
	
	
	/*public void setActivity()
	{
		//screen to home page
				Activity activity = new Activity("com.talkingparents.tpandroid", "crc64e3ad4f69eb83a407.MainActivity");
				((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.talkingparents.tpandroid/com.talkingparents.tpandroidcrc64e3ad4f69eb83a407.MainActivity"));
				
	}
	/* 
 public void assertErrorFieldsAreDisplayed() {
	    Assert.assertTrue(enterValidEmailText.isDisplayed());
	    Assert.assertTrue(enterValidPasswordText.isDisplayed());
	 }
	 
	/* 
	
	//Assertion method
    public void assertInvalidLoginPopupDisplayed() {
        Assert.assertTrue(badLoginCredsAlert.isDisplayed());
    }
    
    public void assertSignInButtonDisabled() {
        Assert.assertFalse(signInButton.isEnabled());
    }
	
}


*/




}
	
