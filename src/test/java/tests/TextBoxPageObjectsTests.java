package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPageObjectsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
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
