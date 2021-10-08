package io.turntabl.student;

import java.util.List;

public class Student {

    private List<Double> grades;

    public Student(List<Double> grades) {
        this.grades = grades;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return getGrades().stream().mapToDouble(grade -> grade).average().getAsDouble();
    }
}
