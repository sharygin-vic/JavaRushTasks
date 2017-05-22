package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream dataOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(dataOut));

        testString.printSomething();
        StringBuilder sb = new StringBuilder(dataOut.toString());
        int fromIndex = 0;
        while ((fromIndex = sb.indexOf("te", fromIndex)) >= 0) {
            sb.replace(fromIndex, fromIndex+2, "??");
            fromIndex++;
            fromIndex++;
        }

        System.setOut(console);
        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
