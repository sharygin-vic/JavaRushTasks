package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 17-May-17.
 */
class AdvertisementStorage {
    private static  AdvertisementStorage ourInstance = new AdvertisementStorage();
    private  List<Advertisement> videos = new ArrayList<Advertisement>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));   // 3 min  50  277
        videos.add(new Advertisement(someContent, "second Video", 100, 10, 15 * 60));   //15 min  10   11
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));     //10 min 200  333
    }

    static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    List<Advertisement> list() {
        return videos;
    }

    void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
