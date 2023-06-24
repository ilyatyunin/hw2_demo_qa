package ru.betboom.utils;

import com.github.javafaker.Faker;
import ru.betboom.pages.components.enums.GendersEnum;
import ru.betboom.pages.components.enums.HobbiesEnum;
import ru.betboom.pages.components.enums.SubjectsEnum;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("ru"));
    static String[]
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
    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        int index = getRandomInt(0,enumClass.getEnumConstants().length - 1);
        return enumClass.getEnumConstants()[index];
    }
    public static String getRandomGender() {
        return getRandomEnum(GendersEnum.class).getGenders();
    }
    public static String getRandomNumber() {
        return "9" + getRandomInt(100000000, 999999999);
    }
    public static String getRandomYear() {
        return Integer.toString(getRandomInt(1900, 2010));
    }
    public static String getRandomMonth() {
        return faker.options().option(months);
    }
    public static String getRandomDay(String year, String month) {
        int intYear = Integer.parseInt(year);
        int intMonth = Arrays.asList(months).indexOf(month);
        YearMonth yearMonthObject = YearMonth.of(intYear, intMonth);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        int day = getRandomInt(1, daysInMonth);
        if (day < 10) {
            return "0" + day;
        } else {
            return Integer.toString(day);
        }
    }
    public static String getRandomSubject() {
        return getRandomEnum(SubjectsEnum.class).getSubjects();
    }
    public static String getRandomHobby() {
        return getRandomEnum(HobbiesEnum.class).getHobbies();
    }
    public static String getRandomState() {
        return faker.options().option(states);
    }
    public static String getRandomCity(String state) {
        Map<String, String[]> cityMap = new HashMap<>();
        cityMap.put("NCR", cityNCR);
        cityMap.put("Uttar Pradesh", cityUttarPradesh);
        cityMap.put("Haryana", cityHaryana);
        cityMap.put("Rajasthan", cityRajasthan);
        return faker.options().option(cityMap.get(state));
    }
}
