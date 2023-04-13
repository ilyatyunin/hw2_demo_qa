package ru.betboom.tests;

import org.junit.jupiter.api.Test;
import ru.betboom.pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {
    // Input variables
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


        // Open website
//        open("/automation-practice-form");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('#fixedban').remove()");


        // Fill registration form
//        $("#firstName").setValue(firstName);
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDate(dayOfMonth, month, year);

//        $("#lastName").setValue(lastName);
//        $("#userEmail").setValue(userEmail);
//        $("#genterWrapper").$(byText(gender)).click();
//        $("#userNumber").setValue(userNumber);
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption(month);
//        $(".react-datepicker__year-select").selectOption(year);
//        $(".react-datepicker__day--0" + dayOfMonth).click();
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