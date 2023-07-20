package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void fillFormsAndSubmitTest(){
        String  userFirstName = "Ололош",
                userLastName = "Трололош",
                userEmail = "ololosh@trololosh.com",
                userGender = "Other",
                userPhoneNumber = "0123456789",
                userBirthYear = "1917",
                userBirthMonth = "October",
                userBirthDate = "25",
                userSubject = "History",
                userHobby = "Music",
                pathToPicture = "com.demoqa/FillFormsAndSubmitPicture.jpg",
                pictureFileName = pathToPicture.substring(pathToPicture.lastIndexOf("/") + 1),
                userAddress = "Moscow",
                userState = "Uttar Pradesh",
                userCity = "Merrut";

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(userGender)).click();
        $("#userNumber").setValue(userPhoneNumber);
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(userBirthYear);
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(userBirthMonth);
        $$("div .react-datepicker__day").findBy(text(userBirthDate)).click();
        $("#subjectsInput").setValue(userSubject).pressEnter();
        $("#hobbiesWrapper").$(byText(userHobby)).click();
        $("#uploadPicture").uploadFromClasspath(pathToPicture);
        $("#currentAddress").setValue(userAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(userState)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(userCity)).click();
        $("button#submit").scrollTo().click();

        $(".modal-content").
                shouldBe(visible);
        $(".modal-content .modal-header").
                shouldHave(text("Thanks for submitting the form"));
        $$("div.table-responsive table tbody tr").findBy(text("Student Name")).
                shouldHave(text(userFirstName + " " + userLastName));
        $$("div.table-responsive table tbody tr").findBy(text("Student Email")).
                shouldHave(text(userEmail));
        $$("div.table-responsive table tbody tr").findBy(text("Gender")).
                shouldHave(text(userGender));
        $$("div.table-responsive table tbody tr").findBy(text("Mobile")).
                shouldHave(text(userPhoneNumber));
        $$("div.table-responsive table tbody tr").findBy(text("Date of Birth")).
                shouldHave(text(userBirthDate + " " + userBirthMonth + "," + userBirthYear));
        $$("div.table-responsive table tbody tr").findBy(text("Subjects")).
                shouldHave(text(userSubject));
        $$("div.table-responsive table tbody tr").findBy(text("Hobbies")).
                shouldHave(text(userHobby));
        $$("div.table-responsive table tbody tr").findBy(text("Picture")).
                shouldHave(text(pictureFileName));
        $$("div.table-responsive table tbody tr").findBy(text("Address")).
                shouldHave(text(userAddress));
        $$("div.table-responsive table tbody tr").findBy(text("State and City")).
                shouldHave(text(userState + " " + userCity));
    }
}
