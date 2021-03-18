package errorAndExceptions.entities;


import errorAndExceptions.exceptions.StudentHasNoSubjectsException;

import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        if (subjects == null || subjects.size() == 0) {
            throw new StudentHasNoSubjectsException("ERROR: student" + name + " does not have any subject");
        }
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
