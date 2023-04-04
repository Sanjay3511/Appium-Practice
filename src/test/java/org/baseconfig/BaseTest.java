package org.baseconfig;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;
import resources.AppPath;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
   public static AppiumDriver driver;
   public DesiredCapabilities caps;
   public String appPath = new AppPath().getApiDemoDebug();
   @BeforeClass
    public void setUp() throws MalformedURLException {
       caps = new DesiredCapabilities();
       caps.setCapability("platFormName","Android");
       caps.setCapability("automationName","UIAutomator2");
       caps.setCapability("deviceName","emulator-5554");
       caps.setCapability("app",appPath);
       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
   }
   @AfterClass
   public void tearDown() {
      driver.quit();
   }
   public void LongPressAction(WebElement ele){
      ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
              ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                      "duration",20000));
   }
   public void scrollable(String text){
      driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
   }
   public void scrollToEnd(){
      boolean canScrollMore;
      do
      {
         canScrollMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",
                 ImmutableMap.of("left", 100, "top", 100,
                         "width", 200, "height", 200,
                         "direction", "down",
                         "percent", 3.0));
      }while(canScrollMore);

   }
}
