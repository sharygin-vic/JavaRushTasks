package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<Student>();
    protected int age;
    protected String name;

    public University(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }




    public Student getStudentWithAverageGrade(double averageGrade) {
        if (students.size() == 0) return null;
        for (Student st : students) {
            if (Double.compare( st.getAverageGrade(), averageGrade) == 0) {
                return st;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        if (students.size() == 0) return null;
        Student max = students.get(0);
        for (Student st : students) {
            if (st.getAverageGrade() > max.getAverageGrade()) {
                max = st;
            }
        }
        return max;
    }

    public Student getStudentWithMinAverageGrade() {
        if (students.size() == 0) return null;
        Student min = students.get(0);
        for (Student st : students) {
            if (st.getAverageGrade() < min.getAverageGrade()) {
                min = st;
            }
        }
        return min;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}