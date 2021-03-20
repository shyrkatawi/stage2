package exceptionstask.entities;


import exceptionstask.exceptions.StudentDoesNotHaveSubjectException;
import exceptionstask.exceptions.StudentHasNoSubjectsException;
import exceptionstask.types.SubjectType;

import java.util.List;

public class Student {
    private final String name;
    private final List<Subject> subjects;

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        if (subjects == null || subjects.isEmpty()) {
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

    public Subject getSubject(SubjectType subjectType) {
        for (Subject subject : subjects) {
            if (subjectType == subject.getType()) {
                return subject;
            }
        }
        throw new StudentDoesNotHaveSubjectException(
                "student does not have subject " + subjectType);
    }

    public boolean isHasSubject(SubjectType subjectType) {
        for (Subject subject : subjects) {
            if (subjectType == subject.getType()) {
                return true;
            }
        }
        throw new StudentDoesNotHaveSubjectException(
                "student does not have subject " + subjectType);
    }
}
