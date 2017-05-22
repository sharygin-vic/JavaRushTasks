package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        int[] res = new int[20];
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(r.readLine());
        }
        return res;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (res < array[i]) {
                res = array[i];
            }
        }
        return res;
    }
}
