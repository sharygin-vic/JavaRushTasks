package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String s = r.readLine();
        int a = Integer.parseInt(s);
        s = r.readLine();
        int b = Integer.parseInt(s);
        s = r.readLine();
        int c = Integer.parseInt(s);

        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            s = "Треугольник существует.";
        } else {
            s = "Треугольник не существует.";
        }
        System.out.println(s);
    }
}