package org.suyog.appium.yatraApp.pageobjects;

import org.suyog.appium.helper.AbstractPage;
import io.appium.java_client.android.AndroidDriver;

public class FlightSearchPage extends AbstractPage {

  public FlightSearchPage(AndroidDriver driver) throws Exception {
    super(driver);
    // TODO Auto-generated constructor stub
  }
  
  public FlightSearchPage selectOriginCity() throws Exception {
    driver.findElement(getElement("srcCityLabel")).click();
    driver.findElement(getElement("citySearchBar")).click();
    driver.findElement(getElement("citySearchBar")).sendKeys("BLR");
    driver.findElement(getElement("citySearchTopResult")).click();
    return new FlightSearchPage(driver);
  }
  
  public FlightSearchPage selectDestinationCity() throws Exception {
    driver.findElement(getElement("destCityLabel")).click();  
    driver.findElement(getElement("citySearchBar")).click();
    driver.findElement(getElement("citySearchBar")).sendKeys("PNQ");
    driver.findElement(getElement("citySearchTopResult")).click();
    return new FlightSearchPage(driver);
  }
  
  public FlightSearchResultsPage navigateToSearchResultsPage() throws Exception {
    driver.findElement(getElement("searchFlightButton")).click();
    Thread.sleep(30000);
    return new FlightSearchResultsPage(driver);  
  }
  
}
