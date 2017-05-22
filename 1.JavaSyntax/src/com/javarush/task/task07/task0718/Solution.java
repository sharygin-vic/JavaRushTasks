package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(r.readLine());
        }
        int maxLen = -1;
        int pos = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > maxLen) {
                maxLen = list.get(i).length();
            } else if (pos == -1) {
                pos = i;
            }
        }

        if (pos != -1) {
            System.out.println(pos);
        }
    }
}

