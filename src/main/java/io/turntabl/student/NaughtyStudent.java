package io.turntabl.student;

import java.util.List;

import io.turntabl.enums.Level;

public class NaughtyStudent extends Student {

    public NaughtyStudent(List<Double> grades, Level level) {
        super(grades, level);
    }

    // returns 10% increase in the average grade
    @Override
    public double getAverageGrade() {
        return super.getAverageGrade() + 1.1;
    }
}
