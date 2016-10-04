package org.suyog.appium.yatraApp.pageobjects;

import org.suyog.appium.helper.AbstractPage;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class FlightSearchResultsPage extends AbstractPage {

  public FlightSearchResultsPage(AndroidDriver driver) throws Exception {
    super(driver);
    // TODO Auto-generated constructor stub
  }
  
  public FlightSearchResultsPage verifyFromToCityOnHeader() throws Exception {
    Assert.assertEquals(driver.findElement(getElement("srcCityHeader")).getText(),"Bangalore");
    Assert.assertEquals(driver.findElement(getElement("destCityHeader")).getText(),"Pune");
    return new FlightSearchResultsPage(driver);
  }

}
