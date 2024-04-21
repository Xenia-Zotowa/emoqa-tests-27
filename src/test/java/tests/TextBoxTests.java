package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
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
