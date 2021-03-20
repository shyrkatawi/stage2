package exceptionstask.exceptions;

public class UniversityDoesNotHaveStudentException extends RuntimeException{
    public UniversityDoesNotHaveStudentException(String message) {
        super(message);
    }
}
