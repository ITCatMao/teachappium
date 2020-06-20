package test_app.wework.page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/20 9:22 PM
 **/
public class ReportPageTest extends BaseTest{
    private ReportPage reportPage;

    @BeforeEach
    void setUp() {
        reportPage=wework.toWorkplacePage().toReportPage();
    }

    @AfterEach
    void tearDown(){
        reportPage.androidBack().androidBack();
    }

    @Test
    void addReport(){
        assertEquals(reportPage.addReport("new test").getReport(),"new test");
    }

}
