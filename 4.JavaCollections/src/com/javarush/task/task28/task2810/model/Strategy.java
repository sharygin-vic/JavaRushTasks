package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

/**
 * Created by dell on 09-Jul-17.
 */
public interface Strategy {
    List<Vacancy> getVacancies(String searchString);
}
