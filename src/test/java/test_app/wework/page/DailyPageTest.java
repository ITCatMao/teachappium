package test_app.wework.page;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyPageTest {

    private static Wework wework;

    @BeforeAll
    public static void setUp() {
        wework = new Wework();
    }

    @AfterAll
    public static void tearDown() {

    }

    @Test
    void add() {
        assertTrue(wework.daily().add("上班打卡", null).getDaily(null).contains("上班打卡"));
    }

    @Test
    void getDaily() {
    }
}