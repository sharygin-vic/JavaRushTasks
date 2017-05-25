package com.javarush.task.task35.task3513;

/**
 * Created by dell on 25-May-17.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency > {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency  o) {
        if (o == null) return 1;
        if (!(o instanceof MoveEfficiency)) return 1;
        int res = Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles);
        if (res  == 0) {
            res = Integer.compare(score, o.score);
        }
        return res;
    }
}
