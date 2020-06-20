package test_app.wework.page;

import org.junit.jupiter.api.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @Description TODO
 * @Author catty
 * @Date 2020/6/20 9:28 PM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodoPageTest extends BaseTest{

    private TodoPage todoPage;

    @BeforeEach
    void setUp() {
        todoPage=wework.toTodoPage();
    }

    @AfterEach
    void tearDown(){
        todoPage.androidBack();
    }

    @Test
    @Order(1)
    void addTodo() {
        assertTrue(todoPage.addTodo("title").getTodo().contains("title"));
    }

    @Test
    @Order(2)
    void getTodo() {
        assert(todoPage.getTodo().size()==1);
    }

    @Test
    @Order(3)
    void doneTodo() {
        assertEquals(todoPage.doneTodo().getTodo().size(),0);
    }
}