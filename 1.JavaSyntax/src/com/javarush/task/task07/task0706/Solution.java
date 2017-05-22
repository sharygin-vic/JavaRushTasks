package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] arr = new int[15];
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(r.readLine());
        }

        int sumEven = 0;  // nechetn
        int sumOdd = 0;  // chetn
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                sumOdd += arr[i];
            } else {
                sumEven += arr[i];
            }
        }

        if (sumOdd > sumEven) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }


    }
}
