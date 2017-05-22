package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            String uri = r.readLine();
            String paramsStr = uri.substring(uri.indexOf('?')+1);

            String paramNames = null;
            String objVal = null;
            String[] pairs = paramsStr.split("&");
            for (String pair : pairs) {
                String[] pairArr = pair.split("=");
                if (paramNames == null) {
                    paramNames = pairArr[0];
                }
                else {
                    paramNames += " " + pairArr[0];
                }
                if ("obj".equals(pairArr[0])) {
                    objVal = pairArr[1];
                }
            }
            System.out.println(paramNames);

            if (objVal != null) {
                try {
                    double d = Double.parseDouble(objVal);
                    alert(d);
                }
                catch (NumberFormatException e) {
                    alert(objVal);
                }
            }

        }
        catch (IOException e) {

        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
