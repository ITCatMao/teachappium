package test_app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/3 8:20 PM
 **/
public class TestDemo {

    public static AppiumDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        //caps.setCapability("dontStopAndRest", "true");

        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.xueqiu.android");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".view.WelcomeActivityAlias");
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void sampleTest() {
        MobileElement me4 = (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        me4.click();
        MobileElement me5 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        me5.sendKeys("alibaba");
        MobileElement me6 = (MobileElement) driver.findElementById("current_price");
        me6.click();

    }
}
