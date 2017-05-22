package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by dell on 16-May-17.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }


    @Override
    public String toString() {
        String res;
        if (dishes.size() > 0) {
            res = String.format("Your order: %s of %s", dishes.toString(), tablet);
        }
        else {
            res = "";
        }
        return res;
    }

    public int getTotalCookingTime() {
        int res = 0;
        for (Dish dish : dishes) {
            res += dish.getDuration();
        }
        return res;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}
