package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/3 8:38 PM
 **/
public class SearchPage extends BasePage {

    By nameLocator = By.id("name");

    public SearchPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public SearchPage search(String key) {
        //driver.findElementById("com.xueqiu.android:id/search_input_text").sendKeys(key);
        do {
            sendkey(By.id("com.xueqiu.android:id/search_input_text"), key);
            System.out.println("sendkeys");
        } while (findElements(nameLocator).size() <= 0);
        return this;
    }

    public List<String> getSearchList() {
        List<String> nameList = new ArrayList<String>();
//        for (Object element : driver.findElements(nameLocator)) {
//            nameList.add(((WebElement) element).getText());
//        }
        findElements(nameLocator).forEach(element -> nameList.add(element.getText()));
        // TODO: stream流 lamda优化
        return nameList;
    }

    public double getPrice() {
        click(nameLocator);
        return Double.valueOf(findElement(By.id("current_price")).getText());
    }
}
