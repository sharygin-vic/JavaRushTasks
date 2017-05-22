package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    private static char utf8char = 0;
    private static String wordWithUtf8Char = "";

    public static void main(String[] args)  {
        //...
        ArrayList<String> words = new ArrayList<String>();
//          String fileName = "c:\\r\\1.txt";
        try (
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader fr = new BufferedReader(new FileReader(r.readLine()));
        ) {
            while (fr.ready()) {
                String line = fr.readLine();
                String[] ss;
                if (line.charAt(0) == '\uFEFF' || line.charAt(0) == '\uFFFE') {
                    ss = line.substring(1).split(" ");
                    utf8char = '\uFEFF';
                    wordWithUtf8Char = ss[0];
                } else {
                    ss = line.split(" ");
                }
                for (String s : ss) {
                    if (s.trim().length() > 0) {
                        words.add(s);
                    }
                }
            }

            System.out.println(Charset.defaultCharset());

            StringBuilder result = getLine(words.toArray(new String[0]));
            System.out.println(result.toString());
        }
        catch (IOException e) {
            StringBuilder result = getLine(words.toArray(new String[0]));
            System.out.println(result.toString());
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sbRes = new StringBuilder();
        int sbResCountWords = 0;
        ArrayList<String> listSrc = new ArrayList<String>(Arrays.asList(words));

        for (int shufleCur = 0; shufleCur < 100000 * listSrc.size(); shufleCur++) {
            ArrayList<String> list = new ArrayList<String>(listSrc);

            Collections.shuffle(list, new Random());
            StringBuilder sb = new StringBuilder();
            int sbCountWords = 0;

            int prevIterWordsCount = list.size();
            int curIterWordsCount = prevIterWordsCount;
            int curIter = curIterWordsCount;
            while (list.size() > 0) {
                String srsWord;
                srsWord = list.get(0);
                list.remove(0);
                curIterWordsCount--;
                curIter--;
                if (sb.length() == 0) {
                    sb.append(srsWord);
                } else {
                    char srsWordStart = srsWord.charAt(0);
                    char sbEnd = sb.charAt(sb.length() - 1);
                    if (Character.toLowerCase(srsWordStart) == sbEnd) {
                        sb.append(" ");
                        if (wordWithUtf8Char.equals(srsWord)) {
                            sb.append(utf8char);
                        }
                        sb.append(srsWord);
                        sbCountWords++;
                    } else {
                        char srsWordEnd = srsWord.charAt(srsWord.length() - 1);
                        char sbStart = sb.charAt(0);
                        if (Character.toUpperCase(srsWordEnd) == sbStart) {
                            sb.insert(0, " ").insert(0, srsWord);
                            if (wordWithUtf8Char.equals(srsWord)) {
                                sb.insert(0, utf8char);
                            }
                            sbCountWords++;
                        } else {
                            list.add(srsWord);
                            curIterWordsCount++;
                        }
                    }
                }

                if (curIter == -1) {
                    if (curIterWordsCount == prevIterWordsCount) {
                        break;
                    } else {
                        prevIterWordsCount = list.size();
                        curIterWordsCount = prevIterWordsCount;
                        curIter = curIterWordsCount;
                    }
                }
            }

            if (sbCountWords > sbResCountWords) {
                sbRes = sb;
                sbResCountWords = sbCountWords;
            }
        }

        return sbRes;
    }

}
