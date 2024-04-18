package qaTeam.tpTesting;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class emptyStates extends setUpConfig {
	
	@Test
	public void SignIn() {
		
		
		//WebElement popUp = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
		//popUp.click();
		
		//Sign into account
				WebElement el1 = driver.findElement(AppiumBy.className("android.widget.Button"));
				el1.click();
				WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign in to an existing account\")"));
				el2.click();
				WebElement el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
				el3.sendKeys("tpdevtesting+2777@gmail.com");
				WebElement el4 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
				el4.sendKeys("123456");
				WebElement el5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign in\")"));
				el5.click();
		
	}
	
	@Test
	public void emptyStateMessageScreen() {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Get started\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(2)"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"No message activity\")"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"new UiSelector().text(\"New message\")"));
		
	}

}
