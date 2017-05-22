package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<String, Cat>();
        map.put("Cata", new Cat("Cata"));
        map.put("Catb", new Cat("Catb"));
        map.put("Catc", new Cat("Catc"));
        map.put("Catd", new Cat("Catd"));
        map.put("Cate", new Cat("Cate"));
        map.put("Catf", new Cat("Catf"));
        map.put("Catg", new Cat("Catg"));
        map.put("Catr", new Cat("Catr"));
        map.put("Catt", new Cat("Catt"));
        map.put("Catu", new Cat("Catu"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
//        Set<Cat> set = new HashSet<Cat>();
//        for (Cat cat : map.values()) {
//            set.add(cat);
//        }
//        return set;
        Set<Cat> convert = new HashSet<>();
        for (Map.Entry<String,Cat> pair:map.entrySet()) {
            convert.add(pair.getValue());
        }
        return convert;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }

}
