package errorAndExceptions.entities.university;

import errorAndExceptions.entities.*;
import errorAndExceptions.types.DepartmentType;
import errorAndExceptions.types.GroupType;
import errorAndExceptions.types.SubjectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniversityCreator {
    private static int STUDENT_ID = 1;

    public static Student createStudent(SubjectType[] subjectTypes) {
        String name = "student" + STUDENT_ID;
        int grade = STUDENT_ID % 10;
        STUDENT_ID++;

        List<Subject> subjectList = new ArrayList<>();
        for (SubjectType subjectType : subjectTypes) {
            subjectList.add(new Subject(subjectType, grade));
        }
        return new Student(name, subjectList);
    }

    public static List<Student> createStudentList(SubjectType[] subjectTypes, int numberOfStudents) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            studentList.add(createStudent(subjectTypes));
        }
        return studentList;
    }

    public static University createUniversity() {
        SubjectType[] subjectTypesForEngineeringDepartment = new SubjectType[]{
                SubjectType.ENGLISH,
                SubjectType.BIOLOGY,
                SubjectType.CHEMISTRY
        };
        Group engineeringGroup1 = new Group(GroupType.GRP_1, createStudentList(subjectTypesForEngineeringDepartment,2));
        Group engineeringGroup2 = new Group(GroupType.GRP_2, createStudentList(subjectTypesForEngineeringDepartment,2));

        SubjectType[] subjectTypesForInformatizationDepartment = new SubjectType[]{
                SubjectType.ENGLISH,
                SubjectType.HISTORY
        };
        Group informatizationGroup1 = new Group(GroupType.GRP_3, createStudentList(subjectTypesForInformatizationDepartment, 2));
        Group informatizationGroup2 = new Group(GroupType.GRP_4, createStudentList(subjectTypesForInformatizationDepartment, 2));

        Department engineeringDepartment = new Department(DepartmentType.ENGINEERING, Arrays.asList(engineeringGroup1, engineeringGroup2));
        Department informatizationDepartment = new Department(DepartmentType.INFORMATIZATION, Arrays.asList(informatizationGroup1, informatizationGroup2));

        return new University("NameOfUniversity", Arrays.asList(engineeringDepartment, informatizationDepartment));
    }
}
