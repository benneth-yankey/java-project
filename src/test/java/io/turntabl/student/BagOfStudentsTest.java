package io.turntabl.student;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.turntabl.enums.Level;

public class BagOfStudentsTest {
    BagOfStudents<Student> bag = new BagOfStudents<>();

    @Test
    void testClear_GivenThatBagIsNotEmpty_ThenReturnEmptyBag() {
        // given
        Student student1 = new Student(List.of(20.00, 30.00), Level.ONE);
        NaughtyStudent student2 = new NaughtyStudent(List.of(15.00, 22.00), Level.TWO);

        // when
        bag.add(student1);
        bag.add(student1);
        bag.add(student2);

        bag.clear();

        // then
        Assertions.assertEquals(0, bag.getBagCount());
    }

    @Test
    void testRemove_GivenThatAStudentCountIsMoreThanOne_ThenDecreaseTheStudentCount() {
        // given
        Student student = new Student(List.of(56.45, 78.30, 66.50), Level.ONE);

        // when
        bag.add(student);
        bag.add(student);

        bag.remove(student);

        // then
        Assertions.assertEquals(1, bag.getCount(student));
    }

    @Test
    void testRemove_GivenThatStudentCountIsEqualToOne_ThenRemoveStudent() {
        // given
        NaughtyStudent naughtstudent = new NaughtyStudent(List.of(35.55, 22.45, 55.50), Level.ONE);

        // when
        bag.add(naughtstudent);
        bag.add(naughtstudent);

        bag.remove(naughtstudent);
        bag.remove(naughtstudent);

        // then
        Assertions.assertEquals(0, bag.getCount(naughtstudent));
    }
}
