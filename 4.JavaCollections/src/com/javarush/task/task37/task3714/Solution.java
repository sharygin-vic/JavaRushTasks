package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        System.out.println(romanToInteger("I") + " = 1");
//        System.out.println(romanToInteger("II") + " = 2");
//        System.out.println(romanToInteger("III") + " = 3");
//        System.out.println(romanToInteger("IV") + " = 4");
//        System.out.println(romanToInteger("V") + " = 5");
//        System.out.println(romanToInteger("VI") + " = 6");
//        System.out.println(romanToInteger("VII") + " = 7");
//        System.out.println(romanToInteger("VIII") + " = 8");
//        System.out.println(romanToInteger("IX") + " = 9");
//        System.out.println(romanToInteger("X") + " = 10");
//        System.out.println(romanToInteger("XII") + " = 12");
//        System.out.println(romanToInteger("XIV") + " = 14");
//        System.out.println(romanToInteger("XXVII") + " = 27");
//        System.out.println(romanToInteger("XL") + " = 40");
//        System.out.println(romanToInteger("XLVI") + " = 46");
//        System.out.println(romanToInteger("LXXX") + " = 80");
//        System.out.println(romanToInteger("LXXXII") + " = 82");
//        System.out.println(romanToInteger("MMCDLXXIV") + " = 2474");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    enum RimDigits {
        I (1), V (5), X (10), L (50), C (100), D (500), M (1000);

        private int value;

        RimDigits(int value) {
            this.value = value;
        };

        public int getValue() {
            return value;
        }
    }

    public static int romanToInteger(String s) {
        String ch = s.substring(0, 1);
        int prevCharValue = RimDigits.valueOf(ch).getValue();
        int rimDigitSum = prevCharValue;  // сумма римских цифр для текущего разряда
        int resSum = 0; // десятичный результат перевода


        for (int i = 1; i < s.length(); i++) {
            ch = s.substring(i, i+1);
            int currentCharValue = RimDigits.valueOf(ch).getValue();

            if (currentCharValue == prevCharValue) {
                rimDigitSum += currentCharValue;
            }
            else if (currentCharValue > prevCharValue) {
                resSum += currentCharValue - rimDigitSum;
                prevCharValue = currentCharValue;
                rimDigitSum = 0;
            }
            else if (currentCharValue < prevCharValue) {
                if (i < s.length()-1) {
                    String chNext = s.substring(i+1, i+2);
                    int nextCharValue = RimDigits.valueOf(chNext).getValue();
                    if (nextCharValue > currentCharValue) {
                        resSum += rimDigitSum - currentCharValue;
                        rimDigitSum = 0;
                    }
                    else {
                        rimDigitSum += currentCharValue;
                    }
                    prevCharValue = currentCharValue;
                }
                else {
                    rimDigitSum += currentCharValue;
                }
            }
        }
        resSum += rimDigitSum;

        return  resSum;
    }
}
