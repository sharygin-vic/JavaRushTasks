package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        while (true) {
            int i = Integer.parseInt(r.readLine());
            sum += i;
            if (i == -1) {
                break;
            }
        }

        System.out.println(sum);
    }
}
