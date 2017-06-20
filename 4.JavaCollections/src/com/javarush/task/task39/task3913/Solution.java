package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        System.out.println("==========  IPQuery  ============");
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
        System.out.println("==========  UserQuery  ============");
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(null, new Date()));
        System.out.println(logParser.getNumberOfUserEvents("Eduard Petrovich Morozko", null, new Date()));
        System.out.println(logParser.getUsersForIP("127.0.0.1", null, new Date()));
        System.out.println(logParser.getLoggedUsers(null, new Date()));
        System.out.println(logParser.getDownloadedPluginUsers(null, new Date()));
        System.out.println(logParser.getWroteMessageUsers(null, new Date()));
        System.out.println(logParser.getSolvedTaskUsers(null, new Date()));
        System.out.println(logParser.getSolvedTaskUsers(null, new Date(), 1));
        System.out.println(logParser.getDoneTaskUsers(null, new Date()));
        System.out.println(logParser.getDoneTaskUsers(null, new Date(), 15));
        System.out.println("======================");

    }
}