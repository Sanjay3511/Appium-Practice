package org.baseconfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
   public static AndroidDriver driver;
   public  static  DesiredCapabilities caps;

   @Test
    public void Config() throws MalformedURLException {
       caps = new DesiredCapabilities();
       caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
       caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
       caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
       caps.setCapability(MobileCapabilityType.APP,"//home//sanjay//practice//Appium-Practice//app//resources//ApiDemos-debug.apk");
       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);

   }

}
