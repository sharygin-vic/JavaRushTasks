package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int b2 = Integer.parseInt(reader.readLine());
        int b3 = Integer.parseInt(reader.readLine());
        int b4 = Integer.parseInt(reader.readLine());

        int minimum = min( a,  b,  b2,  b3,  b4);

        System.out.println("Minimum = " + minimum);
    }


    public static int min2(int a, int b) {
        return a < b ? a : b;
    }

    public static int min(int a, int b, int b2, int b3, int b4) {
        return min2(min2(min2(a, b), min2(b2, b3)), b4);
    }
}
