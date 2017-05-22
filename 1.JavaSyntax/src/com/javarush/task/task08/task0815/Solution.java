package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            map.put("Lastname" + i, "Name" + ((i+10) % 8));
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int res = 0;
        if (map.containsValue(name)) {
            for (String s :map.values()) {
                if (s.equals(name)) res++;
            }
        }
        return res;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        if (map.containsKey(lastName)) return 1;
        else return 0;
    }

    public static void main(String[] args) {

    }
}
