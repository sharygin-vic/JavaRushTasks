package com.javarush.task.task08.task0816;

import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        Date start = new Date("JUNE 1 1980");
        for (int i = 1; i < 10; i++) {
            map.put("Stallone" + i, new Date(start.getTime() + (long)i*37*24*60*60*1000));
        }
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Set<Map.Entry<String, Date>> set = map.entrySet();
        Iterator<Map.Entry<String, Date>> iterator = set.iterator();
        Set<Map.Entry<String, Date>> setDel = new HashSet<Map.Entry<String, Date>>();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> item = iterator.next();
            int month = item.getValue().getMonth()+1;
            if (month > 5 && month < 9) {
                setDel.add(item);
            }
        }
        Iterator<Map.Entry<String, Date>> iteratorDel = setDel.iterator();
        while (iteratorDel.hasNext()) {
            Map.Entry<String, Date> item = iteratorDel.next();
                map.remove(item.getKey());
        }
    }

    public static void main(String[] args) {
        //HashMap<String, Date> map = createMap();
        //removeAllSummerPeople(map);
    }
}
