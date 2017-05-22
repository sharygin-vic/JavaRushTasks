package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        BigInteger res = null;
        if (n < 0) {
            res = new BigInteger("0");
        }
        else {
            res = new BigInteger("1");
            if (n > 1) {
                for (int i = 2; i <= n; i++) {
                    res = res.multiply(new BigInteger(String.valueOf(i)));
                }
            }
        }
        return String.valueOf(res) ;
    }
}
