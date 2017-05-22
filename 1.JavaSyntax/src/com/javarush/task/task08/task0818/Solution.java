package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 10; i++) {
            map.put("Lastname" + i, 270 + 53*i);
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copyMap = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> item : copyMap.entrySet()) {
            if (item.getValue() < 500) {
                map.remove(item.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        HashMap<String, Integer> map = createMap();
//        System.out.println(map);
//
//        removeItemFromMap(map);
//        System.out.println(map);
    }
}