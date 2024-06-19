package tests;

import faker.FakerRandom;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class AutomationPracticeFormPageObjectsFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    FakerRandom fakerRandom = new FakerRandom();


    @Test
    @Tag("demoqa")
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(fakerRandom.firstName)
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
                .clickSubmit()
        ;


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

        registrationPage.checkOutColorRed();
    }
}

