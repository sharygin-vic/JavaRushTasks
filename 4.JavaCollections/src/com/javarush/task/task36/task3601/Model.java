package com.javarush.task.task36.task3601;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 13-Jun-17.
 */
public class Model {
    private Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }
}
