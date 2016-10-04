package org.suyog.appium.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class ApplicationTest {
  
  protected AndroidDriver driver;
  
  @BeforeTest
  public void setUp() throws IOException {
    Properties appProperties = new Properties();
    ApplicationTest abstractTest = new ApplicationTest();
    String fis = "src"+File.separator+"main"+File.separator+"java"+File.separator+abstractTest.getClass().getPackage().getName().replace(".", File.separator)+File.separator+"app"+File.separator+"properties"+File.separator+System.getProperty("properties");
    System.out.println(fis);
    InputStream inputPropertiesFile = new FileInputStream(fis);
    appProperties.load(inputPropertiesFile);
    // Created object of DesiredCapabilities class.
    DesiredCapabilities capabilities = new DesiredCapabilities();
    // Set android deviceName desired capability. Set your device name.
    capabilities.setCapability("deviceName", appProperties.getProperty("deviceName"));
    // Set BROWSER_NAME desired capability. It's Android in our case here.
    capabilities.setCapability(CapabilityType.BROWSER_NAME, appProperties.getProperty("browserName")); 
    // Set android VERSION desired capability. 
    // Set your mobile device's OS version.
    capabilities.setCapability(CapabilityType.VERSION, appProperties.getProperty("version"));
    // Set android platformName desired capability. It's Android in our case here.
    capabilities.setCapability("platformName", appProperties.getProperty("platformName"));
    // Set android appPackage desired capability.
    capabilities.setCapability("appPackage", appProperties.getProperty("appPackage"));
    // Set android appActivity desired capability.
    capabilities.setCapability("appActivity", appProperties.getProperty("appActivity"));
    // Created object of RemoteWebDriver will all set capabilities. 
    // Set appium server address and port number in URL string. 
    // It will launch desired app in android device.
    driver = new AndroidDriver(new URL(appProperties.getProperty("appiumServerUrl")), capabilities);
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    System.out.println("dadasasdasd");
  }

  @AfterTest
  public void End() {
    driver.quit();
  }
}
