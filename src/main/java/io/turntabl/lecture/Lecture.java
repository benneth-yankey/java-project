package io.turntabl.lecture;

import java.util.ArrayList;
import java.util.List;

import io.turntabl.student.Student;

public class Lecture {
    // stores student list
    List<Student> studentList = new ArrayList<>();

    // adds student to student list
    public void enter(Student student) {
        studentList.add(student);
    }

    // returns the student with highest average grade
    public double getHighestAverageGrade() {
        List<Double> grades = studentList.stream().map(student -> student.getAverageGrade()).sorted().toList();
        return grades.get(grades.size() - 1);
    }
}
