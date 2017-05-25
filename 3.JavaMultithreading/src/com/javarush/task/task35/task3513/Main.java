package com.javarush.task.task35.task3513;

import javax.swing.*;

/**
 * Created by dell on 24-May-17.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game = new JFrame();
        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);

        game.add(controller.getView());


        game.setLocationRelativeTo(null);
        game.setVisible(true);


//        Tile[][] gameTiles = model.getGameTiles();
//        gameTiles[0][0].value = 1; gameTiles[0][1].value = 5; gameTiles[0][2].value = 3; gameTiles[0][3].value = 4;
//        gameTiles[1][0].value = 2; gameTiles[1][1].value = 1; gameTiles[1][2].value = 7; gameTiles[1][3].value = 5;
//        gameTiles[2][0].value = 5; gameTiles[2][1].value = 4; gameTiles[2][2].value = 3; gameTiles[2][3].value = 2;
//        gameTiles[3][0].value = 1; gameTiles[3][1].value = 2; gameTiles[3][2].value = 1; gameTiles[3][3].value = 0;
//        System.out.println(model);
//        System.out.println(model.canMove());
//        //model.left();
//        //model.right();
//        model.up();
//        //model.down();
//        System.out.println(model.canMove());
//        System.out.println(model);
    }
}
