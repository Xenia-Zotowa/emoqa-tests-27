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

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

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

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Test");
        $("#userEmail").setValue("Test@test.com");
        $("#currentAddress").setValue("Test street 1");
        $("#permanentAddress").setValue("Test1 street 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Test"));
        $("#output #email").shouldHave(text("Test@test.com"));
        $("#output #currentAddress").shouldHave(text("Test street 1"));
        $("#output #permanentAddress").shouldHave(text("Test1 street 1"));


    }


}
