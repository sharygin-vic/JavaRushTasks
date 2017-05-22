package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int i1 = Integer.parseInt(s);
        s = r.readLine();
        int i2 = Integer.parseInt(s);

        if (i1 < i2) System.out.println(i1);
        else System.out.println(i2);
    }
}