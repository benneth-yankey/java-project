package io.turntabl.student;

import java.util.HashMap;
import java.util.Map;

public class BagOfStudents<T extends Student> {
    private Map<T, Integer> bag = new HashMap<>();

    public int getBagCount() {
        return bag.size();
    }

    public int getCount(T student) {
        if (bag.containsKey(student)) {
            return bag.get(student);
        }
        return 0;
    }

    public void add(T student) {
        if (bag.containsKey(student)) {
            bag.put(student, bag.get(student) + 1);
        } else {
            bag.put(student, 1);
        }
    }

    public void remove(T student) {
        if (bag.containsKey(student)) {
            if (bag.get(student) == 1) {
                bag.remove(student);
            } else {
                bag.compute(student, (key, count) -> count - 1);
            }
        }
    }

    public void clear() {
        bag.clear();
    }
}
