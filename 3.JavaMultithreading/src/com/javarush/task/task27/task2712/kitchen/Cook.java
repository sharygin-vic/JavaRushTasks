package com.javarush.task.task27.task2712.kitchen;



import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by dell on 16-May-17.
 */
public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", arg.toString(), ((Order)arg).getTotalCookingTime()));
        StatisticManager.getInstance().register(new CookedOrderEventDataRow( ((Tablet) o).toString(), name, ((Order)arg).getTotalCookingTime() * 60, ((Order)arg).getDishes()));
//        StatisticManager.getInstance().register(new CookedOrderEventDataRow( ((Order)arg).getTablet().toString(), name, ((Order)arg).getTotalCookingTime() * 60, ((Order)arg).getDishes()));
        setChanged();
        this.notifyObservers(arg);

    }


}
