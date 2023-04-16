package ru.betboom.tests;

import org.junit.jupiter.api.Test;
import ru.betboom.pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {
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
    void fillFormTest() {
//        Fill registration form
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDate(dayOfMonth, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
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