package io.turntabl.student;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.turntabl.enums.Level;

public class StudentTest {

    @Test
    void testGetAverageGrade_GivenStudentWithGrades_ThenReturnAverageGrade() {
        // given
        List<Double> grades = List.of(20.00, 30.00, 40.00, 10.00);

        // when
        Student student = new Student(grades, Level.TWO);

        // then
        Assertions.assertEquals((100 / 4), student.getAverageGrade());
    }
}
