package com.appium.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Description 需要安装appium官网的api demo apk才能测试该类
 * @Author Date
 * @Date 2020/6/3 7:55 PM
 **/
public class ToastTest {
    public static AppiumDriver driver;

    @BeforeAll
    public static void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.NO_RESET, "true");

        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.api");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".io.appium.android.apis.view");
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void toastTest() {
        driver.findElement(By.xpath("//*[@text='Make a Popup!']")).click();
        System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("//*[@text='Search']")).click();
        driver.findElement(By.xpath("//*[@class='android.widget.Toast']")).getText();
        System.out.println(driver.getPageSource());

    }

}
