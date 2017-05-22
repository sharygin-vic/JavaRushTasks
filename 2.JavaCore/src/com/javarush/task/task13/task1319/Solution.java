package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fName = r.readLine();
        BufferedWriter outWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream (fName)));
        ArrayList<String> list = new ArrayList<String>();
        try {


            //list.add(fName);
            String curStr;
            do {
                curStr = r.readLine();
                list.add(curStr);
            }
            while ( !curStr.equals("exit"));

            for (String s : list) {
                outWriter.write(s + "\n");
            }
            outWriter.flush();
        }
//        catch (IOException e) {
//
//        }
        finally {
            //try {
                //r.close();
                outWriter.close();
//            }
//            catch (IOException e) {
//
//            }
        }

    }
}
// c:\r\out.txt