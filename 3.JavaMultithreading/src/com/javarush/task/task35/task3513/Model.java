package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 24-May-17.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;


    public Model() {
        resetGameTiles();
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

    private void compressTiles(Tile[] tiles){
        for (int j = 0; j < FIELD_WIDTH-1; j++) {
            for (int i = FIELD_WIDTH - 1; i > j; i--) {
                if (tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                    tiles[i - 1].value = tiles[i].value;
                    tiles[i].value = 0;
                }
            }
        }
    }

    private void mergeTiles(Tile[] tiles) {
        for (int i = 1; i < FIELD_WIDTH; i++) {
            if (tiles[i-1].value == tiles[i].value) {
                tiles[i-1].value *= 2;
                if (tiles[i-1].value > maxTile) {
                    maxTile = tiles[i-1].value;
                }
                score += tiles[i-1].value;
                for (int j = i+1; j < FIELD_WIDTH; j++) {
                    tiles[j-1].value = tiles[j].value;
                }
                tiles[FIELD_WIDTH-1].value = 0;
            }
        }
    }
}
