package org.suyog.appium.yatraApp.pageobjects;

import org.openqa.selenium.By;
import org.suyog.appium.helper.AbstractPage;

import io.appium.java_client.android.AndroidDriver;

public class FlightSearchPage extends AbstractPage {

  public FlightSearchPage(AndroidDriver driver) throws Exception {
    super(driver);
    // TODO Auto-generated constructor stub
  }
  
  public FlightSearchPage selectOriginCity() throws Exception {
    driver.findElement(By.id("com.yatra.base:id/org_citycode_textview")).click();
    driver.findElement(By.id("com.yatra.base:id/edit_location_search_in_actionbar")).click();
    driver.findElement(By.id("com.yatra.base:id/edit_location_search_in_actionbar")).sendKeys("BLR");
    driver.findElement(By.xpath("//android.widget.LinearLayout[@index=0]/android.widget.TextView[@index=0]")).click();
    return new FlightSearchPage(driver);
  }
  
  public FlightSearchPage selectDestinationCity() throws Exception {
    driver.findElement(By.id("com.yatra.base:id/dest_citycode_textview")).click();  
    driver.findElement(By.id("com.yatra.base:id/edit_location_search_in_actionbar")).click();
    driver.findElement(By.id("com.yatra.base:id/edit_location_search_in_actionbar")).sendKeys("PNQ");
    driver.findElement(By.xpath("//android.widget.LinearLayout[@index=0]/android.widget.TextView[@index=0]")).click();
    return new FlightSearchPage(driver);
  }
  
  public FlightSearchResultsPage navigateToSearchResultsPage() throws Exception {
    driver.findElement(By.id("com.yatra.base:id/search_button")).click();
    Thread.sleep(30000);
    return new FlightSearchResultsPage(driver);  
  }
  
}
