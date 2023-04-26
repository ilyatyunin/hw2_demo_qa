package ru.betboom.tests;

import static ru.betboom.utils.RandomUtils.*;

public class TestData {

    public static String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            gender = getRandomGender(),
            userNumber = getRandomNumber(),
            year = getRandomYear(),
            month = getRandomMonth(),
            dayOfMonth = getRandomDay(year, month),
            subjects = getRandomSubject(),
            hobbies = getRandomHobby(),
            dir = "src/test/resources/",
            file = "PalmTrees.jpg",
            currentAddress = getRandomCurrentAddress(),
            state = getRandomState(),
            city = getRandomCity(state);
}
