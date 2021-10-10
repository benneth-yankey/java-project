package io.turntabl.register;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import io.turntabl.enums.Level;
import io.turntabl.student.Student;
import io.turntabl.student.exceptions.StudentNotFoundException;

public class Register {
    private List<Student> students = new ArrayList<>();

    public Register(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<String> getRegister() {
        return students.stream().map(Student::getName).toList();
    }

    public Map<Level, List<Student>> getRegisterByLevel(Level level) {
        return students.stream().filter(student -> student.getLevel().equals(level))
                .collect(groupingBy(Student::getLevel));
    }

    public String printReport() {
        Map<Level, List<String>> map = students.stream()
                .collect(groupingBy(Student::getLevel, mapping(Student::getName, toList())));

        TreeMap<Level, List<String>> s = new TreeMap<>(map);
        return s.toString();
    }

    public List<Student> sort(Comparator<Student> comparator) {
        return students.stream().sorted(comparator).toList();
    }

    public Student getStudent(String name) throws StudentNotFoundException {
       Optional<Student> s = students.stream().filter(student -> student.getName().equals(name)).findFirst();
       if (s.isEmpty()) {
           throw new StudentNotFoundException("student does not exist");
       }
       return s.get();
    }
}
