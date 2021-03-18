package errorAndExceptions.entities;

import errorAndExceptions.exceptions.DepartmentHasNoGroupsException;
import errorAndExceptions.types.DepartmentType;

import java.util.List;

public class Department {
    private DepartmentType departmentType;
    private List<Group> groups;

    public Department(DepartmentType departmentType, List<Group> groups) {
        this.departmentType = departmentType;
        if (groups == null || groups.size() == 0) {
            throw new DepartmentHasNoGroupsException("ERROR: department " + departmentType + " does not have any group");
        }
        this.groups = groups;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
