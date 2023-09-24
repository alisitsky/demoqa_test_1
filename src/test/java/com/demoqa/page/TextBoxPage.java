package com.demoqa.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    SelenideElement mainHeader = $(".main-header"),
                    userNameInput = $("#userName"),
                    userEmailInput =  $("#userEmail"),
                    currentAddressInput = $("#currentAddress"),
                    permanentAddressInput = $("#permanentAddress"),
                    submitButton = $("#submit"),
                    commonOutput = $("#output"),
                    nameOutput = $("#output #name"),
                    emailOutput = $("#output #email"),
                    currentAddressOutput = $("#output #currentAddress"),
                    permanentAddressOutput =$ ("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage checkMainHeaderHasText(String value) {
        mainHeader.shouldHave(text(value));
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

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkOutputVisibility() {
        commonOutput.shouldBe(visible);
        return this;
    }

    public TextBoxPage checkOutputHasName(String value) {
        nameOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkOutputHasEmail(String value) {
        emailOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkOutputHasCurrentAddress(String value) {
        currentAddressOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkOutputHasPermanentAddress(String value) {
        permanentAddressOutput.shouldHave(text(value));
        return this;
    }
}
