package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws  IOException {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        byte[] textBytes = text.getBytes();
        long fileLength = raf.length();

        byte[] bytesFromFile = new byte[textBytes.length];
        raf.seek(number);
        raf.read(bytesFromFile, 0, textBytes.length);

        String fromFile = convertByteToString(bytesFromFile);

        raf.seek(fileLength);
        if (text.equals(fromFile)) {
            raf.write("true".getBytes());
        }
        else  {
            raf.write("false".getBytes());
        }
        raf.close();
    }

    private static String convertByteToString(byte[] readBytes) {
        String s = new String(readBytes);
        String[] substrings = s.split("\r?\n");
        return substrings[0];
    }
}
