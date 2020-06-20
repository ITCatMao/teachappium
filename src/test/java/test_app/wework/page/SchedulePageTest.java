package test_app.wework.page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/20 9:24 PM
 **/
public class SchedulePageTest extends BaseTest{
    private SchedulePage schedulePage;

    @BeforeEach
    void setUp() {
        schedulePage=wework.toSchedule();
    }

    @AfterEach
    void tearDown(){
        schedulePage.androidBack();
    }

    @Test
    @Order(1)
    void addSchedule() {
        assertTrue(schedulePage.addSchedule("上班打卡", null).getSchedule(null).contains("上班打卡"));
    }

    @Test
    @Order(2)
    void getSchedule() {
        assert(schedulePage.getSchedule(null).size()==1);
    }

    @Test
    @Order(3)
    void delSchedule(){
        assert(schedulePage.delSchedule().getSchedule(null).size()==0);
    }
}
