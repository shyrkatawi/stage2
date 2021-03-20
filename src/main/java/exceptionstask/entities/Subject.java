package exceptionstask.entities;

import exceptionstask.types.SubjectType;

public class Subject {
    private final SubjectType subjectType;
    private final Grade grade;

    public Subject(SubjectType subjectType, int gradeValue) {
        this.subjectType = subjectType;
        this.grade = new Grade(gradeValue);
    }

    public SubjectType getType() {
        return subjectType;
    }

    public Grade getGrade() {
        return grade;
    }
}

