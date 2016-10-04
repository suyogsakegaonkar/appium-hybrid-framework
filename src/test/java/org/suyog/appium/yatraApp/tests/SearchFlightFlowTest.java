package org.suyog.appium.yatraApp.tests;

import org.suyog.appium.helper.ApplicationTest;
import org.suyog.appium.yatraApp.pageobjects.LandingPage;
import org.testng.annotations.Test;

public class SearchFlightFlowTest extends ApplicationTest {
  @SuppressWarnings("rawtypes")

  @Test
  public void SearchFlightFlow_VerifyFromToOnHeader() throws Exception {
    LandingPage landingPage = new LandingPage(driver);
    landingPage.gotoFlightSearchPage()
               .selectOriginCity()
               .selectDestinationCity()
               .navigateToSearchResultsPage()
               .verifyFromToCityOnHeader();
  }

}
