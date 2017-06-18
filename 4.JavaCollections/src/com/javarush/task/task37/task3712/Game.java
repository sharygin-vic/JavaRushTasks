package com.javarush.task.task37.task3712;

/**
 * Created by dell on 19-Jun-17.
 */
// vic :
public abstract class Game {
    public abstract void prepareForTheGame();

    public abstract void playGame();

    public abstract void congratulateWinner();

    public void run() {
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}
