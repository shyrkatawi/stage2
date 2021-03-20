package exceptionstask.entities;

import exceptionstask.exceptions.DepartmentHasNoGroupsException;
import exceptionstask.exceptions.DepartmentDoesNotHaveGroupException;
import exceptionstask.types.DepartmentType;
import exceptionstask.types.GroupType;

import java.util.List;

public class Department {
    private final DepartmentType departmentType;
    private final List<Group> groups;

    public Department(DepartmentType departmentType, List<Group> groups) {
        this.departmentType = departmentType;
        if (groups == null || groups.isEmpty()) {
            throw new DepartmentHasNoGroupsException("ERROR: department " + departmentType + " does not have any group");
        }
        this.groups = groups;
    }

    public DepartmentType getType() {
        return departmentType;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Student getStudentByName(String name){
        for (Group group : groups) {
            Student student = group.getStudentByName(name);
            if (student != null) {
                return student;
            }
        }
        return null;
    }

    public Group getGroupByType(GroupType groupType){
        for (Group group : groups) {
            if(group.getGroupType()==groupType){
                return group;
            }
        }
        throw new DepartmentDoesNotHaveGroupException(
                "department does not have group " + groupType);
    }
}
