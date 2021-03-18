package errorAndExceptions.entities.university;

import errorAndExceptions.entities.Department;
import errorAndExceptions.exceptions.DepartmentHasNoGroupsException;

import java.util.List;

public class University {
    private String name;
    private List<Department> departments;

    public University(String name, List<Department> departments) {
        this.name = name;
        if (departments == null || departments.size() == 0) {
            throw new DepartmentHasNoGroupsException("ERROR: University " + name + " does not have any department");
        }
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}
