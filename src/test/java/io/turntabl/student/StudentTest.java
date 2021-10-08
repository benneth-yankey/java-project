package io.turntabl.student;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {
    List<Double> grades;

    @BeforeEach
    void setUp() {
        grades = List.of(12.23, 34.70, 55.90);
    }

    @Test
    void testThatStudentIsCreated() {
        Student student = new Student(grades);
        Assertions.assertNotNull(student);
    }

    @Test
    void testGetAverageGrade() {
        Student student = new Student(grades);
        DecimalFormat df = new DecimalFormat("0.00");

        double expected = 102.83 / grades.size();
        double actual = student.getAverageGrade();

        Assertions.assertEquals(df.format(expected), df.format(actual));
    }
}
