package ru.betboom.pages;

import com.codeborne.selenide.SelenideElement;
import ru.betboom.pages.components.CalendarComponent;
import ru.betboom.pages.components.ResultsModalComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
//    Components
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModalComponent resultsModalComponent = new ResultsModalComponent();

//    Locators
    SelenideElement
            formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAdress = $("#currentAddress"),
            stateInput = $("#state"),
            stateAndCityValue = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit");

//    Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formHeaderText.shouldHave(text("Student Registration Form"));
        return this;
    }
    public RegistrationPage removeAds() {
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
    public RegistrationPage chooseGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $(dateOfBirthInput).click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage chooseHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAdress.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateAndCityValue.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateAndCityValue.$(byText(value)).click();
        return this;
    }
    public RegistrationPage submitData() {
        submitButton.click();
        return this;
    }
    public RegistrationPage verifyRegistrationModalAppears() {
        resultsModalComponent.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        resultsModalComponent.verifyResult(key, value);
        return this;
    }
    public RegistrationPage closeRegistrationModal() {
        resultsModalComponent.closeModal();
        return this;
    }
}
