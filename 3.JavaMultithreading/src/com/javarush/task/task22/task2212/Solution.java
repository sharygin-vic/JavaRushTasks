package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        String s = "((\\+\\d{2})?(\\(?\\d{3}\\)?){1}(((-\\d)|[\\d]){7}))|((\\+\\d(\\d|(-\\d)))?(\\d|(-\\d)){10})";
        return telNumber.matches(s) && telNumber.matches("([^-]+)|(([^-]+-?){0,3})");
    }

    public static void main(String[] args) {
        System.out.println("+38050-1234567 - " + checkTelNumber("+38050-1234567"));
        System.out.println("+38(050)123-45-67 - " + checkTelNumber("+38(050)123-45-67"));
        System.out.println("+38050123-45-67 - " + checkTelNumber("+38050123-45-67"));
        System.out.println("050-1234-567 - " + checkTelNumber("050-1234-567"));
        System.out.println("0501234567 - " + checkTelNumber("0501234567"));
        System.out.println("(050)1234567 - " + checkTelNumber("(0-50)1234567"));

        System.out.println();

        System.out.println("(050)12345--67 - " + checkTelNumber("(050)12345--67"));
        System.out.println("(05)01234567 - " + checkTelNumber("(05)01234567"));
        System.out.println("+38)050(1234567 - " + checkTelNumber("+38)050(1234567"));  // false
        System.out.println("+38(050)-1-23-4567 - " + checkTelNumber("+38(050)-1-23-4567"));
        System.out.println("+3838(050)1-23-45-6-7 - " + checkTelNumber("+3838(050)1-23-45-6-7"));
        System.out.println("+38(050)(058)1234567 - " + checkTelNumber("+38(050)(058)1234567"));
        System.out.println("+38(050)(058)1-23-45-6-7 - " + checkTelNumber("+38(050)(058)1-23-45-6-7"));
        System.out.println("+38+34(050)(058)1-23-4567 - " + checkTelNumber("+38+34(050)(058)1-23-4567"));
        System.out.println("050ххх4567 - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - " + checkTelNumber("(0)501234567"));
    }
}
