package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by dell on 19-May-17.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
