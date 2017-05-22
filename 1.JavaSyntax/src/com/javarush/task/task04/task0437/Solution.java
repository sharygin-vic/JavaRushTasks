package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        for (int y = 1; y <= 10; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print(8);
            }
            System.out.println();
        }

    }
}
