package qaTeam.tpTesting;

import java.net.MalformedURLException;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class firstTest extends setUpConfig {
	
	@Test
	public void signInScreen() throws MalformedURLException, URISyntaxException{
		
		//Sign into account
		WebElement el1 = driver.findElement(AppiumBy.className("android.widget.Button"));
		el1.click();
		WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign in to an existing account\")"));
		el2.click();
		WebElement el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
		el3.sendKeys("qarecordstesting+1414@gmail.com");
		WebElement el4 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
		el4.sendKeys("1ndyJon35!");
		WebElement el5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign in\")"));
		el5.click();
		
		//Look For Messaging Header
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Welcome to Secure Messaging!\")"));
		
		//Navigation events
		
		WebElement el6 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Menu\")"));
		el6.click();
	
		//Sign Out
		WebElement el7 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign out\")"));
		el7.click();
		WebElement el8 = driver.findElement(AppiumBy.id("android:id/button2"));
		el8.click();
		
		//Look for Logo
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(0)"));
		
		
		

	}
	

	}




