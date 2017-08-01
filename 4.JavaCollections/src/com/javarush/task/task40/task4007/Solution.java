package com.javarush.task.task40.task4007;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");

//        System.out.println();
//        printDate("30.07.2017");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        boolean isDate = date.contains(".");
        boolean isTime = date.contains(":");
        DateFormat fmt;
        if (isDate && isTime) {
            fmt = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        }
        else if (isDate) {
            fmt = new SimpleDateFormat("dd.MM.yy");
        }
        else {
            fmt = new SimpleDateFormat("HH:mm:ss");
        }

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(fmt.parse(date));
            if (isDate) {
                System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                System.out.println("День недели: " + (dayOfWeek == 0 ? 7 : dayOfWeek) );
                System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1) );
                System.out.println("Год: " + calendar.get(Calendar.YEAR));
            }
            if (isTime) {
                System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 1 ? "PM" : "AM") );
                System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
