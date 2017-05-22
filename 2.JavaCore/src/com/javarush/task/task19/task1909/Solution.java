package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(r.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(r.readLine()));
        r.close();

        while(fr.ready()) {
            String s = fr.readLine();
            s = s.replace(".", "!") + "\n";
            fw.write(s);
        }


        fr.close();;
        fw.close();
    }
}
//c:\r\2.txt
//c:\r\3.txt