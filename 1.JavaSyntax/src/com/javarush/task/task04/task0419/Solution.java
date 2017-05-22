package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        int i1 = Integer.parseInt(s);
        s = r.readLine();
        int i2 = Integer.parseInt(s);
        s = r.readLine();
        int i3 = Integer.parseInt(s);
        s = r.readLine();
        int i4 = Integer.parseInt(s);

        System.out.println(max(max(i1, i2), max(i3, i4)));
    }

    static int max(int i1, int i2) {
        if (i1 > i2) return i1;
        else return i2;
    }
}
