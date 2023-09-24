package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.page.RegistrationPage;
import com.demoqa.page.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    public void fillFormTest(){
        String  userName = "Vasya Vasyok",
                userEmail = "vasya@vasiliy.ru",
                currentAddress = "Moscow",
                permanentAddress = "Tula";

        textBoxPage.openPage()
                .checkMainHeaderHasText("Text Box")
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmitButton()

                .checkOutputVisibility()
                .checkOutputHasName(userName)
                .checkOutputHasEmail(userEmail)
                .checkOutputHasCurrentAddress(currentAddress)
                .checkOutputHasPermanentAddress(permanentAddress);
    }
}
