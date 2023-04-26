package ru.betboom.pages.components.enums;

public enum HobbiesEnum {
    Sports("Sports"),
    Reading("Reading"),
    Music("Music");
    private String hobbies;

    HobbiesEnum(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getHobbies() {
        return hobbies;
    }
}
