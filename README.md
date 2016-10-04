# appium-hybrid-framework
appium-hybrid-framework
# Automation for Apps
Appium is an open source test automation framework for use with native, hybrid and mobile web apps. 
It drives iOS and Android apps using the WebDriver protocol.

JUnit project setup
---

This contains the source code for running sample [Appium](http://github.com/appium/appium) tests using [JUnit](http://www.junit.org).

In order to run the tests, you will need to install [Apache Maven](http://maven.apache.org), and Appium (according to the Appium [installation instructions](https://github.com/appium/appium).

You will then need to start appium, eg:

    appium

To compile and run all tests, run:

    mvn test

To run a single test, run:

    mvn -Dtest=com.saucelabs.appium.SimpleTest test
