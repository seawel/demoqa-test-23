import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;
    
    @BeforeEach
    void beforEach()    {
        System.out.println("###           beforEach()");
       result = getResult();
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