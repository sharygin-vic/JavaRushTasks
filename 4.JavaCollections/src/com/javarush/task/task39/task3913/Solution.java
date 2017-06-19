package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));

        Event event = Event.DONE_TASK;
        System.out.println("DONE_TASK " + logParser.getIPsForEvent(event, null, new Date()));
        event = Event.DOWNLOAD_PLUGIN;
        System.out.println("DOWNLOAD_PLUGIN " + logParser.getIPsForEvent(event, null, new Date()));
        event = Event.LOGIN;
        System.out.println("LOGIN " + logParser.getIPsForEvent(event, null, new Date()));
        event = Event.SOLVE_TASK;
        System.out.println("SOLVE_TASK " + logParser.getIPsForEvent(event, null, new Date()));
        event = Event.WRITE_MESSAGE;
        System.out.println("WRITE_MESSAGE " + logParser.getIPsForEvent(event, null, new Date()));
    }
}