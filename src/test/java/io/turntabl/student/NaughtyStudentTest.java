package io.turntabl.student;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NaughtyStudentTest {

    @Test
    void testThatAverageGradeIsHigherBy10Percent() {
        List<Double> grades = List.of(20.00, 30.00, 40.00, 10.00);
        Student student = new Student(grades);

        double percentIncreasee = 0.1;
        double expected = (100.00 / grades.size()) + percentIncreasee;
        double actual = student.getAverageGrade();

        Assertions.assertNotEquals(expected, actual);
        Assertions.assertTrue(expected > actual);
    }
}
