package apiDemoApp;

import io.appium.java_client.AppiumBy;
import org.baseconfig.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PreferenceTest extends BaseTest {
    @Test
    public void accessibility() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElements(AppiumBy.className("android.widget.RelativeLayout")).get(1).click();
        String actual = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(actual,"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Automation");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
