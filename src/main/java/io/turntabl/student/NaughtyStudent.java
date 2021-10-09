package io.turntabl.student;

import java.util.List;

public class NaughtyStudent extends Student {

    public NaughtyStudent(List<Double> grades) {
        super(grades);
    }

    // returns 10% increase in the average grade
    @Override
    public double getAverageGrade() {
        return super.getAverageGrade() + 1.1;
    }
}
