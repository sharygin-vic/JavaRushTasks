package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        //String fileName = "c:\\r\\1.txt";
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        r.close();

        ArrayList<String> words = new ArrayList<String>();
        while (fr.ready()) {
            String[] ss = fr.readLine().split(" ");
            for (String s : ss) {
                if (s.trim().length() > 0) {
                    words.add(s);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (words.size() > 0) {
            String srsWord = words.get(0);
            words.remove(0);
            sb.delete(0, sb.length());
            sb.append(srsWord).reverse();
            int pairIndex = words.indexOf(sb.toString());
            if (pairIndex >= 0) {
                Pair pair = new Pair();
                pair.first = srsWord;
                pair.second = words.get(pairIndex);
                words.remove(pairIndex);
                result.add(pair);

                //System.out.println(pair.toString());
            }


        }


//        while (fr.ready()) {
//            sb.append(fr.readLine()).append(" ");
//        }
        //System.out.println(sb.toString());


        fr.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
