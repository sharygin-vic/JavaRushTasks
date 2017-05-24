package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        HashSet<Integer> res = new HashSet<Integer>();
        try {
            long decimal = Long.parseLong(number);
            for (int radix = 2; radix <= 36; radix++) {
                String s = Long.toUnsignedString(decimal, radix);
                if (new StringBuilder(s).reverse().toString().equals(s)) {
                    res.add(radix);
                }
            }
        }
        catch (NumberFormatException ignor) {/* NOP */}

        return res;
    }
}