package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String fName = r.readLine();
            loadRecords(fName);
            r.close();

            if (args[0].equals("-c") && args.length >= 4) {
                String[] argsParsed = getArgsParsed(args);

                records.add(getNormalizedStr("" + (getMaxId() + 1), 8)
                        + getNormalizedStr(argsParsed[1], 30)
                        + getNormalizedStr(argsParsed[2], 8)
                        + getNormalizedStr(argsParsed[3], 4)
                );
                writeRecords(fName);
            }
        }
    }

    private static String[] getArgsParsed(String[] args) {
        StringBuilder sb = new StringBuilder();
        String[] res = new String[4];
        res[0] = args[0];
        res[3] = args[args.length-1];
        res[2] = args[args.length-2];
        for ( int i = 1; i < args.length-2; i++) {
            sb.append(args[i]).append(" ");
        }
        res[1] = sb.toString().trim();
        return res;
    }

    private static String getNormalizedStr(String s, int length) {
        if (s.length() == length) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        if (s.length() > length) {
            sb.setLength(length);
            return sb.toString();
        }
        else {
            int startLength = sb.length();
            for (int i = 0; i < length - startLength; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }

    private static List<String> records = new ArrayList<String >();

    private static void loadRecords(String fileName) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader(fileName));
        records.clear();
        while (r.ready()) {
            records.add(r.readLine());
        }
        r.close();
    }

    private static void writeRecords(String fileName) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
        for (String s : records) {
            wr.write(s + "\n");
        }
        wr.close();
    }

    private static long getMaxId() {
        long maxId = -1;

        for (String s : records) {
            String strCurId = s.substring(0, 8).trim();
            long curId = Long.parseLong(strCurId);
            if (curId > maxId) {
                maxId = curId;
            }
        }
        return maxId;
    }
}
//c:\r\1.txt
//-c asasas fdfdfd 111 99