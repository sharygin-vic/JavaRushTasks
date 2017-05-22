package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(r.readLine()));
        }

        int maxCount = 0;
        int curCount = 1;
        int curVal = list.get(0).intValue();
        for (int i = 1; i < list.size(); i++) {
             if (list.get(i).intValue() == curVal) {
                 curCount++;
             } else if (curCount > maxCount){
                 maxCount = curCount;
                 curCount = 1;
                 curVal = list.get(i).intValue();
             }
        }
        if (curCount > maxCount){
            maxCount = curCount;
        }
        System.out.println(maxCount);
    }
}