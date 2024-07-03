package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import faker.FakerRandom;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class AutomationPracticeFormPageObjectsFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    FakerRandom fakerRandom = new FakerRandom();


    @Test

    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу и закрываем баннер", () -> {
        registrationPage.openPage()
                    .removeBanner();
        });
        step("Наполняем форму ввода данных с помощью Faker", () -> {
        registrationPage.setFirstName(fakerRandom.firstName)
                .setLastName(fakerRandom.lastName)
                .setEmail(fakerRandom.userEmail)
                .setGender(fakerRandom.gender)
                .setUserNumber(fakerRandom.userPhone)
                .setSubjects(fakerRandom.sabjects)
                .setHobbiesWrapper(fakerRandom.hobbies)
                .loadingImage(fakerRandom.photo)
                .setCurrentAddress(fakerRandom.streetAddress)
                .setStateCity(fakerRandom.state)
                .setDataOfBirt(fakerRandom.day , fakerRandom.month , fakerRandom.year)
                .setCity(fakerRandom.city)
                .removeBanner()
                .clickSubmit()
        ;
        });

        step("Проверяем корректность заполнения данных", () -> {
        registrationPage.checkResult("Student Name", fakerRandom.firstName + " " + fakerRandom.lastName)
                .checkResult("Student Email", fakerRandom.userEmail)
                .checkResult("Gender", fakerRandom.gender)
                .checkResult("Mobile", fakerRandom.userPhone)
                .checkResult("Date of Birth", String.format(fakerRandom.day + " " + fakerRandom.month + "," + fakerRandom.year))
                .checkResult("Subjects", fakerRandom.sabjects)
                .checkResult("Hobbies", fakerRandom.hobbies)
                .checkResult("Picture", fakerRandom.photo)
                .checkResult("Address", fakerRandom.streetAddress)
                .checkResult("State and City", fakerRandom.state + " " + fakerRandom.city);
        });
    }

    @Test

    void miniFormTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу и закрываем баннер", () -> {
            registrationPage.openPage();
        });
        step("Наполняем форму ввода данных", () -> {
        registrationPage.setFirstName(fakerRandom.firstName)
                .setLastName(fakerRandom.lastName)
                .setGender(fakerRandom.gender)
                .setUserNumber(fakerRandom.userPhone)
                .removeBanner()
                .clickSubmit();
        });
        step("Проверяем корректность заполнения данных", () -> {
        registrationPage.checkResult("Student Name", fakerRandom.firstName + " " + fakerRandom.lastName)
                .checkResult("Gender", fakerRandom.gender)
                .checkResult("Mobile", fakerRandom.userPhone);
        });
    }

    @Test
    void negativeFormTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу, закрываем баннер и нажимаем на кнопку отправить", () -> {
            registrationPage.openPage()
                    .removeBanner()
                    .clickSubmit();
        });

        step("Проверяем, что не заполненные поля выделились красным", () -> {
       registrationPage.checkOutColorRed();
        });
   }
}

