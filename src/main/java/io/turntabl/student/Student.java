package io.turntabl.student;

import java.util.List;

import io.turntabl.enums.Level;
import io.turntabl.interfaces.HasLevel;
import io.turntabl.interfaces.Nameable;

public class Student implements Nameable, HasLevel {

    private List<Double> grades;
    private String name;
    private Level level;

    public Student(List<Double> grades, Level level) {
        this.grades = grades;
        this.level = level;
    }

    public Level getLevel() {
        return level;
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
        return grades.stream().mapToDouble(grade -> grade).average().getAsDouble();
    }
}
