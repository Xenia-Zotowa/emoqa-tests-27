package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class AutomationPracticeFormPageObjectsFakerTests {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress();
    String userPhone = faker.phoneNumber().subscriberNumber(10);
    String gender = faker.options().option("Male", "Female", "Other");
    String sabjects = faker.options().option("Maths","Chemistry","English", "Computer Science");
    String hobbies = faker.options().option("Sports", "Reading", "Music");
    String day = String.valueOf(faker.number().numberBetween(1,28));
    String moth = faker.options().option("December","January","February",
                                          "March","April","May","June",
                                          "July", "August","September",
                                          "October","November");
    String year = String.valueOf(faker.number().numberBetween(1980,2020));





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

RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {


        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userPhone)
                .setDataOfBirt(day , moth , year)
                .setSabjects(sabjects)
                .hobbiesWrapper(hobbies)
                .loadingImage("S.jpg")
                .currentAddress(streetAddress)
                .stateCity(registrationPage.state)
                .setCity(registrationPage.city())
                .setSubmit()
        ;

        String city;
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userPhone)
                .checkResult("Date of Birth", String.format(day + " " + moth + "," + year))
                .checkResult("Subjects", sabjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "S.jpg")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", registrationPage.state + " " + registrationPage.city());
    }

    @Test
    void miniFormTest(){

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userPhone)
                .setSubmit();
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userPhone);
    }

    @Test
    void negativeFormTest(){
        registrationPage.openPage()
                .setSubmit();

        registrationPage.checkColorRed();
    }
}

