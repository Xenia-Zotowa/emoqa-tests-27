package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TextBoxTests extends TestBase {

    @Test

    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу и закрываем баннер", () -> {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        });
        step("Наполняем форму ввода данных", () -> {
        $("#userName").setValue("Test");
        $("#userEmail").setValue("Test@test.com");
        $("#currentAddress").setValue("Test street 1");
        $("#permanentAddress").setValue("Test1 street 1");
        $("#submit").click();
        });
        step("Проверяем корректность заполнения данных", () -> {
        $("#output #name").shouldHave(text("Test"));
        $("#output #email").shouldHave(text("Test@test.com"));
        $("#output #currentAddress").shouldHave(text("Test street 1"));
        $("#output #permanentAddress").shouldHave(text("Test1 street 1"));
        });

    }


}
