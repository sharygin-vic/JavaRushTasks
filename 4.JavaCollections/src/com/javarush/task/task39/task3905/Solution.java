package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        PhotoPaint paint = new PhotoPaint();

        Color[][] image = {
                {Color.RED, Color.RED,  Color.BLUE, Color.RED,  Color.RED},
                {Color.RED, Color.BLUE, Color.BLUE, Color.BLUE, Color.RED},
                {Color.RED, Color.BLUE, Color.BLUE, Color.BLUE, Color.RED},
                {Color.RED, Color.RED,  Color.BLUE, Color.RED,  Color.RED}
        };
        solution.printImage(image);

        paint.paintFill(image, 0, 0, Color.RED);
        solution.printImage(image);

        paint.paintFill(image, 1, 1, Color.BLUE);
        solution.printImage(image);

        paint.paintFill(image, 1, 1, Color.GREEN);
        solution.printImage(image);
    }

    private void printImage(Color[][] image) {
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                System.out.format("%8s", image[r][c]);
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
}
