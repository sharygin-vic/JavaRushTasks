package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by dell on 19-May-17.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<Cook>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        if (data != null) {
            statisticStorage.put(data);
        }
    }

    public void register(Cook cook) {
        if (cook != null) {
            cooks.add(cook);
        }
    }

    public Map<Date, Long> getAdvertisementProfit() {
        HashMap<Date, Long> res = new HashMap<Date, Long>();
        List<EventDataRow> eventDataRowList = statisticStorage.getData(EventType.SELECTED_VIDEOS);
        for (EventDataRow eventDataRow: eventDataRowList) {
            Date normDate = removeTimeFromDate(eventDataRow.getDate());
            if (res.containsKey(normDate)) {
                res.put(normDate, res.get(normDate) + ((VideoSelectedEventDataRow)eventDataRow).getAmount());
            }
            else {
                res.put(normDate, ((VideoSelectedEventDataRow)eventDataRow).getAmount());
            }
        }
        return res;
    }

    public Map<Date, Map<String, Integer>> getCookWorkTime() {
        HashMap<Date, Map<String, Integer>> res = new HashMap<Date, Map<String, Integer>>();
        List<EventDataRow> eventDataRowList = statisticStorage.getData(EventType.COOKED_ORDER);
        for (EventDataRow eventDataRow: eventDataRowList) {
            Date normDate = removeTimeFromDate(eventDataRow.getDate());
            Map<String, Integer> cookDataMap;
            if (res.containsKey(normDate)) {
                cookDataMap = res.get(normDate);
            }
            else {
                cookDataMap = new HashMap<String, Integer>();
                res.put(normDate, cookDataMap);
            }
            String cookName = ((CookedOrderEventDataRow)eventDataRow).getCookName();
            if (cookDataMap.containsKey(cookName)) {
                cookDataMap.put(cookName, cookDataMap.get(cookName) + eventDataRow.getTime());
            }
            else {
                cookDataMap.put(cookName, eventDataRow.getTime());
            }
        }
        return res;
    }

    private Date removeTimeFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<EventType, List<EventDataRow>>();

        public StatisticStorage() {
            for (EventType evT : EventType.values()) {
                storage.put(evT, new ArrayList<EventDataRow>());
            }
        }

        private List<EventDataRow> getData(EventType eventType)
        {
            return storage.get(eventType);
        }

        private void put(EventDataRow data) {
            if (data == null) return;
            storage.get(data.getType()).add(data);
        }
    }
}
