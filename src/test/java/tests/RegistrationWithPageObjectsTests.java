package tests.demoqa.registration;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.TestBase;

import java.util.Locale;

public class RegistrationWithPageObjectsTests extends TestBase {

    protected RegistrationPage registrationPage = new RegistrationPage();
  //  protected TestData testData = new TestData();

    @Test
    void successfulAllFieldsRegistrationTest() {

        registrationPage.openRegistrationPage()
        Faker faker = new Faker(new Locale("en-GB"));


        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();
        String phoneNumber = String.valueOf(faker.phoneNumber());
        String birthDay = faker.date().toString();


                .setFirstName(        String firstName = faker.name().firstName();
)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Male")
                .setPhoneNumber(phoneNumber)
                .setBirthDay(birthDay)
                .setSubject("biology")
                .setHobby("sports")
                .uploadPicture("img/","1.png")
                .setAddress(streetAddress)
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