package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private static TreeMap<String, Double> map = new TreeMap<String, Double>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(args[0]));

        while (r.ready()) {
            String s = r.readLine();
            String[] ss = s.split(" ");
            double sum = Double.parseDouble(ss[1]);
            if (map.containsKey(ss[0])) {
                map.put(ss[0], map.get(ss[0]) + sum);
            }
            else {
                map.put(ss[0], sum);
            }
        }
        r.close();

        for (Map.Entry<String, Double> item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
