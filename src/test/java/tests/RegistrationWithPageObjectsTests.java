package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage();
        registrationPage.setFirstName("Alex");
        registrationPage.setLastName("Egorov");
        registrationPage.setEmail("alex@egorov.com");
        registrationPage.setGender("Other");
        registrationPage.setUserNumber("1234567890");
        registrationPage.setDateOfBirth("30", "July", "2008");
        registrationPage.setSubjectsInput("Math");
        registrationPage.setHobbiesWrapperInput("Sports");
        registrationPage.setUploadPictureInput("cat.jpeg");
        registrationPage.setAddressInput("Some address 1");
        registrationPage.setStateInput("NCR");

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex"), text("Egorov"),
                text("alex@egorov.com"), text("1234567890"));
        registrationPage.checkResult("Student Name", "Alex Egorov")
                .checkResult("Student Email", "alex@egorov.com");
    }
}