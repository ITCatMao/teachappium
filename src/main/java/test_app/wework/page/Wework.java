package test_app.wework.page;

import org.openqa.selenium.By;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/6 4:25 PM
 **/
public class Wework extends BasePage {
    public Wework() {
        super("com.tencent.wework", ".launch.LaunchSplashActivity");
    }

    public DailyPage daily() {
        click(By.xpath("//*[text='日程']"));
        return new DailyPage(driver);
    }
}
