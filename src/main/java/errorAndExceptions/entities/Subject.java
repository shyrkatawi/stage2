package errorAndExceptions.entities;

import errorAndExceptions.types.SubjectType;

public class Subject {
    private SubjectType subjectType;
    private Grade grade;

    public Subject(SubjectType subjectType, int gradeValue) {
        this.subjectType = subjectType;
        this.grade = new Grade(gradeValue);
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public Grade getGrade() {
        return grade;
    }
}

