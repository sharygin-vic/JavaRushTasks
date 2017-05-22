package com.javarush.task.task23.task2304;

import java.util.List;
import java.util.Map;

/*
Inner 3
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    private class TaskDataProvider implements DbDataProvider<Task> {
        public void refreshAllData(Map criteria){
            DbMock dbMock = new DbMock();
            tasks = dbMock.getFakeTasks(criteria);
        };
    }

    private class NameDataProvider implements DbDataProvider<String> {
        public void refreshAllData(Map criteria){
            DbMock dbMock = new DbMock();
            names = dbMock.getFakeNames(criteria);
        };
    }

    public static void main(String[] args) {

    }


}
