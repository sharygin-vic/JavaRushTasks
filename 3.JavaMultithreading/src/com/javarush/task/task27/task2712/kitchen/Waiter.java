package com.javarush.task.task27.task2712.kitchen;



import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by dell on 17-May-17.
 */
public class Waiter implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(arg + " was cooked by " + o);   // order = arg;  cook = o
    }
}
