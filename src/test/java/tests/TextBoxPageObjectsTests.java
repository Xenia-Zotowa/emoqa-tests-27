package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;



public class TextBoxPageObjectsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
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
