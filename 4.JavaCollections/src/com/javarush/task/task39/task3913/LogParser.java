package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.DateQuery;
import com.javarush.task.task39.task3913.query.EventQuery;
import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dell on 19-Jun-17.
 */
public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }


    private boolean isDateBetween(Date date, Date after, Date before) {
        Date start = after;
        if (start == null) {
            start = new Date(0);
        }
        Date end = before;
        if (end == null) {
            end = new Date(Long.MAX_VALUE);
        }
        long dateMs = date.getTime();
        long afterMs = start.getTime();
        long beforeMs = end.getTime();
        return dateMs >= afterMs && dateMs <= beforeMs;
    }

    //****************************  IPQuery  interface  ********************************

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> res = getUniqueIPs(after, before);
        return res.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (isDateBetween(data.date, after, before)) {
                res.add(data.ip);
            }
        }
        return res;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.userName.equals(user) && isDateBetween(data.date, after, before)) {
                res.add(data.ip);
            }
        }
        return res;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.event == event && isDateBetween(data.date, after, before)) {
                res.add(data.ip);
            }
        }
        return res;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.status == status && isDateBetween(data.date, after, before)) {
                res.add(data.ip);
            }
        }
        return res;
    }

    //*****************************  UserQuery  interface  ******************************

    @Override
    public Set<String> getAllUsers() {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            res.add(data.userName);
        }
        return res;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (isDateBetween(data.date, after, before)) {
                res.add(data.userName);
            }
        }
        return res.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        HashSet<Event> res = new HashSet<Event>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.userName.equals(user) && isDateBetween(data.date, after, before)) {
                res.add(data.event);
            }
        }
        return res.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.ip.equals(ip) && isDateBetween(data.date, after, before)) {
                res.add(data.userName);
            }
        }
        return res;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.event == Event.LOGIN && isDateBetween(data.date, after, before)) {
                res.add(data.userName);
            }
        }
        return res;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.event == Event.DOWNLOAD_PLUGIN && isDateBetween(data.date, after, before)) {
                res.add(data.userName);
            }
        }
        return res;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.event == Event.WRITE_MESSAGE && isDateBetween(data.date, after, before)) {
                res.add(data.userName);
            }
        }
        return res;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.event == Event.SOLVE_TASK && isDateBetween(data.date, after, before)) {
                res.add(data.userName);
            }
        }
        return res;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        String taskStr = "" + task;
        for (LogData data : datas) {
            if (data.event == Event.SOLVE_TASK && data.eventParam.equals(taskStr) && isDateBetween(data.date, after, before)) {
                res.add(data.userName);
            }
        }
        return res;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.event == Event.DONE_TASK && isDateBetween(data.date, after, before)) {
                res.add(data.userName);
            }
        }
        return res;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        HashSet<String> res = new HashSet<String>();
        List<LogData> datas = parsePath();
        String taskStr = "" + task;
        for (LogData data : datas) {
            if (data.event == Event.DONE_TASK && data.eventParam.equals(taskStr) && isDateBetween(data.date, after, before)) {
                res.add(data.userName);
            }
        }
        return res;
    }

    //*****************************  DateQuery  interface  ******************************

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        HashSet<Date> res = new HashSet<Date>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.userName.equals(user) && data.event == event && isDateBetween(data.date, after, before)) {
                res.add(data.date);
            }
        }
        return res;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        HashSet<Date> res = new HashSet<Date>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.status == Status.FAILED && isDateBetween(data.date, after, before)) {
                res.add(data.date);
            }
        }
        return res;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        HashSet<Date> res = new HashSet<Date>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.status == Status.ERROR && isDateBetween(data.date, after, before)) {
                res.add(data.date);
            }
        }
        return res;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        List<LogData> datas = parsePath();
        Date firstLoginDate = new Date(Long.MAX_VALUE);
        boolean firstLoginDateExists = false;
        for (LogData data : datas) {
            if (data.userName.equals(user) && data.event == Event.LOGIN && isDateBetween(data.date, after, before)) {
                if (data.date.before(firstLoginDate)) {
                    firstLoginDate = data.date;
                    firstLoginDateExists = true;
                }
            }
        }
        if (firstLoginDateExists) return firstLoginDate;
        else return null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<LogData> datas = parsePath();
        String taskStr = "" + task;
        Date firstSolvedDate = new Date(Long.MAX_VALUE);
        boolean firstSolvedDateExists = false;
        for (LogData data : datas) {
            if (data.userName.equals(user) && data.event == Event.SOLVE_TASK && data.eventParam.equals(taskStr)
                    && isDateBetween(data.date, after, before)) {
                if (data.date.before(firstSolvedDate)) {
                    firstSolvedDate = data.date;
                    firstSolvedDateExists = true;
                }
            }
        }
        if (firstSolvedDateExists) return firstSolvedDate;
        else return null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<LogData> datas = parsePath();
        String taskStr = "" + task;
        Date firstDoneDate = new Date(Long.MAX_VALUE);
        boolean firstDoneDateExists = false;
        for (LogData data : datas) {
            if (data.userName.equals(user) && data.event == Event.DONE_TASK && data.eventParam.equals(taskStr)
                    && isDateBetween(data.date, after, before)) {
                if (data.date.before(firstDoneDate)) {
                    firstDoneDate = data.date;
                    firstDoneDateExists = true;
                }
            }
        }
        if (firstDoneDateExists) return firstDoneDate;
        else return null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        HashSet<Date> res = new HashSet<Date>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.userName.equals(user) && data.event == Event.WRITE_MESSAGE && isDateBetween(data.date, after, before)) {
                res.add(data.date);
            }
        }
        return res;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        HashSet<Date> res = new HashSet<Date>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.userName.equals(user) && data.event == Event.DOWNLOAD_PLUGIN && isDateBetween(data.date, after, before)) {
                res.add(data.date);
            }
        }
        return res;
    }

    //*****************************  EventQuery  interface  ******************************

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> res = getAllEvents(after, before);
        return res.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        HashSet<Event> res = new HashSet<Event>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (isDateBetween(data.date, after, before)) {
                res.add(data.event);
            }
        }
        return res;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        HashSet<Event> res = new HashSet<Event>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.ip.equals(ip) && isDateBetween(data.date, after, before)) {
                res.add(data.event);
            }
        }
        return res;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        HashSet<Event> res = new HashSet<Event>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.userName.equals(user) && isDateBetween(data.date, after, before)) {
                res.add(data.event);
            }
        }
        return res;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        HashSet<Event> res = new HashSet<Event>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.status == Status.FAILED && isDateBetween(data.date, after, before)) {
                res.add(data.event);
            }
        }
        return res;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        HashSet<Event> res = new HashSet<Event>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if (data.status == Status.ERROR && isDateBetween(data.date, after, before)) {
                res.add(data.event);
            }
        }
        return res;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        List<LogData> datas = parsePath();
        int res = 0;
        String taskStr = "" + task;
        for (LogData data : datas) {
            if ( data.event == Event.SOLVE_TASK && data.eventParam.equals(taskStr)
                    && isDateBetween(data.date, after, before)) {
                res++;
            }
        }
        return res;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        List<LogData> datas = parsePath();
        int res = 0;
        String taskStr = "" + task;
        for (LogData data : datas) {
            if ( data.event == Event.DONE_TASK && data.eventParam.equals(taskStr)
                    && isDateBetween(data.date, after, before)) {
                res++;
            }
        }
        return res;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if ( data.event == Event.SOLVE_TASK && isDateBetween(data.date, after, before)) {
                int taskNum = Integer.parseInt(data.eventParam);
                if (res.containsKey(taskNum)) {
                    res.put(taskNum, res.get(taskNum) + 1);
                }
                else {
                    res.put(taskNum, 1);
                }
            }
        }
        return res;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        List<LogData> datas = parsePath();
        for (LogData data : datas) {
            if ( data.event == Event.DONE_TASK && isDateBetween(data.date, after, before)) {
                int taskNum = Integer.parseInt(data.eventParam);
                if (res.containsKey(taskNum)) {
                    res.put(taskNum, res.get(taskNum) + 1);
                }
                else {
                    res.put(taskNum, 1);
                }
            }
        }
        return res;
    }

    //******************************************************************************

    private class LogData {
        private String ip;
        private String userName;
        private Event event;
        private Date date;
        private String eventParam;
        private Status status;
    }

    private LogData parseLogStr(String s) {
        String[] words = s.split("( |\t)+");
        if (words.length < 6) return  null;

        LogData res = new LogData();
        res.ip = words[0];
        int wordArrayIndex = words.length - 1;
        res.status = Status.valueOf(words[wordArrayIndex]);
        wordArrayIndex--;
        if (words[wordArrayIndex].matches("[0-9]+")) {
            res.eventParam = words[wordArrayIndex];
            wordArrayIndex--;
        }
        res.event = Event.valueOf(words[wordArrayIndex]);
        wordArrayIndex--;
        String dateStr = words[wordArrayIndex-1] + " " + words[wordArrayIndex];
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            res.date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        wordArrayIndex--;
        wordArrayIndex--;

        String name = words[1];
        for (int i = 2; i <= wordArrayIndex; i++) {
            name += " " + words[i];
        }
        res.userName = name;

        return res;
    }

    List<LogData> parsePath() {
        ArrayList<LogData> res = new ArrayList<LogData>();
        for (File f : logDir.toFile().listFiles()) {
            if (f.isFile() && f.toString().endsWith(".log")) {
                try {
                    List<String> strings = Files.lines(f.toPath()).collect(Collectors.toList());
                    for (String s : strings) {
                        LogData logData = parseLogStr(s);
                        if (logData != null) {
                            res.add(logData);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

}
