package pages;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public void setFirstName() {
        $(setFirstNameLocator().sens(""))
    }

}
