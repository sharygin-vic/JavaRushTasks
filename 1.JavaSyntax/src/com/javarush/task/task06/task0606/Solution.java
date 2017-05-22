package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int val = Integer.parseInt(s);

        processString(s);

        System.out.println("Even: " + even + " Odd: " + odd);
    }

    static private void processString(String s) {
        for (int i = 0; i < s.length(); i++) {
            String ds = s.substring(i, i+1);
            //System.out.println(ds);
            processDigit(Integer.parseInt(ds));
        }
    }

    static private void processDigit(int val) {
        if (val % 2 == 0) {
            even++;
        } else {
            odd++;
        }
    }
}
