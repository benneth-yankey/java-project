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
        Student student = new Student(grades, Level.TWO);
        
        // when
        double actual = student.getAverageGrade();

        // then
        double expected = 25.0;
        Assertions.assertEquals(expected, actual);
    }

    // @Test
    // void testGetGradesAsDoubleStream() {
    //     // given
    //     List<Double> grades = List.of(67.45, 88.45, 77.55);
    //     Student student = new Student(grades, Level.FOUR);

    //     // when

    //     Answer<DoubleStream> answer = (InvocationOnMock invocation) -> DoubleStream.of(67.45, 88.45, 77.55);
    //     when(mock.getGradesAsDoubleStream()).thenAnswer(answer);
    //     // then

    //     // DoubleStream expected = grades.stream().mapToDouble(grade -> grade);
    //     // Assertions.assertEquals(expected, actual);
    // }
}
