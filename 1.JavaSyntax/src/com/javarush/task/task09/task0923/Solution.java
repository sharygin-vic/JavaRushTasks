package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        //String in = r.readLine();
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        char[] in = r.readLine().toCharArray();
        for (char ch : in) {
            if (isVowel(ch)) {
                sbA.append(ch);
                sbA.append(' ');
            } else if (ch != ' ') {
                sbB.append(ch);
                sbB.append(' ');
            }
        }
        System.out.println(sbA.toString());
        System.out.println(sbB.toString());

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}