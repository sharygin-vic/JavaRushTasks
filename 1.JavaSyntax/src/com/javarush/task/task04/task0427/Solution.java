package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(r.readLine());

        if (val > 0 && val < 1000) {
            String s = "четное ";
            if (val % 2 != 0) s = "не" + s;

            if (val < 10) s = s + "однозначное число";
            else if (val < 100) s = s + "двузначное число";
            else s = s + "трехзначное число";

            System.out.println(s);
        }
    }
}
