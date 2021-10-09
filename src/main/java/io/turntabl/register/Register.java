package io.turntabl.register;

import java.util.ArrayList;
import java.util.List;

import io.turntabl.interfaces.Nameable;

public class Register {
    private List<Nameable> nameables = new ArrayList<>();

    public Register(List<Nameable> students) {
        this.nameables = students;
    }

    public List<Nameable> getNameables() {
        return nameables;
    }

    public List<String> getRegister() {
        return nameables.stream().map(Nameable::getName).toList();
    }
}
