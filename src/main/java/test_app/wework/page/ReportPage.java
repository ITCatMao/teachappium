package test_app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/20 11:35 AM
 **/
public class ReportPage extends BasePage{
    private final By todayReport = By.xpath("//android.widget.EditText[1]");
    private final By submit = byText("提交");
    private final By confirm = By.id("b_o");

    public ReportPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    public ReportPage addReport(String report){
        System.out.println(driver.getContextHandles());
        driver.context("WEBVIEW_com.tencent.mm:appbrand0");
        sendKeys(todayReport,report);
        swipeDown();
        click(submit);
        driver.context("NATIVE_APP");
        click(confirm);
        return this;
    }
    public String getReport(){
        return driver.findElement(By.xpath("//*[contains(@text,'今日工作')]/following-sibling::*[1]")).getText();
    }

}
