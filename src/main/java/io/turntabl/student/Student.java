package io.turntabl.student;

import java.util.List;

import io.turntabl.interfaces.Nameable;

public class Student implements Nameable {

    private List<Double> grades;
    private String name;

    public Student(List<Double> grades) {
        this.grades = grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return getGrades().stream().mapToDouble(grade -> grade).average().getAsDouble();
    }
}
