package errorAndExceptions.exceptions;

public class DepartmentHasNoGroupsException extends RuntimeException{
    public DepartmentHasNoGroupsException(String message) {
        super(message);
    }
}
