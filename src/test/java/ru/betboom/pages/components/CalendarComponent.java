package ru.betboom.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String dayPickerLocator = format(".react-datepicker__day--0%s", day);
        $(dayPickerLocator).click();

    }
}
