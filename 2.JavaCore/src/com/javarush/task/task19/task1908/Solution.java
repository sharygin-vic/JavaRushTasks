package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    private static String delimiters = " .,:!?;()\\'\"/{}<>\n";
    private static String numbers = "0123456789";

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(r.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(r.readLine()));
        //long countWords = 0;
        boolean wordStarted = false;
        boolean numberStarted = false;
        StringBuilder sb = new StringBuilder();
        while (fr.ready()) {
            char ch = (char) fr.read();
            if (delimiters.indexOf(ch, 0) >= 0) {  // it is a delimiter char
                if (numberStarted && !wordStarted) {
                    sb.append(" ");
                    //System.out.print(sb.toString());
                    fw.write(sb.toString());
                }
                if (numberStarted || wordStarted) {
                    sb.delete(0, sb.length());
                }
                wordStarted = false;
                numberStarted = false;
            }
            else {
                if (numbers.indexOf(ch, 0) >= 0) {
                    if (!wordStarted) {
                        numberStarted = true;
                    }
                }
                else {
                    wordStarted = true;
                }
                sb.append(ch);
            }
        }
        if (numberStarted && !wordStarted) {
            //sb.append(" ");
            //System.out.print(sb.toString());
            fw.write(sb.toString());
        }
        r.close();
        fr.close();
        fw.close();
    }
}
//c:\r\2.txt