package test_app.xueqiu.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Description 行情tab页
 * @Author catty
 * @Date 2020/6/5 5:05 PM
 **/
public class MarketPage extends BasePage {

    static AndroidDriver driver;

    public MarketPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    /**
     * @Description:点击行情tab页右上角三横进入股票管理页面
     * @Author: PYPUA
     * @return: test_app.xueqiu.page.MarketPage
     **/
    public MarketPage toManage() {
        click(By.id("com.xueqiu.android:id/edit_group"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * @Description:股票管理->选中全部删除
     * @Author: PYPUA
     * @return: test_app.xueqiu.page.MarketPage
     **/
    public MarketPage selectAllAndDelete() {
//        WebElement empty_selected = findElement(By.id("com.xueqiu.android:id/empty_data_desc"));
//        if (empty_selected.getAttribute("enabled").equals("true")) {
        //判断是否存在需要清理的股票
        if (!isElementExist(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout"), 5, "元素")) {
            //该页面无股票的情况
            click(By.id("com.xueqiu.android:id/action_close"));
            System.out.println("该分组暂无股票,不能操作全部删除");
        } else {
            //该页面有股票的情况->勾选全部->删除
            click(By.id("com.xueqiu.android:id/check_all"));
            click(By.id("com.xueqiu.android:id/cancel_follow"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            click(By.id("com.xueqiu.android:id/tv_right"));
            click(By.id("com.xueqiu.android:id/action_close"));//点击完成直接退出
        }
        return this;
    }

    /**
     * @Description:获取所有的自选股
     * @Author: PYPUA
     * @return: List<String>
     **/
    public List<String> getAllStock() {
        toManage();//自选股票管理列表页面
        List<MobileElement> stockList = findElements(By.id("com.xueqiu.android:id/stockName"));
        List<String> nameList;
        if (stockList.size() > 0) {
            nameList = stockList.stream().map(item -> item.getText()).collect(Collectors.toList());
        } else {
            nameList = Arrays.asList("no element");
        }
        click(By.id("com.xueqiu.android:id/action_close"));
        return nameList;
    }


    /**
     * @Description:行情页面搜索按钮，搜索股票
     * @Author: PYPUA
     * @return: test_app.xueqiu.page.MarketPage
     **/
    public MarketPage add(String key) {
        //搜索添加
        click(By.id("com.xueqiu.android:id/action_search"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输入搜索关键字
        sendkey(By.id("com.xueqiu.android:id/search_input_text"), key);
        //添加自选
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[3]/android.widget.TextView"));
        //关闭搜索框返回详情页
        click(By.id("com.xueqiu.android:id/action_close"));
        return this;
    }


}
