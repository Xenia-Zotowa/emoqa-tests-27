package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private SelenideElement userNameInput = $("#userName"),
                            userEmailInput = $("#userEmail"),
                            currentAddressInput =  $("#currentAddress"),
                            permanentAddressInput =  $("#permanentAddress"),
                            submitInput = $(".text-right #submit"),
                            outputNameInput =  $("#output #name"),
                            outputEmailInput = $("#output #email"),
                            outputCurrentAddressInput = $("#output #currentAddress"),
                            outputPermanentAddressInput = $("#output #permanentAddress")
            ;

    public TextBoxPage openPage () {
        open("/text-box");
        return this;
    }
    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress (String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setSubmit(){
        submitInput.click();
        return this;
    }
    public TextBoxPage checkResultName(String value){
        outputNameInput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkResultEmail(String value){
        outputEmailInput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkResultCurrentAddress(String value){
        outputCurrentAddressInput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkResultPermanentAddress(String value){
        outputPermanentAddressInput.shouldHave(text(value));
        return this;
    }
}
