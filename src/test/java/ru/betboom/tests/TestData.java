package ru.betboom.tests;

import static ru.betboom.pages.utils.RandomUtils.*;

public class TestData {
    String
            firstName = getRandomString(10),
            lastName = getRandomString(10),
            userEmail = getRandomEmail(7),
            gender = getRandomGender(),
            userNumber = "9" + getRandomInt(111111111, 999999999),
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
}
