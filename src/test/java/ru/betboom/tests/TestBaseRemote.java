package ru.betboom.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.betboom.helpers.Attach;

import java.util.Map;

public class TestBaseRemote {
    @BeforeAll
    static void firstConfigure() {
        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        Configuration.baseUrl = baseUrl;
        String browser = System.getProperty("browser", "chrome");
        Configuration.browser = browser;
        String browserVersion = System.getProperty("browserVersion", "110.0");
        Configuration.browserVersion = browserVersion;
        String browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browserSize = browserSize;
        String remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.remote = remote;
// gradle property -DbaseUrl=https://demoqa.com -Dbrowser=chrome -DbrowserVersion=114.0 -DbrowserSize=1920x1080 -DremoteBrowserService=https://user1:1234@selenoid.autotests.cloud/wd/hub
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last Screeshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Attach.getVideoUrl();
    }
}
