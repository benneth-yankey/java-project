package io.turntabl.student;

import java.util.List;

public class NaughtyStudent extends Student {

    public NaughtyStudent(List<Double> grades) {
        super(grades);
    }

    @Override
    public double getAverageGrade() {
        double percentIncrease = 0.1;
        return getAverageGrade() + (getAverageGrade() * percentIncrease);
    }
}
