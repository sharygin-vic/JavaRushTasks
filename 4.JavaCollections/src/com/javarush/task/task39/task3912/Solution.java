package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0}
        };
        print(matrix);

        System.out.println(maxSquare(matrix));
        print(matrix);
    }

    public static int maxSquare(int[][] matrix) {
        int maxSquare = 0;

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == 1) {
                    if (x-1 >= 0 && y-1 >= 0) {
                        matrix[y][x] = min3(matrix[y - 1][x], matrix[y][x - 1], matrix[y - 1][x - 1]) + 1;
                        int square = matrix[y][x] * matrix[y][x];
                        if (square > maxSquare)
                            maxSquare = square;
                    }
                }
            }
        }

        return  maxSquare;
    }

    private static int min3(int n1, int n2, int n3) {
        int min2 = n1 < n2 ? n1 : n2;
        return min2 < n3 ? min2 : n3;
    }

    public static void print(int[][] matrix) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                System.out.format("%3s", matrix[y][x]);
            }
            System.out.println();
        }
    }
}
