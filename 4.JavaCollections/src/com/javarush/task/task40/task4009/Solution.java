package com.javarush.task.task40.task4009;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(weekDayOfBirthday("30.05.1984", "2015"));    // sabato
        System.out.println(weekDayOfBirthday("1.12.2015", "2016"));    // giovedì
    }

    public static String weekDayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d.M.yyyy");
        Year targetYear = Year.parse(year);
        LocalDate birthdayDate = LocalDate.parse(birthday, fmt).withYear(targetYear.getValue());
        return DayOfWeek.of(birthdayDate.get(WeekFields.of(Locale.ITALIAN).dayOfWeek()))
                .getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}
