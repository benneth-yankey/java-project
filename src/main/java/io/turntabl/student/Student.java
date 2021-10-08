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
        double sumOfGrade = getGrades().stream().reduce(0.00, (grade, accum) -> grade + accum).doubleValue();
        return sumOfGrade / grades.size();
    }
}
