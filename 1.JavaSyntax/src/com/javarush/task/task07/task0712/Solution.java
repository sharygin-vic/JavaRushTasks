package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(r.readLine());
        }

        int minLen = list.get(0).length();
        int maxLen = list.get(0).length();
        int minPos = 0;
        int maxPos = 0;
        for (int i = 0; i < list.size(); i++){
            String curS = list.get(i);
            if (curS.length() > maxLen) {
                maxLen = curS.length();
                maxPos = i;
            }
            if (curS.length() < minLen) {
                minLen = curS.length();
                minPos = i;
            }
        }
        if (minPos < maxPos) {
            System.out.println(list.get(minPos));
        } else {
            System.out.println(list.get(maxPos));
        }
    }
}
