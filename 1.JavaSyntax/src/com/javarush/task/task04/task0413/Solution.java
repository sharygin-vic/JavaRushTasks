package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int i = Integer.parseInt(s);

        if (i == 1) {
            s = "понедельник";
        } else if (i == 2) {
            s = "вторник";
        } else if (i == 3) {
            s = "среда";
        } else if (i == 4) {
            s = "четверг";
        } else if (i == 5) {
            s = "пятница";
        } else if (i == 6) {
            s = "суббота";
        } else if (i == 7) {
            s = "воскресенье";
        } else {
            s = "такого дня недели не существует";
        }

        System.out.println(s);
    }
}