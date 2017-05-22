package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
//        String fileName = "c:\\r\\3.txt";
        r.close();

        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (fr.ready()) {
            sb.append(fr.readLine());  //.append("\n");
        }
        fr.close();

        String start1 = "<" + args[0] + ">";
        String start2 = "<" + args[0] + " ";
        String stop = "</" + args[0] + ">";
        int stopLength = stop.length();

        String xml = sb.toString();

        getTagsArray(xml, start1, start2, stop);
        sortTags();
        extractTags(xml, 0, tags.size()-1, stopLength);

//        System.out.println(sb.toString());
//        for (Tag tag : tags) {
//            System.out.println(tag);
//        }
    }

    private static void getTagsArray(String xml, String start1, String start2, String stop) {
        tags.clear();
        int strPos = 0;
        while ((strPos = xml.indexOf(start1, strPos+1)) >= 0) {
            tags.add(new Tag(strPos, true));
        }
        strPos = 0;
        while ((strPos = xml.indexOf(start2, strPos+1)) >= 0) {
            tags.add(new Tag(strPos, true));
        }
        strPos = 0;
        while ((strPos = xml.indexOf(stop, strPos+1)) >= 0) {
            tags.add(new Tag(strPos, false));
        }
    }

    private static void sortTags() {
        tags.sort(new Comparator<Tag>() {
            public int compare(Tag o1, Tag o2) {
                return (o1.strPos > o2.strPos) ? 1 : -1;
            }
        });
    }

    private static void extractTags(String xml, int first, int last, int stopLength) {
        if (first < last) {
            int level = 0;
            int i;
            for (i = first; i <= last; i++) {
                Tag tag = tags.get(i);
                if (tag.isStart) {
                    level++;
                } else {
                    level--;
                }
                if (level == 0) {
                    String s = xml.substring(tags.get(first).strPos, tag.strPos + stopLength);
                    System.out.println(s);
                    extractTags(xml, first + 1, i - 1, stopLength);
                    break;
                }
            }
            extractTags(xml, i + 1, last, stopLength);
        }
    }

    private static ArrayList<Tag> tags = new ArrayList<Tag>();

    private static class Tag {
        int strPos;
        boolean isStart;

        Tag(int strPos, boolean isStart) {
            this.strPos = strPos;
            this.isStart = isStart;
        }

        @Override
        public String toString() {
            return "[" + strPos + ", " + isStart + "]";
        }
    }


}
//c:\r\3.txt