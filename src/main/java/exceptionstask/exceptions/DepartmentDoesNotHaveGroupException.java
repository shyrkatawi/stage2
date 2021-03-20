package exceptionstask.exceptions;

public class DepartmentDoesNotHaveGroupException extends RuntimeException{
    public DepartmentDoesNotHaveGroupException(String message) {
        super(message);
    }
}
