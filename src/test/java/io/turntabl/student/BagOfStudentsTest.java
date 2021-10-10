package io.turntabl.student;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.turntabl.enums.Level;

public class BagOfStudentsTest {
    BagOfStudents<Student> bag;
    Student student1;
    Student student2;

    @BeforeEach
    void setUp() {
        // given
        student1 = new Student(List.of(20.00, 30.00), Level.ONE);
        student2 = new NaughtyStudent(List.of(15.00, 22.00), Level.TWO);

        // when
        bag = new BagOfStudents<>();
        bag.add(student1);
        bag.add(student1);
        bag.add(student2);
        bag.add(student2);
        bag.add(student2);
    }

    @Test
    void testThatStudentsCanBeAddedToTheBag() {
        // then
        Assertions.assertEquals(2, bag.getBagCount());
        Assertions.assertEquals(2, bag.getCount(student1));
        Assertions.assertEquals(3, bag.getCount(student2));
    }

    @Test
    void testThatBagIsEmpty() {
        // when
        bag.clear();

        // then
        Assertions.assertEquals(0, bag.getBagCount());
        Assertions.assertEquals(0, bag.getCount(student1));
    }

    @Test
    void testThatMultipleStudentCountDecreasesWhenRemoved() {
        // when
        bag.remove(student1);
        bag.remove(student2);

        // then
        Assertions.assertEquals(1, bag.getCount(student1));
        Assertions.assertEquals(2, bag.getCount(student2));
    }

    @Test
    void testThatStudentIsRemovedWhenCountIsZero() {
        // when
        bag.remove(student1);
        bag.remove(student1);
        bag.remove(student2);
        bag.remove(student2);
        bag.remove(student2);

        // then
        Assertions.assertEquals(0, bag.getCount(student1));
        Assertions.assertEquals(0, bag.getCount(student2));
    }
}
