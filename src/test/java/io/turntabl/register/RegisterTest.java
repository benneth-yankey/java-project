package io.turntabl.register;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.turntabl.enums.Level;
import io.turntabl.student.NaughtyStudent;
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
        List<Student> students = List.of(student1, student2);
        Register register = new Register(students);

        // then
        Assertions.assertEquals(2, register.getNameables().size());
        Assertions.assertEquals(students, register.getNameables());
    }

    @Test
    void testThatListOfNamesByGivenLevelAreReturnedOrAnEmptyList() {
        // given
        Student student1 = new Student(List.of(20.00, 30.00), Level.ONE);
        Student student2 = new Student(List.of(30.00, 40.00), Level.ONE);

        student1.setName("student1");
        student2.setName("student2");

        // when
        List<Student> students = List.of(student1, student2);
        Register register = new Register(students);

        // then
        Assertions.assertEquals(List.of("student1", "student2"), register.getRegisterByLevel(Level.ONE));
        Assertions.assertEquals(2, register.getRegisterByLevel(Level.ONE).size());
        Assertions.assertEquals(List.of(), register.getRegisterByLevel(Level.TWO));
    }

    @Test
    void testThatReportReturnsListOfNamesGroupedByTheirLevel() {
        // given
        Student student1 = new Student(List.of(80.00, 70.00), Level.THREE);
        Student student2 = new Student(List.of(65.00, 85.00), Level.THREE);
        Student naughStudent1 = new NaughtyStudent(List.of(15.00, 20.00), Level.ONE);
        Student naughStudent2 = new NaughtyStudent(List.of(30.00, 40.00), Level.TWO);

        student1.setName("student1");
        student2.setName("student2");
        naughStudent1.setName("naughtystudent1");
        naughStudent2.setName("naughtystudent2");

        // when
        List<Student> students = List.of(student1, student2, naughStudent1, naughStudent2);
        Register register = new Register(students);

        // then
        String expected = "{ONE=[naughtystudent1], TWO=[naughtystudent2], THREE=[student1, student2]}";
        String actual = register.printReport();
        Assertions.assertEquals(expected, actual);
    }
}
