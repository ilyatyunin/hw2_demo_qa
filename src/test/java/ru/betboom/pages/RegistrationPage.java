package ru.betboom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.betboom.pages.components.CalendarComponent;
import ru.betboom.tests.RegistrationWithPageObjectsTests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationPage {
    // SelenideElements / locator /etc

    CalendarComponent calendarComponent = new CalendarComponent();

    SelenideElement // можно поставить public, но нам не нужны эти элементы в других классах
            formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput");
//    ElementsCollection genderInputs = $$(""); // список элементов (коллекция)


    // Actions

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
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
    public void setBirthDate(String day, String month, String year) {
        $(dateOfBirthInput).click();
        calendarComponent.setDate(day, month, year);
    }
}
