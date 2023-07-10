package ru.betboom.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.betboom.pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {
//    Components
    RegistrationPage registrationPage = new RegistrationPage();
//    Input variables
    String
        firstName = "Ilya",
        lastName = "Tyunin",
        userEmail = "is_tyunin@gmail.com",
        gender = "Male",
        userNumber = "9876543210",
        year = "1996",
        month = "November",
        dayOfMonth = "26",
        subjects = "Maths",
        hobbies = "Sports",
        dir = "src/test/resources/",
        file = "PalmTrees.jpg",
        currentAddress = "Bali",
        state = "Haryana",
        city = "Karnal";

    @Test
    @Disabled
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
                .setPicture(dir + file)
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