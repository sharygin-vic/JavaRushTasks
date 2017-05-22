package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream ioStream = null;
        try {
            String fileName = r.readLine();
            ioStream = new FileInputStream(fileName);
            while (ioStream.available() > 0) {
                int data = ioStream.read();
                System.out.print((char)data);
            }
            System.out.println();
        }
        catch (IOException e) {

        }
        finally {
            try {
                ioStream.close();
                r.close();
            }
            catch (IOException e) {

            }

        }

    }
}