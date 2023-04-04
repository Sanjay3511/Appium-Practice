package apiDemoApp;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.baseconfig.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utils.GesturesTest;

public class ScrollView extends BaseTest {
    @Test
    public void  scrollTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        GesturesTest.scrollToEnd();
        GesturesTest.scrollable("WebView");

    }

}
