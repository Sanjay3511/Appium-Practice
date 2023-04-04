package apiDemoApp;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.baseconfig.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GesturesTest;

import java.nio.charset.StandardCharsets;

public class ViewsTest extends BaseTest {
    @Test
    public void LongPressGesture() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
//        driver.findElement(AppiumBy.accessibilityId("2. Cursor (People)")).click();
//        driver.findElement(AppiumBy.accessibilityId("3. Simple Adapter")).click();        dri
        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        GesturesTest.LongPressAction(ele);
        String menuText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText,"Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
        Thread.sleep(2000);
    }
}
