package org.suyog.appium.yatraApp.pageobjects;

import org.openqa.selenium.By;
import org.suyog.appium.helper.AbstractPage;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class FlightSearchResultsPage extends AbstractPage {

  public FlightSearchResultsPage(AndroidDriver driver) throws Exception {
    super(driver);
    // TODO Auto-generated constructor stub
  }
  
  public FlightSearchResultsPage verifyFromToCityOnHeader() throws Exception {
    Assert.assertEquals(driver.findElement(By.id("com.yatra.base:id/origin_header_textview")).getText(),"Bangalore");
    Assert.assertEquals(driver.findElement(By.id("com.yatra.base:id/dest_header_textview")).getText(),"Pune");
    return new FlightSearchResultsPage(driver);
  }

}
