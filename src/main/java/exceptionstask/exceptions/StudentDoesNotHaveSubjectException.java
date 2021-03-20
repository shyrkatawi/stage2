package exceptionstask.exceptions;

public class StudentDoesNotHaveSubjectException extends RuntimeException {
    public StudentDoesNotHaveSubjectException(String message) {
        super(message);
    }
}
