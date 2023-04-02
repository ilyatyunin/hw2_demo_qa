package ru.betboom;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests extends TestBase {
    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Ilya");
        $("#lastName").setValue("Tyunin");
        $("#userEmail").setValue("my@bb.org");
        $("#gender-radio-1").click();
    }
}
