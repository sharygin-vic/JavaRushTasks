package com.javarush.task.task22.task2209;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    private static char[] utf8chars = {'\uFEFF', '\uFFFE'};

    public static void main(String[] args)  {
        try (
                BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String content = new String(Files.readAllBytes(Paths.get(r.readLine())), StandardCharsets.UTF_8);

            // FOR DEBUG:
            //String content = null;
            //String content = "";
            //String content = "Киев Нью-Йорк Амстердам\n Вена   Мельбурн";
            //String content = "\uFEFFКиев   Нью-Йорк    Амстердам  Мельбурн Чес Монегем воронеЖ Жмеринка Артемовск Суворовка Капо  Маев Вена Аеку  Удрот Треля Яс   Срача Апер Ровно   Олем";
            //String content = "Киев   Нью-Йорк    Амстердам  Мельбурн Чес Монегем Воронеж Жмеринка Артемовск Суворовка Капо  Маев Вена Аеку  Удрот Треля Яс   Срача Апер Ровно   Олем";
//            String content = "\uFEFFКиев   Нью-Йорк    Амстердам  Мельбурн Чес Монегем воронеЖ Жмеринка Артемовск Суворовка " +
//                    "Капо  Маев Вена Аеку  Удрот Треля Яс   Срача Апер Ровно " +
//                    "  Олем  Отребово образ Забор Рожеве Ерепейск кротинская яблочное Ефремка Алупка " +
//                    "Аспер ролда адагарка арпа астер родня яворино орлово Ольгин Никополье " +
//                    " Ежов витебск кровск кубард дромив волф форка алпуг гундота атлас " +
//                    " серж жопа апупеня Явор-Пришиб берег груз забор роза астахово орел";      // 60 words -> work time = 1..2 sec

            if (content.charAt(0) == utf8chars[0] || content.charAt(0) == utf8chars[1]) {
                content = content.substring(1);
            }
            String[] words = content.split("\\s+");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sbRes = new StringBuilder();

        if (words == null || words.length == 0)
            return sbRes;
        if (words.length == 1 || words[0].equals(""))
            return sbRes.append(words[0]);

        int sbResCountWords = 0;
        ArrayList<String> listSrc = new ArrayList<String>(Arrays.asList(words));

        for (int shufleCur = 0; shufleCur < 1000 * listSrc.size(); shufleCur++) {
            ArrayList<String> list = new ArrayList<String>(listSrc);

            Collections.shuffle(list, new Random());
            StringBuilder sb = new StringBuilder();
            int sbCountWords = 1;

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
                    if (Character.toLowerCase(srsWordStart) == Character.toLowerCase(sbEnd)) {
                        sb.append(" ");
                        sb.append(srsWord);
                        sbCountWords++;
                    } else {
                        char srsWordEnd = srsWord.charAt(srsWord.length() - 1);
                        char sbStart = sb.charAt(0);
                        if (Character.toUpperCase(srsWordEnd) == Character.toLowerCase(sbStart)) {
                            sb.insert(0, " ").insert(0, srsWord);
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

            if (sbResCountWords == listSrc.size()) {
                break;  // found all words
            }
        }

        //System.out.println("count = " + (sbResCountWords));   // for debug

        return sbRes;
    }

}
