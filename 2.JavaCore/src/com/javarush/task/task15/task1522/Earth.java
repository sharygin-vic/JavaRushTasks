package com.javarush.task.task15.task1522;

/**
 * Created by dell on 02-Apr-17.
 */
public class Earth implements Planet {
    private static Earth instance;

    private Earth() {};

    public static Earth getInstance() {
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }
}
