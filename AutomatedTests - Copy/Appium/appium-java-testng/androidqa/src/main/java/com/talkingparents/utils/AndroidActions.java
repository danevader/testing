package com.talkingparents.utils;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class AndroidActions {
	
AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		
		this.driver =driver;
}
	//When scrolling to text
public void scrollToTextAction(String text)
{
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
}

//No prior idea of where to scroll
//Java
public void scrollToEndAction() {

	boolean canScrollMore;
	do{
				 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				 "left", 100, "top", 100, "width", 200, "height", 200,
				 "direction", "down",
				 "percent", 3.0
				));
	}while(canScrollMore);

}

// Long press on an element
public void LongPressGestureAction(WebElement ele) throws MalformedURLException
{

	// Java
	((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
	    "elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
}

//
public void scrollTo(String text)
{                
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
}





}
