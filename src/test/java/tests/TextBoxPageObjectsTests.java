package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.TextBoxPage;

import java.util.Map;


public class TextBoxPageObjectsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSlenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {

        Selenide.closeWebDriver();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Tag("demoqa")
    void fillFormTest() {

        textBoxPage.openPage()
                .setUserName("Test")
                .setUserEmail("Test@test.com")
                .setCurrentAddress("Test street 1")
                .setPermanentAddress("Test1 street 1")
                .setSubmit()
        ;
        textBoxPage.checkResultName("Test")
                .checkResultEmail("Test@test.com")
                .checkResultCurrentAddress("Test street 1")
                .checkResultPermanentAddress("Test1 street 1");
    }


}
