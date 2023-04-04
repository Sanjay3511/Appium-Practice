package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.baseconfig.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class GesturesTest extends BaseTest {
    public static void LongPressAction(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "duration",20000));
    }
    public static void scrollable(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }
    public static void scrollToEnd(){
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
    public static  void swipe(WebElement ele,String dir){
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "direction",dir,
                        "percent", 0.75));
    }
    public static  void swipeTillEnd() {
        boolean swipeTillEnd;
        do {
           swipeTillEnd =(Boolean)((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                    ImmutableMap.of("direction", "left", "percent", 0.75));
        }while (swipeTillEnd);
    }
    public static void dragAndDropAction(WebElement ele, double endX, double endY){
        ((JavascriptExecutor)driver).executeScript("mobile:dragGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "endX", endX,
                        "endY", endY));
    }
}
