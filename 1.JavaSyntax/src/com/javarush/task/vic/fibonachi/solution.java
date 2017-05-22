package com.javarush.task.vic.fibonachi;

/**
 * Created by dell on 05-Mar-17.
 */
public class solution {
    public static void main(String[] args) {
        int fib = 12;
        for (int i = 0; i <= fib; i++) {
            System.out.println(fibonachi(i));
        }
    }

    public static int fibonachi(int val) {
        if (val == 0) return 0;
        if (val == 1) return 1;
        return fibonachi(val-1) + fibonachi(val - 2);
    }
}
