package test_app.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/6 2:41 PM
 **/
@Slf4j
public class BasePage {
    AndroidDriver<MobileElement> driver;
    //AppiumDriver<MobileElement> driver;

    WebDriverWait wait;

    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.xueqiu.android");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".view.WelcomeActivityAlias");
        caps.setCapability(MobileCapabilityType.NO_RESET, "true");
        caps.setCapability("dontStopAppOnReset", "true");

        try {
            URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    public void quit() {
        driver.quit();

    }

    public MobileElement findElement(By by) {
        return driver.findElement(by);
    }

    public void click(By by) {
        //todo exception
        driver.findElement(by).click();
    }

    public void sendkey(By by, String key) {
        driver.findElement(by).sendKeys(key);
    }

    //todo:
    public void waitElement() {


    }

    public List<MobileElement> findElements(By by) {
        return driver.findElements(by);
    }


    /**
     * @Description 寻找元素是否存在，存在返回true，否则返回false
     * @Param driver 驱动driver
     * @Param locator 涵盖所有的查找方式
     * @Param timeoutSeconds 等待时长秒
     * @Param eleName 元素名称
     **/
    public boolean isElementExist(By locator, int timeoutSeconds, String eleName) {
        try {
            Thread.sleep(timeoutSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            MobileElement webElement = driver.findElement(locator);
            log.info(eleName + "元素查找成功,locator为：" + webElement);
            return true;
        } catch (Exception e) {
            log.info(eleName + "元素未找到");
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

}
