package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        s = r.readLine();
        int age = Integer.parseInt(s);

        if (age < 18) {
            System.out.println("Подрасти еще");
        }
    }
}
