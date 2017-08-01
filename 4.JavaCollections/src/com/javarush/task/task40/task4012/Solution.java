package com.javarush.task.task40.task4012;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isLeap(LocalDate.now()));
        System.out.println(isBefore(LocalDateTime.now().minusDays(1)));
        System.out.println(isBefore(LocalDateTime.now().plusDays(1)));
        System.out.println(addTime(LocalTime.now(), 10, ChronoUnit.HOURS));
        System.out.println(getPeriodBetween(LocalDate.now(), LocalDate.now().plusDays(1)));
        System.out.println(getPeriodBetween(LocalDate.now().plusDays(1), LocalDate.now()));
    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        return  dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isBefore(secondDate)) {
            return Period.between(firstDate, secondDate);
        }
        else {
            return Period.between(secondDate, firstDate);
        }
    }
}
