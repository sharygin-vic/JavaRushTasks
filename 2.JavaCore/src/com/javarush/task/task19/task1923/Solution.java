package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        FileWriter fw = new FileWriter(args[1]);

        String num = "0123456789";

        while (fr.ready()) {
            String s = fr.readLine();
            String[] words = s.split(" ");
            for (String word : words) {
                for (int i=0; i<num.length(); i++) {
                    if (word.indexOf(num.charAt(i)) >= 0) {
                        fw.write(word + " ");
                        break;
                    }
                }
            }
        }


        fr.close();
        fw.close();
    }
}
