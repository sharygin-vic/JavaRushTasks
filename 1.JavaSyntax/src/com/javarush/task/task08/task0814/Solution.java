package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i= 0; i < 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        HashSet<Integer> res = new HashSet<Integer>();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer curIntger = iterator.next();
            if (curIntger.intValue() <= 10) {
                res.add(curIntger);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
