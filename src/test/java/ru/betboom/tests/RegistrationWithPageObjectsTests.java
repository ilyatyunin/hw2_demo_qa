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
    String firstName = "Ilya";
    String lastName = "Tyunin";
    String userEmail = "is_tyunin@gmail.com";
    String gender = "Male";
    String userNumber = "9876543210";
    String year = "1996";
    String month = "November";
    String dayOfMonth = "26";
    String subjects = "Maths";
    String hobbies = "Sports";
    String dir = "src/test/resources/";
    String file = "PalmTrees.jpg";
    String currentAddress = "Moscow";
    String state = "Haryana";
    String city = "Karnal";


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