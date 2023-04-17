package ru.betboom.pages.utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("ru"));
    static String[]
            genders = {"Male", "Female", "Others"},
            subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"},
            hobbies = {"Sports", "Reading", "Music"},
            states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            cityNCR = {"Delhi", "Gurgaon", "Noida"},
            cityUttarPradesh = {"Agra", "Lucknow", "Merrut"},
            cityHaryana = {"Karnal", "Panipat"},
            cityRajasthan = {"Jaipur", "Jaiselmer"},
            months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }
    public static String getRandomLastName() {
        return faker.name().lastName();
    }
    public static String getRandomEmail() {

        return new Faker(new Locale("en")).internet().emailAddress();
    }
    public static String getRandomCurrentAddress() {
        return faker.address().fullAddress();
    }
    public static int getRandomInt(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max);
    }
    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }

    public static String getRandomGender() {
        return getRandomItemFromArray(genders);
    }
    public static String getRandomNumber() {
        return "9" + getRandomInt(100000000, 999999999);
    }
    public static String getRandomYear() {
        return Integer.toString(getRandomInt(1900, 2010));
    }
    public static String getRandomDay() {
        int day = getRandomInt(1, 28);
        if (day < 10) {
            return "0" + day;
        } else {
            return Integer.toString(day);
        }
    }
    public static String getRandomMonth() {
        return getRandomItemFromArray(months);
    }
    public static String getRandomSubject() {
        return getRandomItemFromArray(subjects);
    }
    public static String getRandomHobby() {
        return getRandomItemFromArray(hobbies);
    }
    public static String getRandomState() {
        return getRandomItemFromArray(states);
    }
    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR": {
                return getRandomItemFromArray(cityNCR);
            }
            case "Uttar Pradesh": {
                return getRandomItemFromArray(cityUttarPradesh);
            }
            case "Haryana": {
                return getRandomItemFromArray(cityHaryana);
            }
            case "Rajasthan": {
                return getRandomItemFromArray(cityRajasthan);
            }
        }
        return null;
    }



}
