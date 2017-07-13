package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        int n = 0;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));

        n = 1;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));

        n = 2;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));

        n = 3;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));

        n = 5;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));

        n = 6;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));

        n = 9;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));

        n = 12;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));

        n = 27;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));

        n = 81;
        System.out.println("" + n + "  isPowerOfThree : " + isPowerOfThree(n));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        if (n < 3 || n % 3 != 0)
            return false;
        else
            return isPowerOfThree(n / 3);
    }
}
