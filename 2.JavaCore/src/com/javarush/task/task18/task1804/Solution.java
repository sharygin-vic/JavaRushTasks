package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(r.readLine());
        int[] bytes = new int[256];
//        for (int i = 0; i < bytes.length; i++) {
//            bytes[i] = -1;
//        }

        while (fileInputStream.available() > 0) {
            bytes[fileInputStream.read()]++;
        }
        r.close();
        fileInputStream.close();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] < min && bytes[i] != 0) {
                min = bytes[i];
            }
        }
        if (min < Integer.MAX_VALUE) {
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == min) {
                    System.out.print(i + " ");
                }
            }
        }

        //debug
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println(bytes[i]);
//        }
    }
}

//c:\r\1.txt