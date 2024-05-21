package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.faker.FakerRandom;


public class AutomationPracticeFormPageObjectsFakerTests {
    RegistrationPage registrationPage = new RegistrationPage();
    FakerRandom fakerRandom = new FakerRandom();

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



    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(fakerRandom.firstName)
                .setLastName(fakerRandom.lastName)
                .setEmail(fakerRandom.userEmail)
                .setGender(fakerRandom.gender)
                .setUserNumber(fakerRandom.userPhone)
                .setSabjects(fakerRandom.sabjects)
                .hobbiesWrapper(fakerRandom.hobbies)
                .loadingImage("S.jpg")
                .currentAddress(fakerRandom.streetAddress)
                .setStateCity(fakerRandom.state)
               .setDataOfBirt(fakerRandom.day , fakerRandom.month , fakerRandom.year)
                .setCity(fakerRandom.city)
                .clickSubmit()
        ;

        registrationPage.checkResult("Student Name", fakerRandom.firstName + " " + fakerRandom.lastName)
                .checkResult("Student Email", fakerRandom.userEmail)
                .checkResult("Gender", fakerRandom.gender)
                .checkResult("Mobile", fakerRandom.userPhone)
                .checkResult("Date of Birth", String.format(fakerRandom.day + " " + fakerRandom.month + "," + fakerRandom.year))
                .checkResult("Subjects", fakerRandom.sabjects)
                .checkResult("Hobbies", fakerRandom.hobbies)
                .checkResult("Picture", "S.jpg")
                .checkResult("Address", fakerRandom.streetAddress)
                .checkResult("State and City", fakerRandom.state + " " + fakerRandom.city);
    }

    @Test
    void miniFormTest(){

        registrationPage.openPage()
                .setFirstName(fakerRandom.firstName)
                .setLastName(fakerRandom.lastName)
                .setGender(fakerRandom.gender)
                .setUserNumber(fakerRandom.userPhone)
                .clickSubmit();
        registrationPage.checkResult("Student Name", fakerRandom.firstName + " " + fakerRandom.lastName)
                .checkResult("Gender", fakerRandom.gender)
                .checkResult("Mobile", fakerRandom.userPhone);
    }

    @Test
    void negativeFormTest(){
        registrationPage.openPage()
                .clickSubmit();

        registrationPage.checkColorRed();
    }
}

