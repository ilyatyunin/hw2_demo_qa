package ru.betboom.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithTestDataTests extends TestBase {
    // Input variables
//    String
//            firstName = "Ilya",
//            lastName = "Tyunin",
//            userEmail = "is_tyunin@gmail.com",
//            gender = "Male",
//            userNumber = "9876543210",
//            year = "1996",
//            month = "November",
//            dayOfMonth = "26",
//            subjects = "Maths",
//            hobbies = "Sports",
//            dir = "src/test/resources/",
//            file = "PalmTrees.jpg",
//            currentAddress = "Bali",
//            state = "Haryana",
//            city = "Karnal";
    @Test
    void fillFormTest() {

        // Open website
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // Fill registration form
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + dayOfMonth).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File(dir + file));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

        // Check registration form
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
                text(dayOfMonth),
                text(month),
                text(year),
                text(subjects),
                text(hobbies),
                text(file),
                text(currentAddress),
                text(state),
                text(city)
        );

        $("#closeLargeModal").click();
    }


}