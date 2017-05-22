package com.javarush.task.task14.task1408;

/**
 * Created by dell on 14-Mar-17.
 */
class BelarusianHen extends Hen {
    int getCountOfEggsPerMonth(){
        return 120;
    };

    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
