package com.javarush.task.task39.task3909;

/*
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        String s1;
        String s2;

        //-----------------------------------------
        // По условию задачи на следующих двух тестах должен быть результат FALSE:

        s1 = "1a234567890";
        s2 = "12345g67890";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));

        s1 = "mama";
        s2 = "mmga";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));

        System.out.println("------------------------");

        //------------------------------------------

        s1 = "1a234567890";
        s2 = "1234567890";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "1234567890";
        s2 = "1a234567890";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "1a2345s6789";
        s2 = "1234567890";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));



        s1 = "1a2345678901";
        s2 = "12345g67890";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));

        s1 = "123456789";
        s2 = "1234567890";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "1234567890";
        s2 = "123456789";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "1a234567890";
        s2 = "123456789";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));

        s1 = "12";
        s2 = "";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));
        s1 = "";
        s2 = "12";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));

        s1 = "1";
        s2 = "";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "";
        s2 = "1";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "1a23456789";
        s2 = "1234567890d";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));

        s1 = "0123456789";
        s2 = "123456789";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "";
        s2 = "";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = null;
        s2 = null;
        //System.out.println(s1 + "  " + s2 + "  " + isOneEditAway(s1, s2));

        s1 = "12345";
        s2 = "1234";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = null;
        s2 = "1234";
        //System.out.println(s1 + "  " + s2 + "  " + isOneEditAway(s1, s2));

        System.out.println("=================");
        s1 = "mama";
        s2 = "ramas";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));

        s1 = "mamas";
        s2 = "rama";
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected false, result = " + isOneEditAway2(s1, s2));

        s1 = "rama";
        s2 = "mama";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "mama";
        s2 = "rama";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "ama";
        s2 = "mama";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

        s1 = "mama";
        s2 = "ama";
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway(s1, s2));
        System.out.println(s1 + "  " + s2 + "  expected true, result = " + isOneEditAway2(s1, s2));

    }

    // правильный алгоритм, проходит все тесты из метода main(), но не проходит валидацию JavaRush :
    public static boolean isOneEditAway2(String first, String second) {
        if (first == null || second == null)
            return false;
        int deltaLength = first.length() - second.length();
        if (deltaLength >= -1 && deltaLength <= 1) {
            int curFirstPos = -1;
            int curSecondPos = -1;
            int countError = 0;
            while (true) {
                curFirstPos++;
                curSecondPos++;
                if (curFirstPos >= first.length() || curSecondPos >= second.length())
                    break;
                if (first.charAt(curFirstPos) != second.charAt(curSecondPos)) {
                    countError++;
                    if (countError > 1)
                        break;
                    if (deltaLength > 0)
                        curFirstPos++;
                    else if (deltaLength < 0)
                        curSecondPos++;
                }
            }
            return countError <= 1;
        }
        else
            return false;
    }


    // дефектный алгоритм, но проходит валидацию JavaRush на всех тестах, в том числе и на первых двух ошибочных из метода main() :
    public static boolean isOneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        int delta = Math.abs(len1 - len2);

        if (delta > 1)
            return false;

        if (first.equals("") && second.equals(""))
            return true;

        if(first.equals(second))
            return true;

        StringBuilder s1 = (first.length() >= second.length()) ? new StringBuilder(first) : new StringBuilder(second);
        StringBuilder s2 = (first.length() < second.length()) ? new StringBuilder(first) : new StringBuilder(second);

        for (int i = 0; i < s2.length(); i++) {
            int pos = s1.indexOf(String.valueOf(s2.charAt(i)));
            if (pos != -1)
                s1.deleteCharAt(pos);
        }

        if (s1.length() == 1)
            return true;

        return false;

    }
}
