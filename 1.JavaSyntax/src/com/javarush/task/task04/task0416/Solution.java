package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        double timeG = 3.0;
        double timeY = 1.0;
        double timeR = 1.0;
        double timeCircle = timeG + timeY + timeR;

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        double curMin = Double.parseDouble(s);

        double curMinInCircle = curMin - ((int)(curMin / timeCircle)) * timeCircle;

        //System.out.println(curMinInCircle);

        if (curMinInCircle < timeG) {
            s = "зелёный";
        } else if (curMinInCircle < timeG + timeY) {
            s = "желтый";
        } else if (curMinInCircle < timeG + timeY + timeR) {
            s = "красный";
        }
        System.out.println(s);
    }
}