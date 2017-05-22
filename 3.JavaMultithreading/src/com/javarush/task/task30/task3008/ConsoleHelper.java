package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dell on 01-May-17.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        boolean ok = false;
        String res = null;
        while (!ok) {
            try {
                res = bufferedReader.readLine();
                ok = true;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return res;
    }

    public static int readInt() {
        boolean ok = false;
        int res = 0;
        while (!ok) {
            try {
                res = Integer.parseInt(readString());
                ok = true;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return res;
    }
}
