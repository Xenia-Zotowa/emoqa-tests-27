package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static io.qameta.allure.Allure.step;


public class TextBoxPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу и закрываем баннер", () -> {
        textBoxPage.openPage()
                .removeBanner();
        });
        step("Наполняем форму ввода данных", () -> {
        textBoxPage.setUserName("Test")
                .setUserEmail("Test@test.com")
                .setCurrentAddress("Test street 1")
                .setPermanentAddress("Test1 street 1")
                .setSubmit()
        ;
        });
        step("Проверяем корректность заполнения данных", () -> {
        textBoxPage.checkResultName("Test")
                .checkResultEmail("Test@test.com")
                .checkResultCurrentAddress("Test street 1")
                .checkResultPermanentAddress("Test1 street 1");
        });
    }


}
