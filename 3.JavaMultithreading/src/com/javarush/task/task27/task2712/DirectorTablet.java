package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dell on 19-May-17.
 */
public class DirectorTablet {

    public void printAdvertisementProfit() {
        Map<Date, Long> videoProfits = StatisticManager.getInstance().getAdvertisementProfit();
        Date[] dates = videoProfits.keySet().toArray(new Date[0]);
        Arrays.sort(dates, new Comparator<Date>() {     // сортировка по убыванию
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        double total = 0.0;
        if (dates.length > 0) {
            for (Date date : dates) {
                Long curValue = videoProfits.get(date);
                if (curValue == null || curValue == 0) {
                    continue;
                }
                double curDayProfit = 0.01 * curValue;
                total += curDayProfit;
                if (curDayProfit > 0) {
                    String message = String.format("%s - %.2f", sdf.format(date), curDayProfit);
                    ConsoleHelper.writeMessage(message);
                }
            }
            String message = String.format("Total - %.2f", total);
            ConsoleHelper.writeMessage(message);
        }
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookWorkTime = StatisticManager.getInstance().getCookWorkTime();
        Date[] dates = cookWorkTime.keySet().toArray(new Date[0]);
        Arrays.sort(dates, new Comparator<Date>() {     // сортировка по убыванию
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        int total = 0;
        if (dates.length > 0) {
            for (Date date : dates) {
                String message = sdf.format(date);      //14-May-2013
                ConsoleHelper.writeMessage(message);
                Map<String, Integer> cooksData = cookWorkTime.get(date);
                String[] cookNames = cooksData.keySet().toArray(new String[0]);
                Arrays.sort(cookNames, new Comparator<String>() {     // сортировка по убыванию
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                for (String cookName : cookNames) {
                    int cookingTimeSeconds = cooksData.get(cookName);
                    total += cookingTimeSeconds;
                    message = String.format("%s - %s min", cookName, (int) ((cookingTimeSeconds + 59.0) / 60.0));   //Petrov - 35 min
                    ConsoleHelper.writeMessage(message);
                }
                ConsoleHelper.writeMessage("");
            }
        }
    }

    public void printActiveVideoSet() {
        Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getVideos(true);  //getVideos();  //getVideosActive();

        Map.Entry[] videoArray = videos.entrySet().toArray(new Map.Entry[0]);
        Arrays.sort(videoArray, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return ((String)o1.getKey()).compareToIgnoreCase((String)o2.getKey());
            }
        });

        //for (Map.Entry<String, Integer> item : videos.entrySet()) {
        for (Map.Entry<String, Integer> item : videoArray) {
                ConsoleHelper.writeMessage(item.getKey() + " - " + item.getValue());
        }
    }

    public void printArchivedVideoSet() {
        Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getVideos(false);  //getVideos();  //getVideosArchive();

        Map.Entry[] videoArray = videos.entrySet().toArray(new Map.Entry[0]);
        Arrays.sort(videoArray, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return ((String)o1.getKey()).compareToIgnoreCase((String)o2.getKey());
            }
        });

        //for (Map.Entry<String, Integer> item : videos.entrySet()) {
        for (Map.Entry<String, Integer> item : videoArray) {
                ConsoleHelper.writeMessage(item.getKey());
        }
    }

}
