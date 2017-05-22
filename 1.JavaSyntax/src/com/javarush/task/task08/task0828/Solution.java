package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> monthes = new ArrayList<String>();
        monthes.add("January");
        monthes.add("February");
        monthes.add("March");
        monthes.add("April");
        monthes.add("May");
        monthes.add("June");
        monthes.add("July");
        monthes.add("August");
        monthes.add("September");
        monthes.add("October");
        monthes.add("November");
        monthes.add("December");

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        for (int i = 0; i < monthes.size(); i++) {
            if (s.toUpperCase().equals(monthes.get(i).toUpperCase())) {
                System.out.println(s + " is " + (i+1) + " month");
                break;
            }
        }
    }
}
