package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = r.readLine();
        String fName2 = r.readLine();

        FileInputStream f1 = new FileInputStream(fName1);
        FileInputStream f2 = new FileInputStream(fName2);

        byte[] data1 = new byte[f1.available()];
        f1.read(data1);
        f1.close();

        byte[] data2 = new byte[f2.available()];
        f2.read(data2);
        f2.close();

        FileOutputStream f11 = new FileOutputStream(fName1);
        f11.write(data2);
        f11.write(data1);
        f11.close();

        r.close();
    }
}
