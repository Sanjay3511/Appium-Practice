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

public class DragAndDrop extends BaseTest {
    @Test
    public void  dragAndDropTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        GesturesTest.dragAndDropAction(source,684,659);
        Thread.sleep(3000);
        String result =driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result,"Dropped!");
    }
}
