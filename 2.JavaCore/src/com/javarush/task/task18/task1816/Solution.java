package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(args[0]));
        int count = 0;
        char[] chars = new char[1000];
        int countEngl = 0;
        do {
            count = r.read(chars);
            for (char ch : chars) {
                if (ch >= 'A' && ch <= 'z') {
                    countEngl++;
                }
            }
        }
        while (count == chars.length);
        r.close();
        System.out.println(countEngl);
    }
}
