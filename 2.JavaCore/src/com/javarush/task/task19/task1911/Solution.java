package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;

        ByteArrayOutputStream outData = new ByteArrayOutputStream();
        PrintStream newConsole = new PrintStream(outData);
        System.setOut(newConsole);

        testString.printSomething();
        String res = outData.toString().toUpperCase();


        System.setOut(consoleOut);
        System.out.println(res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
