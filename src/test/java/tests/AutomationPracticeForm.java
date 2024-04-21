package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AutomationPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Tests");
        $("#userEmail").setValue("Test@test.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").click();
        $(".react-datepicker__month-select>[value='0']").click();
        $(".react-datepicker__year-dropdown-container").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--016").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-2+label").click();
        $("#uploadPicture").scrollIntoView(true);
        SelenideElement fileInput = $(byCssSelector("#uploadPicture"));
        fileInput.uploadFromClasspath("images/S.jpg");
        $("#currentAddress").setValue("Test");
        $("#stateCity-wrapper").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();




    }


}

