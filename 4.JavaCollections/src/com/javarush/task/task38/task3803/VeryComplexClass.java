package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.ArrayList;
import java.util.List;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        int sum = 0;
        List<Object> numbers = new ArrayList<Object>();
        numbers.add(new Integer(5));
        numbers.add(new String("tyrudfk"));
        for (Object o : numbers) {
            sum += (Integer) o;
        }
    }

    public void methodThrowsNullPointerException() {
        VeryComplexClass veryComplexClass = null;
        veryComplexClass.methodThrowsClassCastException();
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.methodThrowsClassCastException();
        veryComplexClass.methodThrowsNullPointerException();
    }
}
