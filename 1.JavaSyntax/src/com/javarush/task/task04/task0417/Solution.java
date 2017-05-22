package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
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

        //System.out.println("" + i1 + " " + i2 + " " + i3);

        s = "";
        int pairCount = 0;
        if (i1 == i2) {
            s = "" + i1 + " " + i2;
            pairCount++;
        }
        if (i2 == i3) {
            if (s.length() != 0) {
                s = s + " " + i3;
            } else {
                s = "" + i2 + " " + i3;
            }
            pairCount++;
        }
        if (i1 == i3 && pairCount <= 1) {
            s = "" + i1 + " " + i3;
        }

        if (s.length() > 0) {
            System.out.println(s);
        }
    }
}