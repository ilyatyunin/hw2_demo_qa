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
//        Configuration.baseUrl = ;
//        Configuration.browserSize = "1920x1080";
////        Configuration.holdBrowserOpen = true;
        Configuration.browser = webDriverConfig.getBrowser();
        Configuration.baseUrl = webDriverConfig.getBaseUrl();
        Configuration.browserSize = webDriverConfig.getBrowserSize();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();
        Configuration.browserPosition = webDriverConfig.getBrowserPosition();
        Configuration.pageLoadStrategy = webDriverConfig.getPageLoadStrategy();

        if (webDriverConfig.getRemote()) {
            Configuration.remote = webDriverConfig.getRemoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }
}
