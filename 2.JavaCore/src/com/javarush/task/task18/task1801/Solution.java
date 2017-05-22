package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(r.readLine());
        int max = -1;
        while (fileInputStream.available() > 0) {
            int tmp = fileInputStream.read();
            if (tmp > max) {
                max = tmp;
            }
        }
        r.close();
        fileInputStream.close();
        if (max > -1) {
            System.out.println(max);
        }

    }
}
