package com.demoqa.tests;

import com.demoqa.page.RegistrationPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void fillFormsAndSubmitWithPageObjectsTest(){
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

        registrationPage.openPage()
                        .setFirstName(userFirstName)
                        .setLastName(userLastName)
                        .setUserEmail(userEmail)
                        .setGender(userGender)
                        .setPhoneNumber(userPhoneNumber)
                        .setBirthDate(userBirthDate, userBirthMonth, userBirthYear)
                        .setSubject(userSubject)
                        .setHobbie(userHobby)
                        .uploadPicture(pathToPicture)
                        .setCurrentAddress(userAddress)
                        .setStateAndCity(userState,userCity)
                        .SubmitButtonClick()

                        .checkModalContentVisible()
                        .checkModalContentHasHeader("Thanks for submitting the form")
                        .checkStudentNameValueVisible(userFirstName, userLastName)
                        .checkStudentEmailValueVisible(userEmail)
                        .checkGenderValueVisible(userGender)
                        .checkMobileValueVisible(userPhoneNumber)
                        .checkBirthDateValueVisible(userBirthDate, userBirthMonth, userBirthYear)
                        .checkSubjectsValueVisible(userSubject)
                        .checkHobbiesValueVisible(userHobby)
                        .checkPictureValueVisible(pictureFileName)
                        .checkAddressValueVisible(userAddress)
                        .checkStateAndCityValueVisible(userState, userCity);
    }
}
