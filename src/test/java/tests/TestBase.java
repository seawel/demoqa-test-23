package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {

        com.codeborne.selenide.Configuration.baseUrl = "https://demoqa.com";
        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        //Configuration.pageLoadStrategy = "eager";


    }
}
ипсик