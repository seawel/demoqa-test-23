package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithPageObjectsTestsHW {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Pavlov");
        $("#userEmail").setValue("alexpavlov@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7915600123");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1979");
        $(".react-datepicker__day--022:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("cat.jpeg");
        $("#currentAddress").setValue("Russia,630777,Moscow,ul.Pobedy,d.19,kv.6");
        $("#state").click();
        $("#state").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").$(byText("Jaipur")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex"), text("Pavlov"),
                text("alexpavlov@gmail.com"), text("7915600123"));


    }
}