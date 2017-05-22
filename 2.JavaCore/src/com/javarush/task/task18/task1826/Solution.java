package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);
        byte[] buf = new byte[1000];
        int bufCount;
        while (in.available() > 0) {
            bufCount = in.read(buf);
            for (int i = 0; i < bufCount; i++) {
                buf[i] ^= 23;
            }
            out.write(buf, 0, bufCount);
        }
        in.close();
        out.close();
    }

}
