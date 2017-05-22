package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f = new FileInputStream(r.readLine());
        byte[] data = new byte[256];
        byte comma = (byte) ',';
        int commsCount = 0;
        while (f.available() > 0) {
            int count = f.read(data);
            for (int i = 0; i < count; i++) {
                if (data[i] == comma) {
                    commsCount++;
                }
            }
        }
        f.close();
        r.close();
        System.out.println(commsCount);
        //System.out.println(comma);
    }
}
//c:\r\1.txt