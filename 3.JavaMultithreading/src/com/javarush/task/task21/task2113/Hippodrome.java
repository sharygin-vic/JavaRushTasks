package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 18-Apr-17.
 */
public class Hippodrome /*implements  Runnable*/ {
    private static List<Horse> horses = new ArrayList<Horse>();
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(horses);
        game.horses.add(new Horse("Bulat", 3, 0));
        game.horses.add(new Horse("Sivka", 3, 0));
        game.horses.add(new Horse("Burka", 3, 0));


        //new Thread(game).start();
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse maxDistHorse = horses.get(0);

        for (int i = 1; i < horses.size(); i++) {
            Horse horse = horses.get(i);
            if (horse.getDistance() > maxDistHorse.getDistance()) {
                maxDistHorse = horse;
            }
        }
        return maxDistHorse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
