package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<FileInputStream> files = new ArrayList<FileInputStream>();
        do {
            FileInputStream f = new FileInputStream(r.readLine());
            files.add(f);
            int fileSize = 0;

            byte[] data = new byte[1024];
            fileSize = f.read(data);

            if (fileSize < 1000) {
                r.close();
                for (FileInputStream curFile : files) {
                    curFile.close();
                }
                throw new DownloadException();
            }
        } while (true);
    }

    public static class DownloadException extends Exception {

    }
}
