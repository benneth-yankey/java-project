package io.turntabl.student;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.turntabl.enums.Level;

public class StudentTest {
    List<Double> grades;

    @BeforeEach
    void setUp() {
        grades = List.of(20.00, 30.00, 40.00, 10.00);
    }

    @Test
    void testThatStudentIsCreated() {
        Student student = new Student(grades, Level.ONE);
        Assertions.assertNotNull(student);
    }

    @Test
    void testGetAverageGrade() {
        Student student = new Student(grades, Level.TWO);

        double expected = 100.00 / grades.size();
        double actual = student.getAverageGrade();

        Assertions.assertEquals(expected, actual);
    }
}
