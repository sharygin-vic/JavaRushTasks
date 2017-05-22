package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream os = new FileOutputStream(r.readLine());
        r.close();

        PrintStream consoleOld = System.out;

        ByteArrayOutputStream dataOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(dataOut));

        testString.printSomething();

        System.setOut(consoleOld);

        System.out.println(dataOut.toString());
        os.write(dataOut.toByteArray());

        os.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

