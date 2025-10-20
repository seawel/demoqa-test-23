package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    static void beforeAll() {
            System.out.println("\n###  beforeAll()\n");
            browserSize = "1920x1080";

    }

    @Test
    void fillFormTest() {

        open("https://demoqa.com/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAddress").setValue("Some street 1");
        ///$("permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}
