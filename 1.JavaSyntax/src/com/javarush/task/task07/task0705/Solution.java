package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] arr20 = new int[20];
        int[] arr10_1 = new int[10];
        int[] arr10_2 = new int[10];
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr20.length; i++) {
            arr20[i] = Integer.parseInt(r.readLine());
        }
        int idx;
        int half = arr20.length / 2;
        for (idx = 0; idx < half; idx++) {
            arr10_1[idx]= arr20[idx];
        }
        for (; idx < arr20.length; idx++) {
            arr10_2[idx - half]= arr20[idx];
        }

        for (int i = 0; i < arr10_2.length; i++) {
            System.out.println(arr10_2[i]);
        }
    }
}
