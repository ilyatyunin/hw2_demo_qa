package ru.betboom.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.betboom.config.WebDriverConfig;
import ru.betboom.helpers.Attach;

import java.util.Map;

public class TestBaseRemote {
    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    @BeforeAll
    static void firstConfigure() {
        Configuration.browser = TestBase.webDriverConfig.getBrowser();
        Configuration.baseUrl = TestBase.webDriverConfig.getBaseUrl();
        Configuration.browserSize = TestBase.webDriverConfig.getBrowserSize();
        Configuration.browserVersion = TestBase.webDriverConfig.getBrowserVersion();
        Configuration.browserPosition = TestBase.webDriverConfig.getBrowserPosition();
        Configuration.pageLoadStrategy = TestBase.webDriverConfig.getPageLoadStrategy();

        if (webDriverConfig.getRemote()) {
            Configuration.remote = TestBase.webDriverConfig.getRemoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
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
