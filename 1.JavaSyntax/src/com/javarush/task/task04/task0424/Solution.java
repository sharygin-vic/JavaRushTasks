package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] val = new int[5];
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        val[1] = Integer.parseInt(s);
        s = r.readLine();
        val[2] = Integer.parseInt(s);
        s = r.readLine();
        val[3] = Integer.parseInt(s);
        val[4] = val[1];
        val[0] = val[3];

        s = "";
//        for (int i = 1; i < 4; i++) {
//            if (val[i] != val[i-1] || val[i] != val[i+1]) {
//                if (s.length() > 0) s = s + " ";
//                s = s + i;
//            }
//        }

        for (int i = 1; i < 4; i++) {
            //if (val[i] != val[i-1] || val[i] != val[i+1]) {
            if (val[i] != val[i-1] && val[i-1] == val[i+1]) {
                //if (s.length() > 0) s = s + " ";
                s = s + i;
                break;
            }
        }

        if (s.length() > 0) {
            System.out.println(s);
        }
    }


}
