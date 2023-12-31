package com.demoqa.tests;

import com.demoqa.page.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import static com.demoqa.utils.RandomUtils.*;

public class PracticeFormTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Test
    public void fillFormsAndSubmitWithPageObjectsTest() throws NoSuchFieldException, IllegalAccessException {

        String  userFirstName = faker.name().firstName(),
                userLastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomGender(),
                userPhoneNumber = getRandomPhoneNumber(),
                userBirthDate = faker.date().birthday().toString(),
                userSubject = getRandomSubject(),
                userHobby = getRandomHobbie(),
                pathToPicture = "com.demoqa/FillFormsAndSubmitPicture.jpg",
                pictureFileName = pathToPicture.substring(pathToPicture.lastIndexOf("/") + 1),
                userAddress = faker.address().fullAddress(),
                userState = getRandomState(),
                userCity = getRandomCityForChosenState(userState);

        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName(userFirstName)
                        .setLastName(userLastName)
                        .setUserEmail(userEmail)
                        .setGender(userGender)
                        .setPhoneNumber(userPhoneNumber)
                        .setBirthDate(getDayFromBirthDate(userBirthDate),
                                        getMonthFromBirthDate(userBirthDate),
                                        getYearFromBirthDate(userBirthDate))
                        .setSubject(userSubject)
                        .setHobbie(userHobby)
                        .uploadPicture(pathToPicture)
                        .setCurrentAddress(userAddress)
                        .setStateAndCity(userState,userCity)
                        .submitButtonClick()

                        .checkModalContentVisible()
                        .checkModalContentHasHeader("Thanks for submitting the form")
                        .checkStudentNameValueVisible(userFirstName, userLastName)
                        .checkStudentEmailValueVisible(userEmail)
                        .checkGenderValueVisible(userGender)
                        .checkMobileValueVisible(userPhoneNumber)
                        .checkBirthDateValueVisible(getDayFromBirthDate(userBirthDate),
                                                    getMonthFromBirthDate(userBirthDate),
                                                    getYearFromBirthDate(userBirthDate))
                        .checkSubjectsValueVisible(userSubject)
                        .checkHobbiesValueVisible(userHobby)
                        .checkPictureValueVisible(pictureFileName)
                        .checkAddressValueVisible(userAddress)
                        .checkStateAndCityValueVisible(userState, userCity);
    }
}
