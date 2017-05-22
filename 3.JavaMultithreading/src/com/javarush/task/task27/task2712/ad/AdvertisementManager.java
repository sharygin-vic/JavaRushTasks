package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by dell on 17-May-17.
 */
public class AdvertisementManager {
    private int timeSeconds;
    public final AdvertisementStorage storage = AdvertisementStorage.getInstance();


    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    private List<Advertisement> selectVideos(List<Advertisement> sourceList, List<Advertisement> parentSelectedList, int level, int parentSumTime, int parentSumCost, List<Advertisement>[] currentBestFoundList) {
        if (level == 0) {
            if (currentBestFoundList[0] == null) {
                currentBestFoundList[0] = parentSelectedList;
            }
            else {
                int currentBestFoundListCount = 0;
                int currentBestFoundListTime = 0;
                long currentBestFoundListCost = 0;
                for (Advertisement ad : currentBestFoundList[0]) {
                    currentBestFoundListCost += ad.getAmountPerOneDisplaying();
                    currentBestFoundListTime += ad.getDuration();
                    currentBestFoundListCount += 1;
                }

                if (parentSumCost > currentBestFoundListCost) {     // требование 1 задачи
                    currentBestFoundList[0] = parentSelectedList;
                }
                else {
                    if (parentSumCost == currentBestFoundListCost) {
                        if (parentSumTime > currentBestFoundListTime) {     // требование 4.1 задачи
                            currentBestFoundList[0] = parentSelectedList;
                        }
                        else if (parentSumTime == currentBestFoundListTime) {
                            if (parentSelectedList.size() < currentBestFoundListCount) {        // требование 4.2 задачи
                                currentBestFoundList[0] = parentSelectedList;
                            }
                        }
                    }
                }
            }
            return currentBestFoundList[0];
        }
        else {
            List<Advertisement> res = null;
            for (Advertisement ad : sourceList) {
                if (!parentSelectedList.contains(ad)) {     // требование 3 задачи
                    List<Advertisement> selList = new ArrayList<Advertisement>(parentSelectedList);
                    int newSumTime = parentSumTime;
                    int newSumCost = parentSumCost;
                    int newLevel = level-1;
                    if (parentSumTime + ad.getDuration() > timeSeconds) {       // требование 2 задачи
                        newLevel = 0;
                    }
                    else {
                        selList.add(ad);
                        newSumTime += ad.getDuration();
                        newSumCost += ad.getAmountPerOneDisplaying();
                    }
                    res = selectVideos(sourceList, selList, newLevel, newSumTime, newSumCost, currentBestFoundList);

                }
            }
            return res;
        }
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> storedVideos = AdvertisementStorage.getInstance().list();

//        List<Advertisement> enabledVideos = new ArrayList<Advertisement>();
//        for (Advertisement ad : storedVideos) {
//            if (ad.getHits() > 0) {
//                enabledVideos.add(ad);
//            }
//        }

        HashMap<String, Advertisement> enabledMap = new HashMap<>(storedVideos.size());
        for (Advertisement ad : storedVideos) {
            if (ad.getHits() > 0) {
                if (!enabledMap.containsKey(ad.getName())) {
                    enabledMap.put(ad.getName(), ad);
                }
                else {
                    Advertisement selectedAd = enabledMap.get(ad.getName());
                    if (ad.getAmountPerOneDisplaying() > selectedAd.getAmountPerOneDisplaying()) {
                        enabledMap.put(ad.getName(), ad);
                    }
                }
            }
        }
        List<Advertisement> enabledVideos = new ArrayList<Advertisement>(enabledMap.values());


        if (enabledVideos.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        List<Advertisement>[] currentBestFoundList = new List[1];
        List<Advertisement> videos = selectVideos(enabledVideos, new ArrayList<Advertisement>(), enabledVideos.size(), 0, 0, currentBestFoundList);

        if (videos == null || videos.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        Collections.sort(videos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int res = (int)(o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());  //в порядке уменьшения стоимости показа одного рекламного ролика в копейках
                if (res == 0) {
                    res = (int)(o1.getAmountPerOneDisplaying()*1000d/o1.getDuration() - o2.getAmountPerOneDisplaying()*1000D/o2.getDuration());  //по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки
                }
                return res;
            }
        });

        int videosCount = 0;
        int videosTime  = 0;
        long videosCost = 0;
        for (Advertisement ad : currentBestFoundList[0]) {
            videosCost += ad.getAmountPerOneDisplaying();
            videosTime += ad.getDuration();
            videosCount += 1;
        }

        VideoSelectedEventDataRow videoSelectedEventDataRow = new VideoSelectedEventDataRow(videos, videosCost, videosTime);
        StatisticManager.getInstance().register(videoSelectedEventDataRow);

        for (Advertisement advertisement : videos) {
//            advertisement.revalidate();
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    advertisement.getName(),
                    advertisement.getAmountPerOneDisplaying(),
                    (int)(advertisement.getAmountPerOneDisplaying()*1000d / advertisement.getDuration())));
            advertisement.revalidate();
        }

    }

}
