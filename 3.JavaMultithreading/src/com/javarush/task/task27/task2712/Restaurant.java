package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Locale;

/**
 * Created by dell on 16-May-17.
 */
public class Restaurant {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        Cook cook = new Cook("Amigo");
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        StatisticManager.getInstance().register(cook);




//        for (int i = 0; i < 11; i++) {
            tablet.createOrder();
//        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
