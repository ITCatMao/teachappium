package test_app.xueqiu.page;

import org.openqa.selenium.By;


/**
 * @Description http://appium.io/docs/en/writing-running-appium/caps/
 * @Author catty
 * @Date 2020/6/3 8:36 PM
 **/
public class MainPage extends BasePage {

    /**
     * @Description:点击首页的搜索框
     * @Author: PYPUA
     * @return: test_app.xueqiu.page.SearchPage
     **/
    public SearchPage toSearch() {
        click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage(driver);
    }

    /**
     * @Description:点击底部的行情tab，跳转到行情
     * @Author: PYPUA
     * @return: test_app.xueqiu.page.MarketPage
     **/
    public MarketPage toMarketTab() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.findElementById("com.xueqiu.android:id/tab_name").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").text(\"行情\")").click();

        return new MarketPage(driver);
    }
}
