package ru.betboom.pages.components.enums;

public enum SubjectsEnum {
    Manths("Maths"),
    Accounting("Accounting"),
    Arts("Arts"),
    Chemistry("Chemistry"),
    Physics("Physics"),
    History("History"),
    Economics("Economics"),
    SocialStudies("Social Studies"),
    Civics("Civics"),
    Hindi("Hindi"),
    English("English"),
    Biology("Biology"),
    ComputerScience("Computer Science");
    private String subjects;

    SubjectsEnum(String subjects) {
        this.subjects = subjects;
    }

    public String getSubjects() {
        return subjects;
    }
}