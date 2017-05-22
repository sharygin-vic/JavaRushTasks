package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> res = new HashMap<String, String>();

        res.put("Lastname0", "Name0");
        res.put("Lastname1", "Name1");
        res.put("Lastname2", "Name0");
        res.put("Lastname3", "Name2");
        res.put("Lastname4", "Name3");
        res.put("Lastname5", "Name4");
        res.put("Lastname0", "Name5");
        res.put("Lastname6", "Name0");
        res.put("Lastname7", "Name2");
        res.put("Lastname0", "Name3");

        return res;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
