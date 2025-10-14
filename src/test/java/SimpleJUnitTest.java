import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\n###  beforeAll()\n");
    }

    @BeforeEach
    void beforEach() {
        System.out.println("###            beforEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###             afterEach()\n");
        result = 0;
    }
    @AfterAll
    static void afterAll() {
     System.out.println("\n###  afterAll()\n");
    }
    @Test
    void firstTest() {
        int result = getResult();
        System.out.println("###     firstTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###     secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("###     thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }
}