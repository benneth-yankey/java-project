package io.turntabl.lecture;

import java.util.HashMap;
import java.util.Map;

public class BagOfLectures<T extends Lecture> {
    private Map<T, Integer> bag = new HashMap<>();

    public int getBagCount() {
        return bag.size();
    }

    public int getCount(T lecture) {
        if (bag.containsKey(lecture)) {
            return bag.get(lecture);
        }
        return 0;
    }

    public void add(T lecture) {
        if (bag.containsKey(lecture)) {
            bag.put(lecture, bag.get(lecture) + 1);
        } else {
            bag.put(lecture, 1);
        }
    }

    public void remove(T lecture) {
        if (bag.containsKey(lecture)) {
            if (bag.get(lecture) == 1) {
                bag.remove(lecture);
            } else {
                bag.compute(lecture, (key, count) -> count - 1);
            }
        }
    }

    public void clear() {
        bag.clear();
    }
}
