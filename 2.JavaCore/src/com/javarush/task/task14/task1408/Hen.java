package com.javarush.task.task14.task1408;

/**
 * Created by dell on 14-Mar-17.
 */
abstract class Hen {
    abstract int getCountOfEggsPerMonth();

    String getDescription() {
        return "Я - курица.";
    }
}
