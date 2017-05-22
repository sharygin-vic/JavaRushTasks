package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader rf  = new BufferedReader(new FileReader(r.readLine()));
        r.close();

        while (rf.ready()) {
            String s = rf.readLine();
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            System.out.println(sb.toString());
        }
        rf.close();
    }
}
