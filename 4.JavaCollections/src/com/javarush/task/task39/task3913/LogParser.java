package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

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
public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
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

    //*****************************  QLQuery  interface  ******************************

    @Override
    public Set<Object> execute(String query) {
        String s = query.replaceAll("( |\t)+", " ").trim();
        String field = "";
        if (s.startsWith("get ip")) {
            field = "ip";
            s = s.substring(6).trim();
        }
        else if (s.startsWith("get user")) {
            field = "user";
            s = s.substring(8).trim();
        }
        else if (s.startsWith("get date")) {
            field = "date";
            s = s.substring(8).trim();
        }
        else if (s.startsWith("get event")) {
            field = "event";
            s = s.substring(9).trim();
        }
        else if (s.startsWith("get status")) {
            field = "status";
            s = s.substring(10).trim();
        }
        else
            return null;

        if (s.startsWith("for ")) {
            s = s.substring(4);
        }
        else {
            s = "";
        }
        return getFilteredData(field, s);
    }

    private Set<Object> getFilteredData(String field, String filter) {
        Set<Object> res = new HashSet<Object>();
        List<LogData> datas = parsePath();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        boolean filterIpExists = false;
        String  filterIpValue = null;
        boolean filterUserExists = false;
        String  filterUserValue = null;
        boolean filterDateExists = false;
//        Date    filterDateValue = null;       // это правильно для сравнения дат события лога и фильтра запроса в типе Date (задача 6 - get ip for date = "30.01.2014 12:56:22"):
        String  filterDateValueStr = null;      // это правильно для сравнения дат события лога и фильтра запроса в типе String (задача 6 - get ip for date = "30.01.2014 12:56:22"). Валидатор проверяет через совпадение строк
        boolean filterEventExists = false;
        Event   filterEventValue = null;
        boolean filterStatusExists = false;
        Status  filterStatusValue = null;

//        boolean filterDateIntervalExists = false;
//        Date filterDateAfterValue;
//        Date filterDateBeforeValue;

        if (filter != null && filter.length() > 0) {
            String[] words = filter.split(" ");
            int nextWord = 0;
            String filterFieldName = words[nextWord];
            nextWord++;
            nextWord++;  // skip "="
            String filterFieldStrValue;
            StringBuilder sb = new StringBuilder();
            while (nextWord < words.length && ( (sb.length() > 1) ? (sb.charAt(sb.length()-1) != '"') : true) ) {
                if (sb.length() > 0) sb.append(" ");
                sb.append(words[nextWord]);
                nextWord++;
            }
            int charFirstIndex = 0;
            if (sb.charAt(0) == '"') {
                charFirstIndex++;
            }
            int charLastIndex  = sb.length() - 1;
            if (sb.charAt(charLastIndex) == '"') {
                charLastIndex--;
            }
            filterFieldStrValue = sb.substring(charFirstIndex, charLastIndex+1).trim();

            if ("ip".equals(filterFieldName)) {
                filterIpExists = true;
                filterIpValue = filterFieldStrValue;
            } else if ("user".equals(filterFieldName)) {
                filterUserExists = true;
                filterUserValue = filterFieldStrValue;
            } else if ("date".equals(filterFieldName)) {
                // это правильно для сравнения дат события лога и фильтра запроса в типе Date (задача 6 - get ip for date = "30.01.2014 12:56:22"):
//                try {
//                    filterDateValue = df.parse(filterFieldStrValue);
//                    filterDateExists = true;
//                } catch (ParseException e) {
//                    //e.printStackTrace();
//                }
                // это правильно для сравнения дат события лога и фильтра запроса в типе String (задача 6 - get ip for date = "30.01.2014 12:56:22").
                // Валидатор проверяет через совпадение строк:
                filterDateValueStr = filterFieldStrValue;
                filterDateExists = true;
            } else if ("event".equals(filterFieldName)) {
                filterEventExists = true;
                filterEventValue = Event.valueOf(filterFieldStrValue);
            } else if ("status".equals(filterFieldName)) {
                filterStatusExists = true;
                filterStatusValue = Status.valueOf(filterFieldStrValue);
            }

//          if ("after".equals(filterAfterName)) {
//
//          }
//          else if ("before".equals(filterBeforeName)) {
//
//          }
        }

        for (LogData data : datas) {
            if (  (!filterIpExists || filterIpValue.equals(data.ip))
                &&(!filterUserExists || filterUserValue.equals(data.userName))

                    //&&(!filterDateExists || filterDateValue.equals(data.date))            // это правильно для сравнения дат события лога и фильтра запроса в типе Date (задача 6 - get ip for date = "30.01.2014 12:56:22")
                    &&(!filterDateExists || data.dateStr.contains(filterDateValueStr)  )    // это правильно для сравнения дат события лога и фильтра запроса в типе String (задача 6 - get ip for date = "30.01.2014 12:56:22")
                                                                                            // Валидатор проверяет через совпадение строк

                &&(!filterEventExists || (filterEventValue == data.event))
                &&(!filterStatusExists || (filterStatusValue == data.status))
                /* &&(filterDateIntervalExists ? isDateBetween(data.date, filterDateAfterValue, filterDateBeforeValue) */
            ) {
                if ("ip".equals(field)) res.add(data.ip);
                else if ("user".equals(field)) res.add(data.userName);
                else if ("date".equals(field)) res.add(data.date);
                else if ("event".equals(field)) res.add(data.event);
                else if ("status".equals(field)) res.add(data.status);
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
        private String dateStr;  // исходная дата в виде строки из лога - для сравнения дат события лога и фильтра запроса в типе String (задача 6 - get ip for date = "30.01.2014 12:56:22")
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
        res.dateStr = dateStr;  // костыль для "Парсер логов (6)" валидатора "get ip for date = "30.01.2014 12:56:22""
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
