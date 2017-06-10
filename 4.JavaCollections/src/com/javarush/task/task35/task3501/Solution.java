package com.javarush.task.task35.task3501;
/* 
Вызов статического метода
*/
public class Solution {
    public static void main(String[] args) {
        Number number = GenericStatic.<Number>someStaticMethod(new Integer(3));

        number = GenericStatic.<Number>someStaticMethod(new Double(5.8));
        String str = GenericStatic.<String>someStaticMethod("8756");
    }
}
