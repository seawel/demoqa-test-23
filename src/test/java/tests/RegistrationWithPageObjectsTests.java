package tests.demoqa.registration;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.TestBase;

public class RegistrationWithPageObjectsTests extends TestBase {

    protected RegistrationPage registrationPage = new RegistrationPage();
  //  protected TestData testData = new TestData();

    @Test
    void successfulAllFieldsRegistrationTest() {

        registrationPage.openRegistrationPage()
                .setFirstName("Alex")
                .setLastName("Pavlov")
                .setEmail("alexpavlov@gmail.com")
                .setGender("Male")
                .setPhoneNumber("7915600123")
                .setBirthDay("30", "July", "2008")
                .setSubject("biology")
                .setHobby("sports")
                .uploadPicture("img/","1.png")
                .setAddress("Some address 1")
                .setStateAndCity("NCR", "Delhi")
                .submitForm()
                .checkResult();

    }

    @Test
    void successfulRequiredFieldRegistrationTest() {

        registrationPage.openRegistrationPage()
                .setFirstName("Alex")
                .setLastName("Pavlov")
                .setGender("Male")
                .setPhoneNumber("7915600123")
                .submitForm()
                .checkResult();

    }

    @Test
    void checkErrorFirstNameTest() {

        registrationPage.openRegistrationPage()
                .checkBorderColor("first_name", "grey")
                .setLastName("")
                .setGender("Male")
                .setPhoneNumber("7915600123")
                .submitErrorForm()
                .checkBorderColor("first_name", "red");

    }

    @Test
    void checkErrorEmailTest() {

        registrationPage.openRegistrationPage()
                .checkBorderColor("email", "grey")
                .setFirstName("Alex")
                .setLastName("Pavlov")
                .setEmail(" ")
                .setGender("Male")
                .setPhoneNumber("7915600123")
                .submitErrorForm()
                .checkBorderColor("email", "red");

    }

    @Test
    void checkErrorPhoneNumberTest() {

        registrationPage.openRegistrationPage()
                .checkBorderColor("phone", "grey")
                .setFirstName("Alex")
                .setLastName("Pavlov")
                .setGender("Male")
                .setPhoneNumber("1")
                .submitErrorForm()
                .checkBorderColor("phone", "red");

    }

}