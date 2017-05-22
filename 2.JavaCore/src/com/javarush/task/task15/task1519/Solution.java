package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        while (!"exit".equals(s)) {
            try {
                int val = Integer.parseInt(s);
                if (val > 0 && val < 128) {
                    print((short) val);
                }
                else {
                    print(val);
                }
            }
            catch (NumberFormatException e) {
                try {
                    Double val = Double.parseDouble(s);
                    print(val);
                }
                catch (NumberFormatException eDouble) {
                    print(s);
                }
            }
            s = r.readLine();
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
