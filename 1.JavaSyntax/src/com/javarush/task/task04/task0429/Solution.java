package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int posN = 0;
        int negN = 0;

        for (int i = 0; i < 3; i++) {
            int val = Integer.parseInt(r.readLine());
            //System.out.println("      " + val);
            if (val > 0) posN++;
            else if (val < 0) negN++;
            //else if (val == 0);
        }
        System.out.println("количество отрицательных чисел: " + negN);
        System.out.println("количество положительных чисел: " + posN);
    }
}
