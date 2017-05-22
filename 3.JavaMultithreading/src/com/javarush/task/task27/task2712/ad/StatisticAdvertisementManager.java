package com.javarush.task.task27.task2712.ad;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dell on 21-May-17.
 */
public class StatisticAdvertisementManager {
    private static  StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private  AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }


    public Map<String, Integer> getVideos(boolean active) {
        Map<String, Integer> res = new TreeMap<>();  //(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement != null) {
                if (res.containsKey(advertisement.getName())) {
                    res.put(advertisement.getName(), res.get(advertisement.getName()) + advertisement.getHits());
                }
                else {
                    res.put(advertisement.getName(), advertisement.getHits());
                }
            }
        }
        for (Iterator<Map.Entry<String, Integer>> it = res.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> item = it.next();
            if (active && item.getValue() == 0) {
                it.remove();
            }
            else if (!active && item.getValue() > 0) {
                it.remove();
            }
        }
        return res;
    }


}
