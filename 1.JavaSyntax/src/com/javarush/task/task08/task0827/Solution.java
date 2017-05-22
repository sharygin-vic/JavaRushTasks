package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));

//        System.out.println(isDateOdd("JANUARY 1 2000"));
//        System.out.println(isDateOdd("JANUARY 2 2000"));
//        System.out.println(isDateOdd("JANUARY 3 2000"));
//        System.out.println(isDateOdd("JANUARY 4 2000"));
//        System.out.println(isDateOdd("JANUARY 5 2000"));
//        System.out.println(isDateOdd("JANUARY 6 2000"));
//        System.out.println(isDateOdd("JANUARY 7 2000"));
//        System.out.println(isDateOdd("JANUARY 8 2000"));
//        System.out.println(isDateOdd("JANUARY 29 2000"));
//        System.out.println(isDateOdd("JANUARY 30 2000"));
//        System.out.println(isDateOdd("JANUARY 31 2000"));
//
//        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) {
        boolean res = true;
        Date inDate = new Date(date);
        int y = inDate.getYear();
        Date StartYear = new Date(y, 0, 1);

        if (((inDate.getTime() - StartYear.getTime()) / (1000L*60*60*24) + 1 ) % 2 == 0) {
            res = false;
        }

//        System.out.println(inDate);
//        System.out.println(StartYear);
//        System.out.println(inDate.getTime());
//        System.out.println(StartYear.getTime());
//        System.out.println(((inDate.getTime() - StartYear.getTime()) / (1000L*60*60*24) + 1 ));

        return res;
    }
}
