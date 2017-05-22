package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int val = Integer.parseInt(r.readLine());

        if (val == 0) {
            System.out.println("ноль");
        } else {
            String s;
            if (val < 0) s = "отрицательное ";
            else s = "положительное ";
            if (val % 2 == 0) s = s + "четное число";
            else s = s + "нечетное число";

            System.out.println(s);
        }

    }
}
