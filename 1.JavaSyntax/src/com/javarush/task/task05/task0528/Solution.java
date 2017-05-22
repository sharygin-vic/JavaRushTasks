package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Date date = new Date();
        //System.out.println(date.toString());
        System.out.println("" + date.getDate() + " " + (date.getMonth() + 1) + " " + (date.getYear() + 1900));
    }
}
