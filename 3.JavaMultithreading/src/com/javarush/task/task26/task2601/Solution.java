package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] testArr = {13, 8, 15, 5, 17};
//        Integer[] testArr ={2, 5, 6, 7, 21, 1};
//        Integer[] testArr = {1,2,3,4,6,5,7,8,9, 10};
//
//                sort(testArr);
//        for (int i = 0; i < testArr.length; i++) {
//            System.out.println(testArr[i]);
//        }
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        //find median:
        Arrays.sort(array);
//        int median = array[ (array.length % 2 == 1) ? array.length / 2 : array.length / 2 -1];

        final double median;
        if (array.length % 2 == 0)
            median = (array[array.length /2 - 1] + array[array.length / 2]) / 2;
        else
            median = array[array.length / 2];

        //System.out.println("median = " + median);

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int res = Double.compare(Math.abs(o1 - median), Math.abs(o2 - median));
                if (res == 0) {
                    res = o1 - o2;
                }
                return res;
            }
        });

        return array;
    }


}
