package com.javarush.task.task18.task1828;

/* 
Прайсы 2
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
                String[] argsParsed = getArgsParsedCreate(args);

                records.add(getNormalizedStr("" + (getMaxId() + 1), 8)
                        + getNormalizedStr(argsParsed[1], 30)
                        + getNormalizedStr(argsParsed[2], 8)
                        + getNormalizedStr(argsParsed[3], 4)
                );
                writeRecords(fName);
            }
            else if (args[0].equals("-u") && args.length >= 5) {
                //-u id productName price quantity
                String[] argsParsed = getArgsParsedUpdate(args);
                int index = getRecordNumById(argsParsed[1]);
                if (index != -1) {
                    records.set(index, getNormalizedStr(argsParsed[1], 8)
                                    + getNormalizedStr(argsParsed[2], 30)
                                    + getNormalizedStr(argsParsed[3], 8)
                                    + getNormalizedStr(argsParsed[4], 4)
                            );
                    writeRecords(fName);
                }
            }
            else if (args[0].equals("-d") && args.length >= 2) {
                //-d id
                int index = getRecordNumById(args[1]);
                if (index != -1) {
                    records.remove(index);
                    writeRecords(fName);
                }
            }
        }
    }

    private static List<String> records = new ArrayList<String >();

    private static int getRecordNumById(String id) {
        int res = -1;
        String strId = getNormalizedStr(id, 8);
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).startsWith(strId)) {
                res = i;
            }
        }
        return res;
    }

    private static String[] getArgsParsedCreate(String[] args) {
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

    private static String[] getArgsParsedUpdate(String[] args) {
        //-u id productName price quantity
        StringBuilder sb = new StringBuilder();
        String[] res = new String[5];
        res[0] = args[0];
        res[1] = args[1];
        res[4] = args[args.length-1];
        res[3] = args[args.length-2];
        for ( int i = 2; i < args.length-2; i++) {
            sb.append(args[i]).append(" ");
        }
        res[2] = sb.toString().trim();
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
