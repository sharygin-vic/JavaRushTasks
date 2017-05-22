package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < 10; i++) {
            map.put("Lastname" + i, "Name" + ((i+10) % 7));
        }
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код

        HashMap<String, Integer> mapNames = new HashMap<String, Integer>();
        for (Map.Entry<String, String> item : map.entrySet()) {
            String name = item.getValue();
            if (!mapNames.containsKey(name)) {
                mapNames.put(name, 1);
            } else {
                Integer curCount = mapNames.get(name);
                mapNames.put(name, curCount + 1);
            }
        }
        //System.out.println(mapNames);

        for (Map.Entry<String, Integer> item : mapNames.entrySet()) {
            if (item.getValue() > 1) {
                removeItemFromMapByValue(map, item.getKey());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
//        HashMap<String, String> map = createMap();
//        System.out.println(map);
//        removeTheFirstNameDuplicates(map);
//        System.out.println(map);
    }
}
