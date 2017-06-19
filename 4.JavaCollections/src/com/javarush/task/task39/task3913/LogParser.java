package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
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
public class LogParser implements IPQuery {
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
