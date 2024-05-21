package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class AutomationPracticeFormPageObjectsFakerTests {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress();
    String userPhone = faker.phoneNumber().subscriberNumber(10);
    String gender = faker.options().option("Male", "Female", "Other");
    String sabjects = faker.options().option("Maths","Chemistry","English", "Computer Science");
    String hobbies = faker.options().option("Sports", "Reading", "Music");
  public   String state = faker.options().option("NCR","Uttar Pradesh","Haryana", "Rajasthan");
  public String city = registrationPage.setCity().toString();
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
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userPhone)
                .setSabjects(sabjects)
                .hobbiesWrapper(hobbies)
                .loadingImage("S.jpg")
                .currentAddress(streetAddress)
                .setStateCity(state)
                .setDataOfBirt(registrationPage.day , registrationPage.month , registrationPage.year)
                .setCity()
                .clickSubmit()
        ;

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userPhone)
                .checkResult("Date of Birth", String.format(registrationPage.day + " " + registrationPage.month + "," + registrationPage.year))
                .checkResult("Subjects", sabjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "S.jpg")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void miniFormTest(){

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userPhone)
                .clickSubmit();
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userPhone);
    }

    @Test
    void negativeFormTest(){
        registrationPage.openPage()
                .clickSubmit();

        registrationPage.checkColorRed();
    }
}

