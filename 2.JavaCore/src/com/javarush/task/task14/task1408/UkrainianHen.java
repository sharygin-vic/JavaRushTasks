package com.javarush.task.task14.task1408;

/**
 * Created by dell on 14-Mar-17.
 */
class UkrainianHen extends Hen {
    int getCountOfEggsPerMonth(){
        return 150;
    };

    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}