package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
        for (Word w : words) {
            System.out.println(w.toString());
        }
    }

    private static Word getWord(int[][] crossword, String word, int startX, int startY, int dirX, int dirY) {
        Word res = null;
        boolean wordOk = true;
        int testCharX = startX;
        int testCharY = startY;
        for (int i = 1; i < word.length(); i++) {
            testCharX += dirX;
            testCharY += dirY;
            if ( !(testCharX >= 0 && testCharX < crossword.length && testCharY >= 0 && testCharY < crossword[0].length && word.charAt(i)==crossword[testCharX][testCharY])) {
                wordOk = false;
                break;
            }
        }
        if (wordOk) {
            res = new Word(word);
            res.setStartPoint(startY, startX);
            res.setEndPoint(testCharY, testCharX);
        }
        return res;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> resWords = new ArrayList<Word>();
        for (String s : words) {
            char firstChar = s.charAt(0);
            for (int startX = 0; startX < crossword.length; startX++) {
                for (int startY = 0; startY < crossword[0].length; startY++) {
                    if (firstChar == crossword[startX][startY]) {
                        for (int dirX = -1; dirX <= 1; dirX++) {
                            for (int dirY = -1; dirY <= 1; dirY++) {
                                Word w = getWord(crossword, s, startX, startY, dirX, dirY);
                                if (w != null) {
                                    resWords.add(w);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        // source array (crossword) reading test
//        int startX;
//        int startY;
//        StringBuilder sb = new StringBuilder();
//        for (startX = 0; startX < crossword.length; startX++) {
//            for (startY = 0; startY < crossword[0].length; startY++) {
//                sb.append((char)crossword[startX][startY]).append(" ");
//            }
//            System.out.println(sb.toString());
//            sb.delete(0, sb.length());
//        }

        return resWords;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
