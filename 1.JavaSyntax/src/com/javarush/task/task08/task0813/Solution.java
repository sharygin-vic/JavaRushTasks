package com.javarush.task.task08.task0813;

import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static HashSet<String> createSet() {
        //напишите тут ваш код
        HashSet<String> res = new HashSet<String>();
        for (int i =0; i < 20; i++) {
            res.add("Лрпарвс" + i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
