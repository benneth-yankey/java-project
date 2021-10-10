package io.turntabl.register;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.turntabl.enums.Level;
import io.turntabl.student.Student;

public class Register {
    // stores list of nameables
    private List<Student> students = new ArrayList<>();

    public Register(List<Student> students) {
        this.students = students;
    }

    // returns list of nameables (students)
    public List<Student> getNameables() {
        return students;
    }

    // returns names of nameables
    public List<String> getRegister() {
        return students.stream().map(Student::getName).toList();
    }

    // returns names of nameables by level
    public List<String> getRegisterByLevel(Level level) {
        return students.stream().filter(student -> student.getLevel().equals(level)).map(Student::getName).toList();
    }

    // returns names of nameables grouped by their level
    public String printReport() {
        Map<Level, List<String>> map = students.stream()
                .collect(groupingBy(Student::getLevel, mapping(Student::getName, toList())));

        // convert a Map to a TreeMap to sort keys
        TreeMap<Level, List<String>> s = new TreeMap<>(map);
        return s.toString();
    }
}
