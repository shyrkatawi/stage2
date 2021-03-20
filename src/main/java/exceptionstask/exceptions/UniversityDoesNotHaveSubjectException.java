package exceptionstask.exceptions;

public class UniversityDoesNotHaveSubjectException extends RuntimeException{
    public UniversityDoesNotHaveSubjectException(String message) {
        super(message);
    }
}
