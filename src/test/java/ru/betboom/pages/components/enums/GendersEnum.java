package ru.betboom.pages.components.enums;

public enum GendersEnum {
    Male("Male"),
    Female("Female"),
    Other("Other");
    private String genders;

    GendersEnum(String genders) {
        this.genders = genders;
    }

    public String getGenders() {
        return genders;
    }
}