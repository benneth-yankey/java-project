package io.turntabl.lecture;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.turntabl.enums.Level;
import io.turntabl.student.NaughtyStudent;
import io.turntabl.student.Student;

public class BagOfLecturesTest {
    BagOfLectures<Lecture> bag;
    Lecture lecture1;
    Lecture lecture2;

    @BeforeEach
    void setUp() {
        // given
        Student student1 = new Student(List.of(20.00, 30.00), Level.TWO);
        Student student2 = new Student(List.of(15.00, 22.00), Level.TWO);
        Student student3 = new NaughtyStudent(List.of(15.00, 22.00), Level.ONE);
        Student student4 = new NaughtyStudent(List.of(15.00, 22.00), Level.ONE);
        Student student5 = new NaughtyStudent(List.of(15.00, 22.00), Level.ONE);

        lecture1 = new Lecture();
        lecture1.enter(student1);
        lecture1.enter(student2);

        lecture2 = new Lecture();
        lecture2.enter(student3);
        lecture2.enter(student4);
        lecture2.enter(student5);

        // when
        bag = new BagOfLectures<>();
        bag.add(lecture1);
        bag.add(lecture1);
        bag.add(lecture1);
        bag.add(lecture2);
        bag.add(lecture2);
    }

    @Test
    void testThatLecturesCanBeAddedToTheBag() {
        // then
        Assertions.assertEquals(2, bag.getBagCount());
        Assertions.assertEquals(3, bag.getCount(lecture1));
        Assertions.assertEquals(2, bag.getCount(lecture2));
    }

    @Test
    void testThatBagIsEmpty() {
        // when
        bag.clear();

        // then
        Assertions.assertEquals(0, bag.getBagCount());
        Assertions.assertEquals(0, bag.getCount(lecture1));
    }

    @Test
    void testThatMultipleStudentCountDecreasesWhenRemoved() {
        // when
        bag.remove(lecture1);
        bag.remove(lecture2);

        // then
        Assertions.assertEquals(2, bag.getCount(lecture1));
        Assertions.assertEquals(1, bag.getCount(lecture2));
    }

    @Test
    void testThatStudentIsRemovedWhenCountIsZero() {
        // when
        bag.remove(lecture1);
        bag.remove(lecture1);
        bag.remove(lecture1);
        bag.remove(lecture2);
        bag.remove(lecture2);

        // then
        Assertions.assertEquals(0, bag.getCount(lecture1));
        Assertions.assertEquals(0, bag.getCount(lecture2));
    }
}

