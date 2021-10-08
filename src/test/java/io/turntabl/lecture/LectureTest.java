package io.turntabl.lecture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.turntabl.student.Student;

public class LectureTest {
    Lecture lecture;

    @BeforeEach
    void setUp() {
        lecture = new Lecture();
    }

    @Test
    void testGetHighestAverageGrade() {
       lecture.enter(new Student(List.of(20.00, 30.00))); 
       lecture.enter(new Student(List.of(40.00, 60.00))); 

       double actual = lecture.getHighestAverageGrade();

       assertEquals(50.00, actual);
       assertNotEquals(25.00, actual);
    }
}
