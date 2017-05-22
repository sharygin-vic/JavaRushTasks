package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        List<String> fileNames = new ArrayList<String>();
        String s;
        while (!(s = r.readLine()).equals("end")) {
            fileNames.add(s);
        }
        String targetFileName = fileNames.get(0).substring(0, fileNames.get(0).lastIndexOf('.'));
        //System.out.println(targetFileName);
        FileOutputStream fileOut = new FileOutputStream(targetFileName);
        byte[] buf = new byte[1000];
        int bufCount;
        int curIndex = -1;
        int wroteFiles = 0;
        while (wroteFiles < fileNames.size()) {
            curIndex++;
            String curFileName = targetFileName + ".part" + curIndex;
            if (fileNames.contains(curFileName)) {
                wroteFiles++;
                FileInputStream fileIn = new FileInputStream(curFileName);
                while (fileIn.available() > 0) {
                    bufCount = fileIn.read(buf);
                    fileOut.write(buf, 0, bufCount);
                }
                fileIn.close();
            }
        }

        fileOut.close();
    }
}
