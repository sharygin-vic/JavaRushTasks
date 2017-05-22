package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private static TreeMap<String, Double> map = new TreeMap<String, Double>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] result = line.split("\\s");
            if (map.containsKey(result[0])) {
                map.put(result[0], map.get(result[0]) + Double.parseDouble(result[1]));
            } else {
                map.put(result[0], Double.parseDouble(result[1]));
            }
        }

        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() >= max) {
                max = pair.getValue();
            }
        }
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() == max) {
                System.out.println(pair.getKey());
            }
        }

        reader.close();
    }
}
