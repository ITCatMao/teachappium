package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/6 4:25 PM
 **/
public class BasePage {

    AppiumDriver<MobileElement> driver;

    WebDriverWait wait;
    String packageName;
    String activityName;

    public BasePage(String packageName, String activityName) {
        this.packageName = packageName;
        this.activityName = activityName;
        startApp(packageName, packageName);
    }

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public void startApp(String packageName, String activityName) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, packageName);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activityName);
        caps.setCapability(MobileCapabilityType.NO_RESET, "true");
        caps.setCapability("dontStopAppOnReset", "true");
        caps.setCapability("skipLogcatCapture", "true");

        try {
            URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(remoteUrl, caps);
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void quit() {
        driver.quit();
    }

    public By byText(String text) {
        return By.xpath("//*[@text='" + text + "']");
    }

    public MobileElement find(By by) {
        return driver.findElement(by);
    }

    public MobileElement find(String text) {
        return driver.findElement(By.xpath("//*[@text='" + text + "']"));
    }

    public void click(By by) {
        //todo exception
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
        //driver.findElement(by).click();
    }

    public void click(String text) {

        find(text).click();
    }


    public void sendkey(By by, String key) {

        driver.findElement(by).sendKeys(key);
    }

    //todo:
    public void waitElement() {

    }


}
