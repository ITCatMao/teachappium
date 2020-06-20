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
 * @Date 2020/6/20 11:36 AM
 **/
public class TodoPage extends BasePage{
    private final By todoName = By.id("b2k");
    private final By save = byText("保存");
    private final By todoList = By.id("gw9");
    private final By done = By.id("gwt");

    public TodoPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public TodoPage addTodo(String title){
        click(add);
        sendKeys(todoName,title);
        click(save);
        return this;
    }

    public List<String> getTodo(){
        return driver.findElements(todoList).stream().map(RemoteWebElement::getText).collect(Collectors.toList());
    }

    public TodoPage doneTodo(){
        click(done);
        return this;
    }

}
