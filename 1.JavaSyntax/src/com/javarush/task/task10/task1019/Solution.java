package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (true) {
            int id;
            try {
                id = Integer.parseInt(reader.readLine());
            }
            catch (NumberFormatException e){
                break;
            }
            String name = reader.readLine();
            if (name.isEmpty())
                break;
            map.put(name, id);
        }

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            //System.out.println("Id=" + item.getKey() + " Name=" + item.getValue());
            System.out.println(item.getValue() + " " + item.getKey());
        }
    }
}
