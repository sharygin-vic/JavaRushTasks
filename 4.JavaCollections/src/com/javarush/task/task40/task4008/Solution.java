package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        DateTimeFormatter fmt;
        boolean isDate = date.contains(".");
        boolean isTime = date.contains(":");
        if (isDate && isTime) {
            fmt = DateTimeFormatter.ofPattern("d.M.yyyy H:m:s");
        }
        else if (isDate) {
            fmt = DateTimeFormatter.ofPattern("d.M.yyyy");
        }
        else {
            fmt = DateTimeFormatter.ofPattern("H:m:s");
        }

        if (isDate) {
            LocalDate ld = LocalDate.parse(date, fmt);
            int dayOfMonth = ld.getDayOfMonth();
            System.out.println("День: " + dayOfMonth);
            System.out.println("День недели: " +  ld.getDayOfWeek().getValue());
            System.out.println("День месяца: " + ld.getDayOfMonth());
            System.out.println("День года: " + ld.getDayOfYear());
            System.out.println("Неделя месяца: " + ld.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + ld.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " +  ld.getMonthValue());
            System.out.println("Год: " + ld.getYear());
        }
        if (isTime) {
            LocalTime lt = LocalTime.parse(date, fmt);
            int hour = lt.getHour();
            System.out.println("AM или PM: " + (lt.get(ChronoField.AMPM_OF_DAY) == 1 ? "PM" : "AM") );
            System.out.println("Часы: " + lt.get(ChronoField.HOUR_OF_AMPM) );
            System.out.println("Часы дня: " + hour);
            System.out.println("Минуты: " + lt.getMinute());
            System.out.println("Секунды: " + lt.getSecond());
        }
    }
}
