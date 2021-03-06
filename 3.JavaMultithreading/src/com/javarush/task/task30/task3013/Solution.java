package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код
        number |= (number >> 1);
        number |= (number >> 2);
        number |= (number >> 4);
        number |= (number >> 8);
        number |= (number >> 16);
        return (number & ~(number>>1));



//        return
//////        (number & ((((1 << 7) << 8) << 8) << 8)) == ((((1 << 7) << 8)<< 8) << 8) ?  ((((1 << 7) << 8) << 8) << 1) :
//                (number & ((((1 << 7) << 8) << 8) << 7)) == ((((1 << 7) << 8)<< 8) << 7) ?  ((((1 << 7) << 8) << 8) << 7) :
//                (number & ((((1 << 7) << 8) << 8) << 6)) == ((((1 << 7) << 8)<< 8) << 6) ?  ((((1 << 7) << 8) << 8) << 6) :
//                (number & ((((1 << 7) << 8) << 8) << 5)) == ((((1 << 7) << 8)<< 8) << 5) ?  ((((1 << 7) << 8) << 8) << 5) :
//                (number & ((((1 << 7) << 8) << 8) << 4)) == ((((1 << 7) << 8)<< 8) << 4) ?  ((((1 << 7) << 8) << 8) << 4) :
//                (number & ((((1 << 7) << 8) << 8) << 3)) == ((((1 << 7) << 8)<< 8) << 3) ?  ((((1 << 7) << 8) << 8) << 3) :
//                (number & ((((1 << 7) << 8) << 8) << 2)) == ((((1 << 7) << 8)<< 8) << 2) ?  ((((1 << 7) << 8) << 8) << 2) :
//                (number & ((((1 << 7) << 8) << 8) << 1)) == ((((1 << 7) << 8)<< 8) << 1) ?  ((((1 << 7) << 8) << 8) << 1) :
//
//                (number & (((1 << 7) << 8) << 8)) == (((1 << 7) << 8)<< 8) ?  (((1 << 7) << 8) << 8) :
//                (number & (((1 << 7) << 8) << 7)) == (((1 << 7) << 8)<< 7) ?  (((1 << 7) << 8) << 7) :
//                (number & (((1 << 7) << 8) << 6)) == (((1 << 7) << 8)<< 6) ?  (((1 << 7) << 8) << 6) :
//                (number & (((1 << 7) << 8) << 5)) == (((1 << 7) << 8)<< 5) ?  (((1 << 7) << 8) << 5) :
//                (number & (((1 << 7) << 8) << 4)) == (((1 << 7) << 8)<< 4) ?  (((1 << 7) << 8) << 4) :
//                (number & (((1 << 7) << 8) << 3)) == (((1 << 7) << 8)<< 3) ?  (((1 << 7) << 8) << 3) :
//                (number & (((1 << 7) << 8) << 2)) == (((1 << 7) << 8)<< 2) ?  (((1 << 7) << 8) << 2) :
//                (number & (((1 << 7) << 8) << 1)) == (((1 << 7) << 8)<< 1) ?  (((1 << 7) << 8) << 1) :
//
//                (number & ((1 << 7) << 8)) == ((1 << 7) << 8) ?  ((1 << 7) << 8) :
//                (number & ((1 << 7) << 7)) == ((1 << 7) << 7) ?  ((1 << 7) << 7) :
//                (number & ((1 << 7) << 6)) == ((1 << 7) << 6) ?  ((1 << 7) << 6) :
//                (number & ((1 << 7) << 5)) == ((1 << 7) << 5) ?  ((1 << 7) << 5) :
//                (number & ((1 << 7) << 4)) == ((1 << 7) << 4) ?  ((1 << 7) << 4) :
//                (number & ((1 << 7) << 3)) == ((1 << 7) << 3) ?  ((1 << 7) << 3) :
//                (number & ((1 << 7) << 2)) == ((1 << 7) << 2) ?  ((1 << 7) << 2) :
//                (number & ((1 << 7) << 1)) == ((1 << 7) << 1) ?  ((1 << 7) << 1) :
//
//                (number & (1 << 7)) == (1 << 7) ?  (1 << 7) :
//                (number & (1 << 6)) == (1 << 6) ?  (1 << 6) :
//                (number & (1 << 5)) == (1 << 5) ?  (1 << 5) :
//                (number & (1 << 4)) == (1 << 4) ?  (1 << 4) :
//                (number & (1 << 3)) == (1 << 3) ?  (1 << 3) :
//                (number & (1 << 2)) == (1 << 2) ?  (1 << 2) :
//                (number & (1 << 1)) == (1 << 1) ?  (1 << 1) :
//                (number & (1 << 0)) == (1 << 0) ?  (1 << 0) :
//
//                0;
    }
}