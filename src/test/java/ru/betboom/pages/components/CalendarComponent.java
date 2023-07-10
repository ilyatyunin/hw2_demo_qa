package ru.betboom.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        ElementsCollection days = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");
        days.find(Condition.text(day)).click();


//        $(".react-datepicker__month-select").selectOption(month);
//        $(".react-datepicker__year-select").selectOption(year);
//        String dayPickerLocator = format(".react-datepicker__day--0%s", day);
//        $(dayPickerLocator).click();

    }
}
