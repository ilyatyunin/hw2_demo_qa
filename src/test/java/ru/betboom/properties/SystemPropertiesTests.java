package ru.betboom.properties;

import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTests {
    @Test
    void systemProperties1Tests() {
        System.setProperty("browser", "chrome"); // установить ключ-значение, редкий кейс - обычно передается извне
        String browser = System.getProperty("browser"); // забрать значение
        System.out.println(browser);
    }

    @Test
    void systemProperties2Tests() {

        String browser = System.getProperty("browser", "firefox"); // забрать значение (если нет, то дефолтный) - рекомендуется к использованию

        System.out.println(browser);
    }

    @Test
//    @Tag("property")
    void systemProperties3Tests() {
        System.setProperty("browser", "chrome"); // установить ключ-значение, редкий кейс - обычно передается извне
        String browser = System.getProperty("browser", "firefox"); // забрать значение
        System.out.println(browser);
    }

    @Test
//    @Tag("property")
    void systemProperties4Tests() {

        String browser = System.getProperty("browser", "firefox"); // забрать значение (если нет, то дефолтный) - рекомендуется к использованию

        System.out.println(browser);
    }

    @Test
//    @Tag("hello")
    void systemProperties5Tests() {
        String name = System.getProperty("name", "default_student"); // забрать значение (если нет, то дефолтный) - рекомендуется к использованию
        String message = format("Hello, %s!", name);
        System.out.println(message);
    }
}
