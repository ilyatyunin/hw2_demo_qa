package ru.betboom.tests.old;

import org.junit.jupiter.api.Test;
import ru.betboom.pages.RegistrationPage;

import static ru.betboom.tests.TestData.*;

public class RegistrationWithFakerAndPOTests extends TestBase {
//    Components
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
//        Fill registration form
        registrationPage
                .openPage()
                .removeAds()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .chooseGender(gender)
                .setNumber(userNumber)
                .setBirthDate(dayOfMonth, month, year)
                .setSubjects(subjects)
                .chooseHobbies(hobbies)
                .setPicture(file)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitData();

//        Check registration form
        registrationPage
                .verifyRegistrationModalAppears()

                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", dayOfMonth + " " + month + "," + year)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", file)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city)

                .closeRegistrationModal();
    }
}