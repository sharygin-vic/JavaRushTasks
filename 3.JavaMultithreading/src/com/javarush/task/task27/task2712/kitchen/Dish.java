package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by dell on 16-May-17.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private final int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder sb = new StringBuilder();
        Dish[] vals = Dish.values();
        for (int i = 0; i < vals.length; i++) {
            sb.append(vals[i]).append(", ");
        }
        return sb.substring(0, sb.length()-2);
    }
}
