package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            list.add(r.readLine());
        }

        int maxLength = list.get(0).length();
        for (int i = 0; i < 5; i++) {
            int curLength = list.get(i).length();
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == maxLength) {
                System.out.println(list.get(i));
            }
        }
    }
}
