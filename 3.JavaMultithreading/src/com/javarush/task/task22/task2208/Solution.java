package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry item : params.entrySet()) {
            if (item.getValue() != null) {
                if (sb.length() > 0) {
                    sb.append(" and ").append(item.getKey()).append(" = '").append(item.getValue()).append("'");
                }
                else {
                    sb.append(item.getKey()).append(" = '").append(item.getValue()).append("'");
                }
            }
        }

        return sb.toString();
    }
}
