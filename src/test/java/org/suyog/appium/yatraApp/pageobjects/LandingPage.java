package org.suyog.appium.yatraApp.pageobjects;



import org.suyog.appium.helper.AbstractPage;

import io.appium.java_client.android.AndroidDriver;

public class LandingPage extends AbstractPage {

  public LandingPage(AndroidDriver driver) throws Exception {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public FlightSearchPage gotoFlightSearchPage() throws Exception {
    Thread.sleep(30);
    driver.findElement(getElement("flightsButton")).click();
    return new FlightSearchPage(driver);
  }
  
}
