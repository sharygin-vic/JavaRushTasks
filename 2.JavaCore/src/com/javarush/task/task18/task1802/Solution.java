package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(r.readLine());
        if (fileInputStream.available() > 0) {
            int min = fileInputStream.read();
            while (fileInputStream.available() > 0) {
                int tmp = fileInputStream.read();
                if (min > tmp) {
                    min = tmp;
                }
            }
            System.out.println(min);
        }
        r.close();
        fileInputStream.close();
    }
}
