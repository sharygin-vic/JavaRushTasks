package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOld = System.out;

        ByteArrayOutputStream aos = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(aos);

        System.setOut(newOut);
        testString.printSomething();

        String src = aos.toString();
        int countOut = 0;
        StringBuilder sb = new StringBuilder();
        for (String curS : src.split("\n")) {
            String s = curS.trim();
            sb.append(s).append("\n");
            countOut++;
            if (countOut % 2 == 0) {
                countOut = 0;
                sb.append("JavaRush - курсы Java онлайн").append("\n");
            }
        }

        System.setOut(consoleOld);
        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

}
