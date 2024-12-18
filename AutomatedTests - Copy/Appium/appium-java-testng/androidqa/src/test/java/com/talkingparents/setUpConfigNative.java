package com.talkingparents;

import java.io.File;
import java.io.IOException;
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
	AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws URISyntaxException, IOException {
        // Start Appium Server
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\danev\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        // Initialize UiAutomator2Options
        UiAutomator2Options options = setCapabilities();

        // Initialize Android Driver
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Push the file to the device
		File attachment = getFileFromProject("attachmentFiles/rock.jpg"); // Load file from resources
		String devicePath = "/sdcard/Download/rock.jpg";
		driver.pushFile(devicePath, attachment);
		System.out.println("File pushed to device: " + devicePath);

		 
    }

    private UiAutomator2Options setCapabilities() {
        UiAutomator2Options options = new UiAutomator2Options();

        // Basic Capabilities
        options.setDeviceName("Pixel 8 Pro API 34"); // Update your emulator/device name
        options.setApp("C:\\Program Files\\APKS\\app-android.apk"); // Path to the app APK

        // Additional Capabilities
        options.setCapability("autoGrantPermissions", true);
        options.setCapability("uninstallOtherPackages", "com.example.otherapp"); // Example package name
        options.setCapability("noReset", false); // Ensures clean install each run
        options.setCapability("fullReset", true); // Ensures full reset before test
        options.setCapability("platformName", "Android");
        options.setCapability("automationName", "UiAutomator2");


        // Optional logging
        System.out.println("Appium Capabilities: " + options);

        return options;
		
    }

	private File getFileFromProject(String relativePath) {
		try {
			// Get the file from the resources folder
			URI fileUri = getClass().getClassLoader().getResource(relativePath).toURI();
			return new File(fileUri);
		} catch (Exception e) {
			throw new RuntimeException("File not found in resources: " + relativePath, e);
		}
	}
	

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
