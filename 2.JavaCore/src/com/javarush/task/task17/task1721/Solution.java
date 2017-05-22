package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader allLinesReader = null;
        BufferedReader forRemoveLinesReader = null;
        try {
            String allLinesFileName = r.readLine();
            String forRemoveLinesFileName = r.readLine();
            allLinesReader = new BufferedReader(new FileReader(allLinesFileName));
            forRemoveLinesReader = new BufferedReader(new FileReader(forRemoveLinesFileName));
            String tmp;
            while ((tmp = allLinesReader.readLine()) != null) {
                allLines.add(tmp);
            }
            while ((tmp = forRemoveLinesReader.readLine()) != null) {
                forRemoveLines.add(tmp);
            }

            new Solution().joinData();

            //debug
            //System.out.println(allLines);

        }
        catch (CorruptedDataException e) {

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                r.close();
            } catch (IOException e) {}
            try {
                allLinesReader.close();
            } catch (IOException e) {}
            try {
                forRemoveLinesReader.close();
            } catch (IOException e) {}
        }
    }

    public void joinData () throws CorruptedDataException {
        boolean ok = true;
        for (String s : forRemoveLines) {
            if (!allLines.contains(s)) {
                ok = false;
                break;
            }
        }
        if (ok) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}

//c:\r\1.txt