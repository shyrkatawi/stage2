package errorAndExceptions.exceptions;

public class GroupHasNoStudentsException extends RuntimeException{
    public GroupHasNoStudentsException(String message) {
        super(message);
    }
}
