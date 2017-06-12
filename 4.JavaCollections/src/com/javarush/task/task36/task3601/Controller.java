package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by dell on 13-Jun-17.
 */
public class Controller {
    private Model model = new Model();
    View view;

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }
}
