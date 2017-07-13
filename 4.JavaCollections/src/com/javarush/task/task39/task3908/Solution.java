package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.Map;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        HashMap<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (chars.containsKey(ch)) {
                chars.put(ch, chars.get(ch) + 1);
            }
            else {
                chars.put(ch, 1);
            }
        }

        int count = 0;
        for (Map.Entry<Character, Integer> item : chars.entrySet()) {
            int charCount = item.getValue();
            if ((charCount & 1) == 1) {
                count++;
            }
        }

        return count < 2;
    }
}
