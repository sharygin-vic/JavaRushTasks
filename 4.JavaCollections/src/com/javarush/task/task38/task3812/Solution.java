package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        // vic  ->
        boolean res = false;
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            String[] fullyQualifiedNames = ((PrepareMyTest)c.getAnnotation(PrepareMyTest.class)).fullyQualifiedNames();
            for (String s : fullyQualifiedNames) {
                System.out.println(s);
            }
            res = true;
        }
        return res;
        // <-  vic
    }

    public static boolean printValues(Class c) {
        // vic  ->
        boolean res = false;
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            Class<?>[] values = ((PrepareMyTest)c.getAnnotation(PrepareMyTest.class)).value();
            for (Class clazz : values) {
                System.out.println(clazz);
            }
            res = true;
        }
        return res;
        // <-  vic
    }
}
