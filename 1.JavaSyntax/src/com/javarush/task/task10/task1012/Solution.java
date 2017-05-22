package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        for (Character ch : alphabet) {
//            map.put(ch, 0);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            char[] chars = list.get(i).toCharArray();
//            for (char ch : chars) {
//                map.put(ch, map.get(ch) + 1);
//            }
//        }
//
//        for (Map.Entry<Character, Integer> item : map.entrySet()) {
//            System.out.println(item.getKey() + " " + item.getValue());
//        }        for(String s: list)


        int[] count = new int[33];
        for (int i = 0; i < 10; i++) {
            String s = list.get(i);

            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                int idx = alphabet.indexOf(ch);
                if (idx >= 0) {
                    count[idx]++;
                }
            }
        }
        for(int i = 0; i < count.length; i++)
            System.out.println(alphabet.get(i) + " " + count[i]);

    }

}
