package com.appium.testcase;

import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/3 10:11 AM
 **/
public class HelloWorldTest extends BaseTest {


    @Test
    public void helloSnowBallTest() {
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.xueqiu.android:id/home_search").click();

        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");

        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        System.out.println("price：" + driver.findElement(By.id("current_price")).getText());

    }

}
