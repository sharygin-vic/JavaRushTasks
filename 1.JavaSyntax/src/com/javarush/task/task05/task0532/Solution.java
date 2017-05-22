package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum;

        //напишите тут ваш код
        int n = Integer.parseInt(reader.readLine());
        maximum = Integer.parseInt(reader.readLine());
        for (int i = 1; i < n; i++) {
            int val = Integer.parseInt(reader.readLine());
            if (val > maximum)
                maximum = val;
        }

        System.out.println(maximum);
    }
}
