package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        List<FileInputStream> files = new ArrayList<FileInputStream>();
        String fileName = null;
//        while (true) {
            try {
                while (true) {
                    fileName = r.readLine();
                    FileInputStream fs = new FileInputStream(fileName);
                    files.add(fs);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println(fileName);
                return;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                for (FileInputStream fs : files) {
                    try {
                        fs.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//        }
    }
}
