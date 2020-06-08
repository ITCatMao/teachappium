package com.appium.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/3 10:49 AM
 **/
public class SnowBallTest extends BaseTest {
    @Test
    public void helloSnowBallTest() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement home_search = driver.findElement(By.id("com.xueqiu.android:id/home_search"));
        if ((home_search.getAttribute("enabled")).equals("true")) {
            System.out.println("home_search的location:" + home_search.getLocation());
            home_search.click();
            WebElement search_input_text = driver.findElement(By.id("com.xueqiu.android:id/search_input_text"));
            if (search_input_text.getAttribute("displayed").equals("true")) {
                search_input_text.sendKeys("alibaba");
                System.out.println("搜索成功");
            } else {
                System.out.println("搜索失败");
            }
        }
    }

    @Test
    public void swipeTest() {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point((int) (width * 0.5), (int) (height * 0.8)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point((int) (width * 0.5), (int) (height * 0.2))).release().perform();
    }

    @Test
    public void priceTest() {
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        System.out.println("价格：" + driver.findElement(By.xpath("//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText());

    }

    @Test //使用uiautomator方式点击底部tab交易和行情
    public void uiautomatorSelectTest() {
        //https://developer.android.com/reference/android/support/test/uiautomator/UiSelector.html
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;

        //默认tab->热门
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/scroll_view\").childSelector(text(\"热门\"))").click();

        //driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").text(\"交易\")").click();
        // driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").text(\"行情\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"行情\")").click();

        //底部tab我的
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").fromParent(text(\"行情\"))").click();
    }

    @Test//使用uiautomator方式滑动屏幕
    public void scrollTest() throws InterruptedException {
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("new UiSelector(new UiSelector().scroll(true).instance(0)).scrollIntoView(new UiSelector().text(\"郭三年\").instance(0))\n");

    }
}
