package ru.betboom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.betboom.tests.RegistrationWithPageObjectsTests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    // SelenideElements / locator /etc
    SelenideElement formHeaderText = $(".practice-form-wrapper");
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement gender = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");


    // Actions

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

}
