package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "w");
        long fileLength = raf.length();
        if (number < 0) number = 0;
        else if (number > fileLength) number = fileLength;
        raf.seek(number);
        raf.write(text.getBytes());
        raf.close();
    }
}
