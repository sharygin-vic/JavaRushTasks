package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOld = System.out;

        ByteArrayOutputStream dataOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(dataOut));

        testString.printSomething();
        String inStr = dataOut.toString().trim();
        String[] ss = inStr.split(" ");
        int res;
        if (ss[1].equals("+")) {
            res = Integer.parseInt(ss[0]) + Integer.parseInt(ss[2]);
        }
        else if (ss[1].equals("-")) {
            res = Integer.parseInt(ss[0]) - Integer.parseInt(ss[2]);
        }
        else {
            res = Integer.parseInt(ss[0]) * Integer.parseInt(ss[2]);
        }

        System.setOut(consoleOld);
        System.out.println(inStr + " " + res);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

