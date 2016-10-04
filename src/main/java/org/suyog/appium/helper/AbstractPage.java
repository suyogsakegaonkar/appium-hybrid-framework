package org.suyog.appium.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.suyog.appium.helper.Locator.LocatorEnum;

import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractPage {


  LocatorEnum locatorEnum;

  public AndroidDriver driver;
  Properties prop = new Properties();

  public AbstractPage(AndroidDriver driver) throws Exception {
    this.driver = driver;
    this.loadPropertiesFile();
  }

  private void loadPropertiesFile() throws IOException {
    InputStream input = null;
    String className = Thread.currentThread().getStackTrace()[3].getClassName();
    //System.out.println("In " + className);
    className = className.replace(".", "/");
    String file = "src/test/java/" + className.replace(className.split("\\/")[5],"properties/".concat(className.split("\\/")[5])) + ".properties";
    if (new File(file).exists()) {
      input = new FileInputStream(file);
      prop.load(input);
    } else {
      System.out.println("Properties file does not exist for " + className + " Page...");
    }
  }

  public By getElement(String name, String... dynamicArgs) throws IOException {
    String locatordetails = prop.getProperty(name);
    String locatorType = locatordetails.split("\\|")[0];
    String locator = locatordetails.split("\\|")[1];
    locatorEnum = locatorEnum.valueOf(locatorType);
    int percentCounter = 0;
    for (int i = 0; i < locator.length(); i++) {
      if (locator.charAt(i) == '%') {
        percentCounter++;
      }
    }
    if (dynamicArgs.length >= 0 && dynamicArgs.length == percentCounter) {
      int i = 0;
      for (String arg : dynamicArgs) {
        locator = locator.replace("%".concat(Integer.toString(i)), arg);
        i++;
      }
    } else
      throw new RuntimeException("Incorrect number of arguments provided...");
    //System.out.println("locator: " + locator);
    switch (locatorEnum) {
      case id:
        return By.id(locator);
      case name:
        return By.name(locator);
      case xpath:
        return By.xpath(locator);
      case cssSelector:
        return By.cssSelector(locator);
      case className:
        return By.className(locator);
      case tagName:
        return By.tagName(locator);
      case linkText:
        return By.linkText(locator);
      case partialLinkText:
        return By.partialLinkText(locator);
      default:
        break;
    }
    return null;
  }

}
