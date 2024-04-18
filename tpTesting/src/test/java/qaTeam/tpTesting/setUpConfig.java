package qaTeam.tpTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Provider.Service;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class setUpConfig {
	
	public AndroidDriver driver;
	AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("\\Users\\dane.wilbur\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("10.1.20.115").usingPort(4723).build();
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		
		service.start();
		
		//Set up Android driver & UiAutomator

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 7 Pro API 34");
		options.setApp("\\Program Files\\APKS\\talkingparents.Release.apk");
		
		
		
		driver = new AndroidDriver(new URI("http://10.1.20.115:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Automatically grant permissions
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("autoGrantPermissions", true);
			
		
	}
	@AfterClass
	public void tearDown() {
		service.stop();
		driver.quit();
		
	}

}


