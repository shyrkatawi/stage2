package errorAndExceptions.entities.university;

import errorAndExceptions.entities.*;
import errorAndExceptions.types.DepartmentType;
import errorAndExceptions.types.GroupType;
import errorAndExceptions.types.SubjectType;

public class UniversityUtilities {
    private static double calculateAverageGradeForStudent(University university, String studentName) {
        for (Department department : university.getDepartments()) {
            for (Group group : department.getGroups()) {
                for (Student student : group.getStudents()) {
                    if (student.getName().equals(studentName)) {
                        double gradeSum = 0;
                        for (Subject subject : student.getSubjects()) {
                            gradeSum += subject.getGrade().getValue();
                        }
                        return gradeSum / student.getSubjects().size();
                    }
                }
            }
        }
        return -1;
    }

    public static void showAverageGradeForStudent(University university, String studentName) {
        double averageGrade = calculateAverageGradeForStudent(university, studentName);
        if (averageGrade < 0) {
            System.out.println(String.format("University does not have student with name \"%s\"", studentName));
        } else {
            System.out.println(String.format("Average grade for %s is %.1f", studentName, averageGrade));
        }
    }


    public static double calculateAverageGradeForSubjectGroupDepartment(University university, SubjectType subjectType, GroupType groupType, DepartmentType departmentType) {
        int subjectCounter = 0;
        double gradeSum = 0;
        for (Department department : university.getDepartments()) {
            if (department.getDepartmentType() == departmentType) {
                for (Group group : department.getGroups()) {
                    if (group.getGroupType() == groupType) {
                        for (Student student : group.getStudents()) {
                            for (Subject subject : student.getSubjects()) {
                                if (subject.getSubjectType() == subjectType) {
                                    subjectCounter++;
                                    gradeSum += subject.getGrade().getValue();
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        if (subjectCounter == 0) {
            return -1;
        } else {
            return gradeSum / subjectCounter;
        }
    }

    public static void showAverageGradeForSubjectGroupDepartment(University university, SubjectType subjectType, GroupType groupType, DepartmentType departmentType) {
        double averageGrade = calculateAverageGradeForSubjectGroupDepartment(university, subjectType, groupType, departmentType);
        if (averageGrade < 0) {
            System.out.println(String.format("Impossible to calculate average grade for these parameters \"%s, %s, %s\".",
                    departmentType, groupType, subjectType));
        } else {
            System.out.println(String.format("Average grade of %s, %s, %s is %.1f",
                    departmentType, groupType, subjectType, averageGrade));
        }
    }


    private static double calculateAverageGradeForSubject(University university, SubjectType subjectType) {
        int subjectCounter = 0;
        double gradeSum = 0;
        for (Department department : university.getDepartments()) {
            for (Group group : department.getGroups()) {
                for (Student student : group.getStudents()) {
                    for (Subject subject : student.getSubjects()) {
                        if (subject.getSubjectType() == subjectType) {
                            subjectCounter++;
                            gradeSum += subject.getGrade().getValue();
                        }
                    }
                }
            }
        }
        if (subjectCounter == 0) {
            return -1;
        } else {
            return gradeSum / subjectCounter;
        }
    }

    public static void showAverageGradeForSubject(University university, SubjectType subjectType) {
        double averageGrade = calculateAverageGradeForSubject(university, subjectType);
        if (averageGrade < 0) {
            System.out.println(String.format("University does not have subject with name \"%s\".", subjectType));
        } else {
            System.out.println(String.format("Average grade for subject \"%s\" is %.1f", subjectType, averageGrade));
        }
    }

}
