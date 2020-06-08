package test_app.xueqiu.page;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MarketPageTest {

    static MainPage mainPage;
    static MarketPage marketPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = new MainPage();
        marketPage = new MainPage().toMarketTab();
    }

    @Test
    void toDeleteAll() {
        //System.out.println("自选股列表：" + marketPage.getAllStock());
        marketPage.toManage().selectAllAndDelete();
    }

    @ParameterizedTest
    @ValueSource(strings = {"阿里巴巴", "京东", "pinduoduo"})
    void add1(String keys) {
        marketPage.add(keys);
        assertEquals(keys, marketPage.getAllStock());
    }


}