package test_app.wework.page;

import org.openqa.selenium.By;

/**
 * @Description 日历的测试完善+代办+汇报日报/周报
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

    public SchedulePage toSchedule() {
        click("日程");
        return new SchedulePage(driver);
    }

    public TodoPage toTodoPage() {
        click("待办");
        return new TodoPage(driver);
    }

    public WorkplacePage toWorkplacePage() {
        click("工作台");
        return new WorkplacePage(driver);
    }
}
