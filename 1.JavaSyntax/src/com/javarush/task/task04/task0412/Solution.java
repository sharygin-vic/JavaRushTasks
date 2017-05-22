package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int i = Integer.parseInt(s);

        if (i < 0) {
            i = i + 1;
        } else if (i > 0) {
            i = i * 2;
        }

        System.out.println(i);
    }

}