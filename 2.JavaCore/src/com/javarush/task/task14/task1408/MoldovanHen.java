package com.javarush.task.task14.task1408;

/**
 * Created by dell on 14-Mar-17.
 */
class MoldovanHen extends Hen {
    int getCountOfEggsPerMonth(){
        return 140;
    };

    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
