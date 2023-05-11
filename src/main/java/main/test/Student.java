package main.test;

import java.util.List;
import java.util.Map;

public class Student {
    final String name;
    String group;
    int course;
    Map<String, int[]> marks;

    public Student(String name, String group, int course, Map<String, int[]> marks) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public Map<String, int[]> getMarks() {
        return marks;
    }

}
