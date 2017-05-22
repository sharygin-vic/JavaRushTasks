package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static List<String> lines1;
    public static List<String> lines2;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name1 = r.readLine();
        String name2 = r.readLine();
        r.close();

        lines1 = readFile(name1);
        lines2 = readFile(name2);

        compare();

        //test print
//        for (LineItem item : lines) {
//            System.out.println(item.type + "  " + item.line);
//        }
        //System.out.println(lines1);
        //System.out.println(lines2);
    }

    private static List<String> readFile(String name) throws IOException {
        List<String> list = new ArrayList<String>();
        BufferedReader r = new BufferedReader(new FileReader(name));

        while(r.ready()) {
            list.add(r.readLine());
        }

        r.close();
        return list;
    }

    private static void compare() {
        int i1 = 0;
        int i2 = 0;
        while (i1 < lines1.size()-1 || i2 < lines2.size()-1) {
            if (lines1.get(i1).equals(lines2.get(i2))) {
                lines.add(new LineItem(Type.SAME, lines1.get(i1)));
                i1++;
                i2++;
            }
            else if (lines1.get(i1).equals(lines2.get(i2+1))) {
                lines.add(new LineItem(Type.ADDED, lines2.get(i2)));
                i2++;
            }
            else if (lines1.get(i1+1).equals(lines2.get(i2)) ) {
                lines.add(new LineItem(Type.REMOVED, lines1.get(i1)));
                i1++;
            }
        }
        if ((i1==lines1.size()-1) && (i2 == lines2.size())) {
            lines.add(new LineItem(Type.REMOVED, lines1.get(i1)));
        }
        else if ((i1==lines1.size()) && (i2 == lines2.size()-1)) {
            lines.add(new LineItem(Type.ADDED, lines2.get(i2)));
        }
    }



    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
// c:\r\1.txt
// c:\r\2.txt