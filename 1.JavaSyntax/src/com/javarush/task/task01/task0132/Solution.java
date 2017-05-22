package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код

        int n1 = number / 100;
        int n2 = (number - n1 * 100) / 10;
        int n3 = (number - n1 * 100 - n2 * 10);

        return n1 + n2 + n3;
    }
}