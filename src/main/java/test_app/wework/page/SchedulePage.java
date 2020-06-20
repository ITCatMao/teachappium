package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/20 11:34 AM
 **/
public class SchedulePage extends BasePage{
    public SchedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    private final By taskName = By.id("b2k");
    private final By save = byText("保存");
    private final By taskList = By.id("gg_");

    private final By del = By.id("bfi");
    private final By confirm = By.id("b_o");

    public SchedulePage addSchedule(String name, String time){
        click(add);
        sendKeys(taskName, name);
        click(save);
        return this;
    }

    public List<String> getSchedule(String day){
        if(day!=null){
            click(byText(day));
        }
        return driver.findElements(taskList).stream().map(RemoteWebElement::getText).collect(Collectors.toList());
    }

    public SchedulePage delSchedule(){
        click(taskList);
        click(del);
        click(confirm);
        return this;
    }
}
