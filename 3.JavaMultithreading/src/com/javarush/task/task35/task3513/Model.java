package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by dell on 24-May-17.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    Stack<Tile[][]> previousStates = new Stack<Tile[][]>();
    Stack<Integer> previousScores = new Stack<Integer>();
    boolean  isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    private void saveState(Tile[][] tiles, int score) {
        isSaveNeeded = false;

        //previousStates.push(cloneGameTiles(tiles));
        previousStates.push(tiles);
        previousScores.push(score);
    }

    private Tile[][] cloneGameTiles(Tile[][] tiles) {
        Tile[][] t = tiles;
        if (t == null) {
            t = gameTiles;
        }
        Tile[][] tilesCopy = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tilesCopy[i][j] = new Tile(t[i][j].value);
            }
        }
        return tilesCopy;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
        score = 0;
        maxTile = 2;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) {
            int randomNum = (int)(Math.random() * emptyTiles.size());
            Tile tile = emptyTiles.get(randomNum);
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> res = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    res.add(gameTiles[i][j]);
                }
            }
        }
        return res;
    }

    private boolean compressTiles(Tile[] tiles){
        boolean res = false;
        for (int j = 0; j < FIELD_WIDTH - 1; j++) {
            for (int i = FIELD_WIDTH - 1; i > j; i--) {
                if (tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                        tiles[i - 1].value = tiles[i].value;
                        tiles[i].value = 0;
                        res = true;
                }
            }
        }
        return res;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean res = false;
        for (int i = 1; i < FIELD_WIDTH; i++) {
            if (tiles[i-1].value == tiles[i].value && !tiles[i].isEmpty()) {
                    tiles[i - 1].value *= 2;
                    if (tiles[i - 1].value > maxTile) {
                        maxTile = tiles[i - 1].value;
                    }
                    score += tiles[i - 1].value;
                    for (int j = i + 1; j < FIELD_WIDTH; j++) {
                        tiles[j - 1].value = tiles[j].value;
                    }
                    tiles[FIELD_WIDTH - 1].value = 0;
                    res = true;
            }
        }
        return res;
    }

    void left(){
        int changeCount = 0;
        Tile[][] srcState = cloneGameTiles(gameTiles);
        int srcScore = score;
        for (int i=0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                changeCount++;
            }
        }
        if (changeCount > 0) {
            addTile();
            saveState(srcState, srcScore);
        }
    }

    void right(){
        int changeCount = 0;
        Tile[][] srcState = cloneGameTiles(gameTiles);
        int srcScore = score;
        Tile[] tiles = new Tile[FIELD_WIDTH];
        for (int i=0; i < FIELD_WIDTH; i++) {
            for (int j = FIELD_WIDTH-1; j >= 0; j--) {
                tiles[FIELD_WIDTH - 1 - j] = gameTiles[i][j];
            }
            if (compressTiles(tiles) | mergeTiles(tiles)) {
                changeCount++;
            }
        }
        if (changeCount > 0) {
            addTile();
            saveState(srcState, srcScore);
        }
    }

    void down(){
        int changeCount = 0;
        Tile[][] srcState = cloneGameTiles(gameTiles);
        int srcScore = score;
        Tile[] tiles = new Tile[FIELD_WIDTH];
        for (int i=0; i < FIELD_WIDTH; i++) {
            for (int j = FIELD_WIDTH-1; j >= 0; j--) {
                tiles[FIELD_WIDTH - 1 - j] = gameTiles[j][i];
            }
            if (compressTiles(tiles) | mergeTiles(tiles)) {
                changeCount++;
            }
        }
        if (changeCount > 0) {
            addTile();
            saveState(srcState, srcScore);
        }
    }

    void up(){
        int changeCount = 0;
        Tile[][] srcState = cloneGameTiles(gameTiles);
        int srcScore = score;
        Tile[] tiles = new Tile[FIELD_WIDTH];
        for (int i=0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tiles[j] = gameTiles[j][i];
            }
            if (compressTiles(tiles) | mergeTiles(tiles)) {
                changeCount++;
            }
        }
        if (changeCount > 0) {
            addTile();
            saveState(srcState, srcScore);
        }
    }

    public boolean canMove() {
        if(!getEmptyTiles().isEmpty())
            return true;
        for(int i = 0; i < FIELD_WIDTH; i++) {
            for(int j = 1; j < FIELD_WIDTH; j++) {
                if(gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        }
        for(int j = 0; j < FIELD_WIDTH; j++) {
            for(int i = 1; i < FIELD_WIDTH; i++) {
                if(gameTiles[i][j].value == gameTiles[i-1][j].value)
                    return true;
            }
        }
        return false;
    }

    Tile[][] getGameTiles() {
        return gameTiles;
    }

    void randomMove() {
        switch (((int) (Math.random() * 100)) % 4) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<MoveEfficiency>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        queue.poll().getMove().move();
    }

    boolean hasBoardChanged() {
        return calculateTilesWaight(gameTiles) != calculateTilesWaight(previousStates.peek());
    }

    private int calculateTilesWaight(Tile[][] tiles) {
        int res = 0;
        for(int j = 0; j < FIELD_WIDTH; j++) {
            for(int i = 0; i < FIELD_WIDTH; i++) {
                res += tiles[i][j].value;
            }
        }
        return res;
    }

    MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency res;
        move.move();
        if (!hasBoardChanged()) {
            res = new MoveEfficiency(-1, 0, move);
        }
        else {
            res = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        rollback();
        return res;
    }

    @Override
    public String toString() {
        String res = String.format("score=%d  maxTile=%d%n%10d  %10d  %10d  %10d%n%10d  %10d  %10d  %10d%n%10d  %10d  %10d  %10d%n%10d  %10d  %10d  %10d%n==============%n",
                score, maxTile,
                gameTiles[0][0].value, gameTiles[0][1].value, gameTiles[0][2].value, gameTiles[0][3].value,
                gameTiles[1][0].value, gameTiles[1][1].value, gameTiles[1][2].value, gameTiles[1][3].value,
                gameTiles[2][0].value, gameTiles[2][1].value, gameTiles[2][2].value, gameTiles[2][3].value,
                gameTiles[3][0].value, gameTiles[3][1].value, gameTiles[3][2].value, gameTiles[3][3].value);
        return res;
    }
}
