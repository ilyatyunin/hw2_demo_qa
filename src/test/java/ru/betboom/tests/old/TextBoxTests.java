package ru.betboom.tests.old;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {
//    Input variables
    String
            fullName = "Ilya Tyunin",
            userEmail = "is_tyunin@gmail.com",
            currentAddress = "Bali",
            permanentAddress = "Moscow";

    @Test
    void fillFormTest() {
//        Open website
        open("/text-box");
//        Fill registration form
        $("#userName").setValue(fullName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();

//        Check registration form
        $("#output").shouldHave(visible);
        $("#output #name").shouldHave(text(fullName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }

}
