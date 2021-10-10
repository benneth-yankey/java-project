package io.turntabl.register;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.turntabl.enums.Level;
import io.turntabl.student.NaughtyStudent;
import io.turntabl.student.Student;
import io.turntabl.student.exceptions.StudentNotFoundException;

public class RegisterTest {

    @Test
    void testGetRegisterByLevel_GivenExistingLevel_ThenReturnMapOfStudentGroupedByLevel() {
        // given
        Student student1 = new Student(List.of(20.00, 30.00), Level.ONE);
        Student student2 = new Student(List.of(30.00, 40.00), Level.ONE);

        student1.setName("student1");
        student2.setName("student2");

        // when
        List<Student> students = List.of(student1, student2);
        Register register = new Register(students);

        // then
        Map<Level, List<Student>> expected = new HashMap<>();
        expected.put(Level.ONE, students);

        Assertions.assertEquals(expected, register.getRegisterByLevel(Level.ONE));
    }

    @Test
    void testGetRegisterByLevel_GivenNonExistingLevel_ThenReturnEmptyMap() {
        // given
        Student student1 = new Student(List.of(87.12, 49.67), Level.THREE);
        Student student2 = new Student(List.of(29.92, 55.34), Level.FOUR);

        student1.setName("student1");
        student2.setName("student2");

        // when
        List<Student> students = List.of(student1, student2);
        Register register = new Register(students);

        // then
        Assertions.assertEquals(Map.of(), register.getRegisterByLevel(Level.TWO));
    }

    @Test
    void testPrintReport_GivenFourStudents_ThenReturnMapOfStudentGroupedByLevel() {
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
        Assertions.assertEquals(expected, register.printReport());
    }

    @Test
    void testSort_GivenComparatorToSortByName_ThenReturnSortedListOfStudentByName() {
        // given
        Student student1 = new Student(List.of(80.00, 70.00), Level.THREE);
        Student student2 = new Student(List.of(65.00, 85.00), Level.THREE);
        Student naughtyStudent1 = new NaughtyStudent(List.of(15.00, 20.00), Level.ONE);
        Student naughtyStudent2 = new NaughtyStudent(List.of(30.00, 40.00), Level.TWO);

        student1.setName("benneth");
        student2.setName("daniel");
        naughtyStudent1.setName("andrew");
        naughtyStudent2.setName("godwin");

        // when
        List<Student> students = List.of(student1, student2, naughtyStudent1, naughtyStudent2);
        Register register = new Register(students);

        // then
        List<Student> expected = List.of(naughtyStudent1, student1, student2, naughtyStudent2);
        Assertions.assertEquals(expected, register.sort((s1, s2) -> s1.getName().compareTo(s2.getName())));
    }

    @Test
    void testSort_GivenComparatorToSortByAverageGrade_ThenReturnSortedListOfStudentByAverageGrade() {
        // given
        Student student1 = new Student(List.of(80.00, 70.00), Level.THREE);
        Student student2 = new Student(List.of(65.00, 55.00), Level.THREE);
        Student naughtyStudent1 = new NaughtyStudent(List.of(15.00, 20.00), Level.ONE);
        Student naughtyStudent2 = new NaughtyStudent(List.of(30.00, 40.00), Level.TWO);

        student1.setName("benneth");
        student2.setName("daniel");
        naughtyStudent1.setName("andrew");
        naughtyStudent2.setName("godwin");

        // when
        List<Student> students = List.of(student1, student2, naughtyStudent1, naughtyStudent2);
        Register register = new Register(students);

        // then
        List<Student> expected = List.of(student1, student2, naughtyStudent2, naughtyStudent1);
        Assertions.assertEquals(expected,
                register.sort((s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade())));
    }

    @Test
    void testGetStudent_GivenStudentName_ThenReturnTheStudent() throws StudentNotFoundException {
        // given
        Student student1 = new Student(List.of(65.50, 77.22, 80.00), Level.ONE);
        Student student2 = new Student(List.of(95.00, 56.50, 75.35), Level.THREE);

        student1.setName("dominic");
        student2.setName("rebecca");
    
        // when
        List<Student> students = List.of(student1, student2);
        Register register = new Register(students);

        // then
        Assertions.assertEquals(student1, register.getStudent("dominic"));
    }

    @Test
    void testGetStudent_GivenStudentNameThatDoesNotExist_ItThrowsStudentNotFoundException() {
        // given
        Student student1 = new Student(List.of(50.55, 68.33, 45.89), Level.ONE);
        Student student2 = new Student(List.of(88.23, 35.65, 67.80), Level.THREE);

        student1.setName("dominic");
        student2.setName("rebecca");
    
        // when
        List<Student> students = List.of(student1, student2);
        Register register = new Register(students);

        Exception exception = Assertions.assertThrows(StudentNotFoundException.class, () -> {
           register.getStudent("benneth");
        });

        // then
        Assertions.assertEquals("student does not exist", exception.getMessage());
    }
}
