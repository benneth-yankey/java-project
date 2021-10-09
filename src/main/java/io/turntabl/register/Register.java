package io.turntabl.register;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.turntabl.enums.Level;
import io.turntabl.interfaces.Nameable;
import io.turntabl.student.Student;

public class Register {
    // stores list of nameables
    private List<Nameable> nameables = new ArrayList<>();

    public Register(List<Nameable> students) {
        this.nameables = students;
    }

    // returns list of nameables (students)
    public List<Nameable> getNameables() {
        return nameables;
    }

    // returns names of nameables
    public List<String> getRegister() {
        return nameables.stream().map(Nameable::getName).toList();
    }

    // returns names of nameables by level
    public List<String> getRegisterByLevel(Level level) {
        return nameables.stream().filter(nameable -> ((Student) nameable).getLevel().equals(level))
                .map(Nameable::getName).toList();
    }

    // returns names of nameables grouped by their level
    public String printReport() {
        Map<Level, List<String>> map = nameables.stream()
                .collect(groupingBy(nameable -> ((Student) nameable).getLevel(), mapping(Nameable::getName, toList())));

        // convert a Map to a TreeMap to sort keys
        TreeMap<Level, List<String>> s = new TreeMap<>(map);
        return s.toString();
    }
}
