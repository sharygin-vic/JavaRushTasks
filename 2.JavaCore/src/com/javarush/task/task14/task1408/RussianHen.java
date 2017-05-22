package com.javarush.task.task14.task1408;

/**
 * Created by dell on 14-Mar-17.
 */
class RussianHen extends Hen {
    int getCountOfEggsPerMonth(){
        return 100;
    };

    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
