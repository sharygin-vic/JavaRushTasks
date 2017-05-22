package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(args[0]));
        int countSpace = 0;
        int countAll = 0;
        int countRead = 0;
        char[] chars = new char[1000];
        do {
            countRead = r.read(chars);
            for (int i = 0; i < countRead; i++) {
                countAll++;
                if (chars[i] == ' ') {
                    countSpace++;
                }
            }
        }
        while (countRead == chars.length);
        r.close();

        double res = (double)countSpace / countAll ;
        long rr = Math.round(res * 10000);
        res = rr / 100.0;
        System.out.println(res);
    }
}
