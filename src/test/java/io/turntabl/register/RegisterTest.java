package io.turntabl.register;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.turntabl.enums.Level;
import io.turntabl.interfaces.Nameable;
import io.turntabl.student.Student;

public class RegisterTest {

    @Test
    void testThatNameablesCanBeRegistered() {
        // given
        Student student1 = new Student(List.of(20.00, 30.00), Level.ONE);
        Student student2 = new Student(List.of(30.00, 40.00), Level.THREE);

        student1.setName("student1");
        student2.setName("student2");

        // when
        List<Nameable> students = List.of(student1, student2);
        Register register = new Register(students);

        // then
        int expected = 2;
        Assertions.assertEquals(expected, register.getNameables().size());
    }
}
