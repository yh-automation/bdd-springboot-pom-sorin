package org.sorincos.bdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

  boolean headless = System.getProperty("Headless", "true").equals("true");

  private DriverFactory() {
    // Do-nothing..Do not allow to initialize this class from outside
  }

  private static DriverFactory instance = new DriverFactory();

  public static DriverFactory getInstance() {
    return instance;
  }

  // thread local driver object for webdriver
  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
    @Override
    protected WebDriver initialValue() {
      DesiredCapabilities capabilities = null;
      capabilities = DesiredCapabilities.firefox();
      capabilities.setJavascriptEnabled(true);
      capabilities.setCapability("takesScreenshot", true);

      FirefoxOptions options = new FirefoxOptions();
      if (headless) {
        options.addArguments("-headless", "-safe-mode");
      }
      capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
      final FirefoxDriver firefox = new FirefoxDriver();
      return firefox;
    }
  };

  // call this method to get the driver object and launch the browser
  public WebDriver getDriver() {
    return driver.get();
  }

  // Quits the driver and closes the browser
  public void removeDriver() {
    driver.get().quit();
    driver.remove();
  }
}
