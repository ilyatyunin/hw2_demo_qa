package ru.betboom.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.betboom.pages.RegistrationPage;
import ru.betboom.pages.TextBoxPage;

public class TestBase {
    @BeforeAll
    static void firstConfigure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
