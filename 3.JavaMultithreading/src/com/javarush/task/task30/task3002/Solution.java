package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int radix = 0;
        String s1;
        if (s.startsWith("0x")) {
            s1 = s.replace("0x", "");
            radix = 16;
        }
        else if (s.startsWith("0b")) {
            s1 = s.replace("0b", "");
            radix = 2;
        }
        else if (s.startsWith("0")) {
          //  s1 = s.replace("0", "");
            s1 = s;
            radix = 8;
        }
        else return s;

        if ( radix > 0) {
            return String.valueOf(Integer.parseInt(s1, radix));
        }
        else return "";
    }
}
