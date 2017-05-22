package com.javarush.task.task15.task1516;

/* 
Значения по-умолчанию
*/

public class Solution {
    public  int intVar;
    public  double doubleVar;
    public  Double DoubleVar;
    public  boolean booleanVar;
    public  Object ObjectVar;
    public  Exception ExceptionVar;
    public  String StringVar;

    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(o.intVar);
        System.out.println(o.doubleVar);
        System.out.println(o.DoubleVar);
        System.out.println(o.booleanVar);
        System.out.println(o.ObjectVar);
        System.out.println(o.ExceptionVar);
        System.out.println(o.StringVar);
    }


}
