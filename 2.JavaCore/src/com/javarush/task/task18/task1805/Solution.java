package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(r.readLine());
        int[] bytes = new int[256];

        while (fileInputStream.available() > 0) {
            bytes[fileInputStream.read()]++;
        }
        r.close();
        fileInputStream.close();

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] > 0) {
                System.out.print(i + " ");
            }
        }
    }
}

//c:\r\1.txt