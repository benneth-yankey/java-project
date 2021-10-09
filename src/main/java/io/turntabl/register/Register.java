package io.turntabl.register;

import java.util.ArrayList;
import java.util.List;

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
}
