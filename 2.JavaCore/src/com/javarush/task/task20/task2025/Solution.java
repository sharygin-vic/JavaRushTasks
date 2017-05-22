package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    // 9,223,372,036,854,775,807  - max long

    private static long[][] values; // = new long[10][19];
    private static int nRang;

    //List<Long> res = new LinkedList<Long>();
    private static List<Long> res = new ArrayList<Long>();

    public static long[] getNumbers(long N) {
        prepare(N);
        searchNumbers(N);

        long[] result = new long[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private static void prepare(long N) {
        String s = "" + N;
        nRang = s.length();
        values = new long[10][nRang];

        for (int curRang = 0; curRang < nRang; curRang++) {
            values[0][curRang] = 0;
        }

        for (int curRang = 0; curRang < nRang; curRang++) {
            values[1][curRang] = 1;
        }

        for (int digit = 0; digit < 10; digit++) {
            values[digit][0] = 1;
        }

        for (int digit = 2; digit < 10; digit++) {
            for (int curRang = 1; curRang < nRang; curRang++) {
                values[digit][curRang] = values[digit][curRang-1] * digit;
            }
        }

        //test
        StringBuilder sb = new StringBuilder();
        for (int digit = 0; digit < 10; digit++) {
            for (int curRang = 0; curRang < nRang; curRang++) {
                sb.append(values[digit][curRang]).append("  ");
            }
            System.out.println(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    private static void searchNumbers(long N) {
        //for (long curLong = 1; curLong <= N; curLong++) {}

        for (int curRange = 1; curRange <= nRang; curRange++) {

        }
    }

    public static void main(String[] args) {
        long[] res = getNumbers(9223372036854775807L);
        //long[] res = getNumbers(100000000000L);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i]);
//        }
    }
}
