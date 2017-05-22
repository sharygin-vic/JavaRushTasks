package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int val1 = Integer.parseInt(r.readLine());
        if (val1 <= 0)
            throw new IllegalArgumentException();
        int val2 = Integer.parseInt(r.readLine());
        if (val2 <= 0)
            throw new IllegalArgumentException();
        int minval = val1 < val2 ? val1 : val2;
        int nod = 1;
        for (int i = nod+1; i <= minval; i++) {
            if (val1 % i == 0 && val2 % i == 0)
                nod = i;
        }
        System.out.println(nod);
    }
}
