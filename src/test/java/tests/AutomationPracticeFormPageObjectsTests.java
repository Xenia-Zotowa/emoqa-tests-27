package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeFormPageObjectsTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";

    }
RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Tests")
                .setEmail("Test@test.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setDataOfBirt("16", "January", "2000")
                .setSabjects("Maths")
                .hobbiesWrapper("Sports")
                .loadingImage("S.jpg")
                .currentAddress("Test")
                .stateCity("NCR")
                .setCity("Delhi")
                .setSubmit()
        ;

        registrationPage.checkResult("Student Name", "Test Tests")
                .checkResult("Student Email", "Test@test.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "16 January,2000")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "S.jpg")
                .checkResult("Address", "Test")
                .checkResult("State and City", "NCR Delhi");




    }

    @Test
    void miniFormTest(){

        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Tests")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setSubmit();
        registrationPage.checkResult("Student Name", "Test Tests")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789");
    }

    @Test
    void negativeFormTest(){
        registrationPage.openPage()
                .setSubmit();

        registrationPage.checkColorRed();
    }
}

