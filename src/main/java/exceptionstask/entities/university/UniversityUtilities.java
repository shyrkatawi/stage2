package exceptionstask.entities.university;

import exceptionstask.entities.*;
import exceptionstask.exceptions.UniversityDoesNotHaveSubjectException;
import exceptionstask.types.DepartmentType;
import exceptionstask.types.GroupType;
import exceptionstask.types.SubjectType;

import java.util.List;

public class UniversityUtilities {
    private UniversityUtilities() {
    }

    public static double calculateAverageGradeForStudent(University university, String studentName) {
        Student student = university.getStudentByName(studentName);
        double gradeSum = 0;
        for (Subject subject : student.getSubjects()) {
            gradeSum += subject.getGrade().getValue();
        }
        return gradeSum / student.getSubjects().size();
    }

    public static double calculateAverageGradeForSubjectGroupDepartment(
            University university, SubjectType subjectType, GroupType groupType, DepartmentType departmentType) {
        int subjectCounter = 0;
        double gradeSum = 0;
        Department department = university.getDepartmentByType(departmentType);
        Group group = department.getGroupByType(groupType);
        for (Student student : group.getStudents()) {
            Subject subject = student.getSubject(subjectType);
            gradeSum += subject.getGrade().getValue();
            subjectCounter++;
        }
//        "division by zero" is safe
//        because if there are no subject student.getSubject(subjectType) will throw an exception
        return gradeSum / subjectCounter;
    }

    public static double calculateAverageGradeForSubject(University university, SubjectType subjectType) {
        int subjectCounter = 0;
        double gradeSum = 0;
        final List<Student> universityAllStudents = university.getAllStudents();
        for (Student student : universityAllStudents) {
            if (student.isHasSubject(subjectType)) {
                Subject subject = student.getSubject(subjectType);
                gradeSum += subject.getGrade().getValue();
                subjectCounter++;
            }
        }
        if (subjectCounter != 0) {
            return gradeSum / subjectCounter;
        }
        throw new UniversityDoesNotHaveSubjectException(
                "university does not have subject " + subjectType);
    }
}
