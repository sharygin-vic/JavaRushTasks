package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        char[] chars = s.toCharArray();
        boolean isFirstChar = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                isFirstChar = true;
            } else {
                if (isFirstChar) {
                    isFirstChar = false;
                    chars[i] = Character.toTitleCase(chars[i]);
                }
            }
        }

        String capString = new String(chars);
        System.out.println(capString);
    }
}
