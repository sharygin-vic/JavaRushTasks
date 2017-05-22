package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fName1 = r.readLine();
        String fName2 = r.readLine();
        String fName3 = r.readLine();

        FileOutputStream f1 = new FileOutputStream(fName1);
        FileInputStream f2 = new FileInputStream(fName2);
        FileInputStream f3 = new FileInputStream(fName3);

        byte[] data = new byte[1000];
        while (f2.available() > 0) {
            int count = f2.read(data);
            f1.write(data, 0, count);
        }
        f1.flush();
        while (f3.available() > 0) {
            int count = f3.read(data);
            f1.write(data, 0, count);
        }
        r.close();;
        f1.close();
        f2.close();
        f3.close();
    }
}
