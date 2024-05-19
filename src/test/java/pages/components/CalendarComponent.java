package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String mont, String year) {
        $(".react-datepicker__month-dropdown-container").click();
        $(".react-datepicker__month-select>[value='0']").click();
        $(".react-datepicker__year-dropdown-container").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--016").click();
    }
}
