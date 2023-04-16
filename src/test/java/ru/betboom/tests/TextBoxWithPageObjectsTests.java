package ru.betboom.tests;

import org.junit.jupiter.api.Test;
import ru.betboom.pages.TextBoxPage;

public class TextBoxWithPageObjectsTests extends TestBase {
//    Components
    TextBoxPage textBoxPage = new TextBoxPage();
//    Input variables
    String
            fullName = "Ilya Tyunin",
            userEmail = "is_tyunin@gmail.com",
            currentAddress = "Bali",
            permanentAddress = "Moscow";

    @Test
    void fillFormTest() {
//        Fill registration form
        textBoxPage
                .openPage()
                .setFullName(fullName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitData();
//        Check registration form
        textBoxPage
                .verifyData("Name", fullName)
                .verifyData("Email", userEmail)
                .verifyData("Current Address", currentAddress)
                .verifyData("Permananet Address", permanentAddress);
  }
}
