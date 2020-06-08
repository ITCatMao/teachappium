package com.appium.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Description 需要安装"手势密码锁"app
 * @Author 可以写成直接解锁手机锁屏的手势，不下载app
 * @Date 2020/6/3 11:12 AM
 **/
public class SwipeUnlockTest {


    public static AppiumDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.NO_RESET, "true");

        //adb logcat | grep ActivityManager
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "cn.kmob.screenfingermovelock");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.samsung.ui.FlashActivity");
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void unlockTest() {
        TouchAction touchAction = new TouchAction(driver);
        Duration duration = Duration.ofMillis(5000);
        driver.findElement(By.id("cn.kmob.screenfingermovelock:id/patternTest")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        touchAction.press(PointOption.point(248, 389)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(770, 381)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(1286, 400)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(1289, 894)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(1288, 1409)).waitAction(WaitOptions.waitOptions(duration)).release().perform();
    }
}
