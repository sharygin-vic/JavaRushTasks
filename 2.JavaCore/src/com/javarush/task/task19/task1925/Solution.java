package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        FileWriter fw = new FileWriter(args[1]);

        StringBuilder sb = new StringBuilder();
        while (fr.ready()) {
            String s = fr.readLine();
            String[] ss = s.split(" ");
            for (String word : ss) {
                if (word.length() > 6) {
                    sb.append(word).append(",");
                }
            }
        }

        fw.write(sb.substring(0, sb.length()-1));

        fr.close();
        fw.close();
    }
}
