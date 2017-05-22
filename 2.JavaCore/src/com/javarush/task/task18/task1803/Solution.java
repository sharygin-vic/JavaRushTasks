package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые частые байты
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
        int max = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] > max) {
                max = bytes[i];
            }
        }
        if (max > 0) {
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == max) {
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