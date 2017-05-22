package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
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

        StringBuilder sb = new StringBuilder(dataOut.toString());
        for (int i = sb.length()-1; i >=0; i--) {
            if (!Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
            }
        }

        System.setOut(consoleOld);
        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
