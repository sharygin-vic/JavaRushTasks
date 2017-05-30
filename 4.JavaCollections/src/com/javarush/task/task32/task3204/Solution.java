package com.javarush.task.task32.task3204;


import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream res = new ByteArrayOutputStream();
        String charsDigits = "0123456789";
        String charsLo = "qwertyuiopasdfghjklzxcvbnm";
        String charsHi = "QWERTYUIOPASDFGHJKLZXCVBNM";
        int countCharsDigits = 0;
        int countCharsLo = 0;
        int countCharsHi = 0;
        PrintWriter writer = new PrintWriter(res);
        for (int i = 0; i < 6; i++) {
            int charCase = (int)(Math.random() * 3);
            switch (charCase) {
                case 0 :
                    writer.print(charsDigits.charAt((int)(Math.random() * charsDigits.length())));
                    countCharsDigits++;
                    break;
                case 1 :
                    writer.print(charsLo.charAt((int)(Math.random() * charsLo.length())));
                    countCharsLo++;
                    break;
                case 2 :
                    writer.print(charsHi.charAt((int)(Math.random() * charsHi.length())));
                    countCharsHi++;
                    break;
            }
        }
        if (countCharsDigits == 0) {
            writer.print(charsDigits.charAt((int)(Math.random() * charsDigits.length())));
            countCharsDigits++;
        }
        if (countCharsLo == 0) {
            writer.print(charsLo.charAt((int)(Math.random() * charsLo.length())));
            countCharsLo++;
        }
        if (countCharsHi == 0) {
            writer.print(charsHi.charAt((int)(Math.random() * charsHi.length())));
            countCharsHi++;
        }
        for (int i = 0; i <= (8 - countCharsDigits - countCharsLo - countCharsHi); i++) {
            int charCase = (int)(Math.random() * 3);
            switch (charCase) {
                case 0 :
                    writer.print(charsDigits.charAt((int)(Math.random() * charsDigits.length())));
                    countCharsDigits++;
                    break;
                case 1 :
                    writer.print(charsLo.charAt((int)(Math.random() * charsLo.length())));
                    countCharsLo++;
                    break;
                case 2 :
                    writer.print(charsHi.charAt((int)(Math.random() * charsHi.length())));
                    countCharsHi++;
                    break;
            }
        }
        writer.close();
        return res;
    }
}