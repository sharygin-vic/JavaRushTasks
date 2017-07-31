package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        System.out.println("==========  IPQuery  ============");
        LogParser logParser = new LogParser(Paths.get("c:/r/logs/"));
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
        System.out.println("==========  DateQuery  ============");
        System.out.println(logParser.getDatesForUserAndEvent("Eduard Petrovich Morozko", Event.WRITE_MESSAGE, null, new Date()));
        System.out.println(logParser.getDatesWhenSomethingFailed(null, new Date()));
        System.out.println(logParser.getDatesWhenErrorHappened(null, new Date()));
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Eduard Petrovich Morozko", null, new Date()));
        System.out.println(logParser.getDateWhenUserSolvedTask("Vasya Pupkin", 18, null, new Date()));
        System.out.println(logParser.getDateWhenUserDoneTask("Vasya Pupkin", 15, null, new Date()));
        System.out.println(logParser.getDatesWhenUserWroteMessage("Eduard Petrovich Morozko", null, new Date()));
        System.out.println(logParser.getDatesWhenUserDownloadedPlugin("Eduard Petrovich Morozko", null, new Date()));

        System.out.println("==========  QLQuery  ============");
        System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get date"));
        System.out.println(logParser.execute("get event"));
        System.out.println(logParser.execute("get status"));

        System.out.println("---- get ip");
        System.out.println("for user   : " + logParser.execute("get ip    for   user     = \"  Eduard   Petrovich Morozko   \""));
        System.out.println("for date   : " + logParser.execute("get ip for date = \" 30.1.2014   12:56:22 \""));
        System.out.println("for date   : " + logParser.execute("get ip for date = \"30.01.2014 12:56:22\""));
        System.out.println("for event  : " + logParser.execute("get ip for event = \"WRITE_MESSAGE\""));
        System.out.println("for status : " + logParser.execute("get ip for status = \"OK\""));
        System.out.println("---- get user");
        System.out.println("for ip     : " + logParser.execute("get user for ip = \"192.168.100.2\""));
        System.out.println("for date   : " + logParser.execute("get user for date = \"30.01.2014 12:56:22\""));
        System.out.println("for event  : " + logParser.execute("get user for event = \"WRITE_MESSAGE\""));
        System.out.println("for status : " + logParser.execute("get user for status = \"OK\""));
        System.out.println("---- get date");
        System.out.println("for ip     : " + logParser.execute("get date for ip = \"146.34.15.5\""));
        System.out.println("for user   : " + logParser.execute("get date for user = \"Eduard Petrovich Morozko\""));
        System.out.println("for event  : " + logParser.execute("get date for event = \"WRITE_MESSAGE\""));
        System.out.println("for status : " + logParser.execute("get date for status = \"OK\""));
        System.out.println("---- get event");
        System.out.println("for ip     : " + logParser.execute("get event for ip = \"146.34.15.5\""));
        System.out.println("for user   : " + logParser.execute("get event for user = \"Eduard Petrovich Morozko\""));
        System.out.println("for date   : " + logParser.execute("get event for date = \"30.01.2014 12:56:22\""));
        System.out.println("for status : " + logParser.execute("get event for status = \"OK\""));
        System.out.println("---- get status");
        System.out.println("for ip     : " + logParser.execute("get status for ip = \"146.34.15.5\""));
        System.out.println("for user   : " + logParser.execute("get status for user = \"Eduard Petrovich Morozko\""));
        System.out.println("for date   : " + logParser.execute("get status for date = \"30.01.2014 12:56:22\""));
        System.out.println("for event  : " + logParser.execute("get status for event = \"WRITE_MESSAGE\""));

        System.out.println("==========  QLQuery with date interval ============");
        System.out.println("---- get ip");
        System.out.println("for user   : " + logParser.execute("get ip    for   user     = \"  Eduard   Petrovich    Morozko   \" and   date between \"11.12.2010   0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for date   : " + logParser.execute("get ip for date = \" 30.1.2014   12:56:22 \" and date between \"11.12.2010   0:0:0\"   and \"03.1.2017   23:59:59\""));
        System.out.println("for date   : " + logParser.execute("get ip for date = \"30.01.2014 12:56:22\" and date between \"11.12.2010 00:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for event  : " + logParser.execute("get ip for event = \"WRITE_MESSAGE\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for status : " + logParser.execute("get ip for status = \"OK\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("---- get user");
        System.out.println("for ip     : " + logParser.execute("get user for ip = \"192.168.100.2\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for date   : " + logParser.execute("get user for date = \"30.01.2014 12:56:22\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for event  : " + logParser.execute("get user for event = \"WRITE_MESSAGE\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for status : " + logParser.execute("get user for status = \"OK\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("---- get date");
        System.out.println("for ip     : " + logParser.execute("get date for ip = \"146.34.15.5\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for user   : " + logParser.execute("get date for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for event  : " + logParser.execute("get date for event = \"WRITE_MESSAGE\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for status : " + logParser.execute("get date for status = \"OK\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("---- get event");
        System.out.println("for ip     : " + logParser.execute("get event for ip = \"146.34.15.5\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for user   : " + logParser.execute("get event for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for date   : " + logParser.execute("get event for date = \"30.01.2014 12:56:22\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for status : " + logParser.execute("get event for status = \"OK\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("---- get status");
        System.out.println("for ip     : " + logParser.execute("get status for ip = \"146.34.15.5\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for user   : " + logParser.execute("get status for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for date   : " + logParser.execute("get status for date = \"30.01.2014 12:56:22\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
        System.out.println("for event  : " + logParser.execute("get status for event = \"WRITE_MESSAGE\" and date between \"11.12.2010 0:00:00\" and \"03.01.2017 23:59:59\""));
    }
}