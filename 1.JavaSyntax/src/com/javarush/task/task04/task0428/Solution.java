package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int positiveCount = 0;

        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(r.readLine()) >= 0) positiveCount++;
        }
        System.out.println(positiveCount);
    }
}
