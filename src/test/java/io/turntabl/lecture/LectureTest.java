package io.turntabl.lecture;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.turntabl.student.NaughtyStudent;
import io.turntabl.student.Student;

public class LectureTest {
    Lecture lecture;

    @BeforeEach
    void setUp() {
        lecture = new Lecture();
    }

    @Test
    void testGetHighestAverageGrade() {
        Lecture lecture = new Lecture();
        lecture.enter(new Student(List.of(20.00, 30.00)));
        lecture.enter(new Student(List.of(40.00, 60.00)));

        double actual = lecture.getHighestAverageGrade();

        Assertions.assertEquals(50.00, actual);
        Assertions.assertNotEquals(25.00, actual);
    }

    @Test
    void testThatNaughtyStudentScoreHightThanOughtToBe() {
        lecture.enter(new NaughtyStudent(List.of(15.00, 20.00, 25.00)));
        lecture.enter(new NaughtyStudent(List.of(20.00, 50.00, 50.00)));
       
        double expected = 44.00; 
        Assertions.assertTrue(expected > lecture.getHighestAverageGrade());
        Assertions.assertNotEquals(expected, lecture.getHighestAverageGrade());
    }
}
