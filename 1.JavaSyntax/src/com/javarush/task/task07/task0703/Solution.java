package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] arrS = new String[10];
        int[] arrI = new int[10];

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arrS.length; i++) {
            arrS[i] = r.readLine();
        }

        for (int i = 0; i < arrS.length; i++) {
            arrI[i] = arrS[i].length();
        }

        for (int i= 0; i < arrI.length; i++) {
            System.out.println(arrI[i]);
        }
    }
}
