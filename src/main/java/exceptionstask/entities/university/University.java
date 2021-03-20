package exceptionstask.entities.university;

import exceptionstask.entities.Department;
import exceptionstask.entities.Student;
import exceptionstask.exceptions.UniversityDoesNotHaveDepartmentException;
import exceptionstask.exceptions.UniversityDoesNotHaveStudentException;
import exceptionstask.exceptions.UniversityHasNoDepartmentsException;
import exceptionstask.types.DepartmentType;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final String name;
    private final List<Department> departments;

    public University(String name, List<Department> departments) {
        this.name = name;
        if (departments == null || departments.isEmpty()) {
            throw new UniversityHasNoDepartmentsException(
                    "ERROR: University " + name + " does not have any department");
        }
        this.departments = departments;
    }

    public Department getDepartmentByType(DepartmentType type){
        for (Department department : departments) {
            if(department.getType()==type){
                return department;
            }
        }
        throw new UniversityDoesNotHaveDepartmentException(
                "University does not have department " + type);
    }

    public Student getStudentByName(String name) {
        for (Department department : departments) {
            Student student = department.getStudentByName(name);
            if (student != null) {
                return student;
            }
        }
        throw new UniversityDoesNotHaveStudentException(
                "University does not have student with name " + name);
    }

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        for (Department department : departments) {
            students.addAll(department.getAllStudents());
        }
        return students;
    }
}
