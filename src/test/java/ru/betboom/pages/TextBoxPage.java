package ru.betboom.pages;

import com.codeborne.selenide.SelenideElement;
import ru.betboom.pages.components.OutputDataComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
//    Components
    OutputDataComponent outputDataComponent = new OutputDataComponent();
//    Locators
    SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit");

//    Actions
    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }
    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }
    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }
    public TextBoxPage submitData() {
        submitButton.click();
        return this;
    }
    public TextBoxPage verifyData(String key, String value) {
        outputDataComponent.verifyOutputData(key, value);
        return this;
    }
}
