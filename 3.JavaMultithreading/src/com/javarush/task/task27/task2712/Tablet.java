package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dell on 16-May-17.
 */
public class Tablet extends Observable {
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                ConsoleHelper.writeMessage(order.toString());

                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                try {
                    advertisementManager.processVideos();
                }
                catch (NoVideoAvailableException e) {
                    logger.log(Level.INFO, "No video is available for the order " + order);
                }

                setChanged();
                this.notifyObservers(order);
            }
        }
        catch (IOException e) {
            order = null;
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + '}';
    }
}
