package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in ));

        double sum = 0;
        int count = 0;
        while (true) {
            int val = Integer.parseInt(r.readLine());
            if (val == -1) break;
            count++;
            sum += val;
        }

        if (count == 0) {
            System.out.println(sum);
        } else {
            System.out.println(sum / count);
        }
    }
}

