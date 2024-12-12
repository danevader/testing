package com.talkingparents;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class setUpConfigNative {

	
	
	public AndroidDriver driver;
	AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("\\Users\\dane.wilbur\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		
		service.start();
		
		//Set up Android driver & UiAutomator

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 7 Pro API 34");
		options.setApp("\\Program Files\\APKS\\app-android.apk");
		
		//Set Caps
	
		options.setCapability("autoGrantPermissions", true);
		options.setCapability("uninstallOtherPackages", "\\Program Files\\APKS\\app-android.apk");
		/*options.setCapability("uninstallOtherPackages", "\\Program Files\\APKS\\talkingparents.qaxamarin.apk"); */
	
		
		
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//
		// Automatically grant permissions

		
	}
	@AfterClass
	public void tearDown() 
		{
			driver.quit();
			service.stop();
		}

}


