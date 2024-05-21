package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import com.github.javafaker.Faker;
import pages.components.CalendarComponent;
import pages.faker.FakerRandom;
import tests.AutomationPracticeFormPageObjectsFakerTests;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {


    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInpyt =  $("#dateOfBirthInput"),
            modalWindowResalt = $(".table-responsive"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            loadingImageInput = $("#uploadPicture"),
            currentAddressInput =  $("#currentAddress"),
            stateCityInput = $("#stateCity-wrapper"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit")
            ;


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

   public RegistrationPage setDataOfBirt(String day, String mont, String year) {

     calendarInpyt.click();
      calendarComponent.setDate(day, mont, year);
      return this;
   }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage hobbiesWrapper(String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage loadingImage(String image) {
        loadingImageInput.uploadFromClasspath(image);
        return  this;
    }

    public RegistrationPage currentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateCity(String value) {

        stateCityInput.click();
        stateInput.$(byText(value)).click();
        return  this;
    }



        public RegistrationPage setCity(String value) {

        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        modalWindowResalt.$(new ByText(key)).parent()
                .shouldHave(text(value));
        return this;

    }

    public RegistrationPage checkOutColorRed () {
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;

    }






}