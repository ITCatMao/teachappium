package com.appium.testcase;

import com.sun.tools.corba.se.idl.constExpr.GreaterThan;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/5 9:41 AM
 **/
public class AssertTest extends BaseTest{

    @Test
    @Ignore
    public void assertTest() {
        Integer a = new Integer(3);
        Integer b = new Integer(5);
        assertEquals(a, b);
        assertNotNull(a);
        assertTrue(false);
        assertFalse(true);
        assertNull(b);
        assertSame(a, b);
        assertNotSame(a, b);
        assertArrayEquals(new int[]{7, 8, 9}, new int[]{2, 4, 6});
    }

    @Test
    public void priceTest(){
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        driver.findElement(By.xpath("//*[@text='股票']")).click();
        String realPrice = driver.findElement(By.xpath("//*[text='09999']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();
        assertThat("股票价格对比",Double.parseDouble(realPrice), greaterThanOrEqualTo(200d));

    }
}
