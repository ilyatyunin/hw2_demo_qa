package ru.betboom.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class OutputData {
    public void verifyOutputData(String key, String value) {
        $("#output").$(withText(key)).shouldHave(text(value));
    }
}
