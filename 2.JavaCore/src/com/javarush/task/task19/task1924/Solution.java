package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader rf  = new BufferedReader(new FileReader(r.readLine()));
        r.close();

        while (rf.ready()) {
            String s = rf.readLine();
            String[] words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length()==1 || words[i].length()==2) {
                    try {
                        int n = Integer.parseInt(words[i]);
                        if (map.containsKey(n)) {
                            words[i] = map.get(n);
                        }
                    } catch (NumberFormatException e) {}
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String w : words) {
                sb.append(w).append(" ");
            }
            System.out.println(sb.substring(0, sb.length()-1));
        }
        rf.close();
    }
}
//c:\r\1922.txt