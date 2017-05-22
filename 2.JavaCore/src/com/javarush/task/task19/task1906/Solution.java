package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameIn = r.readLine();
        String nameOut = r.readLine();
        r.close();
        FileReader fr = new FileReader(nameIn);
        FileWriter fw = new FileWriter(nameOut);
        long curNum = 0;
        while (fr.ready()) {
            curNum++;
            int ch = fr.read();
            if (curNum % 2 == 0) {
                fw.write(ch);
            }
        }
        fr.close();
        fw.close();
    }
}
