package errorAndExceptions.entities;

import errorAndExceptions.exceptions.GroupHasNoStudentsException;
import errorAndExceptions.types.GroupType;

import java.util.List;

public class Group {
    private GroupType groupType;
    private List<Student> students;

    public Group(GroupType groupType, List<Student> students) {
        this.groupType = groupType;
        if (students == null || students.size() == 0) {
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
}
