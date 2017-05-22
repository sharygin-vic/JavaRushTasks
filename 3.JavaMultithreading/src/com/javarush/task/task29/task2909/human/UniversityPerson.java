package com.javarush.task.task29.task2909.human;

/**
 * Created by dell on 29-Apr-17.
 */
public class UniversityPerson extends Human {
    private University university;

    public UniversityPerson(String name, int age /*, String university*/) {
        super(name, age);
        //this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
