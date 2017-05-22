package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        List<String> list = new ArrayList<String>();
        do {
            list.add(e.getClass().getName() + ": " + e.getMessage());
            e = e.getCause();
        } while (e != null);

        for (int i = list.size()-1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
//        Thread.currentThread().setUncaughtExceptionHandler(new Solution());
//        try {
//            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
//        }
//        catch (Throwable e) {
//
//            List<String> list = new ArrayList<String>();
//            do {
//                list.add(e.getClass().getName() + ": " + e.getMessage());
//                e = e.getCause();
//            } while (e != null);
//
//            for (int i = list.size()-1; i >= 0; i--) {
//                System.out.println(list.get(i));
//            }
//        }
    }
}
