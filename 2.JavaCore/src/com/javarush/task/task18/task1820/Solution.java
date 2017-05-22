package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = r.readLine();
        String fName2 = r.readLine();

        BufferedReader r1 = new BufferedReader(new FileReader(fName1));
        String data1 = r1.readLine();

        String[] strNumbers = data1.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : strNumbers) {
            long val = Math.round(Double.parseDouble(s));
            sb.append(val).append(" ");
        }
        BufferedWriter f2 = new BufferedWriter(new FileWriter(fName2));
        f2.write(sb.toString().trim());

        r.close();
        r1.close();
        f2.close();
    }
}
