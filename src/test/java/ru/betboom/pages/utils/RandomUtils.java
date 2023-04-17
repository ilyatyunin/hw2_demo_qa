package ru.betboom.pages.utils;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static String[] genders = {"Male", "Female", "Others"};
    public static void main(String[] args) {
        System.out.println(getRandomUuidString());
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail(4));
        System.out.println(getRandomInt(111111, 999999));


        System.out.println(getRandomItemFromArray(genders));
    }

    public static String getRandomUuidString() {
        String uuid = UUID.randomUUID().toString();
        return "uuid = " + uuid;
    }

    public static String getRandomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public static String getRandomEmail(int len) {
        return getRandomString(len) + "@qa.com";
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



}
