package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/6 4:31 PM
 **/
public class DailyPage extends BasePage {
    //todo 多版本app、多平台的app、定位符通常有差别
    private final By taskNameEle = By.id("b2k");
    private final By save = byText("保存");
    private final By taskList = By.id("gg_");
    private By addEle = By.id("gym");

    public DailyPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }


    public DailyPage add(String name, String time) {
        click(addEle);
        sendKeys(taskNameEle, name);
        click(save);
        return this;
    }

    public List<String> getDaily(String day) {
        if (day != null) {
            //todo 选择日期
        }
        //stream流式
        driver.findElements(taskList).stream().map(x -> x.getText()).collect(Collectors.toList());
        return Arrays.asList("1", "2");
    }

}
