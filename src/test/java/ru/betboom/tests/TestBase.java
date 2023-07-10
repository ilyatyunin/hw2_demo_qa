package ru.betboom.tests;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.betboom.config.WebDriverConfig;

import java.util.Map;

public class TestBase {
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
}
