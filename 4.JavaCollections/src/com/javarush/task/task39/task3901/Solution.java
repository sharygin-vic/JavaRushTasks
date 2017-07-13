package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        //int startMax = 0;
        int lengthMax = 1;
        //int startCur = 0;
        int lengthCur = 1;
        HashSet<Character> uniqueSubstring = new HashSet<Character>();
        uniqueSubstring.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (uniqueSubstring.contains(s.charAt(i))) {
                if (lengthCur > lengthMax) {
                    //startMax = startCur;
                    lengthMax = lengthCur;
                }
                //startCur = 0;
                lengthCur = 1;
                uniqueSubstring.clear();
            }
            else {
                lengthCur++;
            }
            uniqueSubstring.add(s.charAt(i));
        }
        if (lengthCur > lengthMax) {
            //startMax = startCur;
            lengthMax = lengthCur;
        }
        //System.out.println(s.substring(startMax, startMax + lengthMax) + "  -  ");

        return lengthMax;
    }
}
