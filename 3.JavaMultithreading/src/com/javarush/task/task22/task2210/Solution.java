package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

//        String test = "level22.lesson13.task01";
//        String[] arr = getTokens(test, ".");
//        for(String s : arr) {
//            System.out.println(s);
//        }

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        ArrayList<String> words = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            words.add(st.nextToken());
        }
        return words.toArray(new String[0]);
    }
}
