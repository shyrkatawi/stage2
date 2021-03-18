package errorAndExceptions.exceptions;

public class StudentHasNoSubjectsException extends RuntimeException {
    public StudentHasNoSubjectsException(String message) {
        super(message);
    }
}
