package exceptionstask.exceptions;

public class UniversityDoesNotHaveDepartmentException extends RuntimeException{
    public UniversityDoesNotHaveDepartmentException(String message) {
        super(message);
    }
}
