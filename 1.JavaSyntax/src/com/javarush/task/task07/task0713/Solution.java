package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> listOther = new ArrayList<Integer>();

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(r.readLine()));
        }

        for ( int i = 0; i < list.size(); i++) {
            Integer val = list.get(i);
            boolean isOther = true;

            if (val % 2 == 0) {
                list2.add(val);
                isOther = false;
            }
            if (val % 3 == 0) {
                list3.add(val);
                isOther = false;
            }
            if (isOther) listOther.add(val);
        }

        printList(list3);
        printList(list2);
        printList(listOther);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
