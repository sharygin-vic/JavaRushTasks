package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        Integer i1 = Integer.parseInt(s);
        s = r.readLine();
        Integer i2 = Integer.parseInt(s);
        s = r.readLine();
        Integer i3 = Integer.parseInt(s);

        if (i1 > max(i2, i3)) {
            s = "" + i1;
            if (i2 > i3) s = s + " " + i2 + " " + i3;
            else s = s + " " + i3 + " " + i2;
        } else if (i2 > max(i1, i3)) {
            s = "" + i2;
            if (i1 > i3) s = s + " " + i1 + " " + i3;
            else s = s + " " + i3 + " " + i1;
        } else if (i3 > max(i2, i1)) {
            s = "" + i3;
            if (i2 > i1) s = s + " " + i2 + " " + i1;
            else s = s + " " + i1 + " " + i2;
        }

        System.out.println(s);
    }

    static Integer max(int i1, int i2) {
        if (i1 > i2) return i1;
        else return i2;
    }
}
