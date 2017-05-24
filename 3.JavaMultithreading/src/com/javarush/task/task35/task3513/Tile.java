package com.javarush.task.task35.task3513;

import java.awt.*;

/**
 * Created by dell on 24-May-17.
 */
public class Tile {
    int value;

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
//        this.value = 0;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public Color getFontColor() {
        if (value < 16) {
            return new Color(0x776e65);
        }
        else {
            return new Color(0xf9f6f2);
        }
    }

    public  Color getTileColor() {
        int colorValue = 0xff0000;
        switch (value) {
            case 0 :
                colorValue = 0xcdc1b4;
                break;
            case  2:
                colorValue = 0xeee4da;
                break;
            case  4:
                colorValue = 0xede0c8;
                break;
            case 8 :
                colorValue = 0xf2b179;
                break;
            case 16 :
                colorValue = 0xf59563;
                break;
            case 32 :
                colorValue = 0xf67c5f;
                break;
            case 64 :
                colorValue = 0xf65e3b;
                break;
            case 128 :
                colorValue = 0xedcf72;
                break;
            case 256 :
                colorValue = 0xedcc61;
                break;
            case 512 :
                colorValue = 0xedc850;
                break;
            case 1024 :
                colorValue = 0xedc53f;
                break;
            case 2048 :
                colorValue = 0xedc22e;
                break;
        }

        return new Color(colorValue);
    }
}
