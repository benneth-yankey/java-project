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

    // @Test
    // void testThatScoresAreHigherThanTheyOughtToBe() {
    //     Lecture lecture = new Lecture();
    //     lecture.enter(new NaughtyStudent(List.of(15.00, 20.00, 25.00)));
    //     lecture.enter(new NaughtyStudent(List.of(5.00, 5.00, 20.00)));

    //     List<Double> averageGrades = lecture.getStudentList().stream().map(student -> student.getAverageGrade()).toList();

    //     double expected = 20.00;
    //     Assertions.assertTrue(expected < averageGrades.get(0));

    //     expected = 10.0;
    //     Assertions.assertTrue(expected < averageGrades.get(1));
    // }
}
