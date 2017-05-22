package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static String delimiters = ".,:!?;()\\'\"/{}<>\n\t";

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameIn = r.readLine();
        String nameOut = r.readLine();
        r.close();

        //=======================================
//        BufferedReader fr = new BufferedReader(new FileReader(nameIn));
//        BufferedWriter fw = new BufferedWriter(new FileWriter(nameOut));
//
//        while (fr.ready()) {
//            char ch = (char) fr.read();
//            if (delimiters.indexOf(ch, 0) < 0) {
//                fw.write(ch);
//            }
//        }
//
//        fr.close();
//        fw.close();

        //=========================================
        BufferedReader fr = new BufferedReader(new FileReader(nameIn));

        List<String> data = new ArrayList<String>();

        while (fr.ready()) {
            data.add(fr.readLine());
        }
        fr.close();

        BufferedWriter fw = new BufferedWriter(new FileWriter(nameOut));
        for (String s : data) {
            //String tmp = s.replaceAll("[ (.),:;!?—-]", "");
            String tmp = s.replaceAll("[\\p{Punct} \n]", "");
            fw.write(tmp);
        }
        fw.close();
    }
}
//c:\r\2.txt
//c:\r\3.txt