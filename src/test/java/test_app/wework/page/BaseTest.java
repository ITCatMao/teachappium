package test_app.wework.page;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/20 9:20 PM
 **/
public class BaseTest {
    static Wework wework;

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {
        wework.quit();
    }
}
