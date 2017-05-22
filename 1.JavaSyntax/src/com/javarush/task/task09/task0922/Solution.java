package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        SimpleDateFormat in = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat out = new SimpleDateFormat("MMM dd, yyyy");
        Date date = in.parse(s);

        System.out.println(out.format(date).toUpperCase());

    }
}
