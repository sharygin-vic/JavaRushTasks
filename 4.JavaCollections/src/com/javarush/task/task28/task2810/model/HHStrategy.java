package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 09-Jul-17.
 */

// http://hh.ua/
// https://hh.ua/search/vacancy?text=java+Киев&page=1
// https://hh.ua/search/vacancy?text=java+ADDITIONAL_VALUE&page=PAGE_VALUE
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        ArrayList<Vacancy> res = new ArrayList<Vacancy>();


        return res;
    }
}
