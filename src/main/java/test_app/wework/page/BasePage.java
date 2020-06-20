package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/6 4:25 PM
 **/
public class BasePage {
    private final int timeOutDefaultSeconds = 60;
    AppiumDriver<MobileElement> driver;

    //AndroidDriver<MobileElement> driver;

    WebDriverWait wait;
    String packageName;
    String activityName;
    final By add = By.id("gym");

    public BasePage(String packageName, String activityName) {
        this.packageName = packageName;
        this.activityName = activityName;
        startApp(this.packageName, this.packageName);
    }

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutDefaultSeconds);
    }

//    public BasePage(AndroidDriver<MobileElement> driver) {
//        this.driver = driver;
//        wait = new WebDriverWait(driver, timeOutDefaultSeconds);
//    }

    public void startApp(String packageName, String activityName) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.tencent.wework");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".launch.LaunchSplashActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET, "true");
        caps.setCapability("dontStopAppOnReset", "true");
        caps.setCapability("skipLogcatCapture", "true");

        try {
            URL remoteUrl = new URL("http://127.0.0.1:4725/wd/hub");
            driver = new AndroidDriver<MobileElement>(remoteUrl, caps);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, timeOutDefaultSeconds);
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
        //todo exception
        find(text).click();
    }

    public void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    public BasePage androidBack() {
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        return this;
    }

    //todo:
    public void waitElement() {

    }

    public int getWidth(double multiple) {
        return (int) (driver.manage().window().getSize().width * multiple);
    }

    public int getHeight(double multiple) {
        return (int) (driver.manage().window().getSize().height * multiple);
    }

    public void swipeDown() {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(getWidth(0.5), getHeight(0.8))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(getWidth(0.5), getHeight(0.2))).release().perform();
    }

    //向上滑动
    public void swipeToUp() {
        int x = driver.manage().window().getSize().getWidth();
        int y = driver.manage().window().getSize().getHeight();
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(x / 2, 8 * y / 10)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(x / 2, 2 * y / 10)).release().perform();
    }

    //九宫格解锁屏幕 geUnlock(driver, By.id("com.alipay.mobile.gesturebiz:id/lockView"), new int[] {0,1,4,7});
    public static void geUnlock(AndroidDriver<AndroidElement> driver, By by, int[] pwd) {
        AndroidElement lockview = driver.findElement(by);

        int start_x = lockview.getLocation().getX();//起始点X
        int start_y = lockview.getLocation().getY();//起始点Y

        int w = lockview.getSize().getWidth();
        int h = lockview.getSize().getHeight();

        List<PointOption> corLists = new ArrayList<PointOption>();//点的坐标集合


        for (int i = 0; i < 3; i++) {//行

            for (int j = 0; j < 3; j++) {//列
                int x_center = start_x + ((2 * j + 1) * w) / 6;
                int y_center = start_y + ((2 * i + 1) * h) / 6;
                corLists.add(PointOption.point(x_center, y_center));
            }
        }

        TouchAction action = new TouchAction(driver);
        //	action.press(PointOption.point(x/2, 8*y/10)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(x/2, 2*y/10)).release().perform();
        action.press(corLists.get(pwd[0])).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)));

        for (int i = 1; i < pwd.length; i++) {
            action.moveTo(corLists.get(pwd[i])).waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)));
        }
        action.release().perform();
    }


}
