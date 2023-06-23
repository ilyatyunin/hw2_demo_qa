// Final version with add TestData, TestBase, Page Object, Components, Faker, Remote (Jenkins + Selenoid), Attachments and Properties
package ru.betboom.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.betboom.pages.RegistrationPage;

import static io.qameta.allure.Allure.step;
import static ru.betboom.tests.TestData.*;

public class RegistrationRemoteWithFakerAndPOTests extends TestBaseRemote {
//    Components
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @Tag("property")
    @DisplayName("Successful registration")
    void fillFormTest() {
//        Fill registration form
        step("Open Form", () -> {
            registrationPage
                    .openPage()
                    .removeAds();
        });
        step("Fill Form", () -> {
            registrationPage
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
        });
//        Check registration form
        step("Verify Results", () -> {
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
        });
    }
}
