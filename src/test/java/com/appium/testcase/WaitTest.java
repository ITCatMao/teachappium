package com.appium.testcase;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/3 7:44 PM
 **/
public class WaitTest extends BaseTest {
    @Test
    public void fun() {
        wait = new WebDriverWait(driver, 10, 1000);
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
        WebElement ali = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='BABA']")));
        System.out.println(ali.getAttribute("enabled"));
        ali.click();
    }
}
