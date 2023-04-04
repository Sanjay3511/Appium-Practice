package org.baseconfig;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;
import resources.AppPath;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
   public static AppiumDriver driver;
   public DesiredCapabilities caps;
   public String appPath = new AppPath().getMewtApk();
   @BeforeClass
    public void setUp() throws MalformedURLException {
       caps.setCapability("platFormName","Android");
       caps.setCapability("automationName","UIAutomator2");
       caps.setCapability("deviceName","emulator-5554");
       caps.setCapability("app",appPath);
       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }
   @AfterClass
   public void tearDown() {
      driver.quit();
   }
}
