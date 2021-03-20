package exceptionstask.entities;

import exceptionstask.exceptions.GroupHasNoStudentsException;
import exceptionstask.types.GroupType;

import java.util.List;

public class Group {
    private final GroupType groupType;
    private final List<Student> students;

    public Group(GroupType groupType, List<Student> students) {
        this.groupType = groupType;
        if (students == null || students.isEmpty()) {
            throw new GroupHasNoStudentsException("ERROR: group " + groupType + " does not have any student");
        }
        this.students = students;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }
}
